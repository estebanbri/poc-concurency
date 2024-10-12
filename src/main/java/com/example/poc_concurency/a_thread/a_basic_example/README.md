# Creacion de threads
Ejemplo que demuestra las dos maneras de crear threads,
   *  Opcion 1: extendiendo la clase Thread
   *  Opcion 2: definiendo la task por separado implementando Runnable y pasandosela al thread

Simulacion de ejecucion (X: means in execution):
```
main-thread: X
Thread-0:    XXXXX
Thread-1:    XX
```
Output:
```
main-thread start...
Thread-0 start notification task...
Thread-1 start packaging task...
main-thread took 3(ms) to completes (***)
Thread-1 took 2000(ms) to complete packaging task...
Thread-0 took 5000(ms) to complete notification task...
```
Nota:
- (***) ESTE LOG DEMUESTRA QUE LA EJECUCION DE LA LOGICA DE HILO PRINCIPAL MAIN NO FUE BLOQUEADO ES DECIR LLEGO HASTA EL ULTIMO LOG DEL MAIN ANTES DE QUE LOS DEMAS HILOS HIJOS TERMINARAN.