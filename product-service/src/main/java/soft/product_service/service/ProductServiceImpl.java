package soft.product_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import soft.ecommercelib.dto.product.ProductDto;
import soft.product_service.document.ProductDoc;
import soft.product_service.repository.ProductRepository;
import soft.product_service.utility.ProductMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean exists(String name) {
        return productRepository.findByName(name).isPresent();
    }

    public ProductDto findById(String id) {
        return ProductMapper.toDto(productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id)));
    }

    public List<ProductDto> findProductInRange(double min, double max) {
        return productRepository.findByPriceBetween(Range.closed(min, max)).stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto save(ProductDto productDto) {
        return ProductMapper.toDto(productRepository.save(ProductMapper.toEntity(productDto)));
    }

    public ProductDto update(ProductDto updatedProductDto, String id) {
        ProductDoc doc = productRepository.findById(id)
                .map(productDoc -> {
                    productDoc.setName(updatedProductDto.getName());
                    productDoc.setPrice(updatedProductDto.getPrice());
                    productDoc.setQuantity(updatedProductDto.getQuantity());
                    return productDoc;
                })
                .orElseThrow(() -> new NoSuchElementException("Product with id: " + id + " not found"));

        return ProductMapper.toDto(productRepository.save(doc));
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
}
