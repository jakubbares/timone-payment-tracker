import java.util.HashMap;
import java.util.Map;

public class PaymentTracker {

    public HashMap<String, Integer> currencyBalances = new HashMap<>();

    public void printOutBalances() {
        for (Map.Entry<String, Integer> balance : currencyBalances.entrySet()) {
            if (balance.getValue() != 0) {
                System.out.println(balance.getKey().toString() + ' ' + balance.getValue().toString());
            }
        }
    }
}
