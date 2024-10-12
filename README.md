## Resumen principal de soluciones con concurrencia.

### Soluciones:
- Thread
  - NO BLOQUEANTE 
- Framework Executor:
  - NO BLOQUEANTE: executor.execute(Runnable)
  - BLOQUEANTE: executor.submit(Calleable) + executor.awaitTermination() + get()
- CompletableFuture
  - NO BLOQUEANTE: CompletableFuture.runAsync(Runnable)
  - NO BLOQUEANTE: CompletableFuture.supplyAsync(Supplier) + theRun(() -> get())
  - NO BLOQUEANTE: 2 o + CompletableFuture.supplyAsync(Supplier) + allOf() + theRun(() -> get())
- @Async
  - NO BLOQUEANTE: return type void
  - NO BLOQUEANTE: return type CompletableFuture + theRun(() -> get())
  - NO BLOQUEANTE: 2 o + return type CompletableFuture +  allOf() + theRun(() -> get())

Como ves el unico caso bloqueante del hilo padre es lo que nos proveia ExecutorFramework para
el manejo de Calleables con su metodo bloqueante awaitTermination, lo no tan malo que te te permite definir
un timeout.

En caso de que no sea una aplicacion spring boot web que ya de por si para cada request maneja un pool de threads,
y tu aplicacion es una aplicacion Java que consta unicamente del hilo principal, para los casos mencionados arriba como 
100% no bloqueantes para el hilo padre, vas a tener que hacer un workaround de bloquear al main porque 
como por defecto los hilos en java se crean de tipo "user thread" es decir cada hilo va a tener una relacion
hilo padre e hilo hijo, cuando el hilo padre muere el/los hilos hijos tambien mueren. Por eso existen
la otra categoria de hilos "hilos daemon" que se ejecutan de manera independiente del hilo que lo creo.

// PENDIENTE
ASYNC AWAIT
LOS PROBLEMAS DE CONCCURRENCIA
THREADLOCAL
ATOMiC INTEGEGER?