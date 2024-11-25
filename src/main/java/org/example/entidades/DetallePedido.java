package org.example.entidades;

import lombok.*;
import javax.persistence.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor @ToString (exclude = "pedido")
@Entity @Table (name = "DetallePedido")
public class DetallePedido {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idDetallePedido;
    private Integer cantidad;
    private Double subtotal;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "idPedido")
    private Pedido pedido;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "idArticulo")
    private Articulo articulo;

}
