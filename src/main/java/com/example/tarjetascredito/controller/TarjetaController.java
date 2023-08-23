package com.example.tarjetascredito.controller;

import com.example.tarjetascredito.dto.TasaDTO;
import com.example.tarjetascredito.exception.BadRequestException;
import com.example.tarjetascredito.model.MarcaTarjeta;
import com.example.tarjetascredito.model.Operacion;
import com.example.tarjetascredito.model.TarjetaCredito;
import com.example.tarjetascredito.service.TarjetaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/api/tarjeta")
public class TarjetaController {

    @Autowired
    private TarjetaServiceImpl servicio;

    @GetMapping("/tasas")
    public ResponseEntity<TasaDTO> consultarTasa(@RequestParam MarcaTarjeta marca,
                                                 @RequestParam BigDecimal monto) {

        if(marca == null) {
            throw new BadRequestException("La Marca es requerida como parametro");
        }

        if(monto == null) {
            throw new BadRequestException("El Monto es requerido como parametro");
        }

        // Crear tarjeta
        TarjetaCredito tarjeta = new TarjetaCredito();
        tarjeta.setMarca(marca);

        // Crear operación
        Operacion operacion = new Operacion();
        operacion.setTarjeta(tarjeta);
        operacion.setMonto(monto);

        // Calcular tasa
        BigDecimal tasa = servicio.calcularTasa(operacion);

        // Mapear datos a DTO
        TasaDTO dto = new TasaDTO();
        dto.setMarca(tarjeta.getMarca());
        dto.setImporte(operacion.getMonto());
        dto.setValor(tasa);

        // Devolver respuesta
        return ResponseEntity.ok(dto);

    }

}