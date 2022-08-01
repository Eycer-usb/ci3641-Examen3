/*
Clase Abstracta que define una Secuencia de elementos
de tipo generico.
*/
package lib
abstract class Secuencia <T> () {
    protected val struct: MutableList<T> = mutableListOf(); // esta es la estructura
                                                            // de almacenamiento de
                                                            // la secuencia
    fun agregar( element: T ): Boolean {
        return struct.add(element);
    }

    fun vacio(): Boolean {
        return struct.isEmpty()
    }

    override fun toString(): String {
        return struct.toString()
    }

    // Remover y Siguiente dependeran de las clases 
    // Hijas de Sucuencia
    abstract fun remover(): T? 
    abstract fun siguiente(): T?

}