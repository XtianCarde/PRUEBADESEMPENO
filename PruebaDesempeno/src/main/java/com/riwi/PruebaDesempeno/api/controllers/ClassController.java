package com.riwi.PruebaDesempeno.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PruebaDesempeno.api.dto.request.ClassRequest;
import com.riwi.PruebaDesempeno.api.dto.response.ClassBasicResp;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.IClassService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/class")
@AllArgsConstructor
@Tag(name = "Class")
public class ClassController {
    
    @Autowired
    private final IClassService classService;

    @Operation(summary = "Lista las clases paginadas", description = "Muestra la lista de clases paginadas en size 10 y se recibe por requestparam")
    @GetMapping
    public ResponseEntity<Page<ClassBasicResp>> getAll(@RequestParam (defaultValue = "1") int page,
    @RequestParam (defaultValue = "10") int size){
        return ResponseEntity.ok(this.classService.getAll(page - 1, size));
    }

    @Operation(summary = "Lista una clase por id", description = "Muestra la una clase en especifico por su identificador")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassBasicResp> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.classService.get(id));
    }

    @ApiResponse(
        responseCode = "400",
        description = "Cuando el id no es válido",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class)
            )
        }
    )
    @Operation(summary = "Agrega una nueva clase")
    @PostMapping
    public ResponseEntity<ClassBasicResp> insert(@Validated @RequestBody ClassRequest request){
        return ResponseEntity.ok(this.classService.create(request));
    }
}
