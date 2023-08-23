package com.example.tarjetascredito;

import com.example.tarjetascredito.model.MarcaTarjeta;
import com.example.tarjetascredito.model.Operacion;
import com.example.tarjetascredito.model.TarjetaCredito;
import com.example.tarjetascredito.service.TarjetaServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class TarjetasCreditoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TarjetasCreditoApplication.class, args);


        // Crear tarjeta Visa
        TarjetaCredito visa = new TarjetaCredito();
        visa.setNumeroTarjeta("4485370048230707");
        visa.setMarca(MarcaTarjeta.VISA);
        visa.setNombreTitular("Juan Perez");
        visa.setApellidoTitular("Perez");
        visa.setFechaVencimiento(LocalDate.of(2025, 10, 25));

        // Crear tarjeta Nara
        TarjetaCredito nara = new TarjetaCredito();
        nara.setNumeroTarjeta("5123202540506035");
        nara.setMarca(MarcaTarjeta.NARA);
        nara.setNombreTitular("Maria Garcia");
        nara.setApellidoTitular("Garcia");
        nara.setFechaVencimiento(LocalDate.of(2024, 11, 15));

        // Crear operación
        Operacion operacion = new Operacion();
        operacion.setTarjeta(visa);
        operacion.setMonto(BigDecimal.valueOf(800));

        // Obtener servicio
        TarjetaServiceImpl servicio = new TarjetaServiceImpl();


        // Llamar métodos
        System.out.println("Información tarjeta: " + servicio.getDetallesTarjeta(visa));

        System.out.println("¿Es vigente? " + servicio.tarjetaValida(visa));

        System.out.println("¿Operación válida? " + servicio.validarOperacion(operacion));

        System.out.println("¿Visa = Nara? " + servicio.tarjetasIguales(visa, nara));

        BigDecimal tasa = servicio.calcularTasa(operacion);
        System.out.println("Tasa: " + tasa);
    }

}
