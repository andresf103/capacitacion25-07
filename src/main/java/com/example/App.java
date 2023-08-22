package com.example;

import com.example.dto.Compra;
import com.example.dto.Persona;
import com.example.dto.CompraPersona;
import com.example.dto.PersonaDireccionReporte;
import com.example.servicio.*;
import com.example.stream.EjemploStream;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class App
{

    public static void main( String[] args )
    {

        PersonaService personaService = new PersonaServiceImpl();
        CompraService compraService = new CompraServiceImpl(personaService);
        ServicioDeImpresion servicioDeImpresion = new ServicioDeImpresion();

        System.out.println(personaService.obtenerTodasLasPersonas());

        List<Compra> compras = compraService.obtenerTodasLasCompras();

        List<CompraPersona> comprasPersonasList = compras.stream().map(compra -> {
           return CompraPersona.builder().nombre(compra.getPersona().getNombre())
                   .fechaDelaCompra(compra.getFecha())
                   .monto(compra.getMonto())
                   .ciudad(compra.getPersona()
                           .getDireccion()
                           .getCiudad())
                   .build();
        }).collect(Collectors.toList());

        System.out.println(comprasPersonasList);

        // Trabajo con Jasper...

        // creamos un subreporte para la cabecera
        // creamos un subreporte para el pie de pagina

        // Creamos dos reportes para mostrar uno para mostrar solo personas
        // otro para mostrar solo las compras
        // otro uniendo a ambas y agrupando por persona y totalizando


        // Uno con

        List<PersonaDireccionReporte> personaDireccionReporteList = personaService.obtenerTodasLasPersonas()
                .stream()
                .map(PersonaDireccionReporte::new).sorted(Comparator.comparing(PersonaDireccionReporte::getCiudad))
                .collect(Collectors.toList());

        try {
            servicioDeImpresion.mostrarImpresionEnPantalla(personaDireccionReporteList, "personas.jasper");
//            servicioDeImpresion.mostrarImpresionEnPantalla(comprasPersonasList, "compras.jasper");
        } catch (JRException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
