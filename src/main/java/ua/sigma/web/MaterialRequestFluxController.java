package ua.sigma.web;

import ua.sigma.model.MaterialRequest;
import ua.sigma.service.MaterialRequestFluxService;
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


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "deleted successfully";
    }


}
