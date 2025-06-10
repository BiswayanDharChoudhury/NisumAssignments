import java.util.Random;

public class q8 {

    // Functional interface for any operation that may fail and needs retry
    @FunctionalInterface
    interface RetryableOperation {
        void execute() throws Exception;
    }

    // Retry utility with exponential backoff
    public static void retryWithBackoff(RetryableOperation operation, int maxRetries, long initialDelayMillis) {
        int attempt = 0;
        long delay = initialDelayMillis;

        while (true) {
            try {
                operation.execute();  // Try executing the operation
                System.out.println("Operation succeeded on attempt " + (attempt + 1));
                break;
            } catch (Exception e) {
                attempt++;
                if (attempt >= maxRetries) {
                    System.out.println("Operation failed after " + attempt + " attempts: " + e.getMessage());
                    break;
                } else {
                    System.out.println("Attempt " + attempt + " failed. Retrying in " + delay + " ms...");
                    try {
                        Thread.sleep(delay); // Wait with exponential backoff
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.out.println("Retry interrupted.");
                        break;
                    }
                    delay *= 2; // Exponential backoff
                }
            }
        }
    }

    // Simulated flaky network call
    public static void simulatedNetworkCall() throws Exception {
        if (new Random().nextInt(4) != 0) { // 75% chance to fail
            throw new Exception("Simulated network failure");
        }
        System.out.println("Simulated network call succeeded!");
    }

    // Main method to test retry logic
    public static void main(String[] args) {
        System.out.println("Starting retry mechanism for simulated network call...\n");
        retryWithBackoff(() -> simulatedNetworkCall(), 5, 1000);
    }
}
