package az.stepit.mscart.mapper;


import az.stepit.mscart.dao.entity.CartEntity;
import az.stepit.mscart.model.dto.CartDto;

public class CartMapper {
    public static CartEntity toEntity(CartDto dto) {
        CartEntity entity = new CartEntity();
        entity.setUsername(dto.getUsername());
        entity.setProductName(dto.getProductName());
        return entity;
    }

}

