# Creacion de threads con ExecutorFramework
Equivale al mismo ejemplo en a_basic_example pero utilizando CompletableFuture.

Simulacion de ejecucion (X: means in execution):
```
http-nio-8080-exec-1-thread:         X
ForkJoinPool.commonPool-worker-1:    XXXXX
ForkJoinPool.commonPool-worker-2:    XX
```
Output:
```
http-nio-8080-exec-1-thread start...
ForkJoinPool.commonPool-worker-1 start notification task...
ForkJoinPool.commonPool-worker-2 start packaging task...
http-nio-8080-exec-1-thread took 3(ms) to completes (***)
ForkJoinPool.commonPool-worker-2 took 2000(ms) to complete packaging task...
ForkJoinPool.commonPool-worker-1 took 5000(ms) to complete notification task...
```
Nota:
- (***) ESTE LOG DEMUESTRA QUE LA EJECUCION DE LA LOGICA DE HILO PRINCIPAL MAIN NO FUE BLOQUEADO ES DECIR LLEGO HASTA EL ULTIMO LOG DEL MAIN ANTES DE QUE LOS DEMAS HILOS HIJOS TERMINARAN.