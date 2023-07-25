package com.example.stream;

import com.example.dto.Direccion;


/*
 * Aunque aquí estamos haciendo uso del patron de diseño builder, nos sirve para entender como funciona mas o menos los streams
 * en su manera de encadenar los distintos métodos
 * */
public class EjemploStream {

    private Integer numero;
    private String nombre;
    private String apellido;
    private Direccion direccion;

    private EjemploStream() {
    }

    static public EjemploStreamBuilder builder() {
        return new EjemploStreamBuilder();
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    static public class EjemploStreamBuilder {
        private Integer numero;
        private String nombre;
        private String apellido;
        private Direccion direccion;

        public EjemploStreamBuilder() {
            numero = 0;
            nombre = "";
            apellido = "";
            direccion = new Direccion();
        }

        public EjemploStreamBuilder numero(Integer numero) {
            this.numero = numero;
            return this;
        }
        public EjemploStreamBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public EjemploStreamBuilder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }
        public EjemploStreamBuilder direccion(Direccion direccion) {
            this.direccion = direccion;
            return this;
        }
        public EjemploStream build() {
            EjemploStream ejemploStream = new EjemploStream();
            ejemploStream.direccion = direccion;
            ejemploStream.numero = numero;
            ejemploStream.apellido = apellido;
            ejemploStream.nombre = nombre;
            return ejemploStream;
        }
    }
}
