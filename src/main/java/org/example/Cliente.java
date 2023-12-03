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


    //GETTERS AND SETTTERS

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



    /**
    * Este metodo solicita un servicio de taxi por parte del cliente
     * * @param listaUsuarios
    * @return PagoServicio Devuelve una instancia PagoServicio.
    **/
     public double solicitarTaxi(ArrayList<String> listaUsuarios){

         //EN ESTE PRÓXIMO BLOQUE SE PIDEN TODOS LOS DATOS TANTO PARA AGREGAR A SERVICIOS.TXT COMO A VIAJES.TXT
         //PERO NO SE AGREGAN HASTA EL FINAL PORQUE UNA VEZ MOSTRADO EL SUBTOTAL HAY QUE PREGUNTARLE AL USUARIO SI
         //DESEA CONFIRMAR EL VIAJE O NO. SI NO LO CONFIRMA, SE LE MUESTRA OTRA VEZ EL MENÚ INICIAL
    
         Scanner sc = new Scanner(System.in);
         Random rd = new Random();
         
         System.out.println("Usted esta solicitando un taxi");
         System.out.print("Ingrese la ubicacion de INICIO de la ruta: \n");
         String origen = sc.nextLine();

         System.out.print("Ingrese la ubicacion de FIN de la ruta: \n");
         String fin = sc.nextLine();

         System.out.print("Ingrese la fecha del viaje: \n");
         String fecha = sc.nextLine();

         System.out.print("Ingrese la hora del viaje: \n");
         String hora = sc.nextLine();

         System.out.println("Ingrese el metodo de pago");
         System.out.print("si es efectivo escriba E o TARJETA DE CREDITO escriba TC: \n");
         String elMetodo = sc.nextLine();
         MetodoPago metodo = MetodoPago.valueOf(elMetodo);

         System.out.print("Ingrese la cantidad de personas que iran en el viaje: \n");
         int cantidad = sc.nextInt();

         int kilometraje=rd.nextInt(4,45);
         final double tarifa=0.50;
         double subTotal= kilometraje*tarifa;
         double total;

         if (elMetodo.equals("TC")){
             total=subTotal+(subTotal*0.15);
         }
         else{
             total=subTotal;
         }
         


         ArrayList<String> listaServicios=ManejoArchivos.leerArchivo("servicios.txt");
         String numeroServicio=String.valueOf(listaServicios.size());
         //ArrayList<Servicio> Servicios;

         ArrayList<String> listaConductores = ManejoArchivos.leerArchivo("conductores.txt");
         ArrayList<String> listaPagos=ManejoArchivos.leerArchivo("pagos.txt");


         String nombreConductor="Sin info"; //TERMINANDO EL WHILE QUEDA EL NOMBRE DEL CONDUCTOR QUE HARÁ EL SERVICIOTAXI
         String codigoVehiculoPrevio;
         int codigoVehiculo; //TERMINANDO EL WHILE QUEDA EL INT DEL CODIGO DEL VEHICULO DEL CONDUCTOR QUE HARÁ EL SERVICIOTAXI
         String conductor="";
         String[] infoConductor=conductor.split(",");
         int numeroAleatorio;
         ArrayList<String> listaVehiculos=ManejoArchivos.leerArchivo("vehiculos.txt");
         while(nombreConductor.equals("Sin info")) {
                 numeroAleatorio=rd.nextInt(1,listaConductores.size()-1);
                 conductor=listaConductores.get(numeroAleatorio);
                 infoConductor=conductor.split(",");
                 codigoVehiculoPrevio=infoConductor[2];
                 codigoVehiculo=Integer.parseInt(codigoVehiculoPrevio);

                 String[] infoVehiculoDeCandidato= listaVehiculos.get(codigoVehiculo).split(",");


                 if (infoConductor[1].equals("D") & infoVehiculoDeCandidato[4].equals("AUTO")) {



                     for (String usuario:listaUsuarios){
                         String[] infoUsuario=usuario.split(",");
                         if (infoUsuario[0].equals(infoConductor[0])){
                             nombreConductor=infoUsuario[1];
                         }

                     }

                 }

             }

         //HASTA ESTE MOMENTO YA SE TIENEN TODOS LOS DATOS DEL SERVICIO Y DEL VIAJE

         System.out.print("El subtotal del viaje solicitado es: "+subTotal+" Y el total es: "+total+" Desea confirmar su viaje?\n");
         System.out.println("SI/NO: ");
         String confirmacion = sc.next();

         if (confirmacion.equals("SI")){
             String cadenaPorAgregarServicios=numeroServicio+","+"T"+","+numeroCedula+","+nombreConductor+","+origen+","+fin+","+fecha+","+hora;
             ManejoArchivos.escribirArchivo("servicios.txt","\n"+cadenaPorAgregarServicios);
             String cadenaPorAgregarViajes=numeroServicio+","+String.valueOf(cantidad)+","+String.valueOf(kilometraje)+","+String.valueOf(subTotal);
             ManejoArchivos.escribirArchivo("viajes.txt","\n"+cadenaPorAgregarViajes);

             int numeroPagosExistentes=listaPagos.size();
             String numeroPago=String.valueOf(numeroPagosExistentes);
             String cadenaPorAgregarPagos=numeroPago+","+fecha+","+numeroServicio+","+
                     elMetodo+","+numeroCedula+","+String.valueOf(subTotal)+","+String.valueOf(total);
             ManejoArchivos.escribirArchivo("pagos.txt",cadenaPorAgregarPagos);
             return total;
         }
         else{
             return 0.00;
         }
         
        
    }
     
     
    /**
     * Este metodo solicita una encomienda por parte del cliente
     * @param listaUsuarios lista requerida para obtener la instancia PagoServicio.
     * @return PagoServicio Devuelve una instancia PagoServicio.
     **/
    public double solicitarEncomienda(ArrayList<String> listaUsuarios){

        //EN ESTE PRÓXIMO BLOQUE SE PIDEN TODOS LOS DATOS TANTO PARA AGREGAR A SERVICIOS.TXT COMO A VIAJES.TXT
        //PERO NO SE AGREGAN HASTA EL FINAL PORQUE UNA VEZ MOSTRADO EL SUBTOTAL HAY QUE PREGUNTARLE AL USUARIO SI
        //DESEA CONFIRMAR EL VIAJE O NO. SI NO LO CONFIRMA, SE LE MUESTRA OTRA VEZ EL MENÚ INICIAL

        //eliminar lineas vacias del arraylist listaUsuarios
        String[] infoUsuarioPorBorrar;
        for (int i=0;i<listaUsuarios.size();i++){
            infoUsuarioPorBorrar=listaUsuarios.get(i).split(",");
            if(infoUsuarioPorBorrar.length==1){
                listaUsuarios.remove(i);
            }
        }

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.print("Usted esta solicitando el servicio de encomiendas");
        System.out.print("Ingrese la ubicacion de INICIO de la ruta: ");
        String origen = sc.next();

        System.out.print("Ingrese la ubicacion de FIN de la ruta: ");
        String fin = sc.next();

        System.out.print("Ingrese la fecha del viaje: ");
        String fecha = sc.next();

        System.out.print("Ingrese la hora del viaje: ");
        String hora = sc.next();

        System.out.print("Ingrese el metodo de pago");
        System.out.print("si es efectivo escriba E o TARJETA DE CREDITO escriba TC: ");
        String elMetodo = sc.next();
        MetodoPago metodo = MetodoPago.valueOf(elMetodo);

        System.out.print("Ingrese la cantidad de productos que desea enviar: ");
        int cantidad = sc.nextInt();
        System.out.print("Ingrese el tipo de productos que desea enviar(MEDICAMENTOS, DOCUMEMTOS O ROPA): ");
        String tipoEncomienda=sc.next().toUpperCase();
        System.out.print("Ingrese el peso total de los productos que desea enviar: ");
        String pesoProductos=sc.next();


        double subTotal= cantidad+4;
        double total;

        if (elMetodo.equals("TC")){
            total=subTotal+(subTotal*0.15);
        }
        else{
            total=subTotal;
        }



        ArrayList<String> listaServicios=ManejoArchivos.leerArchivo("servicios.txt");
        //eliminar lineas vacias del arraylist listaServicios
        String[] infoServicioPorBorrar;
        for (int i=0;i<listaServicios.size();i++){
            infoServicioPorBorrar=listaServicios.get(i).split(",");
            if(infoServicioPorBorrar.length==1){
                listaServicios.remove(i);
            }
        }

        String numeroServicio=String.valueOf(listaServicios.size());
        ArrayList<Servicio> Servicios;

        ArrayList<String> listaConductores = ManejoArchivos.leerArchivo("conductores.txt");
        //eliminar lineas vacias del arraylist listaServicios
        String[] infoConductorPorBorrar;
        for (int i=0;i<listaConductores.size();i++){
            infoConductorPorBorrar=listaConductores.get(i).split(",");
            if(infoConductorPorBorrar.length==1){
                listaConductores.remove(i);
            }
        }

        ArrayList<String> listaPagos=ManejoArchivos.leerArchivo("pagos.txt");

        //eliminar lineas vacias del arraylist listaPagos
        String[] infoPagosPorBorrar;
        for (int i=0;i<listaPagos.size();i++){
            infoPagosPorBorrar=listaPagos.get(i).split(",");
            if(infoPagosPorBorrar.length==1){
                listaPagos.remove(i);
            }
        }





        String nombreConductor="Sin info"; //TERMINANDO EL WHILE QUEDA EL NOMBRE DEL CONDUCTOR QUE HARÁ EL SERVICIOTAXI
        String codigoVehiculoPrevio;
        int codigoVehiculo; //TERMINANDO EL WHILE QUEDA EL INT DEL CODIGO DEL VEHICULO DEL CONDUCTOR QUE HARÁ EL SERVICIOTAXI
        String conductor="";
        String[] infoConductor=conductor.split(",");
        int numeroAleatorio;
        ArrayList<String> listaVehiculos=ManejoArchivos.leerArchivo("vehiculos.txt");
        while(nombreConductor.equals("Sin info")) {
            numeroAleatorio=rd.nextInt(1,listaConductores.size()-1);
            conductor=listaConductores.get(numeroAleatorio);
            infoConductor=conductor.split(",");
            codigoVehiculoPrevio=infoConductor[2];
            codigoVehiculo=Integer.parseInt(codigoVehiculoPrevio);

            String[] infoVehiculoDeCandidato= listaVehiculos.get(codigoVehiculo+1).split(",");


            if (infoConductor[1].equals("D") & infoVehiculoDeCandidato[4].equals("MOTO")) {

                for (String usuario:listaUsuarios){
                    String[] infoUsuario=usuario.split(",");
                    if (infoUsuario[0].equals(infoConductor[0])){
                        nombreConductor=infoUsuario[1];
                    }

                }

            }
        }

        //HASTA ESTE MOMENTO YA SE TIENEN TODOS LOS DATOS DEL SERVICIO Y DEL VIAJE



        System.out.print("El subtotal del viaje solicitado es: "+subTotal+" Y el total es: "+total+"\nDesea confirmar su viaje? SI/NO: \n");
        String confirmacion = sc.nextLine();
        sc.close();









        if (confirmacion.equals("SI")){
            String cadenaPorAgregarServicios=numeroServicio+","+"T"+","+numeroCedula+","+nombreConductor+","+origen+","+fin+","+fecha+","+hora;
            ManejoArchivos.escribirArchivo("servicios.txt","\n"+cadenaPorAgregarServicios);
            String cadenaPorAgregarEncomiendas=numeroServicio+","+tipoEncomienda+","+String.valueOf(cantidad)+","+String.valueOf(pesoProductos)+","+String.valueOf(subTotal);
            ManejoArchivos.escribirArchivo("viajes.txt","\n"+cadenaPorAgregarEncomiendas);

            int numeroPagosExistentes=listaPagos.size();
            String numeroPago=String.valueOf(numeroPagosExistentes);
            String cadenaPorAgregarPagos=numeroPago+","+fecha+","+numeroServicio+","+
                    elMetodo+","+numeroCedula+","+String.valueOf(subTotal)+","+String.valueOf(total);
            ManejoArchivos.escribirArchivo("pagos.txt",cadenaPorAgregarPagos);
            return total;
        }
        else{
            return 0.00;
        }


    }



    /**
     * Este metodo solicita una encomienda por parte del cliente
     * @param  listaServicios instancia requerida para ser agregada a la lista.
     **/
    @Override
    public boolean consultarServicios(ArrayList<String> listaServicios){

        listaServicios.remove(0);

        //eliminar lineas vacias del arraylist listaServicios
        String[] infoServicioPorBorrar;
        for (int i=0;i<listaServicios.size();i++){
            infoServicioPorBorrar=listaServicios.get(i).split(",");
            if(infoServicioPorBorrar.length==1){
                listaServicios.remove(i);
            }
        }

        ArrayList<Servicio> listaDeServicios=new ArrayList<>();
        String[] infoServicios;
        for (String servicio:listaServicios){
            infoServicios=servicio.split(",");
            if (infoServicios[2].equals(this.numeroCedula)) {
                //numeroServicio,tipoServicio,cedulaCliente,nombreConductor,desde,hasta,fecha,hora
                String numeroServicio = infoServicios[0];
                String tipoDeServicio = infoServicios[1];
                TipoServicio tipoServicio;
                if (tipoDeServicio.equals("E")) {
                    tipoServicio = TipoServicio.E;
                } else {
                    tipoServicio = TipoServicio.T;
                }
                String cedulaCliente = infoServicios[2];
                String nombreConductor = infoServicios[3];
                String desde = infoServicios[4];
                String hasta = infoServicios[5];
                String fecha = infoServicios[6];
                String hora = infoServicios[7];
                Servicio servicioPorAgregar = new Servicio(numeroServicio, tipoServicio, cedulaCliente, nombreConductor, desde, hasta, fecha, hora);
                listaDeServicios.add(servicioPorAgregar);
            }
        }
        for (Servicio servicio:listaDeServicios){
            servicio.mostrarInformacion();
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Desea regresar al menú(1) o cerrar sesión(2)?: ");
        String respuesta= sc.nextLine();
        if (respuesta.equals("1")){
            return true;
        }
        else{
            return false;
        }


        








    }

}



