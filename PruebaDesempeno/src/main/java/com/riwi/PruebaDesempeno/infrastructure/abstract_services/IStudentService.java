package com.riwi.PruebaDesempeno.infrastructure.abstract_services;

import org.springframework.data.domain.Page;
import com.riwi.PruebaDesempeno.api.dto.request.StudentRequest;
import com.riwi.PruebaDesempeno.api.dto.response.ClassOfStudent;
import com.riwi.PruebaDesempeno.api.dto.response.StudentBasicResp;

public interface IStudentService extends CrudService<StudentRequest, StudentBasicResp, Long> {
    Page<StudentBasicResp> findByNameAndisActive(int page, int size, String name);
    ClassOfStudent getById(Long id);
}
