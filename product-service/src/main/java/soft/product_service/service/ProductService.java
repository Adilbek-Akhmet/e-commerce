package soft.product_service.service;

import soft.ecommercelib.dto.product.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    Boolean exists(String name);
    ProductDto findById(String id);
    List<ProductDto> findProductInRange(double min, double max);
    ProductDto save(ProductDto productDto);
    ProductDto update(ProductDto updatedProductDto, String id);
    void deleteAll();
}
