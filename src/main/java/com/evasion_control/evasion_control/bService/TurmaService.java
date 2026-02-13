package com.evasion_control.evasion_control.bService;

import com.evasion_control.evasion_control.Infrastrucure.Entity.Empresa;
import com.evasion_control.evasion_control.Infrastrucure.Entity.Professor;
import com.evasion_control.evasion_control.Infrastrucure.Entity.Turma;
import com.evasion_control.evasion_control.Infrastrucure.Enums.Periodo;
import com.evasion_control.evasion_control.Infrastrucure.Repository.EmpresaRepository;
import com.evasion_control.evasion_control.Infrastrucure.Repository.ProfessorRepository;
import com.evasion_control.evasion_control.Infrastrucure.Repository.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final EmpresaRepository empresaRepository;
    private final ProfessorRepository professorRepository;

    public Turma createTurma(Turma turma) {

        String turmaEmpId = turma.getEmpresaId();
        String turmaProfId = turma.getProfessorId();

        if (turmaEmpId == null) {
            throw new IllegalArgumentException("Empresa é obrigatória");
        }

        if (turmaProfId == null) {
            throw new IllegalArgumentException("Professor é obrigatório");
        }

        Empresa empresa = empresaRepository.findById(turmaEmpId)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        professorRepository.findById(turmaProfId)
                .orElseThrow(() -> new RuntimeException("Professor não logado"));

        turma.setCodigoTurma(gerarCodigoTurma(empresa, turma.getMateria(), turma.getPeriodo()));

        return turmaRepository.save(turma);
    }

    public List<Turma> findAllTurmas() {
        return turmaRepository.findAll();
    }

    private String gerarCodigoTurma(Empresa empresa, String materia, Periodo periodo) {

        String siglaEmpresa = gerarSigla(empresa.getNome());
        String siglaMateria = gerarSigla(materia);
        String siglaPeriodo = gerarSigla(periodo.name());

        // conta quantas já existem
        long quantidade = turmaRepository
                .countByEmpresaIdAndMateriaAndPeriodo(empresa.getId(), materia, periodo);

        long sequencial = quantidade + 1;

        return siglaEmpresa + "-" + siglaMateria + "-" + siglaPeriodo + "-" + String.format("%02d", sequencial);
    }

    private String gerarSigla(String texto) {
        return texto.length() >= 3
                ? texto.substring(0, 3).toUpperCase()
                : texto.toUpperCase();
    }

}
