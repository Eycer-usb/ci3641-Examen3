/*
Se implementa una Pila de Tipo Generico
*/
package lib
class Pila <T> : Secuencia <T> () {
    
    override fun remover(): T? {
        return struct.removeLast()
    }
    
    override fun siguiente(): T {
    return struct.last()
    }
}