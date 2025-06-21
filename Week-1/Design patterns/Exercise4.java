import java.util.*;

public class Exercise4 {
    public static void main(String[] args){
        new AdapterTest().runTests();
    }
}

class AdapterTest {
    void runTests() {
        PaymentProcessor paypal = new PaypalAdapter(new PaypalPayment());
        PaymentProcessor stripe = new StripeAdapter(new StripePayment());

        paypal.processPayment();
        stripe.processPayment();
    }
}

interface PaymentProcessor {
    void processPayment();
}

class PaypalPayment {
    void makePaypalPayment() {
        System.out.println("Payment processed using PayPal.");
    }
}

class StripePayment {
    void makeStripePayment() {
        System.out.println("Payment processed using Stripe.");
    }
}

class PaypalAdapter implements PaymentProcessor {
    private PaypalPayment paypalPayment;

    public PaypalAdapter(PaypalPayment paypalPayment) {
        this.paypalPayment = paypalPayment;
    }

    @Override
    public void processPayment() {
        paypalPayment.makePaypalPayment();
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void processPayment() {
        stripePayment.makeStripePayment();
    }
}
