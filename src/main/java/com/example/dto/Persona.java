package com.example.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Persona {

    private Integer idPersona;
    private String nombre;
    private Date fechaDeNacimiento;
    private Direccion direccion;

    @Override
    public String toString() {
        return "\nPersona{" +
                "\n idPersona=" + idPersona +
                "\n nombre='" + nombre + '\'' +
                "\n fechaDeNacimiento=" + fechaDeNacimiento +
                "\n direccion=" + direccion +
                "\n}";
    }
}
