public class BalancePrintingThread extends Thread {

    PaymentProcessor processor;

    BalancePrintingThread(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(13000);
                processor.tracker.printOutBalances();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
