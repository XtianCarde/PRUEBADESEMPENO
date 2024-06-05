package com.riwi.PruebaDesempeno.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.PruebaDesempeno.api.dto.request.ClassRequest;
import com.riwi.PruebaDesempeno.api.dto.response.ClassBasicResp;
import com.riwi.PruebaDesempeno.domain.entities.ClassEntity;
import com.riwi.PruebaDesempeno.domain.repositories.ClassRepository;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.IClassService;
import com.riwi.PruebaDesempeno.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService implements IClassService {
    @Autowired
    private final ClassRepository classRepository;
    @Override
    public ClassBasicResp create(ClassRequest rq) {
        ClassEntity entity = this.requestToClassEntity(rq);

        return this.entityToBasicResp(this.classRepository.save(entity));
    }

    @Override
    public ClassBasicResp get(Long id) {
        return this.entityToBasicResp(this.find(id));
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
        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.classRepository.findAll(pagination)
                                .map(this::entityToBasicResp);
    }
    
    public ClassBasicResp entityToBasicResp(ClassEntity entity){
        return ClassBasicResp.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .description(entity.getDescription())
                    .createdAt(entity.getCreatedAt())
                    .isActive(entity.getIsActive())
                    .build();
    }

    public ClassEntity requestToClassEntity(ClassRequest request){

        return ClassEntity.builder()
                    .description(request.getDescription())
                    .isActive(request.getIsActive())
                    .name(request.getName())
                    .build();
    }

    private ClassEntity find(Long id){
        return this.classRepository.findById(id)
                                .orElseThrow(() -> new BadRequestException("La clase por el id suministrado no existe"));
    }
}
