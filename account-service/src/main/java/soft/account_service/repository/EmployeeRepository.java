package soft.account_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import soft.account_service.document.EmployeeDoc;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<EmployeeDoc, String> {
    Optional<EmployeeDoc> findByUsername(String username);
}
