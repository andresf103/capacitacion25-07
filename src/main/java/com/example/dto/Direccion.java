package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Direccion {
    Integer direccionId;
    String calleYNumero;
    String ciudad;
    String codigoPostal;

    @Override
    public String toString() {
        return "Direccion{" +
                "\n direccionId=" + direccionId +
                "\n calleYNumero='" + calleYNumero + '\'' +
                "\n ciudad='" + ciudad + '\'' +
                "\n codigoPostal='" + codigoPostal + '\'' +
                "\n}";
    }
}
