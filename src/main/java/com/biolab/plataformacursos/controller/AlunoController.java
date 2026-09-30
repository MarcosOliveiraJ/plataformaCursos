package com.biolab.plataformacursos.controller;

import com.biolab.plataformacursos.DTOs.*;
import com.biolab.plataformacursos.entities.Aluno;
import com.biolab.plataformacursos.services.AlunoServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    private final AlunoServices services;

    public AlunoController(AlunoServices services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<?> criarAluno(@Valid @RequestBody AlunoRequest req) {
        return ResponseEntity.ok(services.criarAluno(req));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> mostrar() {
        return ResponseEntity.ok(services.mostrarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> buscarID(@PathVariable Long id) {
        AlunoResponse alunos = services.buscarID(id);
        return ResponseEntity.ok(alunos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlunos(@PathVariable Long id) {
        services.deletarAlunos(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> alterarDados(@Valid @PathVariable Long id, @RequestBody AlunoRequest dados) {
        Aluno alunosAtualizados = services.alterarDados(id, dados);
        return ResponseEntity.ok(alunosAtualizados);
    }
}