package com.riwi.PruebaDesempeno.infrastructure.abstract_services;

import com.riwi.PruebaDesempeno.api.dto.request.MultimediaRequest;
import com.riwi.PruebaDesempeno.api.dto.response.MultimediaBasicResp;

public interface IMultimediaService extends CrudService<MultimediaRequest, MultimediaBasicResp, Long> {
    
}
