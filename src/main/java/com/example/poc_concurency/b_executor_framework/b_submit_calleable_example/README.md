# Creacion de threads con ExecutorFramework
Ahora supone que tus tareas tienen que el resultado de todo su procesamiento entonces entran en juego los Calleable.
El metodo get() tiene exactamente la misma consecuencia que metodo join() de threads, va a blaoquear la ejecucion del thread
padre es decir en este caso el thread main.

Simulacion de ejecucion (X: means in execution):
```
main-thread:        XXXXX
pool-1-thread-1:    XXXXX
pool-1-thread-2:    XX
```
Output:
```
main-thread start...
pool-1-thread-2 start packaging task...
pool-1-thread-1 start notification task...
pool-1-thread-2 took 2000(ms) to complete packaging task...
pool-1-thread-1 took 5000(ms) to complete notification task...
RESULT_SUCCESS, RESULT_SUCCESS
main-thread took 5007(ms) to completes
```
Nota: el awaitTermination es bloqueante para thread main pero se especifica tiempo de timeout, la solucion completamente asincrona fue mas adelante dada por CompletableFuture