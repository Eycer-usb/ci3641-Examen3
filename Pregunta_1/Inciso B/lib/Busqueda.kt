/*
Clase abstracta Padre para la busqueda por
DFS o BSF.
*/
package lib
abstract class Busqueda( private val grafo: Grafo ) {
    // Se difinen las variables de Clase
    private var n: Int = grafo.cantidadDeElementos
    abstract val secuencia: Secuencia<Int> // El tipo especifico de la
                                           // secuencia dependera de
                                           // las clases hijas de Busqueda

    /*
    Se ejecuta el recorrido sobre el grafo, se busca si 
    existe un camino de 'a' a 'b'. Si es afirmativo retorna el
    numero de nodos explorados. Si no son alcanzables se retorna -1
    */                                 
    fun buscar( a: Int, b: Int): Int
    {
        // Visitados lleva un registro de los nodos explorados
        var visitado: Array<Boolean> = Array( n, { false } )

        // Inicialmente el nodo de partida ya es visitado
        // por lo que se agrega a la secuencia
        visitado[a] = true
        secuencia.agregar(a);

        // La variable c lleva la cuenta de nodos explorados 
        // (sin contar el nodo de inicio)
        var c = 0

        // Se inicia el recorrido sobre el grafo
        while( !secuencia.vacio() && !visitado[b]){

            // Se obtiene el elemento actual a explorar
            var elem: Int = secuencia.siguiente()!!
            var i = 0;
            var m = grafo.adyacentes(elem).size

            while (i < m && !visitado[b] ) {
                // Se obtiene uno de los nodos adyacentes
                var ady = grafo.adyacentes(elem)[i]

                if( !visitado[ady] ){ // Si no ha sido explorado el adyacente
                                      // se introduce a la secuencia
                                      // y se marca como visitado
                    secuencia.agregar(ady)
                    visitado[ady] = true
                    c++

                    // Luego si el elemento siguiente en la cola
                    // no a cambiado entonces se continua con el 
                    // siguiente adyacente del elemento.
                    // Si el elemento cambio entonces lo actualizamos
                    // Y restablecemos los valores de las variables del
                    // ciclo
                    if( elem == secuencia.siguiente() ){
                        i++
                    }
                    else {
                        i = 0
                        elem = secuencia.siguiente()!!
                        m = grafo.adyacentes(elem).size
                    }
                } 
                // Si el adyacente ya habia sido visitado 
                // se prosigue con el siguiente adyacente
                else {
                    i++
                }
            }
            secuencia.remover()
        }
        // Vaciamos la secuencia de la clase
        // para asegurar la integridad de ejecuciones posteriores
        // sobre una misma instancia.
        while( !secuencia.vacio() ) secuencia.remover()

        return if(visitado[b]) c else -1
    }
}