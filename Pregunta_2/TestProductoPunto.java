import java.util.Arrays;
import java.util.Random;
public class TestProductoPunto {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        double[] vector1 = new double[n];
        double[] vector2 = new double[n];
        double[] productoParcial = new double[n];

        // Generando Dos Vectores aleatorios dada la dimension como argumento
        for (int i = 0; i < n; i++) {
            vector1[i] = (-255) + (new Random().nextDouble() * (255 - (-255)));
            vector2[i] = (-255) + (new Random().nextDouble() * (255 - (-255)));
        }
        System.out.println("Vector 1: " + Arrays.toString(vector1));
        System.out.println("Vector 2: " + Arrays.toString(vector2));
        
        productosParcialesConHilos( vector1, vector2, productoParcial );
        System.out.println("Producto Punto: " + sumarComponentes( productoParcial ));
    }

    // Dados dos vectores se calcula un vector de productos parciales ans
    // donde ans[i] =  v1[i]*v2[i], mediante hilos de ejecucion dado que
    // cada dimension es independiente entre si entonces no existirian
    // condiciones de carrera.

    public static void productosParcialesConHilos( double[] v1, double[] v2,
                                                     double[] ans ) {
        for (int i = 0; i < ans.length; i++) {
            ProductoPunto temp = new ProductoPunto(i, v1[i], v2[i], ans );
            temp.start();
            System.out.println("Calculo de Coordenada " + i + " iniciado");
        }
    }

    // Dado un vector de sumas parciales suma todos sus elementos
    // Este no implementa hilos
    public static double sumarComponentes( double[] productoParcial ) {
        System.out.println("Calculando la suma de los productos parciales");
        double resultado = 0.0;
        for (int i = 0; i < productoParcial.length; i++) {
            resultado += productoParcial[i];
        }
        return resultado;
    }
}
