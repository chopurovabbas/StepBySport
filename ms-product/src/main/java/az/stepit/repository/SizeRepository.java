package az.stepit.repository;

import az.stepit.dao.ProductEntity;
import az.stepit.dao.SizeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SizeRepository extends CrudRepository<SizeEntity, Long> {

    @Query("select value from SizeEntity as value" +
            " where value.productId = :id")
    List<SizeEntity> getSizes(@Param("id") Long id);

}
