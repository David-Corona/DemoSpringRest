package com.corona.demoSpringRest.models;

public class Bootcamper {
    private String nombre;
    private double valor;

    public Bootcamper(){}

    public Bootcamper(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
