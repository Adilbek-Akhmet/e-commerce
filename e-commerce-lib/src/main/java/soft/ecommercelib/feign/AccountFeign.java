package soft.ecommercelib.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import soft.ecommercelib.dto.account.CustomerDto;
import soft.ecommercelib.dto.account.EmployeeDto;

@FeignClient(name = "account-service")
public interface AccountFeign {

    @GetMapping("/customers/{username}")
    CustomerDto findByCustomerName(@PathVariable String username);

    @GetMapping("/employees/{username}")
    EmployeeDto findByEmployeeName(@PathVariable String username);
}
