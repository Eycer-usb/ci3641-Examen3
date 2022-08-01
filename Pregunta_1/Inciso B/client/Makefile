KC=kotlinc
KFLAGS= -cp
KPATH= /

all: MainKt.class
MainKt.class: ../lib/lib.jar main.kt
	$(KC) $(KFLAGS) ../lib/lib.jar main.kt

../lib/lib.jar:
	cd ../lib && make

clean:
	rm MainKt.class