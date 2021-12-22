package az.stepit.mscart.service;

import az.stepit.mscart.model.dto.CartDto;
import az.stepit.mscart.model.dto.ProductDto;

import java.util.List;


public interface CartService {

    void addProduct(CartDto cartDto);

    List<ProductDto> getProducts(String username);

    void deleteProduct(CartDto cartDto);
}
