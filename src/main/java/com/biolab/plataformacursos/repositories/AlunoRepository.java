package com.biolab.plataformacursos.repositories;

import com.biolab.plataformacursos.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
