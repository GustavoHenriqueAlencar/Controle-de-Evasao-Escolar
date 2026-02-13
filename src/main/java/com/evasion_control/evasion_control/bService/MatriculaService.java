package com.evasion_control.evasion_control.bService;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Matricula;
import com.evasion_control.evasion_control.Infrastrucure.Entity.Turma;
import com.evasion_control.evasion_control.Infrastrucure.Repository.AlunoRepository;
import com.evasion_control.evasion_control.Infrastrucure.Repository.MatriculaRepository;
import com.evasion_control.evasion_control.Infrastrucure.Repository.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class MatriculaService {

    private MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;


    public Matricula createMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> findAllMatriculas() {
        return matriculaRepository.findAll();
    }

    public List<String> findMatriculasByTurmaId(String turmaId) {
        return matriculaRepository.findByTurmaId(turmaId).stream()
                .map(matricula -> {
                    return alunoRepository.findById(matricula.getAlunoId())
                            .map(aluno -> aluno.getNome())
                            .orElse("Aluno não encontrado");
                })
                .toList();
    }




}
