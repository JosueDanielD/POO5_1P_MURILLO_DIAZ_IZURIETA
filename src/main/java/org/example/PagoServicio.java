package org.example;

public class PagoServicio {

    private Servicio servicio;
    private String fechaPago;
    private MetodoPago metodoPago;
    private int identificadorServicio;
    private Cliente cliente;
    private Double valorPagar;


public PagoServicio(Servicio servicio, String fechaPago, MetodoPago metodoPago, int identificadorServicio, Cliente cliente, Double valorPagar){
this.servicio = servicio;
this.fechaPago = fechaPago;
this.metodoPago = metodoPago;
this.identificadorServicio = identificadorServicio;
this.cliente = cliente;
this.valorPagar = valorPagar;
}

public Servicio getservicio(){
    return servicio;
}
public void setservicio(Servicio servicio){
    this.servicio = servicio;
}

public String getfechaPago(){
    return fechaPago;
}
public void setfechaPago(String fechaPago){
    this.fechaPago = fechaPago;
}
public MetodoPago getmetodoPago(){
    return metodoPago;
}
public void setmetodoPago(MetodoPago metodoPago){
    this.metodoPago = metodoPago;
}


public int getidentificadorServicio(){
    return identificadorServicio;
}
public void setidentificadorServicio(int identificadorServicio){
    this.identificadorServicio = identificadorServicio;
}


public Cliente getcliente(){
    return cliente;
}
public void setcliente(Cliente cliente){
    this.cliente = cliente;
}


public Double getvalorPagar(){
    return valorPagar;
}
public void setvalorPagar(Double valorPagar){
    this.valorPagar = valorPagar;
}

}