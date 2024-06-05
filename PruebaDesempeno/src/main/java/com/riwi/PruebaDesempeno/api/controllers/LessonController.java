package com.riwi.PruebaDesempeno.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PruebaDesempeno.api.dto.request.LessonRequest;
import com.riwi.PruebaDesempeno.api.dto.response.LessonBasicResp;
import com.riwi.PruebaDesempeno.api.dto.response.MultimediaOfLesson;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.ILessonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "lessons")
@AllArgsConstructor
@Tag(name = "Lessons")
public class LessonController {
    
    @Autowired
    private final ILessonService lessonService;

    @Operation(summary = "Insertar compañias", description = "")
    @GetMapping(path = "/{id}/multimedia")
    public ResponseEntity<MultimediaOfLesson> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.lessonService.multimediaOfLesson(id));
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
    @Operation(summary = "Guardar una leccion", description = "guardar una lección con su respectivo contenido multimedia")
    @PostMapping
    public ResponseEntity<LessonBasicResp> insert(@Validated @RequestBody LessonRequest request){
        return ResponseEntity.ok(this.lessonService.create(request));
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
    @Operation(summary = "Deshabilitar una leccion", description = "deshabilitar una leccion y su contenido multimedia")
    @PatchMapping(path = "/{id}/disable")
    public ResponseEntity<LessonBasicResp> disableLesson(@PathVariable Long id){
        return ResponseEntity.ok(this.lessonService.get(id));
    }
}
