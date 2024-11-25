package org.example.entidades;

import lombok.*;
import javax.persistence.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor @ToString (exclude = {"imagen","unidadDeMedida"})
@Entity @Table (name = "Articulo")
public class Articulo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticulo;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Integer tiempoEstimadoMinutos;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "idImagen")
    private Imagen imagen;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "idUnidadDeMedida")
    private UnidadDeMedida unidadDeMedida;

}
