package lib
class Cola <T> : Secuencia <T> () {
    
    override fun remover(): T? {
        return struct.removeFirst()
    }

}