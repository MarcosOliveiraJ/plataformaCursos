package com.biolab.plataformacursos.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponse {
    private long id;

    private String titulo;

    private String cargaHoraria;

    private Set<AlunoRequest> alunos;


    public CursoResponse(long id, String titulo, String cargaHoraria) {
        this.id = id;
        this.titulo = titulo;
        this.cargaHoraria = cargaHoraria;
    }
}
