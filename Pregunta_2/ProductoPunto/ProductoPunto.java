class ProductoPunto extends Thread {
    int i;
    double ai;
    double bi;
    double[] array;
    public ProductoPunto( int index, double coordVector1, 
                        double coordVector2, double[] resultadosParciales ) {
        i = index;
        ai = coordVector1;
        bi = coordVector2;
        array = resultadosParciales;
    }

    public void run() {
        array[i] = ai*bi;
    }
}