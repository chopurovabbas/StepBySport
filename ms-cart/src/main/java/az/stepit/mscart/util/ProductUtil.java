package az.stepit.mscart.util;


import az.stepit.mscart.client.ProductApiClient;
import az.stepit.mscart.model.dto.CartDto;
import az.stepit.mscart.model.dto.ProductDto;
import az.stepit.mscart.model.exception.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ProductUtil {
    ProductApiClient productApiClient;

    public ProductUtil(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public void productExists(CartDto cartDto) {
        ProductDto productDto = null;
        List<ProductDto> products = productApiClient.getProducts();
        for(ProductDto p : products){
            if(Objects.equals(p.getId(), cartDto.getId())){
                productDto = p;
            }
        }

        if (productDto == null){
            throw new ProductNotFoundException();
        }
    }
}
