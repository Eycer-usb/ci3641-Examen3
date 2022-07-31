package lib
class Pila <T> : Secuencia <T> () {
    
    override fun remover(): T? {
        return struct.removeLast()
    }

}