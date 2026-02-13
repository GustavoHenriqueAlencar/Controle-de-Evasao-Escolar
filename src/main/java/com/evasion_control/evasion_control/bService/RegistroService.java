package com.evasion_control.evasion_control.bService;

import com.evasion_control.evasion_control.DTO.FrequenciaAluno;
import com.evasion_control.evasion_control.Infrastrucure.Entity.Registro;
import com.evasion_control.evasion_control.Infrastrucure.Repository.RegistroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistroService {

    private RegistroRepository registroRepository;

    public Registro registrarFrequencia(Registro registro) {

        boolean existe = registroRepository.existsByTurmaIdAndDataRegistro(
                registro.getTurmaId(),
                registro.getDataRegistro()
        );

        if (existe) {
            throw new RuntimeException("Já existe registro para essa turma nessa data");
        }

        for (FrequenciaAluno f : registro.getFrequencia()) {
            if (f.faltas() < 1)
                throw new RuntimeException("É obrigatório colocar faltas maior que 0");
        }

        return registroRepository.save(registro);
    }

}
