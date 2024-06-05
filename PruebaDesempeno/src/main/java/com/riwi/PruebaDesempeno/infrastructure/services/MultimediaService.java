package com.riwi.PruebaDesempeno.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.PruebaDesempeno.api.dto.request.MultimediaRequest;
import com.riwi.PruebaDesempeno.api.dto.response.MultimediaBasicResp;
import com.riwi.PruebaDesempeno.domain.repositories.MultimediaRepository;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.IMultimediaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MultimediaService implements IMultimediaService {
    
    @Autowired
    private final MultimediaRepository multimediaRepository;

    @Override
    public MultimediaBasicResp create(MultimediaRequest rq) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public MultimediaBasicResp get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public MultimediaBasicResp update(MultimediaRequest rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<MultimediaBasicResp> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
}
