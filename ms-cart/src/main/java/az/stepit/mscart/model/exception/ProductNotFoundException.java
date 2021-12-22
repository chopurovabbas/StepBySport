package az.stepit.mscart.model.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Customer not found");
    }
}