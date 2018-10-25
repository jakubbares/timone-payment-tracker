import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class PaymentProcessingTest {

    PaymentProcessor processor = null;

    @Before
    public void prepareProcessor() {
        processor = new PaymentProcessor();
    }

    @Test
    public void testProcessLine() {
        String line1 = "CZK 1000";
        String line2 = "CZK -700";

        processor.processLine(line1);
        processor.processLine(line2);

        Integer actual = processor.tracker.currencyBalances.get("CZK");
        Integer expected = 300;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testProcessFile() {
        processor.processPaymentFile("Payments.txt");

        Integer actual = processor.tracker.currencyBalances.get("USD");
        Integer expected = 400;
        Assert.assertEquals(expected, actual);
    }
}
