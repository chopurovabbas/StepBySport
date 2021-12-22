package az.stepit.repository;

import az.stepit.dao.ImageEntity;
import az.stepit.dao.SizeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ImageRepository extends CrudRepository<ImageEntity, Long> {

    @Query("select value from ImageEntity as value" +
            " where value.productId = :id")
    List<ImageEntity> getImages(@Param("id") Long id);

}
