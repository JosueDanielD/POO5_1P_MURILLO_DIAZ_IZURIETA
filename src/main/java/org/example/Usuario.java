package org.example;
import java.util.ArrayList;

public abstract class Usuario {

    //(em)ATRIBUTOS CLASE USUARIO
    protected String nombre;
    protected String apellido;
    protected String numeroCedula;
    protected String user;
    protected String contraseña;
    protected String numeroCelular;
    protected TipoUsuario tipoUsuario;

    //(em)CONSTRUCTOR DE USUARIO
    public Usuario(String nombre,String apellido,String numeroCedula, String user,String contraseña,String numeroCelular, TipoUsuario tipoUsuario){
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCedula = numeroCedula;
        this.user = user;
        this.contraseña = contraseña;
        this.numeroCelular = numeroCelular;
        this.tipoUsuario = tipoUsuario;
    }

    //(em)CONSTRUCTOR VACÍO:

    public Usuario(){
    }

    /**
     *Este metodo sera sobrescrito en sus hijas.
     **/
    //(em)MÉTODOS USUARIO
    public  abstract boolean consultarServicios(ArrayList<String> listaServicios);
    

    



}
