package soft.account_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import soft.account_service.document.CustomerDoc;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerDoc, String> {
    Optional<CustomerDoc> findByUsername(String username);
}
