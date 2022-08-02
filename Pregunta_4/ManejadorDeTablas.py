"""
Se construye un manejador de Tablas de Metodos
Virtuales para un sistema orientado a objetos
con herencia simple y despacho dinamico de metodos

Al ejecutarse, se solicitan ordenes al usuario
para definir sus clases junto con sus respectivos
metodos o para Describir las clases ya introducidas
"""

import sys

"""
La memoria consiste en un diccionario donde las
claves corresponden al nombre de los metodos y
los valores corresponden a una lista de pares.

En la primera coordenada se guarda el nombre del
metodo, y en la segunda el nombre
de la clase que la define.

Un ejemplo, la clase perro que hereda de
Mamifero con algunos metodos:

Perro  -> [ [Ladrar, Perro], [Amamantar, Mamifero] ]

"""
memoria = {}

"""
Dada la accion a realizar, la ejecuta
segun los argumentos introducidos por el usuario
"""
def ejecutar(accion, argumentos):
    if(accion == "CLASS"):
        clase(argumentos)
    elif(accion == "DESCRIBIR"):
        describir(argumentos)
    elif(accion == "SALIR"):
        sys.exit()
    else:
        print("Error en el Formato de Entrada")


"""
La funcion clase maneja las solicitudes de deficion
de clases por parte del usuario. 
"""
def clase(argumentos):
    # Extraemos las secciones de los argumentos
    secciones = argumentos.split(' ')

    # Tanto si es una clase que hereda de otra
    # o es una clase simple se 
    # ejecuta el metodo correspondiente
    if secciones[1] == ':':
        crear_clase_herencia(secciones, memoria)
    else:
        crear_clase_simple(secciones, memoria)


"""
Se Crea una clase simple (sin herencia)
dadas las secciones del argumento
recibido del usuario
"""
def crear_clase_simple(secciones, memoria):
    nombre = secciones[0]
    if nombre in memoria:
        print("Ya existe una clase con ese nombre")
    else:
        memoria[nombre] = [ [ i, nombre ] for i in secciones[1:] ]


"""
Se crea una clase que hereda de otra clase, dadas las secciones
del argumento del usuario
"""
def crear_clase_herencia(secciones, memoria):
    # Extraemos el nombre de la nueva clase
    # como de la clase padre
    nombre = secciones[0]
    clase_padre = secciones[2]

    # Verificamos que el nombre no este aun definido
    # y que la clase padre este bien definida
    if nombre in memoria:
        print("Ya existe una clase con ese nombre")
    elif not clase_padre in memoria:
        print("La clase Padre no existe")

    # Si estas precondiciones se cumplen se procede 
    # a definir la nueva clase
    else:
        # Se sobreescriben los metodos que se heredan
        # en caso de existir coincidencia entre el 
        # nombre de algun metodo
        metodos = memoria[clase_padre].copy()
        for metodo in metodos:
            if metodo[0] in secciones[3:]:
                metodo[1] = nombre
            
        # Se agregan los Metodos nuevos (Habran repetidos)
        for i in secciones[3:]:
            metodos.append([i, nombre])

        # Eliminamos repetidos y almacenamos en memoria
        aux = []
        for i in metodos:
            if not i in aux:
                aux.append(i)
        memoria[nombre] = aux
                
"""
La Funcion describir maneja la solicitud
de descripcion de una clase por parte del usuario
Para esto es necesarion que en el argumento este
el nombre de la clase a describir
"""
def describir(argumentos):
    seccion = argumentos.split(' ')
    nombre = seccion[0]
    if not nombre in memoria:
        print("No existe una clase con ese nombre")
    else:
        print(imprimir_clase(nombre, memoria), end="")


"""
Dado el nombre de una clase se retorna un string
segun el formato propuesto en el enunciado
"""
def imprimir_clase(nombre, memoria) -> str:
    lista = memoria[nombre]
    ans = ""
    for metodo in lista:
        ans += metodo[0] + ' -> ' + metodo[1] + ' :: ' +  metodo[0] + "\n"
    return ans

"""
Ejecuta un bucle recibiendo solicitudes
del usuario
"""
def main():
    entrada = input(">> ")
    entrada = entrada.split(" ")
    try:
        accion = entrada[0]
        argumentos = ""
        if accion != "SALIR":
            argumentos = " ".join(entrada[1:])
        ejecutar(accion, argumentos)
    except IndexError:
        print("Error en el formato de entrada")
    main()


"""
Si se llama desde este archivo
se ejecuta la funcion main()
"""
if __name__ == "__main__":
    main()