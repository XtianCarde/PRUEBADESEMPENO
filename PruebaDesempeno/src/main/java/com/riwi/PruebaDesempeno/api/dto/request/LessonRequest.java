package com.riwi.PruebaDesempeno.api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {
    
    @NotBlank(message = "El titulo de la leccion es requerido")
    @Size(min = 5,max = 50,message = "El titulo debe contener entre 5 y 50 caracteres")
    private String title;
    @NotBlank(message = "El contenido de la leccion es requerido")
    @Size(min = 10, message = "El contenido debe contener al menos 10 caracteres")
    private String content;
    @NotNull(message = "El id de la clase es requerido")
    @Min(value = 1, message = "El id debe ser mayor que 0")
    private Long classId;
    @NotNull(message = "El estado de la leccion es requerido")
    private Boolean isActive;
}
