package com.example.servicio;

import com.example.dto.Compra;

import java.util.List;

public interface CompraService {

    List<Compra> obtenerTodasLasCompras();

    List<Compra> obtenerComprasPorPersona(Integer idPersona);

}
