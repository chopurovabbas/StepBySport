package az.stepit.mscart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private Long price;
    private List<Long> size;
    private List<String> imageUrl;
    private String collection;

}
