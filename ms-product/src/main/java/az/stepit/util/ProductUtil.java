package az.stepit.util;

import az.stepit.dao.ProductEntity;
import az.stepit.model.exception.ProductNotFoundException;
import az.stepit.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductUtil {
    private final ProductRepository productRepository;

    public ProductUtil(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity productExists(Long id) {
        Optional<ProductEntity> entityOptional = productRepository.findById(id);
        if (entityOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return entityOptional.get();
    }

}
