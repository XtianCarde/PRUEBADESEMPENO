package com.riwi.PruebaDesempeno.infrastructure.abstract_services;

import com.riwi.PruebaDesempeno.api.dto.request.ClassRequest;
import com.riwi.PruebaDesempeno.api.dto.response.ClassBasicResp;

public interface IClassService extends CrudService<ClassRequest, ClassBasicResp, Long> {
    
}
