package com.evasion_control.evasion_control.Controller;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Matricula;
import com.evasion_control.evasion_control.Infrastrucure.Repository.AlunoRepository;
import com.evasion_control.evasion_control.bService.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<Matricula> createMatricula(@RequestBody Matricula matricula) {
        Matricula savedMatricula = matriculaService.createMatricula(matricula);
        return ResponseEntity.ok(savedMatricula);
    }

    // Listar todas as matrículas
    @GetMapping("/turma/{turmaId}")
    public ResponseEntity<List<String>> getNomesAlunosByTurma(@PathVariable String turmaId) {
        List<String> nomesAlunos = matriculaService.findMatriculasByTurmaId(turmaId);
        return ResponseEntity.ok(nomesAlunos);
    }

}



