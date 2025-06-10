sealed class PaymentException extends Exception permits InvalidPaymentMethodException, InvalidOfferAppliedException {
    public PaymentException(String message) {
        super(message);
    }
}

final class InvalidPaymentMethodException extends PaymentException {
    public InvalidPaymentMethodException(String message) {
        super(message);
    }
}

final class InvalidOfferAppliedException extends PaymentException {
    public InvalidOfferAppliedException(String message) {
        super(message);
    }
}

class PaymentService {
    public void paymentMethod(String method, boolean offerApplied) throws PaymentException {
        if (!method.equalsIgnoreCase("CARD") && !method.equalsIgnoreCase("UPI")) {
            throw new InvalidPaymentMethodException("Unsupported payment method: " + method);
        }
        if (offerApplied && method.equalsIgnoreCase("CASH")) {
            throw new InvalidOfferAppliedException("Offers cannot be applied on cash payments.");
        }
        System.out.println("Payment successful using " + method + (offerApplied ? " with offer." : "."));
    }

    public void processPaymentMethod(String method, boolean offerApplied) {
        try {
            paymentMethod(method, offerApplied);
        } catch (PaymentException e) {
            // Pattern matching using instanceof (Java 16+)
            if (e instanceof InvalidPaymentMethodException ipme) {
                System.out.println("Payment Error: " + ipme.getMessage());
            } else if (e instanceof InvalidOfferAppliedException ioae) {
                System.out.println("Offer Error: " + ioae.getMessage());
            } else {
                System.out.println("General Payment Exception: " + e.getMessage());
            }
        }
    }
}

public class q6 {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        // Test cases
        service.processPaymentMethod("CARD", true);
        service.processPaymentMethod("CASH", true);
        service.processPaymentMethod("BITCOIN", false);
    }
}
