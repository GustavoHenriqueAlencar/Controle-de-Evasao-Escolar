package com.evasion_control.evasion_control.bService;

import com.evasion_control.evasion_control.DTO.FrequenciaAluno;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FrequenciaService {
    public FrequenciaAluno createFrequencia(FrequenciaAluno freq) {
        return new FrequenciaAluno(freq.alunoId(), freq.faltas(), freq.justificativa());
    }
}
