package com.evasion_control.evasion_control.bService;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Aluno;
import com.evasion_control.evasion_control.Infrastrucure.Repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAllAlunos() {
        return alunoRepository.findAll();
    }

}
