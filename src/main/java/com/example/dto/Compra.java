package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Compra {
    private Integer idCompra;
    private Persona persona;
    private Date Fecha;
    private BigDecimal monto;

    @Override
    public String toString() {
        return "Compra{" +
                "\n idCompra=" + idCompra +
                "\n persona=" + persona +
                "\n Fecha=" + Fecha +
                "\n monto=" + monto +
                "\n}";
    }
}
