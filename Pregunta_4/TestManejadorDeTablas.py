"""
Se Realizan pruebas sobre ManejadorDeTablas
para verificar su correcto funcionamiento
"""

import unittest
from ManejadorDeTablas import *

class TestManejadorDeTablas( unittest.TestCase ):
    # Crear Clase Simple
    def test_crear_clase_simple(self):
        memoria = {}
        crear_clase_simple( [ "test", "m1", "m2" ], memoria )
        self.assertTrue( "test" in memoria )
        self.assertTrue( memoria["test"] == [ ["m1","test"], ["m2","test"] ] )
    
    # Crear Clase Heredera
    def test_crear_clase_herencia(self):
        memoria = {}
        crear_clase_simple( [ "test1", "m1", "m2" ], memoria )
        crear_clase_herencia( [ "test2", ":", "test1", "m1", "m3" ], memoria )
        self.assertTrue( "test2" in memoria )
        self.assertTrue( memoria["test2"] == [ ["m1","test2"], ["m2","test1"], ["m3","test2"] ] )

    # Se verifica que la funcion imprimir clase retorna el formato adecuado
    def test_imprimir_clase(self):
        memoria = {}
        crear_clase_simple( [ "test1", "m1", "m2" ], memoria )
        crear_clase_herencia( [ "test2", ":", "test1", "m1", "m3" ], memoria )
        self.assertTrue( imprimir_clase("test2", memoria) == 
        "m1 -> test2 :: m1\nm2 -> test1 :: m2\nm3 -> test2 :: m3\n" )


# Se ejecutan las pruebas unitarias
if '__main__' == __name__:
    unittest.main()