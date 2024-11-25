package org.example.entidades;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor @ToString (exclude = {"detalles","cliente"})
@Entity @Table (name = "Pedido")
public class Pedido {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idPedido;
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double costo;
    private String estado;
    private LocalDate fechaPedido;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "idCliente")
    private Cliente cliente;
    @Builder.Default @OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles = new ArrayList<>();

}
