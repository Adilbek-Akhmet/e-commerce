package soft.account_service.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import soft.ecommercelib.dto.account.Department;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees")
public class EmployeeDoc {
    @Id
    private String id;
    private String username;
    private String email;
    private String mobileNumber;
    private String address;
    private Department department;
}
