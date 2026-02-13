package com.evasion_control.evasion_control.Controller;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Turma;
import com.evasion_control.evasion_control.bService.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService turmaService;

    // Criar nova turma
    @PostMapping
    public ResponseEntity<Turma> createTurma(@RequestBody Turma turma) {
        Turma savedTurma = turmaService.createTurma(turma);
        return ResponseEntity.ok(savedTurma);
    }

    // Listar todas as turmas
    @GetMapping
    public ResponseEntity<List<Turma>> getAllTurmas() {
        List<Turma> turmas = turmaService.findAllTurmas();
        return ResponseEntity.ok(turmas);
    }
}
