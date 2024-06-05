package com.riwi.PruebaDesempeno.infrastructure.abstract_services;

import com.riwi.PruebaDesempeno.api.dto.request.LessonRequest;
import com.riwi.PruebaDesempeno.api.dto.response.LessonBasicResp;

public interface IStudentService extends CrudService<LessonRequest, LessonBasicResp, Long> {
    
}
