package com.biolab.plataformacursos.repositories;

import com.biolab.plataformacursos.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
