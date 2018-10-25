import java.util.Scanner;

public class PaymentProcessingThread extends Thread {

    PaymentProcessor processor;

    PaymentProcessingThread(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            processor.processLine(line);
        }
    }
}
