/*
BFS define el tipo de la secuencia como Cola. De esta secuencia
se vale la clase abstracta Busqueda para recorrer el grafo dado
*/

package lib
class BFS( val grafo: Grafo ): Busqueda(grafo) {
    override val secuencia: Cola<Int> = Cola()
}