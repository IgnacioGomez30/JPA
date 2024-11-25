package org.example.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table (name = "Cliente")
public class Cliente {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    public String mostrarNombreYApellido(){
        return "Cliente: " + getNombre() + " " + getApellido();
    }
}
