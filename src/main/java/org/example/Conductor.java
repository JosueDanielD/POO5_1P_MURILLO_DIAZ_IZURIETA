package org.example;
import java.util.ArrayList;
import java.util.Scanner;

//(em)Clase Conductor es Hija de Usuario
public class Conductor extends Usuario {

    //(em)Atributos propios de Conductor
    private EstadoConductor estadoConductor;
    private Vehiculo vehiculo;

    //(em)Constructor de la clase
    public Conductor(String nombre,
                     String apellido,
                     String numeroCedula,
                     String user,
                     String contraseña,
                     String numeroCelular,
                     TipoUsuario tipoUsuario,
                     EstadoConductor estadoConductor,
                     Vehiculo vehiculo) {
        super(nombre, apellido, numeroCedula, user, contraseña, numeroCelular, tipoUsuario);
        this.estadoConductor = estadoConductor;
        this.vehiculo = vehiculo;
    }

    //(em)Metodos getters y setters
    public EstadoConductor getEstadoConductor() {
        return estadoConductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setEstadoConductor(EstadoConductor estadoConductor) {
        this.estadoConductor = estadoConductor;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    //(em)Metodo consultarServicio sobrescrito

    /**
     * Este metodo consulta los servicios de conductor
     *
     * @param listaServicios lista requerida para realizar el print necesario.
     **/

    @Override
    public boolean consultarServicios(ArrayList<String> listaServicios) {

        listaServicios.remove(0);
        //eliminar lineas vacias del arraylist listaServicios
        String[] infoServicioPorBorrar;
        for (int i=0;i<listaServicios.size();i++){
            infoServicioPorBorrar=listaServicios.get(i).split(",");
            if(infoServicioPorBorrar.length==1){
                listaServicios.remove(i);
            }
        }

        ArrayList<Servicio> listaDeServicios = new ArrayList<>();
        String[] infoServicios;
        for (String servicio : listaServicios) {
            infoServicios = servicio.split(",");
            if (infoServicios[3].equals(this.nombre)) {
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

        for (Servicio servicio : listaDeServicios) {
            servicio.mostrarInformacion();
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Desea regresar al menú(1) o cerrar sesión(2)?: ");
        String respuesta = sc.nextLine();
        if (respuesta.equals("1")) {
            return true;
        } else {
            return false;
        }


        /**
         * Este metodo consulta el vehiculo del conductor.
         **/


    }

    public boolean consultarVehiculo() {
        System.out.println(this.getVehiculo().toString());
        Scanner sc= new Scanner(System.in);
        System.out.println("Desea volver al menú(1) o cerrar sesión(2)?: ");
        String eleccion=sc.nextLine();
        sc.close();

        if (eleccion.equals("1")){
            return true;
        }
        else{
            return false;
        }


    }





}

