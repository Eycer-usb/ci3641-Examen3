KC=kotlinc
KFLAGS=-cp


all: lib.jar

lib.jar: Secuencia.class Cola.class Pila.class
	jar -cvf $@ lib/*.class


Secuencia.class: Secuencia.kt
	$(KC) Secuencia.kt

Cola.class: Cola.kt
	$(KC) $(KFLAGS) . Cola.kt

Pila.class: Pila.kt
	$(KC) $(KFLAGS) . Pila.kt


clean:
	rm lib.jar lib/*.class
