package com.riwi.PruebaDesempeno.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.PruebaDesempeno.api.dto.request.LessonRequest;
import com.riwi.PruebaDesempeno.api.dto.response.LessonBasicResp;
import com.riwi.PruebaDesempeno.domain.repositories.LessonRepository;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.ILessonService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {
    
    @Autowired
    private final LessonRepository lessonRepository;

    @Override
    public LessonBasicResp create(LessonRequest rq) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public LessonBasicResp get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public LessonBasicResp update(LessonRequest rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<LessonBasicResp> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }


}
