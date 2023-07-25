package com.example.servicio;

import java.util.List;
import java.util.Optional;

import com.example.dto.Persona;

public interface PersonaService {
    
    List<Persona> obtenerTodasLasPersonas();
    Optional<Persona> obtenerPersonaPorId(Integer id);
}
