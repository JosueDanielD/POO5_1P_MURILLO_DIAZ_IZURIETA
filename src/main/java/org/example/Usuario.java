package org.example;

public abstract class Usuario {

    //(em)ATRIBUTOS CLASE USUARIO
    protected String nombre;
    protected String apellido;
    protected String numeroCedula;
    protected String user;
    protected String numeroCelular;
    protected TipoUsuario tipoUsuario;

    //(em)CONSTRUCTOR DE USUARIO
    public Usuario(String nombre,String apellido,String numeroCedula, String user,String numeroCelular, TipoUsuario tipoUsuario){
        this.nombre=nombre;
        this.apellido=apellido;
        this.numeroCedula=numeroCedula;
        this.user=user;
        this.numeroCelular=numeroCelular;
        this.tipoUsuario=tipoUsuario;
    }

    //(em)CONSTRUCTOR VACÍO:

    public Usuario(){
    }


    //(em)MÉTODOS USUARIO
    public abstract void consultarServicios();

    



}
