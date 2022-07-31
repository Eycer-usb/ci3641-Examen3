KC=kotlinc
KFLAGS= -cp
KPATH= /

all: MainKt.class
MainKt.class: ../lib/lib.jar main.kt
	$(KC) $(KFLAGS) ../lib/lib.jar main.kt
# all: Main.jar
# Main.jar: ../lib/lib.jar main.kt
# 	$(KC) $(KFLAGS) ../lib/lib.jar: main.kt -d Main.jar

../lib/lib.jar:
	cd ../lib && make

clean:
	rm MainKt.class