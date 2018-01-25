package com.study.web;

import com.study.model.MaterialRequest;
import com.study.service.MaterialRequestFluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "flux/mr")
public class MaterialRequestFluxController {

    @Autowired
    private MaterialRequestFluxService service;

    // API - read
    @GetMapping("/{id}")
    @ResponseBody
    @Validated
    public Mono<MaterialRequest> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping
    @ResponseBody
    public Flux<MaterialRequest> findAll() {
        return service.getAll();
    }


    // API - write

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Mono<MaterialRequest> saveOrUpdate(@RequestBody final MaterialRequest mr) {
        return service.save(mr);
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String delete(@RequestBody final MaterialRequest mr) {
        service.delete(mr);
        return "deleted successfully";
    }


}
