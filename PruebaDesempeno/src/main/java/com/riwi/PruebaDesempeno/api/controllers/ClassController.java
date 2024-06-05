package com.riwi.PruebaDesempeno.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PruebaDesempeno.api.dto.response.ClassBasicResp;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.IClassService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/class")
@AllArgsConstructor
public class ClassController {
    
    @Autowired
    private final IClassService classService;

    @GetMapping
    public ResponseEntity<Page<ClassBasicResp>> getAll(@RequestParam (defaultValue = "1") int page,
    @RequestParam (defaultValue = "10") int size){
        return ResponseEntity.ok(this.classService.getAll(page - 1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassBasicResp> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.classService.get(id));
    }
}
