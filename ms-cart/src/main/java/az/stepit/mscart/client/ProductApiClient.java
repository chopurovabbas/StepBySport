package az.stepit.mscart.client;

import az.stepit.mscart.model.dto.ProductDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductApiClient {
    private final RestTemplate restTemplate;

    public ProductApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDto> getProducts() {
        String apiUrl = "http://localhost:8080/products";
        ResponseEntity<List<ProductDto>> productResponse =
                restTemplate.exchange(apiUrl,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<ProductDto>>() {
                        });
        return productResponse.getBody();
    }
}
