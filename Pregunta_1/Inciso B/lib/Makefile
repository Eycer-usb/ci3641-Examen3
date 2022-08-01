KC=kotlinc
KFLAGS=-cp


all: lib.jar

lib.jar: lib/Secuencia.class lib/Cola.class lib/Pila.class\
		lib/Grafo.class lib/Busqueda.class lib/DFS.class lib/BFS.class
	jar -cvf $@ lib/*.class


lib/Secuencia.class: Secuencia.kt
	$(KC) Secuencia.kt

lib/Cola.class: Cola.kt
	$(KC) $(KFLAGS) . Cola.kt

lib/Pila.class: Pila.kt
	$(KC) $(KFLAGS) . Pila.kt

lib/Grafo.class: Grafo.kt
	$(KC) $(KFLAGS) . Grafo.kt

lib/Busqueda.class: Busqueda.kt
	$(KC) $(KFLAGS) . Busqueda.kt

lib/DFS.class: DFS.kt
	$(KC) $(KFLAGS) . DFS.kt

lib/BFS.class: BFS.kt
	$(KC) $(KFLAGS) . BFS.kt


clean:
	rm lib.jar lib/*.class
