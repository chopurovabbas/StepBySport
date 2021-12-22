package az.stepit.repository;

import az.stepit.dao.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query("delete from ProductEntity as p" +
            " where p.name = :name")
    void deleteProductByName(@Param("name") String name);

}
