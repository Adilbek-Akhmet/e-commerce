package soft.deliveryservice.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import soft.ecommercelib.dto.account.EmployeeDto;
import soft.ecommercelib.dto.order.OrderDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("deliveries")
public class DeliveryDoc {
    @Id
    private String id;
    private OrderDto orderDto;
    private EmployeeDto deliveryEmployee;
}
