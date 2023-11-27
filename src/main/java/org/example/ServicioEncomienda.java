package org.example;

import java.util.Random;

public class ServicioEncomienda extends Servicio{
    private int cantidadProductos;
    private double peso;
    private TipoServicio tipoServicio;
    private TipoEncomienda tipoEncomienda;
    
    public ServicioEncomienda(String origen,String destino,String fecha, Conductor conductor,int identificadorServicio,String hora,
            int cantidadProductos,
            double peso,
            TipoServicio tipoServicio,
            TipoEncomienda tipoEncomienda){
        super(origen,destino,fecha,conductor,identificadorServicio,hora);
        this.cantidadProductos = cantidadProductos;
        this.peso = peso;
        this.tipoServicio = tipoServicio;
        this.tipoEncomienda = tipoEncomienda;
    }

}
