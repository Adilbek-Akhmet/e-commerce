package soft.ecommercelib.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import soft.ecommercelib.dto.account.CustomerDto;
import soft.ecommercelib.dto.product.ProductDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private CustomerDto customerDto;
    private ProductDto productDto;
    private String address;
    private String mobileNumber;
}
