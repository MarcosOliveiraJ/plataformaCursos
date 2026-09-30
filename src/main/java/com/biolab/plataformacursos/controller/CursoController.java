package com.biolab.plataformacursos.controller;

import com.biolab.plataformacursos.DTOs.*;
import com.biolab.plataformacursos.entities.Curso;
import com.biolab.plataformacursos.services.CursoServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {
    private final CursoServices services;

    public CursoController(CursoServices services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<?> criarCurso(@RequestBody CursoRequest req){
        return ResponseEntity.ok("Curso criado" + services.criarCurso(req));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponse>> mostrarCursos(){
        return ResponseEntity.ok(services.mostrarCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> buscarID(@PathVariable Long id){
        CursoResponse cursos = services.buscarID(id);
        return ResponseEntity.ok(cursos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCursos(@PathVariable Long id) {
        services.deletarCursos(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> alterarDados(@Valid @PathVariable Long id, @RequestBody CursoRequest dados){
        Curso cursosAtualizados = services.alterarDados(id, dados);
        return ResponseEntity.ok(cursosAtualizados);
    }
}