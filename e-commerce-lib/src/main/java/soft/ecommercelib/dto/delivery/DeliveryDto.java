package soft.ecommercelib.dto.delivery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import soft.ecommercelib.dto.account.EmployeeDto;
import soft.ecommercelib.dto.order.OrderDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDto {
    private OrderDto orderDto;
    private EmployeeDto deliveryEmployee;
}
