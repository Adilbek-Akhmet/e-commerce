package soft.product_service.utility;

import soft.ecommercelib.dto.product.ProductDto;
import soft.product_service.document.ProductDoc;

public class ProductMapper {

    private ProductMapper() {
    }

    public static ProductDoc toEntity(ProductDto dto) {
        return ProductDoc.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();
    }

    public static ProductDto toDto(ProductDoc doc) {
        return ProductDto.builder()
                .id(doc.getId())
                .name(doc.getName())
                .description(doc.getDescription())
                .quantity(doc.getQuantity())
                .price(doc.getPrice())
                .build();
    }
}
