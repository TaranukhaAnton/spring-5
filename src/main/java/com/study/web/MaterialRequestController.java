package com.study.web;

import com.study.model.MaterialRequest;
import com.study.service.MaterialRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/mr")
public class MaterialRequestController {

    @Autowired
    private MaterialRequestService materialRequestService;

    // API - read

    @GetMapping("/{id}")
    @ResponseBody
      public Optional<MaterialRequest> findById(@PathVariable("id") String id) {
        return materialRequestService.findById(id);
    }

    @GetMapping
    @ResponseBody
    public List<MaterialRequest> findAll() {
        return materialRequestService.getAll();
    }


    // API - write

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MaterialRequest saveOrUpdate(@RequestBody final MaterialRequest mr) {
        return materialRequestService.save(mr);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String delete(@RequestBody final MaterialRequest mr) {
        materialRequestService.delete(mr);
        return "deleted successfully";
    }



}
