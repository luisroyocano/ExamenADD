package examenprimeraevaluacion;
import java.io.*;
import java.util.Scanner;
public class Ejercicio3 {

    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 3: Ficheros secuenciales");
        opciones(sc);
    }
    public static void opciones(Scanner sc)throws IOException{        
        String rutaArchivo = "LukeSkywalker.txt"; 
        System.out.println("¿Qué apartado desea realizar?\na)Leer fichero.\nb)Escribir fichero.\nc)Salir del programa.");
        String respuesta = sc.nextLine();
        if(respuesta.equals("a")||respuesta.equals("leer")){
            leerFichero(sc,rutaArchivo);
        }else if(respuesta.equals("b")||respuesta.equals("escribir")){
            escribirFichero(sc,rutaArchivo);
        }else if(respuesta.equals("c")||respuesta.equals("salir")){
            System.exit(0);
        }
    }
    public static void escribirFichero(Scanner sc, String rutaArchivo)throws IOException{      
        System.out.println("Indique el texto que quiere añadir:");
        String textoAñadir = sc.nextLine();
        System.out.println("¿Desea sobreescribir el fichero?");
        String respuesta = sc.nextLine();
        if(respuesta.equals("si")){
            FileWriter fw = new FileWriter(rutaArchivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n"+textoAñadir);
            bw.close();
        }else if(respuesta.equals("no")){
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            String almacen;String almacenAuxiliar = "";
            while((almacen=br.readLine())!=null){
                almacenAuxiliar+=almacen+"\n";
            }
            br.close();
            FileWriter fw = new FileWriter(rutaArchivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(almacenAuxiliar+textoAñadir);
            bw.close();
        }
        opciones(sc);
    }
    public static void leerFichero(Scanner sc, String rutaArchivo)throws IOException{
        FileReader fr = new FileReader(rutaArchivo);
        BufferedReader br = new BufferedReader(fr);       
        String contenidoFichero;String almacenAuxiliar="";
        while((contenidoFichero=br.readLine())!=null){
            almacenAuxiliar+=contenidoFichero+"\n";
            
        }
        System.out.println("Contenido del fichero:"+almacenAuxiliar);
        opciones(sc);
    }
    
}
