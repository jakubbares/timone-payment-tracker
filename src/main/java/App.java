public class App {

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        PaymentProcessingThread paymentProcessing = new PaymentProcessingThread(processor);
        BalancePrintingThread balancePrinting = new BalancePrintingThread(processor);

        processor.processPaymentFile("Payments.txt");
        paymentProcessing.start();
        balancePrinting.start();
    }
}
