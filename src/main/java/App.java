import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        BalancePrintingThread balancePrinting = new BalancePrintingThread(processor);

        processor.processPaymentFile("Payments.txt");
        balancePrinting.start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("quit")) {
                balancePrinting.interrupt();
                break;
            }
            processor.processLine(line);
        }


    }
}
