package com.riwi.PruebaDesempeno.api.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LessonBasicResp {
    
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Boolean isActive;
}
