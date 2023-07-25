package com.example;

import com.example.dto.Compra;
import com.example.dto.Persona;
import com.example.dto.CompraPersona;
import com.example.servicio.CompraService;
import com.example.servicio.CompraServiceImpl;
import com.example.servicio.PersonaService;
import com.example.servicio.PersonaServiceImpl;
import com.example.stream.EjemploStream;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class App
{

    public static void main( String[] args )
    {

        EjemploStream stream = EjemploStream.builder().apellido("Fernandez").numero(5).build();

        PersonaService personaService = new PersonaServiceImpl();
        CompraService compraService = new CompraServiceImpl(personaService);

        System.out.println(personaService.obtenerTodasLasPersonas());

        /*
         * Foreach: Aplica una función a cada uno de los elementos. Este método es terminal, no se puede encadenar con otra etapa del Stream.
         * Map: Transforma cada uno de los objetos que contiene la colección, pudiendo incluso cambiar el tipo de Stream
         * Reduce: Transforma la colección en un único objeto del mismo tipo del stream después de aplicar una función de agregación a cada elemento.
         * Filter: Filtra los elementos que satisfagan una determinada condición.
         * Collect: El paso final de la transformación del Stream, nos permitirá por ejemplo volverlo a convertir a una lista estándar.
         * */

        //1. Mostrar en pantalla solo las personas no repetidas hacerlo como mejor les salga

        Set<Persona> personaSet = new HashSet<>(personaService.obtenerTodasLasPersonas());
        System.out.println(personaSet);
        System.out.println(personaService.obtenerTodasLasPersonas().stream().distinct().collect(Collectors.toList()));

        //2. Ordenar la lista de personas por ciudad y mostrarlo en pantalla -> uso de comparador

        System.out.println(personaSet.stream().sorted(Comparator.comparing(persona -> persona.getDireccion().getCiudad())).collect(Collectors.toList()));

        //3. Ordenar la lista de compras por codigo postal

        List<Compra> compras = compraService.obtenerTodasLasCompras();

        //4. Mostrar en pantalla solo las compras mayores a 300 y que las personas sean de la ciudad de parana


        /*
          5. Crear una lista utilizando la lista de personas y de compras y
          mostrar en pantalla solo los siguientes datos: nombre de la persona,
          ciudad, fecha de la compra y monto
        */

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


        //6. Mostrar el nombre, y el monto total de todas las compras por persona.
        personaSet.forEach(persona -> {
            BigDecimal montoTotal = compras.stream()
                    .filter(compra -> compra.getPersona().equals(persona))
                    .map(compra -> compra.getMonto())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            System.out.println("Nombre: " + persona.getNombre() + " - Monto total: " + montoTotal);
        });

        //7. Mostrar el monto total de todas las compras por ciudad.
        Set<String> ciudades = personaSet.stream().map(persona -> persona.getDireccion().getCiudad()).collect(Collectors.toSet());

        ciudades.forEach(ciudad -> {
            BigDecimal montoTotal = compras.stream()
                    .filter(compra -> compra.getPersona().getDireccion().getCiudad().equals(ciudad))
                    .map(compra -> compra.getMonto())
                    .reduce(BigDecimal.ZERO, (acc, monto)-> acc.add(monto));
            System.out.println("Ciudad: " + ciudad + " - Monto total: " + montoTotal);
        });


    }
}
