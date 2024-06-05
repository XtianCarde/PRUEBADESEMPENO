package com.riwi.PruebaDesempeno.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.PruebaDesempeno.api.dto.request.ClassRequest;
import com.riwi.PruebaDesempeno.api.dto.response.ClassBasicResp;
import com.riwi.PruebaDesempeno.domain.repositories.ClassRepository;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.IClassService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService implements IClassService {
    @Autowired
    private final ClassRepository classRepository;
    @Override
    public ClassBasicResp create(ClassRequest rq) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ClassBasicResp get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ClassBasicResp update(ClassRequest rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<ClassBasicResp> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
