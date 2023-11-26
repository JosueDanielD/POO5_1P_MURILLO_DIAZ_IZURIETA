package org.example;

import java.util.Random;

public class ServicioEncomienda extends Servicio{
    private int cantidadProductos;
    private double peso;
    private TipoServicio tipoServicio;
    private TipoEncomienda tipoEncomienda;


    @Override
    public double calcularCosto(){
        double costoEncomienda=this.cantidadProductos+4;
        return costoEncomienda;


    }
}
