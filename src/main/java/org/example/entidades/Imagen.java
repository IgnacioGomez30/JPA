package org.example.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table (name = "Imagen")
public class Imagen {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idImagen;
    private String nombre;
    private String url;

    @OneToOne (mappedBy = "imagen")
    private Articulo articulo;

}
