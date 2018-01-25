package com.study.service;


import com.study.model.MaterialRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface MaterialRequestFluxService {
    Mono<MaterialRequest> findById(String id);
    Flux<MaterialRequest> getAll();
    Mono<MaterialRequest> save(MaterialRequest mr);
    Mono<Void> delete(MaterialRequest mr);
}
