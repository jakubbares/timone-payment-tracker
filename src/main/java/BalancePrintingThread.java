import java.util.concurrent.TimeUnit;

public class BalancePrintingThread extends Thread {

    PaymentProcessor processor;

    BalancePrintingThread(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                TimeUnit.MINUTES.sleep(1);
                processor.tracker.printOutBalances();
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
}
