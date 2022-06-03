package soft.deliveryservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import soft.deliveryservice.document.DeliveryDoc;

public interface DeliveryRepository extends ReactiveMongoRepository<DeliveryDoc, String> {
}
