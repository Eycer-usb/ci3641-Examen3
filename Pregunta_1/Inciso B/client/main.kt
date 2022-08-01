/*
Programa cliente con Pruebas para las
clases Cola, Pila, Secuencia, Grafo, DFS, BFS
*/
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

    // Probando grafos
    var g = Grafo( 5 )
    println(g)
    // Agregado de lados
    g.agregarLado( 0, 1 )
    g.agregarLado( 1, 2 )
    g.agregarLado( 2, 3 )
    g.agregarLado( 0, 4 )
    println(g)

    //Busqueda DFS y bfs
    var dfs = DFS(g)
    var bfs = BFS(g)
    println("DFS: ${dfs.buscar(0,4)}")
    println("BFS: ${bfs.buscar(0,4)}")
    println("DFS: ${dfs.buscar(2,4)}")
    println("BFS: ${bfs.buscar(2,4)}")


}