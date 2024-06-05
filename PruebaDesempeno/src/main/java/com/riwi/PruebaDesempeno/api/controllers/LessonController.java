package com.riwi.PruebaDesempeno.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "lessons")
@AllArgsConstructor
public class LessonController {
    
    @Autowired
    private final ILessonService lessonService;


    @GetMapping(path = "/{id}/multimedia")
    public ResponseEntity<MultimediaOfLesson> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.lessonService.multimediaOfLesson(id));
    }

    @PostMapping
    public ResponseEntity<LessonBasicResp> insert(@Validated @RequestBody LessonRequest request){
        return ResponseEntity.ok(this.lessonService.create(request));
    }

    @PatchMapping(path = "/{id}/disable")
    public ResponseEntity<LessonBasicResp> disableLesson(@PathVariable Long id){
        return ResponseEntity.ok(this.lessonService.get(id));
    }
}
