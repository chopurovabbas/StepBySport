package az.stepit.mscart.model.exception;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException() {
        super("Account not found");
    }
}