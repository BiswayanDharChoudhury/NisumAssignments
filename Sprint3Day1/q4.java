import java.util.*;
import java.io.IOException;
import java.io.UncheckedIOException;

public class q4 {

    
    static class LegacyAPI {
        public static String readData() throws IOException {
            throw new IOException("Legacy API failure during read");
        }
    }

    // Functional interface that can throw IOException
    @FunctionalInterface
    interface SupplierWithIOException<T> {
        T get() throws IOException;
    }

    public static <T> T wrapIO(SupplierWithIOException<T> action) {
        try {
            return action.get(); // try running the action
        } catch (IOException e) {
            throw new UncheckedIOException(e); // convert to unchecked
        }
    }

   
    public static void main(String[] args) {
        try {
            String result = wrapIO(() -> LegacyAPI.readData());
            System.out.println("Result: " + result);
        } catch (UncheckedIOException e) {
            System.out.println("Caught UncheckedIOException: " + e.getMessage());
        }
    }
}
