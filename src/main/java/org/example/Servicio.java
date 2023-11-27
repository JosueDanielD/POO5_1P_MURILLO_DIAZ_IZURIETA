package org.example;

public class Servicio {
    protected String origen;
    protected String destino;
    protected String fecha;
    protected Conductor conductor;
    protected int identificadorServicio;
    protected String hora;
    
    
    public Servicio(String origen,String destino,String fecha, Conductor conductor,int identificadorServicio,String hora){
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.conductor = conductor;
        this.identificadorServicio = identificadorServicio;
        this.hora = hora;
    }
    /**
    * Este metodo que se modificara en las hijas.
    **/
    public void mostrarInformacion(){

    }

}
