## Resumen principal de soluciones con concurrencia.

Endpoints REST Asincronos usando RestController:

[localhost:8080/nonblocking-with-spring-async-void-example](localhost:8080/nonblocking-with-spring-async-void-example)
[localhost:8080/nonblocking-with-spring-async-with-return-value-example](localhost:8080/nonblocking-with-spring-async-with-return-value-example)

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

Tip: recorda que los threads que se crean con CompletaFuture en el ForkJoinPool son por defecto daemon threads.
(Implica que si la jvm se apaga las task mueren, esto singifica que si tu aplicacion solo consta de un unico 
thread-main y un CompletableFuture si no usas join() sobre el completablefuture no va a completarse la task
porque el thread-main va a completarse y va a apagarse la jvm sin que se ejecute tu task)

// PENDIENTE
ASYNC AWAIT
LOS PROBLEMAS DE CONCCURRENCIA
THREADLOCAL
ATOMiC INTEGEGER?