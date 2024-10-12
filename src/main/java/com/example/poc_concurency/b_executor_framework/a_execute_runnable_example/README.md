# Creacion de threads con ExecutorFramework
Equivale al mismo ejemplo en a_basic_example pero utilizando framework executor obtenes la misma salida.

Simulacion de ejecucion (X: means in execution):
```
main-thread:        X
pool-1-thread-1:    XXXXX
pool-1-thread-2:    XX
```
Output:
```
main thread start...
pool-1-thread-2 start packaging task...
pool-1-thread-1 start notification task...
main thread took 6(ms) to completes (***)
pool-1-thread-2 took 2000(ms) to complete packaging task...
pool-1-thread-1 took 5000(ms) to complete notification task...
```
Nota:
- (***) ESTE LOG DEMUESTRA QUE LA EJECUCION DE LA LOGICA DE HILO PRINCIPAL MAIN NO FUE BLOQUEADO ES DECIR LLEGO HASTA EL ULTIMO LOG DEL MAIN ANTES DE QUE LOS DEMAS HILOS HIJOS TERMINARAN.