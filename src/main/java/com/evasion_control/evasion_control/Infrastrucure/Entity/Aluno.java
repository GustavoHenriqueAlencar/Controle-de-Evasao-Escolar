package com.evasion_control.evasion_control.Infrastrucure.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Array;
import java.util.List;

@Document(collection = "alunos")
@Data
@Getter
@Setter
public class Aluno {

    @Id
    private String id;

    private String nome;
}
