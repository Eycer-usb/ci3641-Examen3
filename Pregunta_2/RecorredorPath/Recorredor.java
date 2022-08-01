/*
 * Se recibe un arreglo de un elemento donde se almacenara el contador
 * y ademas el string con el path de inicio
 * 
 * Se cuentan los archivos de este nivel y se generan nuevos hilos
 * para explorar sus subdirectorios.
*/

import java.io.File;
public class Recorredor extends Thread {

    int[] c;
    String path;

    public Recorredor( int[] contador, String dir ) {
        c = contador;
        path = dir;
    }

    public void run() {
        File[] carpeta = new File(path).listFiles();
        System.out.println("Ejecutando Hilo sobre: " + path);
        for (int i = 0; i < carpeta.length; i++) {
            if (carpeta[i].isFile()) {
                incrementarContador(c);
            }
            else if (carpeta[i].isDirectory()) {
                Recorredor temp = new Recorredor(c, path + "/" + carpeta[i].getName());
                temp.start();
            }
        }
    }
    
    // Para evitar accesos simultaneos al contador 
    // se crea este metodo synchronized
    synchronized public void incrementarContador( int[] c ){
        c[0]++;
    }
}
