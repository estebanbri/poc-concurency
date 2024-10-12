# Creacion de threads con ExecutorFramework
Ahora supone que tus tareas tienen que el resultado de todo su procesamiento entonces entran en juego los Calleable.
El metodo get() tiene exactamente la misma consecuencia que metodo join() de threads, va a blaoquear la ejecucion del thread
padre es decir en este caso el thread main.

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
http-nio-8080-exec-1-thread took 4(ms) to completes (***)
ForkJoinPool.commonPool-worker-2 took 2000(ms) to complete packaging task...
ForkJoinPool.commonPool-worker-1 took 5000(ms) to complete notification task...
RESULT_SUCCESS, RESULT_SUCCESS
```
Nota:
- (***) ESTE LOG DEMUESTRA QUE LA EJECUCION DE LA LOGICA DE HILO PRINCIPAL MAIN NO FUE BLOQUEADO ES DECIR LLEGO HASTA EL ULTIMO LOG DEL MAIN ANTES DE QUE LOS DEMAS HILOS HIJOS TERMINARAN.