package com.example.tarjetascredito.controller;

import com.example.tarjetascredito.model.MarcaTarjeta;
import com.example.tarjetascredito.model.Operacion;
import com.example.tarjetascredito.model.TarjetaCredito;
import com.example.tarjetascredito.service.TarjetaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;


@RestController
@RequestMapping("/api/tarjeta")
public class TarjetaController {

/*
    @GetMapping("/prueba")
    public  String prueba (){
        return "hola mundo";
    }
*/


    @Autowired
    private TarjetaServiceImpl servicio;

    @GetMapping("/tasas")
    public BigDecimal consultarTasa(@RequestParam("marca") MarcaTarjeta marca,
                                    @RequestParam("monto") BigDecimal monto){

        TarjetaCredito tarjeta = new TarjetaCredito();
        tarjeta.setMarca(marca);

        Operacion operacion = new Operacion();
        operacion.setTarjeta(tarjeta);
        operacion.setMonto(monto);

        return servicio.calcularTasa(operacion);
    }



}