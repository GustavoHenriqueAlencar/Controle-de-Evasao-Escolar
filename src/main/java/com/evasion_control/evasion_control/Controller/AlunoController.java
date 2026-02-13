package com.evasion_control.evasion_control.Controller;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Aluno;
import com.evasion_control.evasion_control.bService.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    // Endpoint para criar um novo aluno
    @PostMapping
    public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno) {
        Aluno savedAluno = alunoService.createAluno(aluno);
        return ResponseEntity.ok(savedAluno);
    }

    // Endpoint para listar todos os alunos
    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunos = alunoService.findAllAlunos();
        return ResponseEntity.ok(alunos);
    }


}
