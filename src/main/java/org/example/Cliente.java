package org.example;

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

    //@Override
    //public void consultarServicios(){
    //  System.out.println("a");
    // }


    // public ServicioTaxi solicitarTaxi(){

    //}

    //public ServicioEncomienda solicitarEncomienda(){

    //}

    //public ArrayList<PagoServicio> pagoServicio(){

    //}

}



