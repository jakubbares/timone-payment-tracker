public class BalancePrintingThread extends Thread {

    PaymentProcessor processor;

    BalancePrintingThread(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void run() {
        processor.tracker.printOutBalances();
    }
}
