package az.stepit.mscart.repository;

import az.stepit.mscart.dao.entity.CartEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CartRepository extends CrudRepository<CartEntity, Long> {

    @Query("select cart from CartEntity as cart" +
            " where cart.username = :username")
    List<CartEntity> getCart(@Param("username") String username);

    @Modifying
    @Query("delete from CartEntity cart " +
            " where cart.username = :username and cart.productName = :productName")
    void deleteFromCart(@Param("username") String username,
                        @Param("productName") String productName);

}
