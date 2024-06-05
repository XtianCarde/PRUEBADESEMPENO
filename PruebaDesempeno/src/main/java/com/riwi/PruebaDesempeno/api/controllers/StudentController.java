package com.riwi.PruebaDesempeno.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PruebaDesempeno.api.dto.response.StudentBasicResp;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.IStudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "students")
@AllArgsConstructor
public class StudentController {
    
    @Autowired
    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<Page<StudentBasicResp>> findStudentsByNameAndActive(@RequestParam (defaultValue = "1") int page,
    @RequestParam (defaultValue = "10") int size, @RequestParam(defaultValue = "") String name){
        return ResponseEntity.ok(this.studentService.findByNameAndisActive(page - 1, size, name));
    }
}
