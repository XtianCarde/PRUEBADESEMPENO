package com.riwi.PruebaDesempeno.api.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentBasicResp {
    private Long id;
    private String name;
    private String email;
    private ClassBasicResp classBasic;
    private LocalDateTime createdAt;
    private Boolean active;
}
