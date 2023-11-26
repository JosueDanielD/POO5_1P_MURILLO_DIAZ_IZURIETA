package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidosSI {

    //(jd)ATRIBUTOS CLASE PRINCIPAL PEDIDOSSI
    //ArrayList<Usuario> listaUsuarios;
    //ArrayList<Vehiculo> listaVehiculos;
    //ArrayList<Servicio> listaServicios;


    //(jd)METODO PRINCIPAL:
    public static void main(String[] args) {
        System.out.println("********************************\nBIENVENIDO AL SISTEMA******************************\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("USUARIO: ");
        String user = sc.nextLine();
        System.out.println("CONTRASEÑA: ");
        String contrasenia = sc.nextLine();
        if(validarUsuario(user,contrasenia)){
            System.out.println("*************MENÚ*****************");
            System.out.println("                                  ");
            System.out.println("1. Solicitar servicio de taxi");
            System.out.println("2. Solicitar comida a domicilio");
            System.out.println("3. Solicitar entrega encomienda");
            System.out.println("4. Consultar servicios");
            System.out.println(" ");
            System.out.println("Elija una opción: ");
            int opcionElegida= sc.nextInt();
            switch(opcionElegida){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        }





    }

    //public void iniciarSesion(Usuario user){
    //}


    public static boolean validarUsuario(String user,String contrasenia){ //SI ES DE TIPO CLIENTE VA A RETORNAR TRUE
        Scanner sc=new Scanner (System.in);
        ArrayList<String> listaUsuarios = ManejoArchivos.leerArchivo("usuarios.txt");
        for (int i=0;i<listaUsuarios.size();i++){ //PARA CADA LÍNEA DE USUARIOS.TXT
            String informacionUsuario[]=listaUsuarios.get(i).split(","); //OBTENGO UN ARRAY DE SUS DATOS (PARA CADA USUARIO)
            if (informacionUsuario[3].equals(user)){ //SI EL USUARIO ESTÁ EN ALGUNA LÍNEA DE USUARIOS.TXT
                if (informacionUsuario[6].equals("C")){ //SI EL TIPO DE USUARIO ES CLIENTE
                    ArrayList<String> listaClientes=ManejoArchivos.leerArchivo("clientes.txt"); //OBTENGO UN ARRAYLIST
                    //COMPUESTO CON CADA LINEA DE CLIENTES.TXT
                    for (int j=0;j<listaClientes.size();j++){ //PARA CADA LINEA DE CLIENTES.TXT
                        String informacionCliente[]=listaClientes.get(j).split(","); //CREANDO UN ARRAY POR CADA CLIENTE DONDE
                        //CADA ESPACIO DEL ARRAY ES UN DATO DEL CLIENTE (SEGÚN EL FORMATO DEL ENCABEZADO DE CLIENTES.TXT
                        if (informacionCliente[0].equals(informacionUsuario[0])){ //SI LA CEDULA DEL CLIENTE ES IGUAL A LA CEDULA DEL USUARIO

                            //CLIENTE EXISTENTE Y CON DATOS COMPLETOS
                            return true;

                        }
                        else{ //SI ES QUE NO ESTÁ REGISTRADO EN CLIENTES.TXT
                            System.out.println("Por favor, ingrese su edad: ");
                            int edad=sc.nextInt();
                            System.out.println("Por favor, ingrese su número de tarjeta de crédito");
                            String numeroTarjeta=sc.nextLine();
                            String cadenaPorAgregar=informacionUsuario[0]+","+String.valueOf(edad)+","+numeroTarjeta;
                            ManejoArchivos.escribirArchivo("clientes.txt",cadenaPorAgregar);

                            return true;

                        }
                    }

                }
                else{

                    if (informacionUsuario[6].equals("R")){ //SI EL TIPO DE USUARIO ES CONDUCTOR
                        ArrayList<String> listaConductores=ManejoArchivos.leerArchivo("conductores.txt"); //OBTENGO UN ARRAYLIST
                        //COMPUESTO CON CADA LINEA DE CONDUCTOR.TXT
                        for (int j=0;j<listaConductores.size();j++){ //PARA CADA LINEA DE CONDUCTOR.TXT
                            String informacionConductor[]=listaConductores.get(j).split(","); //CREANDO UN ARRAY POR CADA CONDUCTOR DONDE
                            //CADA ESPACIO DEL ARRAY ES UN DATO DEL CONDUCTOR (SEGÚN EL FORMATO DEL ENCABEZADO DE CLIENTES.TXT
                            if (informacionConductor[0].equals(informacionConductor[0])){ //SI LA CEDULA DEL CLIENTE ES IGUAL A LA CEDULA DEL USUARIO

                                //Conductor EXISTENTE Y CON DATOS COMPLETOS
                                return false;

                            }
                            else{ //SI ES QUE NO ESTÁ REGISTRADO EN CONDUCTORES.TXT
                                System.out.println("Por favor, ingrese su estado: ");
                                String estado=sc.nextLine();
                                System.out.println("Por favor, ingrese el código del vehículo: ");
                                String codigoVehiculo=sc.nextLine();
                                String cadenaPorAgregar=informacionUsuario[0]+","+estado+","+codigoVehiculo;
                                ManejoArchivos.escribirArchivo("conductores.txt",cadenaPorAgregar);

                                return false;

                            }
                        }

                    }

                }

            }
            else{ //SI EL USUARIO NO EXISTE

                System.out.println("USUARIO NO REGISTRADO. POR FAVOR: ");
                System.out.println("Ingrese su nombre: ");
                String nombre=sc.nextLine();
                System.out.println("Ingrese su apellido: ");
                String apellido=sc.nextLine();
                System.out.println("Ingrese su número de cédula");
                String numeroCedula=sc.nextLine();
                System.out.println("Ingrese su usuario: ");
                String usuario=sc.nextLine();
                System.out.println("Ingrese su contraseña: ");
                String contrasena=sc.nextLine();
                System.out.println("Ingrese su número de celular: ");
                String numeroCelular=sc.nextLine();
                System.out.println("Desea registrarse como cliente(C) o como conductor(R)?");
                String tipoDeUsuario=sc.nextLine();
                if (tipoDeUsuario.equals("C")){
                    TipoUsuario tipoUsuario=TipoUsuario.C;
                    Usuario usuarioo=new Usuario(nombre,apellido,numeroCedula,usuario,contrasena,numeroCelular,tipoUsuario);
                    String cadenaParaAgregar=usuarioo.numeroCedula+usuarioo.nombre+usuarioo.apellido+usuarioo.user+usuarioo.contraseña+usuarioo.numeroCelular+String.valueOf(usuarioo.tipoUsuario);
                    ManejoArchivos.escribirArchivo("usuarios.txt",cadenaParaAgregar);
                    System.out.println("Por favor, ingrese su edad: ");
                    int edad =sc.nextInt();
                    System.out.println("Por favor ingrese su número de tarjeta de crédito: ");
                    String numeroTarjeta= sc.nextLine();
                    Cliente cliente=new Cliente(usuarioo.nombre,usuarioo.apellido,usuarioo.numeroCedula,usuarioo.user,usuarioo.contraseña,usuarioo.numeroCelular,usuarioo.tipoUsuario,edad,numeroTarjeta);

                    String cadenaParaAgregarDos=usuarioo.numeroCedula+edad+numeroTarjeta;
                    ManejoArchivos.escribirArchivo("clientes.txt",cadenaParaAgregarDos);
                }
                else{
                    if(tipoDeUsuario.equals("R")){
                        TipoUsuario tipoUsuario=TipoUsuario.R;
                        Usuario usuarioo=new Usuario(nombre,apellido,numeroCedula,usuario,contrasena,numeroCelular,tipoUsuario);
                        String cadenaParaAgregar=usuarioo.numeroCedula+usuarioo.nombre+usuarioo.apellido+usuarioo.user+usuarioo.contraseña+usuarioo.numeroCelular+String.valueOf(usuarioo.tipoUsuario);
                        ManejoArchivos.escribirArchivo("usuarios.txt",cadenaParaAgregar);
                        System.out.println("Por favor ingrese su estado(Disponible D u Ocupado O): ");
                        String estado=sc.nextLine();
                        EstadoConductor estadoConductor=EstadoConductor.O;
                        if (estado.equals("D")){
                            estadoConductor=EstadoConductor.D;
                        }
                        else{
                            if(estado.equals("O")){
                                estadoConductor=EstadoConductor.O;
                            }
                        }
                        System.out.println("Por favor escriba el código de su vehículo: ");
                        String codigoVehiculo=sc.nextLine();
                        System.out.println("Por favor ingrese la placa de su vehículo: ");
                        String placa=sc.nextLine();
                        System.out.println("Por favor ingrese la marca de su vehículo: ");
                        String marca=sc.nextLine();
                        System.out.println("Por favor ingrese el modelo de su vehículo: ");
                        String modelo=sc.nextLine();
                        System.out.println("Por favor ingrese su tipo de vehículo(AUTO O MOTO): ");
                        String tipoDeVehiculo=sc.nextLine().toUpperCase();
                        TipoVehiculo tipoVehiculo=TipoVehiculo.AUTO;
                        if (tipoDeVehiculo.equals("AUTO")){
                            tipoVehiculo=TipoVehiculo.AUTO;
                        }
                        if(tipoDeVehiculo.equals("MOTO")){
                            tipoVehiculo=TipoVehiculo.MOTO;
                        }
                        Vehiculo vehiculo=new Vehiculo(placa,marca,modelo,tipoVehiculo);
                        String cadena=codigoVehiculo+","+placa+","+modelo+","+marca+","+tipoDeVehiculo;
                        ManejoArchivos.escribirArchivo("vehiculos.txt",cadena);
                        String cadena2=numeroCedula+estado+codigoVehiculo;
                        ManejoArchivos.escribirArchivo("conductores.txt",cadena2);




                        Conductor conductor=new Conductor(usuarioo.nombre,usuarioo.apellido,usuarioo.numeroCedula,usuarioo.user,usuarioo.contraseña,usuarioo.numeroCelular,usuarioo.tipoUsuario,estadoConductor,codigoVehiculo);
                    }
                }




            }
        }
        return true;
    }




}


