package ua.sigma.persistence;

import ua.sigma.model.MaterialRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialRequestRepository extends MongoRepository<MaterialRequest, String> {
}
