package com.riwi.PruebaDesempeno.api.dto.response;

import java.time.LocalDateTime;
import com.riwi.PruebaDesempeno.util.enums.TypeContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaBasicResp {
    private Long id;
    private TypeContent typeContent;
    private String url;
    private LocalDateTime createdAt;
    private Boolean isActive; 
}
