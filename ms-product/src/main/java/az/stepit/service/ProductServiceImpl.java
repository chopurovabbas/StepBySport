package az.stepit.service;

import az.stepit.dao.ImageEntity;
import az.stepit.dao.ProductEntity;
import az.stepit.dao.SizeEntity;
import az.stepit.mapper.ProductMapper;
import az.stepit.model.ProductDto;
import az.stepit.repository.ImageRepository;
import az.stepit.repository.ProductRepository;
import az.stepit.repository.SizeRepository;
import az.stepit.util.ProductUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SizeRepository sizeRepository;
    private final ImageRepository imageRepository;
    private final ProductUtil productUtil;

    public ProductServiceImpl(ProductRepository productRepository,
                              SizeRepository sizeRepository,
                              ImageRepository imageRepository,
                              ProductUtil productUtil) {
        this.productRepository = productRepository;
        this.sizeRepository = sizeRepository;
        this.imageRepository = imageRepository;
        this.productUtil = productUtil;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> products = new ArrayList<>();

        productRepository.findAll().forEach(e -> {

            List<SizeEntity> sizes = sizeRepository.getSizes(e.getId());
            List<ImageEntity> images = imageRepository.getImages(e.getId());

            products.add(ProductMapper.toDto(e, sizes ,images));


        });
        return products;
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductEntity entity = productUtil.productExists(id);
        List<SizeEntity> sizes = sizeRepository.getSizes(id);
        List<ImageEntity> images = imageRepository.getImages(id);
        return ProductMapper.toDto(entity, sizes, images);
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        productRepository.save(ProductMapper.toEntity(productDto));
        List<SizeEntity> sizeEntities = ProductMapper.toSizeEntity(productDto);
        List<ImageEntity> imageEntities = ProductMapper.toImageEntity(productDto);
        sizeRepository.saveAll(sizeEntities);
        imageRepository.saveAll(imageEntities);
        return productDto;
    }

    @Override
    public void deleteProduct(String name) {
        productRepository.deleteProductByName(name);
    }

}
