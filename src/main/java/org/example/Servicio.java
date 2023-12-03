package org.example;

import java.util.ArrayList;

public class Servicio {
    protected String numeroServicio;
    protected TipoServicio tipoServicio;
    protected String cedulaCliente;
    protected String nombreConductor;
    protected String desde;
    protected String hasta;
    protected String fecha;
    protected String hora;
    
    
    public Servicio(String numeroServicio,TipoServicio tipoServicio,String cedulaCliente,String nombreConductor,String desde, String hasta,String fecha,String hora){
        this.numeroServicio=numeroServicio;
        this.tipoServicio=tipoServicio;
        this.cedulaCliente=cedulaCliente;
        this.nombreConductor=nombreConductor;
        this.desde=desde;
        this.hasta=hasta;
        this.fecha=fecha;
        this.hora=hora;


    }
    /**
    * Este metodo que se modificara en las hijas.
    **/
    public void mostrarInformacion(){
        ArrayList<String> listaViajes= ManejoArchivos.leerArchivo("viajes.txt");
        ArrayList<String> listaEncomiendas= ManejoArchivos.leerArchivo("encomiendas.txt");

        //eliminar lineas vacias del arraylist listaViajes
        String[] infoViajePorBorrar;
        for (int i=0;i<listaViajes.size();i++){
            infoViajePorBorrar=listaViajes.get(i).split(",");
            if(infoViajePorBorrar.length==1){
                listaViajes.remove(i);
            }
        }
        //eliminar lineas vacias del arraylist listaEncomiendas
        String[] infoEncomiendaPorBorrar;
        for (int i=0;i<listaEncomiendas.size();i++){
            infoEncomiendaPorBorrar=listaEncomiendas.get(i).split(",");
            if(infoEncomiendaPorBorrar.length==1){
                listaEncomiendas.remove(i);
            }
        }


        String tipoDeServicio;
        String cantidadPasajeros="0";
        String cantidadProductos="0";
        String tipoEncomienda= "sin datos";
        String[] infoViaje;
        String[] infoEncomienda;
        for (String viaje: listaViajes){
            infoViaje= viaje.split(",");
            if (infoViaje[0].equals(this.numeroServicio) ){
                cantidadPasajeros=infoViaje[1];
            }

        }
        for (String encomienda: listaEncomiendas){
            infoEncomienda=encomienda.split(",");
            if (infoEncomienda[0].equals(this.numeroServicio)){
                cantidadProductos=infoEncomienda[2];
                tipoEncomienda=infoEncomienda[1];
            }
        }

        if (tipoServicio==TipoServicio.T){
            tipoDeServicio="Servicio Taxi";






            System.out.println("\n***********************************************" +
                    "\nTipo: "+tipoDeServicio+"\nCantidad Pasajeros: "+cantidadPasajeros+"\nFecha: "+this.fecha+"\nHora: "+
                    this.hora+"\nDesde: "+this.desde+"\nHasta: "+this.hasta+
                    "\n***********************************************");

        }
        else{
            tipoDeServicio="Servicio Encomienda";


            System.out.println("\n***********************************************" +
                    "\nTipo: "+tipoDeServicio+"\nTipo Encomienda: "+tipoEncomienda+"\nCantidad Productos: "+cantidadProductos+
                    "\nFecha: "+this.fecha+"\nHora: "+
                    this.hora+"\nDesde: "+this.desde+"\nHasta: "+this.hasta+
                    "\n***********************************************");



        }





    }

}
