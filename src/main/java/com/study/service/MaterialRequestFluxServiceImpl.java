package com.study.service;

import com.study.model.MaterialRequest;
import com.study.persistence.MaterialRequestFluxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MaterialRequestFluxServiceImpl implements MaterialRequestFluxService {

    @Autowired
    private MaterialRequestFluxRepository repo;

    @Override
    public Mono<MaterialRequest> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Flux<MaterialRequest> getAll() {
        return repo.findAll();
    }

    @Override
    public Mono<MaterialRequest> save(MaterialRequest mr) {
        return repo.save(mr);
    }

    @Override
    public Mono<Void> delete(MaterialRequest mr) {
        return repo.delete(mr);
    }
}
