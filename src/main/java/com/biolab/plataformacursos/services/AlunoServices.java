package com.biolab.plataformacursos.services;

import com.biolab.plataformacursos.DTOs.AlunoRequest;
import com.biolab.plataformacursos.DTOs.AlunoResponse;
import com.biolab.plataformacursos.entities.Aluno;
import com.biolab.plataformacursos.entities.Curso;
import com.biolab.plataformacursos.repositories.AlunoRepository;
import com.biolab.plataformacursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServices {
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoServices(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public String criarAluno(AlunoRequest req) {
        Aluno aluno = new Aluno(
                req.getNome(),
                req.getEmail()
        );

        Curso curso = cursoRepository.getReferenceById(req.getIdCurso());
        aluno.getCursos().add(curso);

        alunoRepository.save(aluno);
        return "Aluno criado";
    }

    public List<AlunoResponse> mostrarAlunos() {
        return alunoRepository.findAll().stream().map(
                alunos -> new AlunoResponse(
                        alunos.getId(), alunos.getNome(), alunos.getEmail())).toList();
    }

    public AlunoResponse buscarID(long id) {
        Optional<Aluno> alunos = alunoRepository.findById(id);
        AlunoResponse alunoResponse = new AlunoResponse();
        alunoResponse.setNome(alunos.get().getNome());
        alunoResponse.setEmail(alunos.get().getEmail());
        alunoResponse.setId(alunos.get().getId());
        return alunoResponse;
    }

    public String deletarAlunos(long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        alunoRepository.deleteById(id);
        return "Aluno excluída";
    }

    public Aluno alterarDados(Long id, AlunoRequest dadosAtualizados) {
        Aluno alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado por ID: " + id));
        Curso curso = cursoRepository.getReferenceById(dadosAtualizados.getIdCurso());
        alunoExistente.setNome(dadosAtualizados.getNome());
        alunoExistente.setEmail(dadosAtualizados.getEmail());
        alunoExistente.setCursos(new HashSet<>());
        alunoExistente.getCursos().add(curso);
        return alunoRepository.save(alunoExistente);
    }
}
