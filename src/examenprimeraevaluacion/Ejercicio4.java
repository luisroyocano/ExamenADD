package examenprimeraevaluacion;

import java.io.IOException;
import java.io.*;
import java.util.Scanner;
public class Ejercicio4 {

    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 4: Ficheros aleatorios.");
        opciones(sc);
    }
    public static void opciones(Scanner sc)throws IOException{
        File fichero = new File("HanSoloAleatorio.txt");        
        RandomAccessFile RAF = new RandomAccessFile(fichero, "rw");
        System.out.println("¿Qué operación desea realizar?\na)Insertar Registro\nb)Saber nº total de registros\nc)Salir del programa");
        String respuesta = sc.nextLine();
        if(respuesta.equals("insertar")||respuesta.equals("a")){
            insertarRegistro(sc,fichero,RAF);
        }else if(respuesta.equals("numero registros")||respuesta.equals("b")){
            numeroRegistros(RAF,sc);
        }else if(respuesta.equals("salir")||respuesta.equals("c")){
            System.exit(0);
        }
    }
    public static void insertarRegistro(Scanner sc,File fichero, RandomAccessFile RAF)throws IOException{
        System.out.println("Indique el registro que desea insertar:");
        System.out.println("Nota 1:");
        String nota01 = sc.nextLine();
        float nota1 = Float.parseFloat(nota01);
        System.out.println("Nota 2:");
        String nota02 = sc.nextLine();
        float nota2 = Float.parseFloat(nota02);
        System.out.println("Nota 3:");
        String nota03 = sc.nextLine();
        float nota3 = Float.parseFloat(nota03);       
        int longitud=(int)fichero.length();
        RAF.seek(longitud);
        RAF.writeFloat(nota1);
        RAF.writeFloat(nota2);
        RAF.writeFloat(nota3);
        opciones(sc);
    }
    public static void numeroRegistros(RandomAccessFile RAF,Scanner sc)throws IOException{
        int numReg = (int)RAF.length()/12;
        System.out.println("Número de registros: "+numReg);
        opciones(sc);
    }
    
}
