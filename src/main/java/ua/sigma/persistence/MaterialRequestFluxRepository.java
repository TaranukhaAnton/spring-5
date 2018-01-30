package ua.sigma.persistence;

import ua.sigma.model.MaterialRequest;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MaterialRequestFluxRepository  extends ReactiveMongoRepository<MaterialRequest, String> {
}
