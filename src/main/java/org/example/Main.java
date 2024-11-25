package org.example;

import org.example.entidades.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            /*
            ----------------------- CARGA DE DATOS -----------------------

            Cliente cliente1 = Cliente.builder()
        .nombre("Juan")
        .apellido("Perez")
        .telefono("1234567890")
        .email("juanperez@example.com")
        .fechaNacimiento(LocalDate.of(1985, 6, 15))
        .build();
Cliente cliente2 = Cliente.builder()
        .nombre("Ana")
        .apellido("Gonzalez")
        .telefono("9876543210")
        .email("ana.gonzalez@example.com")
        .fechaNacimiento(LocalDate.of(1990, 12, 10))
        .build();
Cliente cliente3 = Cliente.builder()
        .nombre("María")
        .apellido("Lopez")
        .telefono("5551234567")
        .email("maria.lopez@example.com")
        .build();

UnidadDeMedida seisPorciones = UnidadDeMedida.builder()
        .denominacion("6 porciones")
        .build();
UnidadDeMedida dosPorciones = UnidadDeMedida.builder()
        .denominacion("2 porciones")
        .build();
UnidadDeMedida botella = UnidadDeMedida.builder()
        .denominacion("Botella")
        .build();

Imagen imagen1 = Imagen.builder()
        .nombre("Veggie grande")
        .build();
Imagen imagen2 = Imagen.builder()
        .nombre("Pepperoni grande")
        .build();
Imagen imagen3 = Imagen.builder()
        .nombre("Cuatro quesos grande")
        .build();
Imagen imagen4 = Imagen.builder()
        .nombre("Veggie chica")
        .build();
Imagen imagen5 = Imagen.builder()
        .nombre("Pepperoni chica")
        .build();
Imagen imagen6 = Imagen.builder()
        .nombre("Cuatro quesos chica")
        .build();
Imagen imagen7 = Imagen.builder()
        .nombre("Cerveza Corona")
        .build();
Imagen imagen8 = Imagen.builder()
        .nombre("Cerveza Stella Artois")
        .build();

Articulo veggieGrande = Articulo.builder()
        .denominacion("Pizza Veggie grande")
        .precioVenta(8800.0)
        .stockActual(20)
        .stockMaximo(50)
        .tiempoEstimadoMinutos(15)
        .imagen(imagen1)
        .unidadDeMedida(seisPorciones)
        .build();
Articulo pepperoniGrande = Articulo.builder()
        .denominacion("Pizza Pepperoni grande")
        .precioVenta(9500.0)
        .stockActual(18)
        .stockMaximo(50)
        .tiempoEstimadoMinutos(20)
        .imagen(imagen2)
        .unidadDeMedida(seisPorciones)
        .build();
Articulo cuatroQuesosGrande = Articulo.builder()
        .denominacion("Pizza Cuatro quesos grande")
        .precioVenta(9800.0)
        .stockActual(15)
        .stockMaximo(50)
        .tiempoEstimadoMinutos(18)
        .imagen(imagen3)
        .unidadDeMedida(seisPorciones)
        .build();
Articulo veggieChica = Articulo.builder()
        .denominacion("Pizza Veggie chica")
        .precioVenta(5000.0)
        .stockActual(8)
        .stockMaximo(30)
        .tiempoEstimadoMinutos(12)
        .imagen(imagen4)
        .unidadDeMedida(dosPorciones)
        .build();
Articulo pepperoniChica = Articulo.builder()
        .denominacion("Pizza Pepperoni chica")
        .precioVenta(5300.0)
        .stockActual(10)
        .stockMaximo(30)
        .tiempoEstimadoMinutos(15)
        .imagen(imagen5)
        .unidadDeMedida(dosPorciones)
        .build();
Articulo cuatroQuesosChica = Articulo.builder()
        .denominacion("Pizza Cuatro quesos chica")
        .precioVenta(5800.0)
        .stockActual(12)
        .stockMaximo(30)
        .tiempoEstimadoMinutos(18)
        .imagen(imagen6)
        .unidadDeMedida(dosPorciones)
        .build();
Articulo cervezaCorona = Articulo.builder()
        .denominacion("Cerveza Corona")
        .precioVenta(6500.0)
        .stockActual(30)
        .stockMaximo(100)
        .imagen(imagen7)
        .unidadDeMedida(botella)
        .build();
Articulo cervezaStella = Articulo.builder()
        .denominacion("Cerveza Stella Artois")
        .precioVenta(6800.0)
        .stockActual(40)
        .stockMaximo(100)
        .imagen(imagen8)
        .unidadDeMedida(botella)
        .build();

Pedido pedido1 = Pedido.builder()
        .horaEstimadaFinalizacion(LocalTime.of(21, 45))
        .total(15800.0)
        .estado("Entregado")
        .fechaPedido(LocalDate.of(2024, 10, 10))
        .cliente(cliente1)
        .build();
DetallePedido det1 = DetallePedido.builder()
        .pedido(pedido1)
        .articulo(pepperoniGrande)
        .cantidad(1)
        .build();
DetallePedido det2 = DetallePedido.builder()
        .pedido(pedido1)
        .articulo(cervezaStella)
        .cantidad(1)
        .build();

pedido1.getDetalles().add(det1);
pedido1.getDetalles().add(det2);

Pedido pedido2 = Pedido.builder()
        .horaEstimadaFinalizacion(LocalTime.of(20, 15))
        .total(27500.0)
        .estado("Cancelado")
        .fechaPedido(LocalDate.of(2024, 10, 10))
        .cliente(cliente2)
        .build();
DetallePedido det3 = DetallePedido.builder()
        .pedido(pedido2)
        .articulo(cervezaStella)
        .cantidad(2)
        .build();
DetallePedido det4 = DetallePedido.builder()
        .pedido(pedido2)
        .articulo(veggieChica)
        .cantidad(1)
        .build();

pedido2.getDetalles().add(det3);
pedido2.getDetalles().add(det4);

Pedido pedido3 = Pedido.builder()
        .horaEstimadaFinalizacion(LocalTime.of(23, 00))
        .total(40000.0)
        .estado("Entregado")
        .fechaPedido(LocalDate.of(2024, 10, 10))
        .cliente(cliente3)
        .build();
DetallePedido det5 = DetallePedido.builder()
        .pedido(pedido3)
        .articulo(veggieGrande)
        .cantidad(1)
        .build();
DetallePedido det6 = DetallePedido.builder()
        .pedido(pedido3)
        .articulo(cuatroQuesosGrande)
        .cantidad(1)
        .build();
DetallePedido det7 = DetallePedido.builder()
        .pedido(pedido3)
        .articulo(cervezaCorona)
        .cantidad(2)
        .build();

pedido3.getDetalles().add(det5);
pedido3.getDetalles().add(det6);
pedido3.getDetalles().add(det7);

em.persist(pedido1);
em.persist(pedido2);
em.persist(pedido3);*/

            System.out.println("\n--------- INFORMACIÓN PEDIDO 1 ---------");
            Cliente cliente1 = em.find(Cliente.class, 5L);
            Pedido pedido1 = em.find(Pedido.class, 1L);
            cliente1.mostrarNombreYApellido();
            System.out.println(pedido1);

            System.out.println("\n--------- INFORMACIÓN PEDIDO 2 ---------");
            Cliente cliente2 = em.find(Cliente.class, 6L);
            Pedido pedido2 = em.find(Pedido.class, 2L);
            cliente2.mostrarNombreYApellido();
            System.out.println(pedido2);

            System.out.println("\n--------- INFORMACIÓN PEDIDO 3 ---------");
            Cliente cliente3 = em.find(Cliente.class, 7L);
            Pedido pedido3 = em.find(Pedido.class, 3L);
            cliente3.mostrarNombreYApellido();
            System.out.println(pedido3);

            System.out.println("\n--------- INFORMACIÓN PEDIDO 4 ---------");
            Cliente cliente4 = em.find(Cliente.class, 5L);
            Pedido pedido4 = em.find(Pedido.class, 4L);
            cliente4.mostrarNombreYApellido();
            System.out.println(pedido4);

            System.out.println("\n--------- TODOS LOS ARTÍCULOS ---------");
            String sql = "SELECT * FROM Articulo";
            Query consulta = em.createNativeQuery(sql, Articulo.class);
            List<Articulo> articulos = consulta.getResultList();
            articulos.forEach(System.out::println);

            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
        } finally{
            em.close();
            emf.close();
        }

    }
}
