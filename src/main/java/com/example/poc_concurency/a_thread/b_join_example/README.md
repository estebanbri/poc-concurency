# Metodo join ("el t-hijo le dice al t-padre esperame que me complete para continuar tu ejecucion")
Te permite definir el orden en el que se completen los threads. Orden determinado por relacion thread-padre y thread-hijo.
(Desventaja es una operacion bloquetante para el thread-padre (es decir bloqueante para el thread en el que se hace uso de join es decir en este ejemplo se bloqueara el thread main, pero tanto el thread packaging como el thread notification no se van a bloquear entre sí),
por ende es critico de donde vas a ubicar los join y segun donde ubiques los join vas a obtener resultados diferentes en cuanto a tiempo es decir
si en tu main hubieras puesto el 
```java
var t1 = new Thread(notificationTask);
t1.join();
var t2 = new Thread(packagingTask);
t.join();
```
Output:
```
main-thread start...
Thread-0 start notification task...
Thread-0 thread took 5000(ms) to complete notification task...
Thread-1 start packaging task...
Thread-1 thread took 2000(ms) to complete packaging task...
main-thread took 7034(ms) to completes
```
Simulacion de ejecucion (X: means in execution):
```
main-thread: XXXXXXX
Thread-0:    XXXXX
Thread-1:         XX
```
- TIEMPO_TOTAL_EJECUCION_MAIN = TIEMPO_Thread-0 + TIEMPO_Thread-1

y el otro ejemplo es el que mostras en tu ejemplo primero creas t1 y t2 y al final haces los join despues de la creacion de ambos entonces ambos
iniciar al mismo momento que le das a start()

Simulacion de ejecucion (X: means in execution):
```
main-thread: XXXXX
Thread-0:    XXXXX
Thread-1:    XX
```
- TIEMPO_TOTAL_EJECUCION_MAIN = TIEMPO_Thread-0

Output:
```
main-thread start...
Thread-1 start packaging task...
Thread-0 start notification task...
Thread-1 thread took 2000(ms) to complete packaging task...
Thread-0 thread took 5000(ms) to complete notification task...
main-thread took 5020(ms) to completes
```