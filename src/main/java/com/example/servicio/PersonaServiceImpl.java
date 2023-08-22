package com.example.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.dto.Direccion;
import com.example.dto.Persona;
import com.example.repositorio.PersonaRepositorio;

public class PersonaServiceImpl implements PersonaService {

    PersonaRepositorio personaRepositorio;

    public PersonaServiceImpl(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }

    @Override
    public List<Persona> obtenerTodasLasPersonas() {
        return this.personaRepositorio.obtenerTodasLasPersonas();
    }

    @Override
    public Optional<Persona> obtenerPersonaPorId(Integer id) {
        return this.personaRepositorio.obtenerPersonaPorId(id);
    }


}
