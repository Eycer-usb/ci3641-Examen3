/*
DFS define el tipo de la secuencia como Pila. De esta secuencia
se vale la clase abstracta Busqueda para recorrer el grafo dado
*/
package lib
class DFS( val grafo: Grafo ): Busqueda(grafo) {
    override val secuencia: Pila<Int> = Pila()
}