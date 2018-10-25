public class WrongCurrencyLengthException extends Exception {

    public WrongCurrencyLengthException(String currencyString) {
        super(currencyString + " is not the length of 3");
    }
}
