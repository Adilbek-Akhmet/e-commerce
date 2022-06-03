package soft.account_service.utility;

import soft.account_service.document.EmployeeDoc;
import soft.ecommercelib.dto.account.EmployeeDto;

public class EmployeeMapper {

    private EmployeeMapper() {
    }

    public static EmployeeDto toDto(EmployeeDoc doc) {
        return EmployeeDto.builder()
                .id(doc.getId())
                .username(doc.getUsername())
                .mobileNumber(doc.getMobileNumber())
                .email(doc.getEmail())
                .address(doc.getAddress())
                .department(doc.getDepartment())
                .build();
    }

    public static EmployeeDoc toEntity(EmployeeDto dto) {
        return EmployeeDoc.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .mobileNumber(dto.getMobileNumber())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .department(dto.getDepartment())
                .build();
    }
}
