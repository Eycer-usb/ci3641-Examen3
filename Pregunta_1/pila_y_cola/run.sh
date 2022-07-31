#!/bin/bash
cat msg.txt
echo
echo "Presione Enter"
read 
cd lib/
make clean
cd ../client
make clean
make
kotlin -cp ../lib/lib.jar:. MainKt

echo "Finalizado"
