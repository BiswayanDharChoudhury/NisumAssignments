// Define a custom exception
class DataNotFoundException extends Exception {
    public DataNotFoundException(String message) {
        super(message);
    }
}

// Repository Layer (Innermost)
class DataRepository {
    public String fetchDataById(int id) throws DataNotFoundException {
        if (id <= 0) {
            throw new DataNotFoundException("No data found for ID: " + id);
        }
        return "Data for ID: " + id;
    }
}

// Service Layer (Middle)
class BusinessService {
    private final DataRepository repository = new DataRepository();

    public String processBusinessLogic(int id) throws DataNotFoundException {
        // Simply delegate and rethrow if any error occurs
        return repository.fetchDataById(id).toUpperCase(); // Example transformation
    }
}

// Controller Layer (Top Layer)
class DataController {
    private final BusinessService service = new BusinessService();

    public void handleRequest(int id) {
        try {
            String result = service.processBusinessLogic(id);
            System.out.println("Success: " + result);
        } catch (DataNotFoundException e) {
            // Handle the exception at the top level
            System.err.println("Error: " + e.getMessage());
        }
    }
}

// Main class
public class q10 {
    public static void main(String[] args) {
        DataController controller = new DataController();

        System.out.println("Case 1: Valid ID");
        controller.handleRequest(5);  // Should succeed

        System.out.println("\nCase 2: Invalid ID");
        controller.handleRequest(0);  // Should fail and bubble up the error
    }
}
