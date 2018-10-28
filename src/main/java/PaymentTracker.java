import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentTracker {

    public ConcurrentHashMap<String, Integer> currencyBalances = new ConcurrentHashMap<>();

    public void printOutBalances() {
        for (Map.Entry<String, Integer> balance : currencyBalances.entrySet()) {
            if (balance.getValue() != 0) {
                System.out.println(balance.getKey() + ' ' + balance.getValue().toString());
            }
        }
    }
}
