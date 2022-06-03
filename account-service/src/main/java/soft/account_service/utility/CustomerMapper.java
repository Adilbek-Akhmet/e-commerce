package soft.account_service.utility;

import soft.account_service.document.CustomerDoc;
import soft.ecommercelib.dto.account.CustomerDto;

public class CustomerMapper {

    private CustomerMapper() {
    }

    public static CustomerDto toDto(CustomerDoc doc) {
        return CustomerDto.builder()
                .id(doc.getId())
                .username(doc.getUsername())
                .mobileNumber(doc.getMobileNumber())
                .email(doc.getEmail())
                .address(doc.getAddress())
                .build();
    }

    public static CustomerDoc toEntity(CustomerDto dto) {
        return CustomerDoc.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .mobileNumber(dto.getMobileNumber())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .build();
    }
}
