public class WrongCurrencyLengthException extends Exception {

    String currencyString;

    public WrongCurrencyLengthException(String currencyString) {
        super(currencyString);
    }
}
