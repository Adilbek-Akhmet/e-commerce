package soft.deliveryservice.utility;

import soft.deliveryservice.document.DeliveryDoc;
import soft.ecommercelib.dto.delivery.DeliveryDto;

public class DeliveryMapper {

    private DeliveryMapper() {
    }

    public static DeliveryDto toDto(DeliveryDoc doc) {
        return DeliveryDto.builder()
                .orderDto(doc.getOrderDto())
                .deliveryEmployee(doc.getDeliveryEmployee())
                .build();
    }

    public static DeliveryDoc toEntity(DeliveryDto dto) {
        return DeliveryDoc.builder()
                .orderDto(dto.getOrderDto())
                .deliveryEmployee(dto.getDeliveryEmployee())
                .build();
    }
}
