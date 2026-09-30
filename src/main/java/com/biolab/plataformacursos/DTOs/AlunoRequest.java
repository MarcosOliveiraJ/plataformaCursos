package com.biolab.plataformacursos.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequest {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @Column(length = 150)
    private String email;
    private long idCurso;
    private Set<CursoRequest> cursos;

    public AlunoRequest(String nome, String email, long idCurso) {
        this.nome = nome;
        this.email = email;
        this.idCurso = idCurso;
    }
}
