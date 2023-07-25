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
public class CompraPersona {

    private String nombre;
    private String ciudad;
    private Date fechaDelaCompra;
    private BigDecimal monto;

}
