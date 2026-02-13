package com.evasion_control.evasion_control.Infrastrucure.Entity;

import com.evasion_control.evasion_control.DTO.FrequenciaAluno;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "registros")
@Data
@Getter
@Setter
public class Registro {

    @Id
    private String id;
    private String turmaId;
    private String EmpresaId;

    private List<FrequenciaAluno> frequencia;

    private LocalDate dataRegistro;

}
