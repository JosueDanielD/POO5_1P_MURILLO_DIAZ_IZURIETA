package org.example;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Cliente extends Usuario {
    
    //(em) Atributos de la clase hija "cliente"
    private int edad;
    private String numeroTarjeta;
    
    //(em) constructor de Cliente
    public Cliente(String nombre,
            String apellido,
            String numeroCedula,
            String user,
            String contraseña,
            String numeroCelular,
            TipoUsuario tipoUsuario,
            int edad,
            String numeroTarjeta){
    
        super(nombre,apellido,numeroCedula,user,contraseña,numeroCelular,tipoUsuario);
        this.edad = edad;
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public int getEdad(){
        return edad;
    }
    public String getNumeroTarjeta(){
        return numeroTarjeta;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setNumeroTarjeta(String numeroTarjeta){
        this.numeroTarjeta = numeroTarjeta;
    }
    
    //(em)se sobrescribe el metodo consultar servicios para el cliente
    @Override
    public void consultarServicios(ArrayList<Servicio> listaServicios){
      System.out.println("Estos son los servicios que ha solicitado: ");
      
      for (Servicio a: listaServicios){
          System.out.println(a);
      }
      
      System.out.println("----------------------");
     }

    /**
    * Este metodo solicita una encomienda por parte del cliente
    * @param  listaUsuarios lista requerida para obtener la instancia PagoServicio.
    * @return PagoServicio Devuelve una instancia PagoServicio.
    **/
     public PagoServicio solicitarTaxi(ArrayList<Usuario> listaUsuarios){
    
         Scanner sc = new Scanner(System.in);
         Random rd = new Random();
         
         System.out.println("Usted esta solicitando un taxi");
         System.out.print("Ingrese la ubicacion de INICIO de la ruta: \n");
         String origen = sc.nextLine();
         sc.nextLine();
         System.out.print("Ingrese la ubicacion de FIN de la ruta: \n");
         String fin = sc.nextLine();
         sc.nextLine();
         System.out.print("Ingrese la fecha del viaje: \n");
         String fecha = sc.nextLine();
         sc.nextLine();
         System.out.print("Ingrese la hora del viaje: \n");
         String hora = sc.nextLine();
         sc.nextLine();
         System.out.println("Ingrese el metodo de pago");
         System.out.print("si es CREDITO escriba C o TARJETA DE CREDITO escriba TC: \n");
         String elMetodo = sc.nextLine();
         MetodoPago metodo = MetodoPago.valueOf(elMetodo);
         sc.nextLine();
         System.out.print("Ingrese la cantidad de personas que iran en el viaje: \n");
         int cantidad = sc.nextInt();
         sc.nextLine();
         
         int kilometraje=rd.nextInt(4,45);
         final double tarifa=0.50;
         double costoViaje= kilometraje*tarifa;
         
         System.out.print("Desea confirmar su viaje? SI/NO: \n");
         String confirmacion = sc.nextLine();
         sc.nextLine();
         
         int identificador=rd.nextInt(100,10000);
         
         Conductor conductor;
         
         for(Usuario a: listaUsuarios){
             if (a instanceof Conductor){
                 Conductor b = (Conductor)a;
                 if(b.getEstadoConductor()== EstadoConductor.valueOf("D")&& b.getVehiculo().gettipoVehiculo() == TipoVehiculo.valueOf("AUTO")){
                     conductor = b;
                     break;
                 }
                 
             }
         }
         sc.close();
         if (confirmacion == "SI"){
             ServicioTaxi nuevoServicioTaxi =new ServicioTaxi(origen,fin,fecha,conductor,identificador,hora,cantidad,TipoServicio.valueOf("T"));
             PagoServicio nuevoPagoServicio = new PagoServicio(nuevoServicioTaxi, fecha, metodo, identificador, this, costoViaje);
             return nuevoPagoServicio;
         }
         else{
             return null;
         }
         
        
    }
     
     
    /**
     * Este metodo solicita una encomienda por parte del cliente
     * @param listaUsusarios lista requerida para obtener la instancia PagoServicio.
     * @return PagoServicio Devuelve una instancia PagoServicio.
     **/
    public PagoServicio solicitarEncomienda(ArrayList<Usuario> listaUsuarios){
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        
        System.out.println("Usted esta solicitando un taxi");
        System.out.print("Ingrese la ubicacion de INICIO de la ruta: \n");
        String origen = sc.nextLine();
        sc.nextLine();
        System.out.print("Ingrese la ubicacion de FIN de la ruta: \n");
        String fin = sc.nextLine();
        sc.nextLine();
        System.out.print("Ingrese la fecha del viaje: \n");
        String fecha = sc.nextLine();
        sc.nextLine();
        System.out.print("Ingrese la hora del viaje: \n");
        String hora = sc.nextLine();
        sc.nextLine();
        System.out.println("Ingrese el metodo de pago");
        System.out.print("si es CREDITO escriba C o TARJETA DE CREDITO escriba TC: \n");
        String elMetodo = sc.nextLine();
        MetodoPago metodo = MetodoPago.valueOf(elMetodo);
        sc.nextLine();
        System.out.println("Ingrese el tipo de encomienda");
        System.out.print("Las opciones son MEDICINA/DOCUMENTOS/ROPA: \n");
        String tipoEnco = sc.nextLine();
        TipoEncomienda encomienda = TipoEncomienda.valueOf(tipoEnco);
        sc.nextLine();
        System.out.print("Ingrese la cantidad de productos: \n");
        int cantidad = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el peso en KG de los productos: \n");
        double peso = sc.nextDouble();
        sc.nextLine();
        
        double calculo = (cantidad * 1)+4;
        
        int identificador=rd.nextInt(100,10000);
        
        System.out.print("Desea confirmar su entrega? SI/NO: \n");
        String confirmacion = sc.nextLine();
        sc.nextLine();
        
        Conductor conductor;
        for(Usuario a: listaUsuarios){
            if (a instanceof Conductor){
                Conductor b = (Conductor)a;
                if(b.getEstadoConductor()== EstadoConductor.valueOf("D")&& b.getVehiculo().gettipoVehiculo() == TipoVehiculo.valueOf("MOTO")){
                    
                    conductor = b;
                    break;
                }
                 
            }
        }
        sc.close();
        if (confirmacion == "SI"){
             ServicioEncomienda nuevoServicioEnco=new ServicioEncomienda(origen,fin,fecha,conductor,identificador,hora,cantidad,peso,TipoServicio.valueOf("E"),encomienda));
             PagoServicio nuevoPagoServicio = new PagoServicio(nuevoServicioEnco, fecha, metodo, identificador, this, calculo);
             return nuevoPagoServicio; 
        }
         else{
            return null;
         }
         
    }
    
    /**
     * Este metodo solicita una encomienda por parte del cliente
     * @param  PagoServicio instancia requerida para ser agregada a la lista.
     * @param  listaPagoServicio Lista requerida para que se agrege la instancia.
     **/
    public void ActualizacionPagoServicio(PagoServicio PagoServicio,ArrayList<PagoServicio> listaPagoServicio){
        listaPagoServicio.add(PagoServicio); 
    }

}



