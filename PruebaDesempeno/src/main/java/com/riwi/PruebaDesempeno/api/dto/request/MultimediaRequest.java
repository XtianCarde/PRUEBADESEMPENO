package com.riwi.PruebaDesempeno.api.dto.request;

import com.riwi.PruebaDesempeno.util.enums.TypeContent;

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
public class MultimediaRequest {
    
    @NotNull(message = "El tipo de contenido es requerido")
    private TypeContent typeContent;
    @NotBlank(message = "El url del contenido es requerido")
    @Size(min = 10, message = "La url debe contener minimo 10 caracteres")
    private String url;
    @NotNull(message = "El id de la leccion es requerido")
    @Min(value = 1, message = "El id de la leccion es requerido")
    private Long lessonId;
    @NotBlank(message = "El estado del estudiante es requerido")
    private Boolean active;
}
