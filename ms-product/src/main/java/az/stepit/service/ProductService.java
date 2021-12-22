package az.stepit.service;

import az.stepit.model.ProductDto;
import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto addProduct(ProductDto productDto);

    void deleteProduct(String name);
}
