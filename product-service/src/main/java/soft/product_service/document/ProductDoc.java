package soft.product_service.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("products")
public class ProductDoc {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
