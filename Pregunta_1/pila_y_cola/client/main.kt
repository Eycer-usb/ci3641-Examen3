import lib.*
fun main() {
    /* Probando la Cola */
    println("Probando Cola")
    var cola: Cola<Int> = Cola()
    cola.agregar(0)
    cola.agregar(10)
    cola.agregar(20)
    println(cola)
    while( !cola.vacio() ){
        
        println(cola.remover())
    }

    // Probando la Pila
    println("Probando la Pila")
    var pila: Pila <Int> = Pila()
    pila.agregar(0)
    pila.agregar(10)
    pila.agregar(20)
    println(pila)
    while( !pila.vacio() ){
        println(pila.remover())
    }

}