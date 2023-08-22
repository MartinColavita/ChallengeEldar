package com.example.tarjetascredito.model;

import lombok.Data;
import java.time.LocalDate;


@Data
public class TarjetaCredito {

    private MarcaTarjeta marca;
    private String numeroTarjeta;
    private String nombreTitular;
    private String apellidoTitular;
    private LocalDate fechaVencimiento;



    public TarjetaCredito() {
    }

    public TarjetaCredito(MarcaTarjeta marca, String numeroTarjeta, String nombreTitular, String apellidoTitular, LocalDate fechaVencimiento) {
        this.marca = marca;
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.apellidoTitular = apellidoTitular;
        this.fechaVencimiento = fechaVencimiento;
    }

}