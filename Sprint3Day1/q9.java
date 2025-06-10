import java.util.ArrayList;
import java.util.List;

// Custom ValidationException that aggregates all errors
class ValidationException extends RuntimeException {
    private final List<String> errors;

    public ValidationException(List<String> errors) {
        super("Validation failed with errors:\n" + String.join("\n", errors));
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}

// Functional interface for reusable validation rules
@FunctionalInterface
interface Validator<T> {
    void validate(T t, List<String> errors);
}

// Validation rule utility class
class ValidationRules {

    public static Validator<String> notBlank(String fieldName) {
        return (value, errors) -> {
            if (value == null || value.trim().isEmpty()) {
                errors.add(fieldName + " must not be blank.");
            }
        };
    }

    public static Validator<String> maxLength(String fieldName, int max) {
        return (value, errors) -> {
            if (value != null && value.length() > max) {
                errors.add(fieldName + " must not exceed " + max + " characters.");
            }
        };
    }

    public static Validator<Integer> positive(String fieldName) {
        return (value, errors) -> {
            if (value == null || value <= 0) {
                errors.add(fieldName + " must be a positive number.");
            }
        };
    }

    public static <T> void validateAll(T object, List<Validator<T>> rules) {
        List<String> errors = new ArrayList<>();
        for (Validator<T> rule : rules) {
            rule.validate(object, errors);
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}

// Java 14+ record for model
record User(String name, String email, int age) {}

public class q9 {
    public static void main(String[] args) {
        User user = new User("  ", "verylongemailaddress_thatexceedslimit@example.com", -10);

        try {
            validateUser(user);
            System.out.println("User is valid.");
        } catch (ValidationException ve) {
            System.out.println("Validation failed:");
            ve.getErrors().forEach(System.out::println);
        }
    }

    private static void validateUser(User user) {
        List<Validator<User>> rules = List.of(
            (u, errors) -> ValidationRules.notBlank("Name").validate(u.name(), errors),
            (u, errors) -> ValidationRules.notBlank("Email").validate(u.email(), errors),
            (u, errors) -> ValidationRules.maxLength("Email", 30).validate(u.email(), errors),
            (u, errors) -> ValidationRules.positive("Age").validate(u.age(), errors)
        );

        ValidationRules.validateAll(user, rules);
    }
}
