package com.example.servicio;

import com.example.dto.Compra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CompraServiceImpl implements CompraService {

    private final PersonaService personaService;
    private static final List<Compra> compras = new ArrayList<>();

    public CompraServiceImpl(PersonaService personaService) {
        this.personaService = personaService;
        compras.addAll(insertarCompras());
    }

    @Override
    public List<Compra> obtenerTodasLasCompras() {
        return new ArrayList<>(compras);
    }

    @Override
    public List<Compra> obtenerComprasPorPersona(Integer idPersona) {
        return compras.stream().filter(compra -> compra.getPersona().getIdPersona().equals(idPersona)).collect(Collectors.toList());
    }

    private List<Compra> insertarCompras() {
        Compra compra1 = Compra.builder()
                .idCompra(0)
                .Fecha(new Date())
                .persona(personaService.obtenerPersonaPorId(1).orElse(null))
                .monto(BigDecimal.valueOf(100.0))
                .build();
        Compra compra2 = Compra.builder()
                .idCompra(1)
                .Fecha(new Date())
                .persona(personaService.obtenerPersonaPorId(1).orElse(null))
                .monto(BigDecimal.valueOf(100.0))
                .build();
        Compra compra3 = Compra.builder()
                .idCompra(2)
                .Fecha(new Date())
                .persona(personaService.obtenerPersonaPorId(1).orElse(null))
                .monto(BigDecimal.valueOf(550.0))
                .build();
        Compra compra4 = Compra.builder()
                .idCompra(3)
                .Fecha(new Date())
                .persona(personaService.obtenerPersonaPorId(2).orElse(null))
                .monto(BigDecimal.valueOf(100.0))
                .build();
        Compra compra5 = Compra.builder()
                .idCompra(4)
                .Fecha(new Date())
                .persona(personaService.obtenerPersonaPorId(3).orElse(null))
                .monto(BigDecimal.valueOf(150.0))
                .build();
        Compra compra6 = Compra.builder()
                .idCompra(5)
                .Fecha(new Date())
                .persona(personaService.obtenerPersonaPorId(4).orElse(null))
                .monto(BigDecimal.valueOf(150.0))
                .build();
        Compra compra7 = Compra.builder()
                .idCompra(6)
                .Fecha(new Date())
                .persona(personaService.obtenerPersonaPorId(4).orElse(null))
                .monto(BigDecimal.valueOf(100.0))
                .build();
        Compra compra8 = Compra.builder()
                .idCompra(7)
                .Fecha(new Date())
                .persona(personaService.obtenerPersonaPorId(5).orElse(null))
                .monto(BigDecimal.valueOf(100.0))
                .build();
        Compra compra9 = Compra.builder()
                .idCompra(8)
                .Fecha(new Date())
                .persona(personaService.obtenerPersonaPorId(4).orElse(null))
                .monto(BigDecimal.valueOf(200.0))
                .build();
        Compra compra10 = Compra.builder()
                .idCompra(9)
                .Fecha(new Date())
                .persona(personaService.obtenerPersonaPorId(5).orElse(null))
                .monto(BigDecimal.valueOf(500.0))
                .build();
        return Arrays.asList(compra1,compra2,compra3,compra4,compra5,compra6,compra7,compra8,compra9,compra10);
    }

}
