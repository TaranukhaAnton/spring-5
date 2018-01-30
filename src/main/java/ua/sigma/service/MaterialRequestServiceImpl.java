package ua.sigma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sigma.model.MaterialRequest;
import ua.sigma.persistence.MaterialRequestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialRequestServiceImpl implements MaterialRequestService {

    @Autowired
    private MaterialRequestRepository repo;


    @Override
    public Optional<MaterialRequest> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public List<MaterialRequest> getAll() {
        return repo.findAll();
    }

    @Override
    public MaterialRequest save(MaterialRequest mr) {
        return repo.save(mr);
    }

    @Override
    public void delete(String id) {
        Optional<MaterialRequest> optionalRequest = repo.findById(id);
        if (optionalRequest.isPresent()) {
            repo.delete(optionalRequest.get());
        }
    }
}
