package az.stepit.mscart.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart",uniqueConstraints={@UniqueConstraint(columnNames={"product_name"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(name = "product_name")
    private String productName;

}
