package com.example.tarjetascredito.service;

import com.example.tarjetascredito.model.Operacion;
import com.example.tarjetascredito.model.TarjetaCredito;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;


@Service
public class TarjetaServiceImpl implements TarjetaService{

    @Override
    public String getDetallesTarjeta(TarjetaCredito tarjeta) {
        return tarjeta.toString();
    }

    @Override
    public boolean validarOperacion(Operacion operacion) {
        // Valida si el monto de una operación es menor a $1000
        return operacion.getMonto().compareTo(BigDecimal.valueOf(1000)) <= 0;
    }

    @Override
    public boolean tarjetaValida(TarjetaCredito tarjeta) {
        // Valida si la fecha de vencimiento de una tarjeta es posterior a hoy
        return tarjeta.getFechaVencimiento().isAfter(LocalDate.now());
    }

    @Override
    public boolean tarjetasIguales(TarjetaCredito t1, TarjetaCredito t2) {
        // Compara solo los números de dos tarjetas
        return t1.getNumeroTarjeta().equals(t2.getNumeroTarjeta());
    }

    @Override
    public BigDecimal calcularTasa(Operacion operacion) {
        // Calcula la tasa según la marca de la tarjeta
        BigDecimal tasa;

        try {
            switch(operacion.getTarjeta().getMarca()) {
                case VISA:
                    tasa = BigDecimal.valueOf(LocalDate.now().getYear()).divide(BigDecimal.valueOf(12));
                    break;
                case NARA:
                    tasa = BigDecimal.valueOf(LocalDate.now().getDayOfMonth()).multiply(BigDecimal.valueOf(0.5));
                    break;
                case AMEX:
                    tasa = BigDecimal.valueOf(LocalDate.now().getMonthValue()).multiply(BigDecimal.valueOf(0.1));
                    break;
                default:
                    tasa = BigDecimal.ZERO;
            }
        } catch (ArithmeticException e) {
            // si ocurre un error en la división
            System.out.println("Error calculando tasa: " + e.getMessage());
            tasa = BigDecimal.ZERO;

        } catch (NullPointerException e) {
            // si la marca es null
            System.out.println("Error obteniendo marca de tarjeta: " + e.getMessage());
            tasa = BigDecimal.ZERO;

        } catch (Exception e) {
            // Otras excepciones
            System.out.println("Error calculando tasa: " + e.getMessage());
            tasa = BigDecimal.ZERO;
        }

        return tasa;
    }

}
