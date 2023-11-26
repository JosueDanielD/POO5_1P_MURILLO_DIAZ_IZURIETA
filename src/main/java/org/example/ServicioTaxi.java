package org.example;
import java.util.Random;
public class ServicioTaxi extends Servicio {
    private int numeroPersonas;
    private TipoServicio tipoServicio;

    @Override
    public double calcularCosto(){
        Random r= new Random();
        int kilometraje=r.nextInt(4,45);
        final double tarifa=0.50;
        double costoViaje= kilometraje*tarifa;

        return costoViaje;
    }
}
