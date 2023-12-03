package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PedidosSI {

    //(jd)ATRIBUTOS CLASE PRINCIPAL PEDIDOSSI
    ArrayList<Usuario> listaUsuarios;
    ArrayList<Vehiculo> listaVehiculos;
    ArrayList<Servicio> listaServicios;
    ArrayList<Cliente> listaClientes;
    ArrayList<Conductor> listaConductores;



    //(jd)METODO PRINCIPAL:
    public static void main(String[] args) {

        ArrayList<String> listaUsuarios=ManejoArchivos.leerArchivo("usuarios.txt");


        Scanner sc= new Scanner(System.in);
        System.out.println("************\nBIENVENIDO AL SISTEMA\n************");
        System.out.println("USUARIO: ");
        String user=sc.nextLine();
        System.out.println("CONTRASEÑA: ");
        String contraseña=sc.nextLine();


        Usuario usuario=validarUsuario(user,contraseña);

        boolean valorRetorno=false;
        do {

            if (usuario instanceof Cliente) {
                valorRetorno = mostrarMenuCliente((Cliente) usuario);
            } else {
                valorRetorno=mostrarMenuConductor((Conductor)usuario);
            }
        }

        while (valorRetorno);

    }


    /**
     * Este metodo valida el usuario
     *
     * @param user        String con el user para logear e identifica el tipo de cliente.
     * @param contrasenia String con la contraseña para logear e identifica el tipo de cliente.
     * @return Usuario se obtiene un usuario para saber poder usar los demás métodos del sistema.
     **/


    public static Usuario  validarUsuario(String user, String contrasenia) { //Valida si el usuario existe y si no existe le pide los datos
        // necesarios para su registro.
        ArrayList<String> listaUsuarios = ManejoArchivos.leerArchivo("usuarios.txt");
        ArrayList<String> listaClientes = ManejoArchivos.leerArchivo("clientes.txt");
        ArrayList<String> listaConductores = ManejoArchivos.leerArchivo("conductores.txt");
        ArrayList<String> listaVehiculos = ManejoArchivos.leerArchivo("vehiculos.txt");
        Scanner sc = new Scanner(System.in);

        //CASO 1: EL USUARIO ES CLIENTE Y ESTÁ TANTO EN USUARIOS.TXT COMO EN CLIENTES.TXT
        //CASO 2: EL USUARIO ES CLIENTE Y ESTÁ SOLO EN USUARIOS.TXT
        //CASO 3: EL USUARIO ES CONDUCTOR Y ESTÁ TANTO EN USUARIOS.TXT COMO EN CONDUCTORES.TXT
        //CASO 4: EL USUARIO ES CONDUCTOR Y ESTÁ SOLO EN USUARIOS.TXT
        //CASO 5: EL USUARIO NO TIENE REGISTROS
        int caso = 0;
        int indiceUsuarioEnCasoDeExistir = 0;
        int indiceClienteEnCasoDeExistir = 0;
        int indiceConductorEnCasoDeExistir = 0;

        String[] informacionUsuario;
        String[] informacionCliente;
        String[] informacionConductor;
        String[] informacionVehiculo;
        int contadorClientes=0;
        int contadorConductores=0;
        int contador=0;

        for (int i = 0; i < listaUsuarios.size(); i++) {
            informacionUsuario = listaUsuarios.get(i).split(",");
            if (informacionUsuario[3].equals(user)) { //usuario existen en usuarios.txt
                if (informacionUsuario[6].equals("C")) { //si el usuario es de tipo cliente
                    for (int j = 0; j < listaClientes.size(); j++) {
                        informacionCliente = listaClientes.get(j).split(",");

//                        -------------------------------CASO1-----------------------------------
                        if (informacionCliente[0].equals(informacionUsuario[0])) {
                            //el usuario está tanto en usuarios.txt como en clientes.txt
                            caso = 1;
                            System.out.println("caso1");
                            indiceUsuarioEnCasoDeExistir = i;
                            indiceClienteEnCasoDeExistir = j;
                        } else {
                            contadorClientes++;
                        }

//                        --------------------------------CASO2------------------------------------
                        if (contadorClientes == listaClientes.size()) { //se verifica que el usuario no coincide con ninguna cedula
                            //de clientes.txt
                            caso = 2;
                            System.out.println("caso2");

                            indiceUsuarioEnCasoDeExistir = i;

                        }


                    }

                }
                if (informacionUsuario[6].equals("R")) { //si el usuario es de tipo conductor
                    for (int j = 0; j < listaConductores.size(); j++) {
                        informacionConductor = listaClientes.get(j).split(",");

//                        -------------------------------CASO3-----------------------------------
                        if (informacionConductor[0].equals(informacionUsuario[0])) {
                            //el usuario está tanto en usuarios.txt como en clientes.txt
                            caso = 3;
                            System.out.println("caso3");

                            indiceUsuarioEnCasoDeExistir = i;
                            indiceConductorEnCasoDeExistir = j;
                        } else {
                            contadorConductores++;
                        }

//                        --------------------------------CASO4------------------------------------
                        if (contadorConductores == listaConductores.size()) { //se verifica que el usuario no coincide con ninguna cedula
                            //de conductores.txt
                            caso = 4;
                            System.out.println("caso4");

                            indiceUsuarioEnCasoDeExistir = i;

                        }


                    }

                }


            }
            if(!(informacionUsuario[3].equals(user))){
                contador++;
            }

            if(contador==listaUsuarios.size()){ //Se verifica si ningún usuario tiene un user que coincida con el del que
                //está iniciando sesión.
                caso=5;
                System.out.println("caso5");

            }



            }

        String nombreUsuarioPorAgregar;
        String apellidoUsuarioPorAgregar;
        String cedulaUsuarioPorAgregar;
        String usuarioUsuarioPorAgregar;
        String contraseniaUsuarioPorAgregar;
        String celularUsuarioPorAgregar;
        String tipoDeUsuario;
        TipoUsuario tipoUsuario;
        EstadoConductor estadoConductor;
        TipoVehiculo tipoVehiculo=TipoVehiculo.AUTO;
        String edad="";
        String placa="";
        String marca="";
        String modelo="";

        int edadNumerico;
        String numeroTarjeta;

        String codigoVehiculo;
        String placaVehiculo;
        String modeloVehiculo;
        String marcaVehiulo;
        String tipoDeVehiculo;
        TipoVehiculo tipoDeVeh;



        switch (caso) {

            case 1:
                informacionUsuario = listaUsuarios.get(indiceUsuarioEnCasoDeExistir).split(",");
                informacionCliente = listaClientes.get(indiceClienteEnCasoDeExistir).split(",");
                nombreUsuarioPorAgregar = informacionUsuario[1];
                apellidoUsuarioPorAgregar = informacionUsuario[2];
                cedulaUsuarioPorAgregar = informacionUsuario[0];
                usuarioUsuarioPorAgregar = informacionUsuario[3];
                contraseniaUsuarioPorAgregar = informacionUsuario[4];
                celularUsuarioPorAgregar = informacionUsuario[5];
                tipoDeUsuario=informacionUsuario[6];
                if (tipoDeUsuario.equals("C")){
                    tipoUsuario=TipoUsuario.C;
                }
                else{
                    tipoUsuario=TipoUsuario.R;
                }
                edad=informacionCliente[1];
                edadNumerico = Integer.parseInt(edad);
                numeroTarjeta = informacionCliente[2];


                //nombre,apellido,numeroCedula,user,contrasenia,numerocelular,TipoUsuario tipoUsuario,int Edad,numeroTarjeta
                Cliente clienteParaRetornar = new Cliente(nombreUsuarioPorAgregar, apellidoUsuarioPorAgregar, cedulaUsuarioPorAgregar,
                        usuarioUsuarioPorAgregar, contraseniaUsuarioPorAgregar, celularUsuarioPorAgregar, tipoUsuario, edadNumerico, numeroTarjeta);

                return clienteParaRetornar;




            case 2:
                informacionUsuario=listaUsuarios.get(indiceUsuarioEnCasoDeExistir).split(",");


                System.out.println("Hacen falta datos para su registro completo.\nPor favor, ingrese su edad: ");
                edad = sc.nextLine();
                sc.nextLine();
                System.out.println("Ahora su número de tarjeta de crédito: ");
                numeroTarjeta = sc.nextLine();
                edadNumerico = Integer.parseInt(edad);



                nombreUsuarioPorAgregar = informacionUsuario[1];
                apellidoUsuarioPorAgregar = informacionUsuario[2];
                cedulaUsuarioPorAgregar = informacionUsuario[0];
                usuarioUsuarioPorAgregar = informacionUsuario[3];
                contraseniaUsuarioPorAgregar = informacionUsuario[4];
                celularUsuarioPorAgregar = informacionUsuario[5];
                tipoUsuario = TipoUsuario.C;


                //nombre,apellido,numeroCedula,user,contrasenia,numerocelular,TipoUsuario tipoUsuario,int Edad,numeroTarjeta
                clienteParaRetornar = new Cliente(nombreUsuarioPorAgregar, apellidoUsuarioPorAgregar, cedulaUsuarioPorAgregar,
                        usuarioUsuarioPorAgregar, contraseniaUsuarioPorAgregar, celularUsuarioPorAgregar, tipoUsuario, edadNumerico, numeroTarjeta);

                String cadenaPorAgregar = informacionUsuario[0] + "," + edad+ "," + numeroTarjeta;
                ManejoArchivos.escribirArchivo("clientes.txt","\n"+ cadenaPorAgregar);

                return clienteParaRetornar;



            case 3:
                informacionConductor = listaClientes.get(indiceConductorEnCasoDeExistir).split(",");
                informacionUsuario=listaUsuarios.get(indiceUsuarioEnCasoDeExistir).split(",");

                nombreUsuarioPorAgregar = informacionUsuario[1];
                apellidoUsuarioPorAgregar = informacionUsuario[2];
                cedulaUsuarioPorAgregar = informacionUsuario[0];
                usuarioUsuarioPorAgregar = informacionUsuario[3];
                contraseniaUsuarioPorAgregar = informacionUsuario[4];
                celularUsuarioPorAgregar = informacionUsuario[5];
                if (informacionConductor[1].equals("D")) {
                    estadoConductor = EstadoConductor.D;
                } else {
                    estadoConductor = EstadoConductor.O;
                }


                for (String vehiculo : listaVehiculos) {
                    informacionVehiculo = vehiculo.split(",");
                    if (informacionConductor[2].equals(informacionVehiculo[0])) {
                        placa = informacionVehiculo[1];
                        modelo = informacionVehiculo[2];
                        marca = informacionVehiculo[3];
                        if (informacionVehiculo[4].equals("AUTO")) {
                            tipoVehiculo = TipoVehiculo.AUTO;
                        } else {
                            tipoVehiculo = TipoVehiculo.MOTO;
                        }
                    }
                }
                Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, tipoVehiculo);
                Conductor conductorParaRetornar = new Conductor(nombreUsuarioPorAgregar, apellidoUsuarioPorAgregar, cedulaUsuarioPorAgregar
                        , usuarioUsuarioPorAgregar, contraseniaUsuarioPorAgregar, celularUsuarioPorAgregar, TipoUsuario.R, estadoConductor, vehiculo);


                return conductorParaRetornar;


            case 4:

                System.out.println("Hacen falta datos para su registro completo.\nPor favor, ingrese: ");
                System.out.println("Estado(D u O): ");
                String estado = sc.nextLine();


                if (estado.equals("D")) {
                    estadoConductor = EstadoConductor.D;
                } else {
                    estadoConductor = EstadoConductor.O;
                }
                codigoVehiculo = String.valueOf(listaVehiculos.size());
                System.out.println("Placa del vehículo: ");
                placaVehiculo = sc.nextLine();
                System.out.println("Modelo: ");
                modeloVehiculo = sc.nextLine();
                System.out.println("Marca: ");
                marcaVehiulo = sc.nextLine();
                System.out.println("Tipo de Vehículo (MOTO O AUTO)");
                tipoDeVehiculo = sc.nextLine().toUpperCase();
                if (tipoDeVehiculo.equals("MOTO")) {
                    tipoDeVeh = TipoVehiculo.MOTO;
                } else {
                    tipoDeVeh = TipoVehiculo.AUTO;
                }
                vehiculo = new Vehiculo(placaVehiculo, marcaVehiulo, modeloVehiculo, tipoDeVeh);
                //cadena por agregar al txt de conductores
                String [] infoUsuarioo=listaUsuarios.get(indiceUsuarioEnCasoDeExistir).split(",");

                String cadenaPorAgregarConductores = infoUsuarioo[0] + "," + estado + "," + codigoVehiculo;
                ManejoArchivos.escribirArchivo("conductores.txt", "\n"+cadenaPorAgregarConductores);
                String cadenaPorAgregarVehiculos = codigoVehiculo + "," + placaVehiculo + "," + modeloVehiculo + "," + marcaVehiulo + "," + tipoDeVehiculo;
                ManejoArchivos.escribirArchivo("vehiculos.txt", "\n"+cadenaPorAgregarVehiculos);
                nombreUsuarioPorAgregar = infoUsuarioo[1];
                apellidoUsuarioPorAgregar = infoUsuarioo[2];
                cedulaUsuarioPorAgregar = infoUsuarioo[0];
                usuarioUsuarioPorAgregar = infoUsuarioo[3];
                contraseniaUsuarioPorAgregar = infoUsuarioo[4];
                celularUsuarioPorAgregar = infoUsuarioo[5];
                tipoUsuario = TipoUsuario.R;
                conductorParaRetornar = new Conductor(nombreUsuarioPorAgregar, apellidoUsuarioPorAgregar, cedulaUsuarioPorAgregar,
                        usuarioUsuarioPorAgregar, contraseniaUsuarioPorAgregar, celularUsuarioPorAgregar, tipoUsuario, estadoConductor
                        , vehiculo);
                return conductorParaRetornar;



            case 5:

                System.out.println("CUENTA NO REGISTRADA");
                System.out.println("Por favor, ingrese: \nNúmero de cédula: ");
                String cedula = sc.nextLine();
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();
                System.out.println("Apellido: ");
                String apellido = sc.nextLine();
                System.out.println("Usuario: ");
                String nombreUsuario = sc.nextLine();
                System.out.println("Contraseña: ");
                String contraseña = sc.nextLine();
                System.out.println("Número de celular: ");
                String numeroCelular = sc.nextLine();
                System.out.println("Desea como registrarse como cliente (C) o como conductor (R): ");
                String tipoDeUsuarioDos = sc.nextLine();

                //AGREGAR USUARIO EN USUARIOS.TXT:


                cadenaPorAgregar = cedula + "," + nombre + "," + apellido + "," + nombreUsuario + "," + contraseña + "," + numeroCelular + "," +tipoDeUsuarioDos;
                ManejoArchivos.escribirArchivo("usuarios.txt", "\n"+cadenaPorAgregar);

                //REGISTRO DE DATOS ADICIONALES DEPENDIENDO DE SI ES CLIENTE O CONDUCTOR:
                if (String.valueOf(tipoDeUsuarioDos).equals("C")) {
                    //SE PIDE INFORMACIÓN PARA AGREGAR EL CLIENTE A CLIENTES.TXT
                    System.out.println("Edad: ");
                    String edadStr = sc.nextLine();
                    System.out.println("Numero de Tarjeta De Crédito");
                    numeroTarjeta = sc.nextLine();
                    int edadCliente = Integer.parseInt(edadStr);

                    //Instanciando un Cliente

                    Cliente clientePorRetornar = new Cliente(nombre, apellido, cedula, nombreUsuario, contraseña, numeroCelular,
                            TipoUsuario.C, edadCliente, numeroTarjeta);

                    //CADENA POR AGREGAR A CLIENTES.TXT

                    String cadenaPorAgregar2 = cedula + "," + edadStr + "," + numeroTarjeta;
                    ManejoArchivos.escribirArchivo("clientes.txt", "\n"+cadenaPorAgregar2);

                    return clientePorRetornar;


                } else {

                    System.out.println("Estado(D u O): ");
                    estado = sc.nextLine();
                    codigoVehiculo = String.valueOf(listaVehiculos.size());
                    System.out.println("Placa del vehículo: ");
                    placaVehiculo = sc.nextLine();
                    System.out.println("Modelo: ");
                    modeloVehiculo = sc.nextLine();
                    System.out.println("Marca: ");
                    marcaVehiulo = sc.nextLine();
                    System.out.println("Tipo de Vehículo (MOTO O AUTO)");
                    tipoDeVehiculo = sc.nextLine().toUpperCase();


                    if (tipoDeVehiculo.equals("MOTO")) {
                        tipoVehiculo = TipoVehiculo.MOTO;
                    } else {
                        tipoVehiculo = TipoVehiculo.AUTO;
                    }
                    if (estado.equals("D")) {
                        estadoConductor = EstadoConductor.D;
                    } else {
                        estadoConductor = EstadoConductor.O;
                    }
                    //cadena por agregar al txt de conductores
                    cadenaPorAgregarConductores = cedula + "," + estado + "," + codigoVehiculo;
                    ManejoArchivos.escribirArchivo("conductores.txt", "\n"+cadenaPorAgregarConductores);
                    cadenaPorAgregarVehiculos = codigoVehiculo + "," + placaVehiculo + "," + modeloVehiculo + "," + marcaVehiulo + "," + tipoVehiculo;
                    ManejoArchivos.escribirArchivo("vehiculos.txt", "\n"+cadenaPorAgregarVehiculos);

                    //instanciando vehículo:
                    vehiculo = new Vehiculo(placaVehiculo, marcaVehiulo, modeloVehiculo, tipoVehiculo);


                    //instanciando Conductor:
                    Conductor conductorPorRetornar = new Conductor(nombre, apellido, cedula, nombreUsuario, contraseña,
                            numeroCelular, TipoUsuario.R, estadoConductor, vehiculo);


                    return conductorPorRetornar;







                }
            case 6:

            default:
                return null;
        }
    }



    public static boolean mostrarMenuCliente(Cliente cliente){

        ArrayList<String> listaServicios=ManejoArchivos.leerArchivo("servicios.txt");
        ArrayList<String> listaUsuarios=ManejoArchivos.leerArchivo("usuarios.txt");
        Scanner sc=new Scanner(System.in);
        System.out.println("***********MENÚ************\n*                            *\n****************************\n");
        System.out.println("1. Solicitar servicio de taxi.\n2.Solicitar entrega de encomienda. \n3. Consultar servicios\n" +
                "4. Salir del Menú\nElija una opción: ");
        int opcionElegida=sc.nextInt();
        while (!(opcionElegida==1 || opcionElegida==2 || opcionElegida==3 || opcionElegida==4)) {
            System.out.println("OPCIÓN NO VÁLIDA. Por favor vuelva a ingresar: ");
            opcionElegida = sc.nextInt();
        }
        Double total=9.9999;

        switch(opcionElegida){
            case 1:

                //METODO SOLICITAR TAXI
                total=cliente.solicitarTaxi(listaUsuarios);
                if (total==0.00){
                    return true; //O sea debo volver a llamar a mostrar menú en el main.
                }
                else{
                    return true;
                }



            case 2:

                //METODO SOLICITAR ENCOMIENDA
                total=cliente.solicitarEncomienda(listaUsuarios);
                if (total==0.00){
                    return true; //DEBO VOLVER A LLAMAR A MOSTRAR MENÚ
                }

                return true;



            case 3:
                boolean valorBool=cliente.consultarServicios(listaServicios);
                return valorBool;





                case 4:
                return false;

        }
        return false;

    }


    public static boolean mostrarMenuConductor(Conductor conductor){

        ArrayList<String> listaServicios=ManejoArchivos.leerArchivo("servicios.txt");
        ArrayList<String> listaUsuarios=ManejoArchivos.leerArchivo("usuarios.txt");
        Scanner sc=new Scanner(System.in);
        System.out.println("***********MENÚ************\n*                            *\n****************************\n");
        System.out.println("1. Consultar Servicio Asignado.\n2. Consultar datos de vehículo.\n3. Salir del Menú\nElija una opción: ");
        int opcionElegida=sc.nextInt();
        while (!(opcionElegida==1 || opcionElegida==2 || opcionElegida==3)) {
            System.out.println("OPCIÓN NO VÁLIDA. Por favor vuelva a ingresar: ");
            opcionElegida = sc.nextInt();
        }
        Double total=9.9999;
        boolean valorBool=false;

        switch(opcionElegida){
            case 1:

                //METODO CONSULTAR SERVICIO ASIGNADO
                valorBool=conductor.consultarServicios(listaServicios);
                if (valorBool){
                    return true; //O sea debo volver a llamar a mostrar menú en el main.
                }
                else{
                    return false;
                }



            case 2:

                //METODO CONSULTAR DATOS DE VEHÍCULO
                valorBool=conductor.consultarVehiculo();
                if (valorBool){
                    return true; //DEBO VOLVER A LLAMAR A MOSTRAR MENÚ
                }

                return false;


            case 3:
                return false;

        }
        return false;
    }


}





