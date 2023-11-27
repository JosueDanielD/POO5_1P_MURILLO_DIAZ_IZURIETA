package org.example;
import java.io.*;
import java.util.ArrayList;

public class ManejoArchivos {
    //IMPLIMENTAR MÉTODO QUE CREE UN ARCHIVO DE TEXTO:
    
    /**
    * Este metodo crea un archivo
    * @param  nombreArchivo nombre del archivo para crearlo.
    **/
    public static void crearArchivo(String nombreArchivo){
        File archivo= new File(nombreArchivo);
        try{
            PrintWriter salida=new PrintWriter (archivo);
            salida.close();
            System.out.println("Se creo el archivo");
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }

    //IMPLEMENTAR MÉTODO QUE ESCRIBA EN UN ARCHIVO:
    
    /**
    * Este metodo escribe en un archivo
    * @param  nombreArchivo String con el nombre del archivo para escribir.
    * @param  contenido String con el contenido para escribir.
    * @return PagoServicio Devuelve una instancia PagoServicio.
    **/
    public static void escribirArchivo(String nombreArchivo, String contenido){
        File archivo= new File(nombreArchivo); //para verificar si el archivo existe.
        try{
            PrintWriter salida=new PrintWriter (new FileWriter(archivo,true));
            salida.println(contenido);
            salida.close();
            System.out.println("Se escribió el archivo");
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
        catch (IOException ex){
            ex.printStackTrace(System.out);
        }
    }





    //AHORA UN MÉTODO PARA LEER ARCHIVOS:
    
    /**
    * Este metodo escribe en un archivo
    * @param  nombreArchivo String con el nombre del archivo para escribir necesario para retornar eun arreglo.
    * @return ArrayList<String> arreglo que contiene la linea del archivo como Strings.
    **/
    
    public static ArrayList<String> leerArchivo(String nombreArchivo){
        File archivo= new File(nombreArchivo); //para verificar si el archivo existe.
        ArrayList<String> lecturaArchivo=new ArrayList<String>();

        try{
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura= entrada.readLine();
            while(lectura !=null){
                System.out.println(lectura);
                lecturaArchivo.add(lectura);
                lectura=entrada.readLine();
            }
            return lecturaArchivo;

        }
        catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
        catch (IOException ex){
            ex.printStackTrace(System.out);
        }
        return lecturaArchivo;

    }

}
