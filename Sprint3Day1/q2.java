class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class q2 {

    public static void validateAge(int age) {
        try {
            if (age <= 0) {
                throw new InvalidAgeException("Invalid age: Age must be greater than 0.");
            } else {
                System.out.println("Valid age: " + age);
            }
        } catch (InvalidAgeException e) {
           
            System.out.println("Caught Exception: " + e.getMessage());
        } catch (Exception e) {
            
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int[] testAges = {25, -5, 0, 18};

        for (int age : testAges) {
            System.out.println("\nTesting age: " + age);
            validateAge(age);
        }
    }
}
