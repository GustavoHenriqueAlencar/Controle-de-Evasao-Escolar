package com.evasion_control.evasion_control.Infrastrucure.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matriculas")
@Data
@Getter
@Setter
public class Matricula {

    @Id
    private String id;

    private String alunoId;
    private String turmaId;

}
