package org.example.entidades;

import lombok.*;
import javax.persistence.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table (name = "UnidadDeMedida")
public class UnidadDeMedida {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidadDeMedida;
    private String denominacion;

}
