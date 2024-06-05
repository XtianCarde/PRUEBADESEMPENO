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
public class StudentRequest {
    
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 4, max = 50, message = "El nombre debe contener entre 4 y 50 caracteres")
    private String name;
    @NotBlank(message = "El email es requerido")
    private String email;
    @NotNull(message = "El id de la clase es requerido")
    @Min(value = 1, message = "El id debe ser mayor que 0")
    private Long classId;
    @NotBlank(message = "El estado del estudiante es requerido")
    private Boolean active;
}
