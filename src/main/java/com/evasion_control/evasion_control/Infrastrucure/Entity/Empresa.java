package com.evasion_control.evasion_control.Infrastrucure.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empresas")
@Data
@Getter
@Setter
public class Empresa {

    @Id
    private String id;

    private String nome;
    private String email;

}
