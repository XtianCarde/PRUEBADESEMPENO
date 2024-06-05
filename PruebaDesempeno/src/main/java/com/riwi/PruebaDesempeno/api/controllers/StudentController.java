package com.riwi.PruebaDesempeno.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PruebaDesempeno.api.dto.request.StudentRequest;
import com.riwi.PruebaDesempeno.api.dto.response.ClassOfStudent;
import com.riwi.PruebaDesempeno.api.dto.response.StudentBasicResp;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.IStudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "students")
@AllArgsConstructor
@Tag(name = "Students")
public class StudentController {
    
    @Autowired
    private final IStudentService studentService;

    @Operation(summary = "Paginación estudiantes", description = "Lista paginada de los estudiantes registrados en el sistema y buscar por nombre")
    @GetMapping
    public ResponseEntity<Page<StudentBasicResp>> findStudentsByNameAndActive(@RequestParam (defaultValue = "1") int page,
    @RequestParam (defaultValue = "10") int size, @RequestParam(defaultValue = "") String name){
        return ResponseEntity.ok(this.studentService.findByNameAndisActive(page - 1, size, name));
    }

    @Operation(summary = "Obtiene por id", description = "Obtener la información de un estudiante por id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassOfStudent> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.studentService.getById(id));
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
    @PostMapping
    public ResponseEntity<StudentBasicResp> insertStudent(@Validated @RequestBody StudentRequest request){
        return ResponseEntity.ok(this.studentService.create(request));
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
    @PatchMapping(path = "/{id}/disable")
    public ResponseEntity<StudentBasicResp> disableStudent(@PathVariable Long id){
        return ResponseEntity.ok(this.studentService.get(id));
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
    @PutMapping(path = "/{id}")
    public ResponseEntity<StudentBasicResp> update(@Validated @RequestBody StudentRequest request,@PathVariable Long id){
        return ResponseEntity.ok(this.studentService.update(request, id));
    }
}
