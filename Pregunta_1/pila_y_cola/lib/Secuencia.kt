package lib
abstract class Secuencia <T> () {
    protected val struct: MutableList<T> = mutableListOf();
    fun agregar( element: T ): Boolean {
        return struct.add(element);
    }

    abstract fun remover(): T? 

    fun vacio(): Boolean {
        return struct.isEmpty()
    }

    override fun toString(): String {
        return struct.toString()
    }

}