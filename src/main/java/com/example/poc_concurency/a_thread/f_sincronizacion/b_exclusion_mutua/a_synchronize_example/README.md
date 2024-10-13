# synchronize keyword (Synchronizacion de entre threads de porcion de codigo no atomica)
El uso de volatile lo que hace al SO es avisarle actualiza inmediatamente en la shared cache que usan
todos los threads de la memoria RAM ya!. Sin el uso de volatile no quiere decir que siguiendo 
el ejemplo nunca va a salir del while, en realidad el no usar volatile es dejar que el SO
cuando se le cante, es decir cuando a el le sea convienente, actualizar lo que tengan los 
cache de la cpu al shared cache en ram.
Nota: si bien el for dice hasta 5, pero cada thread va hacer ese for 5 veces y tenes dos threads en tu metodo main
y como el counter es compartido entonces el resultado final va a llegar hasta 10 en el ejemplo.

Output (SIN USAR synchronize):
```
Thread-1 - Count is: 2
Thread-0 - Count is: 1
Thread-0 - Count is: 3
Thread-1 - Count is: 3
Thread-0 - Count is: 5
Thread-1 - Count is: 5
Thread-1 - Count is: 6
Thread-0 - Count is: 6
Thread-1 - Count is: 7
Thread-0 - Count is: 7
```

Output (USANDO synchronize ambos thread 'ven' el mismo valor almaceando en count antes de incrementarla)
```
Thread-0 - Count is: 1
Thread-1 - Count is: 2
Thread-1 - Count is: 3
Thread-0 - Count is: 4
Thread-1 - Count is: 5
Thread-0 - Count is: 6
Thread-0 - Count is: 7
Thread-1 - Count is: 8
Thread-0 - Count is: 9
Thread-1 - Count is: 10
```