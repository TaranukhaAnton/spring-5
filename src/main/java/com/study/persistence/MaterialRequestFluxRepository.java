package com.study.persistence;

import com.study.model.MaterialRequest;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MaterialRequestFluxRepository  extends ReactiveMongoRepository<MaterialRequest, String> {
}
