package lib
/*
Se representa Un grafo de enteros como lista de adyacencias
Es necesario especificar la cantidad de nodos que contiene
el grafo al instanciar la clase.

Ademas se cuenta con un conjunto de metodos para operar el

*/
class Grafo( val cantidadDeElementos: Int ) 
{
    protected var g: Array<MutableList<Int>> = Array( cantidadDeElementos, { mutableListOf() } );
    
    fun agregarLado( a: Int, b:Int ): Boolean
    {
        if( a < cantidadDeElementos && b < cantidadDeElementos &&
        a >= 0 && b >= 0 && !g[a].contains(b))
        {
            g[a].add(b);
            return true
        }
        else
        {
            return false
        }
    }

    fun removerLado( a: Int, b: Int ): Boolean
    {
        if( a < cantidadDeElementos && b < cantidadDeElementos
            && a >= 0 && b >= 0 && g[a].contains(b))
        {
            g[a].remove(b);
            return true
        }
        else
        {
            return false
        }
    }

    fun adyacentes( a: Int ) : MutableList<Int> {
        try {
            return g[a]
        }
        catch(e: Throwable) {
            throw Exception("Elemento no esta en el grafo\n")
        }
    }

    override fun toString(): String {
        var str: String = ""
        for (i in 0..(cantidadDeElementos-1)) {
            str += "$i -> " + g[i].toString() + "\n"
        }
        return str
    }
}