package ua.sigma.service;


import ua.sigma.model.MaterialRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface MaterialRequestFluxService {
    Mono<MaterialRequest> findById(String id);

    Flux<MaterialRequest> getAll();

    Mono<MaterialRequest> save(MaterialRequest mr);

    void delete(String id);
}
