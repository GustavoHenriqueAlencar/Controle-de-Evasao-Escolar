package com.evasion_control.evasion_control.Infrastrucure.Entity;

import com.evasion_control.evasion_control.Infrastrucure.Enums.Periodo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "turmas")
@Data
@Getter
@Setter
public class Turma {

    @Id
    private String id;

    private String codigoTurma;
    private String materia;
    private Periodo periodo;

    private String professorId;
    private String empresaId;

}
