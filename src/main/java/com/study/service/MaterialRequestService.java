package com.study.service;


import com.study.model.MaterialRequest;

import java.util.List;
import java.util.Optional;


public interface MaterialRequestService {
    Optional<MaterialRequest> findById(String id);
    List<MaterialRequest> getAll();
    MaterialRequest save(MaterialRequest mr);
    void delete(MaterialRequest mr);
}
