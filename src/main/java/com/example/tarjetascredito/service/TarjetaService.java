package com.example.tarjetascredito.service;

import com.example.tarjetascredito.model.MarcaTarjeta;
import com.example.tarjetascredito.model.Operacion;
import com.example.tarjetascredito.model.TarjetaCredito;
import java.math.BigDecimal;


public interface TarjetaService {

    // Obtiene los detalles de una tarjeta
    String getDetallesTarjeta(TarjetaCredito tarjeta);


    // Valida si una tarjeta está vigente
    boolean tarjetaValida(TarjetaCredito tarjeta);


    // Valida si una operación es permitida
    boolean validarOperacion(Operacion operacion);


    // Compara si dos tarjetas son iguales
    boolean tarjetasIguales(TarjetaCredito t1, TarjetaCredito t2);


    // Calcula la tasa de una operación según la tarjeta
    BigDecimal calcularTasa(Operacion operacion);

}
