package az.stepit.mscart.controller;

import az.stepit.mscart.config.CarRequest;
import az.stepit.mscart.model.dto.CartDto;
import az.stepit.mscart.model.dto.ProductDto;
import az.stepit.mscart.service.CartService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    @ResponseBody
    public List<ProductDto> getProducts(@Valid @RequestParam String username) {
        return cartService.getProducts(username);
    }

    @PostMapping
    public void addProductToCart(@Valid @RequestBody CartDto cartDto) {
        cartService.addProduct(cartDto);
    }

    @DeleteMapping
    public CartDto deleteProductFromCart(@Valid @RequestBody CartDto cartDto) {
        cartService.deleteProduct(cartDto);
        return cartDto;
    }

}
