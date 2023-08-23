package com.example.tarjetascredito.model;

import lombok.Data;
import java.math.BigDecimal;


@Data
public class Operacion {
    private TarjetaCredito tarjeta;
    private BigDecimal monto;


    public Operacion() {
    }

    public Operacion(TarjetaCredito tarjeta, BigDecimal monto) {
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

}