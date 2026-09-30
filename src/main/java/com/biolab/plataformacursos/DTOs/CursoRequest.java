package com.biolab.plataformacursos.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String cargaHoraria;
}
