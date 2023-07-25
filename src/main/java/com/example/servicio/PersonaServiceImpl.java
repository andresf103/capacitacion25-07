package com.example.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.dto.Direccion;
import com.example.dto.Persona;

public class PersonaServiceImpl implements PersonaService {

    private static final List<Persona> personas = new ArrayList<>();

    public PersonaServiceImpl() {
        personas.addAll(insertarPersonas());
        personas.addAll(insertarPersonas());
        personas.addAll(insertarPersonas());
        personas.addAll(insertarPersonas());
    }

    @Override
    public List<Persona> obtenerTodasLasPersonas() {
        return new ArrayList<>(personas);
    }

    @Override
    public Optional<Persona> obtenerPersonaPorId(Integer id) {
        return personas.stream().filter(persona -> persona.getIdPersona().equals(id)).findFirst();
    }

    private List<Persona> insertarPersonas() {
        Persona persona1 = Persona.builder()
                .idPersona(0)
                .nombre("Julian Martinez")
                .direccion(
                        Direccion.builder()
                                .direccionId(0)
                                .calleYNumero("CalleFalsa 123")
                                .ciudad("Santo Tomé")
                                .codigoPostal("3100").build()).build();

        Persona persona2 = Persona.builder()
                .idPersona(1)
                .nombre("Juan Monzon")
                .direccion(
                        Direccion.builder()
                                .direccionId(1)
                                .calleYNumero("Fraternidad 2348")
                                .ciudad("Paraná")
                                .codigoPostal("3100").build()).build();

        Persona persona3 = Persona.builder()
                .idPersona(3)
                .nombre("Liliana Alcaraz")
                .direccion(
                        Direccion.builder()
                                .direccionId(3)
                                .calleYNumero("CalleFalsa 564")
                                .ciudad("Santa Fe")
                                .codigoPostal("3200").build()).build();

        Persona persona4 = Persona.builder()
                .idPersona(4)
                .nombre("Andrés Arletaz")
                .direccion(
                        Direccion.builder()
                                .direccionId(0)
                                .calleYNumero("Francia 123")
                                .ciudad("Paraná")
                                .codigoPostal("3100").build()).build();

        Persona persona5 = Persona.builder()
                .idPersona(5)
                .nombre("Luciana Gimenez")
                .direccion(
                        Direccion.builder()
                                .direccionId(1)
                                .calleYNumero("Fraternidad 2348")
                                .ciudad("Paraná")
                                .codigoPostal("3100").build()).build();

        Persona persona6 = Persona.builder()
                .idPersona(6)
                .nombre("Veronica Pross")
                .direccion(
                        Direccion.builder()
                                .direccionId(2)
                                .calleYNumero("CalleFalsa 564")
                                .ciudad("Santa Fe")
                                .codigoPostal("3200").build()).build();
        return Arrays.asList(persona1, persona2, persona3, persona4, persona5, persona6);
    }

}
