package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidosSI {

    //(jd)ATRIBUTOS CLASE PRINCIPAL PEDIDOSSI
    //ArrayList<Usuario> listaUsuarios;
    //ArrayList<Vehiculo> listaVehiculos;
    //ArrayList<Servicio> listaServicios;


    //(jd)METODO PRINCIPAL:
    public static void main (String[] args){
        System.out.println("********************************\nBIENVENIDO AL SISTEMA******************************\n");
        Scanner sc= new Scanner(System.in);
        System.out.println("USUARIO: ");
        String user= sc.nextLine();
        System.out.println("CONTRASEÑA: ");
        String contrasenia=sc.nextLine();
        ArrayList<String> listaUsuarios =ManejoArchivos.leerArchivo("usuarios.txt");
        for (int i=0;i<listaUsuarios.size();i++){ //PARA CADA LÍNEA DE USUARIOS.TXT
            String informacionUsuario[]=listaUsuarios.get(i).split(","); //OBTENGO UN ARRAY DE SUS DATOS (PARA CADA USUARIO)
            if (informacionUsuario[3]==user){ //SI EL USUARIO ESTÁ EN ALGUNA LÍNEA DE USUARIOS.TXT
                if (informacionUsuario[6].equals("C")){ //SI EL TIPO DE USUARIO ES CLIENTE
                    ArrayList<String> listaClientes=ManejoArchivos.leerArchivo("clientes.txt"); //OBTENGO UN ARRAYLIST
                    //COMPUESTO CON CADA LINEA DE CLIENTES.TXT
                    for (int j=0;j<listaClientes.size();j++){ //PARA CADA LINEA DE CLIENTES.TXT
                        String informacionCliente[]=listaClientes.get(j).split(","); //CREANDO UN ARRAY POR CADA CLIENTE DONDE
                        //CADA ESPACIO DEL ARRAY ES UN DATO DEL CLIENTE (SEGÚN EL FORMATO DEL ENCABEZADO DE CLIENTES.TXT
                        if (informacionCliente[0].equals(informacionUsuario[0])){ //SI LA CEDULA DEL CLIENTE ES IGUAL A LA CEDULA DEL USUARIO

                            //Si llegó hasta aquí quiere decir que ya existe el cliente y además se tiene toda la informacoón en
                            // usuarios.txt y clientes.txt
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
                    //String informacionClientes[]=infoClientes.get()
                    System.out.println("Por favor, ingrese su edad: ");
                    int edad=sc.nextInt();
                    System.out.println("Por fav,r ingrese su número de tarjeta de crédito");
                    String numeroTarjeta=sc.nextLine();
                    String cadenaPorAgregar=informacionUsuario[0]+","+String.valueOf(edad)+","+numeroTarjeta;
                    //ManejoArchivos.escribirArchivo();
                }

            }
        }



    }

    public void iniciarSesion(Usuario user){

    }

    public boolean validarUsuario(Usuario user){
        return true;
    }

    public Usuario crearUsuario(Boolean valorBool){
         Usuario user1=new Usuario();
         return user1;

    }


}


