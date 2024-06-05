package com.riwi.PruebaDesempeno.infrastructure.abstract_services;

import com.riwi.PruebaDesempeno.api.dto.request.LessonRequest;
import com.riwi.PruebaDesempeno.api.dto.response.LessonBasicResp;
import com.riwi.PruebaDesempeno.api.dto.response.MultimediaOfLesson;

public interface ILessonService extends CrudService<LessonRequest, LessonBasicResp, Long> {
    MultimediaOfLesson multimediaOfLesson(Long id);
}
