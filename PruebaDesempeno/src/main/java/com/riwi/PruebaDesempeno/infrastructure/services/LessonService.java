package com.riwi.PruebaDesempeno.infrastructure.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.riwi.PruebaDesempeno.api.dto.request.LessonRequest;
import com.riwi.PruebaDesempeno.api.dto.response.LessonBasicResp;
import com.riwi.PruebaDesempeno.api.dto.response.MultimediaBasicResp;
import com.riwi.PruebaDesempeno.api.dto.response.MultimediaOfLesson;
import com.riwi.PruebaDesempeno.domain.entities.ClassEntity;
import com.riwi.PruebaDesempeno.domain.entities.LessonEntity;
import com.riwi.PruebaDesempeno.domain.entities.MultimediaEntity;
import com.riwi.PruebaDesempeno.domain.repositories.ClassRepository;
import com.riwi.PruebaDesempeno.domain.repositories.LessonRepository;
import com.riwi.PruebaDesempeno.domain.repositories.MultimediaRepository;
import com.riwi.PruebaDesempeno.infrastructure.abstract_services.ILessonService;
import com.riwi.PruebaDesempeno.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {
    
    @Autowired
    private final LessonRepository lessonRepository;

    @Autowired
    private final MultimediaRepository multimediaRepository;

    @Autowired final ClassRepository classRepository;

    @Override
    public LessonBasicResp create(LessonRequest rq) {
        LessonEntity lessonEntity = this.requestToLessonEntity(rq);

        this.lessonRepository.save(lessonEntity);
        lessonEntity.getMultimediaEntity().stream().forEach(multimedia -> {

            MultimediaEntity newMultimedia = MultimediaEntity.builder()
                .type(multimedia.getType())
                .url(multimedia.getUrl())
                .lessonEntity(multimedia.getLessonEntity())
                .build();

                this.multimediaRepository.save(newMultimedia);
            }
        );

        lessonEntity.setMultimediaEntity(new ArrayList<>());

        return this.entityToLessonBasicResp(lessonEntity);
        
    }

    @Override
    public LessonBasicResp get(Long id) {
        LessonEntity entity = this.find(id);
        entity.setIsActive(false);
        return this.entityToLessonBasicResp(this.lessonRepository.save(entity));
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

    @Override
    public MultimediaOfLesson multimediaOfLesson(Long id) {
        LessonEntity entity = this.find(id);

        List<MultimediaBasicResp> multimedia = entity.getMultimediaEntity()
                            .stream()
                            .map(this::entitymMultimediaToBasicResp)
                            .collect(Collectors.toList());

        return MultimediaOfLesson.builder()
                    .id(entity.getId())
                    .title(entity.getTitle())
                    .contentMulti(multimedia)
                    .content(entity.getContent())
                    .createdAt(entity.getCreatedAt())
                    .isActive(entity.getIsActive())
                    .build();
    }

    private LessonEntity requestToLessonEntity(LessonRequest request){

        return LessonEntity.builder()
                    .title(request.getTitle())
                    .content(request.getContent())
                    .classEntity(this.findClass(request.getClassId()))
                    .isActive(request.getIsActive())
                    .build();
    }
    
    private LessonBasicResp entityToLessonBasicResp(LessonEntity entity){
        return LessonBasicResp.builder()
                    .id(entity.getId())
                    .content(entity.getContent())
                    .createdAt(entity.getCreatedAt())
                    .title(entity.getTitle())
                    .isActive(entity.getIsActive())
                    .build();
    }

    private MultimediaBasicResp entitymMultimediaToBasicResp(MultimediaEntity entity){
        return MultimediaBasicResp.builder()
                    .id(entity.getId())
                    .createdAt(entity.getCreatedAt())
                    .typeContent(entity.getType())
                    .isActive(entity.getIsActive())
                    .build();
    }

    private LessonEntity find(Long id){
        return this.lessonRepository.findById(id)
                            .orElseThrow(() -> new BadRequestException("La leccion por el id suministrado no se encuentra"));
    }

    private ClassEntity findClass(Long id){
        return this.classRepository.findById(id)
                                .orElseThrow(() -> new BadRequestException("La clase por el id suministrado no existe"));
    }


}
