package org.example;

public class Usuario {

    //(jd)ATRIBUTOS CLASE USUARIO
    protected String nombre;
    protected String apellido;
    protected String numeroCedula;
    protected String user;
    protected String numeroCelular;
    protected TipoUsuario tipoUsuario;

    //(jd)CONSTRUCTOR DE USUARIO
    public Usuario(String nombre,String apellido,String numeroCedula, String user,String numeroCelular, TipoUsuario tipoUsuario){
        this.nombre=nombre;
        this.apellido=apellido;
        this.numeroCedula=numeroCedula;
        this.user=user;
        this.numeroCelular=numeroCelular;
        this.tipoUsuario=tipoUsuario;
    }

    //(jd)CONSTRUCTOR VACÍO:

    public Usuario(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    //(jd)MÉTODOS USUARIO
    public void consultarServicios(){

    }



}
