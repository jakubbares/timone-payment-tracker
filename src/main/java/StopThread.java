import java.util.Scanner;

public class StopThread extends Thread {

    PaymentProcessor processor;

    StopThread(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("quit")) {
                processor.allThreadsRunning = false;
                interrupt();
            }
        }
    }
}
