/*
Se implementa una Cola de Tipo Generico
*/
package lib
class Cola <T> : Secuencia <T> () {
    
    override fun remover(): T? {
        return struct.removeFirst()
    }
    override fun siguiente(): T {
        return struct[0]
    }

}