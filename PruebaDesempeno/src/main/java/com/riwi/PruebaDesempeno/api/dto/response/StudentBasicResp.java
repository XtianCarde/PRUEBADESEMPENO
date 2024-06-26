package com.riwi.PruebaDesempeno.api.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class StudentBasicResp {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private Boolean isActive;
}
