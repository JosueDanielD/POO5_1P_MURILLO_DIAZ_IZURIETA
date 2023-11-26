package org.example;
import java.util.ArrayList;

//(em)Clase Conductor es Hija de Usuario
public class Conductor extends Usuario{
    
    //(em)Atributos propios de Conductor
    private EstadoConductor estadoConductor; 
    private Vehiculo vehiculo;
    
    //(em)Constructor de la clase
    public Conductor(String nombre,
            String apellido,
            String numeroCedula,
            String user,
            String contraseña,
            String numeroCelular,
            TipoUsuario tipoUsuario,
            EstadoConductor estadoConductor,
            Vehiculo vehiculo){
    super(nombre,apellido,numeroCedula,user,contraseña,numeroCelular,tipoUsuario);
    this.estadoConductor = estadoConductor;
    this.vehiculo = vehiculo;
    }
    
    //(em)Metodos getters y setters
    public EstadoConductor getEstadoConductor(){
        return estadoConductor;
    }
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
    public void setEstadoConductor(EstadoConductor estadoConductor){
        this.estadoConductor = estadoConductor;
    }
    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
    
    //(em)Metodo consultarServicio sobrescrito
    @Override
    public void consultarServicios(ArrayList<Servicio> listaServicios){
        System.out.println("Estos son los servicios que se le ha Asignado: ");
        
        for (Servicio a: listaServicios){
          System.out.println(a);
        }
      
        System.out.println("----------------------");
    }
    
    //(em)Metodo consultar su vehiculo
    public void ConsultarVehiculo(){
        System.out.println(this.getVehiculo());
    }
}


