package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaDireccionReporte {
    private Integer idPersona;
    private String nombre;
    private Date fechaDeNacimiento;
    private Integer direccionId;
    private String calleYNumero;
    private String ciudad;
    private String codigoPostal;

    public PersonaDireccionReporte(Persona persona) {
        this.idPersona = persona.getIdPersona();
        this.nombre = persona.getNombre();
        this.fechaDeNacimiento = persona.getFechaDeNacimiento();
        this.direccionId = persona.getDireccion().getDireccionId();
        this.calleYNumero = persona.getDireccion().getCalleYNumero();
        this.ciudad = persona.getDireccion().getCiudad();
        this.codigoPostal = persona.getDireccion().getCodigoPostal();
    }

}