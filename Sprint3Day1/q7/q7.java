import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class q7 {

    // Static block to set up global uncaught exception handler
    static {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            try (PrintWriter pw = new PrintWriter(new FileWriter("error_log.txt", true))) {
                pw.println("Unhandled Exception in thread \"" + thread.getName() + "\":");
                pw.println("Exception: " + throwable);
                for (StackTraceElement element : throwable.getStackTrace()) {
                    pw.println("\tat " + element);
                }
            } catch (IOException e) {
                System.err.println("Failed to write to log file: " + e.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Program started...");

        // Simulate an unhandled exception
        String value = null;
        System.out.println(value.length());  

        System.out.println("Program ended."); 
    }
}
