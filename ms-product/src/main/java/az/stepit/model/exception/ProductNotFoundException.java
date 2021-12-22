package az.stepit.model.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Product not found");
    }
}