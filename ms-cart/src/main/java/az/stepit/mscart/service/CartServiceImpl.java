package az.stepit.mscart.service;

import az.stepit.mscart.client.ProductApiClient;
import az.stepit.mscart.dao.entity.CartEntity;
import az.stepit.mscart.mapper.CartMapper;
import az.stepit.mscart.model.dto.CartDto;
import az.stepit.mscart.model.dto.ProductDto;
import az.stepit.mscart.repository.CartRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductApiClient client;

    public CartServiceImpl(CartRepository cartRepository,
                           ProductApiClient client) {
        this.cartRepository = cartRepository;
        this.client = client;
    }

    @Override
    public void addProduct(CartDto cartDto) {
        cartRepository.save(CartMapper.toEntity(cartDto));
    }

    @Override
    public List<ProductDto> getProducts(String username) {
        List<CartEntity> cartEntities = cartRepository.getCart(username);
        List<String> productsName = new ArrayList<>();
        for (CartEntity c : cartEntities) {
            productsName.add(c.getProductName());
        }
        List<ProductDto> products = client.getProducts();
        List<ProductDto> cartProducts = new ArrayList<>();
        for (ProductDto p : products) {
            for (String s : productsName) {
                if (Objects.equals(p.getName(), s)) {
                    cartProducts.add(p);
                }
            }
        }
        return cartProducts;
    }

    @Override
    @Transactional
    public void deleteProduct(CartDto cartDto) {
        cartRepository.deleteFromCart(cartDto.getUsername(), cartDto.getProductName());
    }
}
