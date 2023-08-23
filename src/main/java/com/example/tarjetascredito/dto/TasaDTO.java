package com.example.tarjetascredito.dto;


import com.example.tarjetascredito.model.MarcaTarjeta;
import lombok.Data;
import java.math.BigDecimal;


@Data
public class TasaDTO {
    private MarcaTarjeta marca;
    private BigDecimal importe;
    private BigDecimal valor;
}
