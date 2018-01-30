package ua.sigma.service;


import ua.sigma.model.MaterialRequest;

import java.util.List;
import java.util.Optional;


public interface MaterialRequestService {
    Optional<MaterialRequest> findById(String id);

    List<MaterialRequest> getAll();

    MaterialRequest save(MaterialRequest mr);

    void delete(String id);
}
