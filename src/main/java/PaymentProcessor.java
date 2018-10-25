import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PaymentProcessor {

    PaymentTracker tracker = new PaymentTracker();
    Boolean allThreadsRunning = true;

    public void processPaymentFile(String fileName) {
        try {
            InputStream stream = PaymentProcessor.class.getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String line = null;
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void processLine(String line) {
        if (line.equalsIgnoreCase("quit")) { return; }
        String[] lineData = line.split(" ");
        try {
            if (lineData[0].length() != 3) throw new WrongCurrencyLengthException(lineData[0].toUpperCase());
            Payment payment = new Payment(lineData[0].toUpperCase(), Integer.parseInt(lineData[1]));
            processPayment(payment);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Not enough arguments in " + line);
        } catch (NumberFormatException ex) {
            System.out.println("Amount not found in " + line);
        } catch (WrongCurrencyLengthException ex) {
            System.out.println(ex);
        }
    }

    private void processPayment(Payment payment) {
        Integer balance = tracker.currencyBalances.get(payment.currency);
        if (balance == null) {
            balance = 0;
        }
        balance += payment.amount;
        tracker.currencyBalances.put(payment.currency, balance);
    }
}
