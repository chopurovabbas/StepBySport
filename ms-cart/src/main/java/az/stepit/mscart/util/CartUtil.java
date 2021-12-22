package az.stepit.mscart.util;

import az.stepit.mscart.repository.CartRepository;
import org.springframework.stereotype.Component;


@Component
public class CartUtil {
    private final CartRepository cartRepository;

    public CartUtil(CartRepository accountRepository) {
        this.cartRepository = accountRepository;
    }

/*    public CartEntity cartExists(Long id) throws CartNotFoundException {
        Optional<CartEntity> entityOptional = cartRepository.findById(id);
        if (entityOptional.isEmpty()) {
            throw new CartNotFoundException();
        }
        return entityOptional.get();
    }*/

}
