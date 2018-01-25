package com.study.persistence;

import com.study.model.MaterialRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialRequestRepository extends MongoRepository<MaterialRequest, String> {
}
