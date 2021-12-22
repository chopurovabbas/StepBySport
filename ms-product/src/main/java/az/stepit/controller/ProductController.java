package az.stepit.controller;

import az.stepit.model.ProductDto;
import az.stepit.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
        return productDto;
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody String name) {
        productService.deleteProduct(name);
    }

}
