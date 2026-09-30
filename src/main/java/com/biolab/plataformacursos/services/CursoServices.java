package com.biolab.plataformacursos.services;

import com.biolab.plataformacursos.DTOs.CursoRequest;
import com.biolab.plataformacursos.DTOs.CursoResponse;
import com.biolab.plataformacursos.entities.Curso;
import com.biolab.plataformacursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServices {
    private final CursoRepository cursoRepository;

    public CursoServices(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public String criarCurso(CursoRequest request) {
        Curso curso = new Curso();
        curso.setTitulo(request.getTitulo());
        curso.setCargaHoraria(request.getCargaHoraria());
        cursoRepository.save(curso);
        return "Curso criado";
    }

    public List<CursoResponse> mostrarCursos() {
        return cursoRepository.findAll().stream().map(
                cursos -> new CursoResponse(cursos.getId(),
                        cursos.getTitulo(), cursos.getCargaHoraria())).toList();
    }

    public CursoResponse buscarID(long id) {
        Optional<Curso> cursos = cursoRepository.findById(id);
        CursoResponse cursoResponse = new CursoResponse();
        cursoResponse.setTitulo(cursos.get().getTitulo());
        cursoResponse.setCargaHoraria(cursos.get().getCargaHoraria());
        cursoResponse.setId(cursos.get().getId());
        return cursoResponse;
    }

    public String deletarCursos(long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        cursoRepository.deleteById(id);
        return "Curso excluído";
    }

    public Curso alterarDados(Long id, CursoRequest dadosAtualizados) {
        Curso cursoExistente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado por ID: " + id));
        cursoExistente.setTitulo(dadosAtualizados.getTitulo());
        cursoExistente.setCargaHoraria(dadosAtualizados.getCargaHoraria());
        return cursoRepository.save(cursoExistente);
    }


}
