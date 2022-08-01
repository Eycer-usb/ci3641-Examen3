/*
 * Tester de La clase Recorredor de Path.
 * Se Recibe por la linea de comandos el path de origen
 * se retorna la cantidad de archivos que archivos (No Directorios)
 * Que estan dentro de esta carpeta 
*/

public class TestRecorredor {
    public static void main(String[] args) {

        String path = args[0];
        int[] contador = new int[1];
        contador[0] = 0;
        Recorredor r = new Recorredor(contador, path);
        r.start();       
        while (Recorredor.activeCount()>1) continue;
        System.out.println("Cantidad de Archivos: " + contador[0]);        
    }

}