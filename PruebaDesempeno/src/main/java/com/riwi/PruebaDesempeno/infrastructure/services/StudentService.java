package com.riwi.PruebaDesempeno.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.riwi.PruebaDesempeno.api.dto.request.StudentRequest;
import com.riwi.PruebaDesempeno.api.dto.response.ClassBasicResp;
import com.riwi.PruebaDesempeno.api.dto.response.ClassOfStudent;
import com.riwi.PruebaDesempeno.api.dto.response.StudentBasicResp;
import com.riwi.PruebaDesempeno.domain.entities.ClassEntity;
import com.riwi.PruebaDesempeno.domain.entities.StudentEntity;
import com.riwi.PruebaDesempeno.domain.repositories.StudentRepository;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.IStudentService;
import com.riwi.PruebaDesempeno.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {
    
    @Autowired
    private final StudentRepository studentRepository;

    @Override
    public StudentBasicResp create(StudentRequest rq) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }


    @Override
    public StudentBasicResp get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }


    @Override
    public StudentBasicResp update(StudentRequest rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    @Override
    public Page<StudentBasicResp> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }


    @Override
    public Page<StudentBasicResp> findByNameAndisActive(int page, int size, String name) {
        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.studentRepository.findByNameAndIsActive(pagination, name,true)
                                .map(this::entityToBasicResp);
    }


    @Override
    public ClassOfStudent getById(Long id) {
        return this.entityToClassOfStudent(id);
    }

    private StudentBasicResp entityToBasicResp(StudentEntity entity){
        return StudentBasicResp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .createdAt(entity.getCreatedAt())
                .isActive(entity.getIsActive())
                .build();
    }

    private ClassOfStudent entityToClassOfStudent(Long id){
        StudentEntity entity = this.find(id);
        ClassBasicResp classBasicResp = ClassBasicResp.builder()
                        .id(entity.getClassEntity().getId())
                        .createdAt(entity.getClassEntity().getCreatedAt())
                        .description(entity.getClassEntity().getDescription())
                        .name(entity.getClassEntity().getName())
                        .isActive(entity.getClassEntity().getIsActive())
                        .build();

        return ClassOfStudent.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .createdAt(entity.getCreatedAt())
                .isActive(entity.getIsActive())
                .classBasicResp(classBasicResp)
                .build();
    }

    private StudentEntity find(Long id){
        return this.studentRepository.findById(id)
                                .orElseThrow(() -> new BadRequestException("No hay estudiantes por este numero"));
    }
}
