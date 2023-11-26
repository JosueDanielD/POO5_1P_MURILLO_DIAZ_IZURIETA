package org.example;
import java.util.Random;
public class ServicioTaxi extends Servicio {
    private int numeroPersonas;
    private TipoServicio tipoServicio;

    //@Override
    public double calcularCosto(MetodoPago metodoPago){
        Random r= new Random();
        int kilometraje=r.nextInt(4,45);
        final double tarifa=0.50;
        double costoViaje= kilometraje*tarifa;
        if (metodoPago==MetodoPago.TC){
            costoViaje=costoViaje+(costoViaje*0.15);

        }

        return costoViaje;


    }
}
