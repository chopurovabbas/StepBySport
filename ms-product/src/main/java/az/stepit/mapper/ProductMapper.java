package az.stepit.mapper;


import az.stepit.dao.ImageEntity;
import az.stepit.dao.ProductEntity;
import az.stepit.dao.SizeEntity;
import az.stepit.model.ProductDto;

import java.util.ArrayList;
import java.util.List;


public class ProductMapper {
    public static ProductDto toDto(ProductEntity entity, List<SizeEntity> sizeEntity, List<ImageEntity> imageEntity) {
        List<Long> size = new ArrayList<>();

        for (SizeEntity s : sizeEntity) {
            size.add(s.getValue());
        }

        List<String> image = new ArrayList<>();

        for (ImageEntity i : imageEntity) {
            image.add(i.getValue());
        }

        ProductDto dto = new ProductDto();
        dto.setName(entity.getName());
        dto.setId(entity.getId());
        dto.setPrice(entity.getPrice());
        dto.setSize(size);
        dto.setImageUrl(image);

        dto.setCollection(entity.getCollection());
        dto.setModel(entity.getModel());

        return dto;

    }

    public static ProductEntity toEntity(ProductDto dto) {
        List<Long> size = dto.getSize();
        List<String> image = dto.getImageUrl();

        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        entity.setCollection(dto.getCollection());
        entity.setModel(dto.getModel());

        for (Long s : size) {
            SizeEntity sizeEntity = new SizeEntity();
            sizeEntity.setProductId(dto.getId());
            sizeEntity.setValue(s);
        }

        for (String u : image) {
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setProductId(dto.getId());
            imageEntity.setValue(u);
        }

        return entity;
    }

    public static List<SizeEntity> toSizeEntity(ProductDto dto) {

        List<SizeEntity> sizeEntity = new ArrayList<>();
        List<Long> size = dto.getSize();

        for (Long s : size) {
            SizeEntity sizeEntityProduct = new SizeEntity();
            sizeEntityProduct.setProductId(dto.getId());
            sizeEntityProduct.setValue(s);
            sizeEntity.add(sizeEntityProduct);
        }

        return sizeEntity;
    }

    public static List<ImageEntity> toImageEntity(ProductDto dto) {

        List<ImageEntity> imageEntities = new ArrayList<>();
        List<String> image = dto.getImageUrl();

        for (String u : image) {
            ImageEntity imageEntityProduct = new ImageEntity();
            imageEntityProduct.setProductId(dto.getId());
            imageEntityProduct.setValue(u);
            imageEntities.add(imageEntityProduct);
        }

        return imageEntities;
    }


}

