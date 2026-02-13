package com.evasion_control.evasion_control.bService;

import com.evasion_control.evasion_control.DTO.FrequenciaAluno;
import com.evasion_control.evasion_control.Infrastrucure.Entity.Registro;
import com.evasion_control.evasion_control.Infrastrucure.Repository.RegistroRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioCsvService {

    private final RegistroRepository repository;

    public RelatorioCsvService(RegistroRepository repository) {
        this.repository = repository;
    }

    public byte[] gerarCsvPorPeriodo(
            LocalDate inicio,
            LocalDate fim
    ) {

        List<Registro> registros =
                repository.findByDataRegistroBetween(inicio, fim);

        StringBuilder csv = new StringBuilder();

        csv.append("DATA,EMPRESA,TURMA,ALUNO,FALTAS,JUSTIFICATIVA\n");

        for (Registro registro : registros) {

            for (FrequenciaAluno f : registro.getFrequencia()) {

                csv.append(registro.getDataRegistro()).append(",");
                csv.append(registro.getEmpresaId()).append(",");
                csv.append(registro.getTurmaId()).append(",");
                csv.append(f.alunoId()).append(",");
                csv.append(f.faltas()).append(",");
                csv.append(
                        f.justificativa() == null ? "" : f.justificativa()
                ).append("\n");
            }
        }

        return csv.toString().getBytes(StandardCharsets.UTF_8);
    }
}

