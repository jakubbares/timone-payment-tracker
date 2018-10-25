import java.util.Scanner;
import java.util.Timer;

public class PaymentProcessingThread extends Thread {

    PaymentProcessor processor;

    PaymentProcessingThread(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void run() {
        Timer timer = new Timer();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("quit")) {
                break;
            }
            processor.processLine(line);
        }
    }
}
