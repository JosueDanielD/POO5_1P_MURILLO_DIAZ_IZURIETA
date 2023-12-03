package org.example;

public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private TipoVehiculo tipoVehiculo;
    
    
    
    public Vehiculo(String placa, String marca, String modelo, TipoVehiculo tipoVehiculo ){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
    }
    
    public String getplaca(){
        return placa;
    }
    public String getmarca(){
        return marca;
    }
    public String getmodelo(){
        return modelo;
    }
    public TipoVehiculo gettipoVehiculo(){
        return  tipoVehiculo;
    }
    public void setplaca(String placa){
        this.placa = placa;
    }
    public void setmarca(String marca){
        this.marca = marca;
    }
    public void setmodelo(String modelo){
        this.modelo = modelo;
    }
    public void settipoVehiculo(TipoVehiculo tipoVehiculo){
        this.tipoVehiculo = tipoVehiculo;
    }
    
    
    public String toString(){
        return ("Placa: "+this.getplaca() +"\nMarca: "+ this.getmarca()+"\nModelo: " +this.getmodelo()+"\nTipo de Vehículo: " +this.gettipoVehiculo());
    }
}
