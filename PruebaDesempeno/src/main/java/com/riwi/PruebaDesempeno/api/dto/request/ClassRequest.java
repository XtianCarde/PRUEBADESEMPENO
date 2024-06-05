package com.riwi.PruebaDesempeno.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRequest {
    
    @NotBlank(message = "El nombre de la tarea es requerido")
    @Size(min = 4,max = 100, message = "El nombre debe contener entre 4 y 100 caracteres")
    private String name;
    @NotBlank(message = "La descripcion es requerida")
    @Size(min = 10,message = "La descripción requiere como minimo 10 caracteres")
    private String description;
    @NotBlank(message = "El estado de la clase es requerido")
    private Boolean active;
}
