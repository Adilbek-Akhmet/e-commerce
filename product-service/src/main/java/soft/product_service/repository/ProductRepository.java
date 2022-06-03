package soft.product_service.repository;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.MongoRepository;
import soft.product_service.document.ProductDoc;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductDoc, String> {
    List<ProductDoc> findByPriceBetween(Range<Double> priceRange);
    Optional<ProductDoc> findByName(String name);
}
