# Inter-thread Communication (wait y notify)
Permite que los threads coordinen y se "comuniquen" entre ellos avisasando cuando puede arrancar otro thread o cuando se debe dormir.
Para el caso en el que se usa wait/notify para el acceso a un recurso compartido especialmente la operacion wait() 
es importante para poder **liberar locks** que tienen los threads sobre los recursos compartido, sin wait()
el thread que tiene un recurso compartido tomado es decir tiene capturado su lock los demas threads no podrian realizar
tareas es decir acceder a dicho recurso compartido. Recorda que los threads son hdp ellos nunca van a liberar un
lock por que si, son egoistas por ende tener que usar wait() para quitarselos.

Utiles para casos como:
- Coordinar en el procesamiento de un recurso compartido y liberar lock sobre recurso compartido (Caso producto-consumidor)
- Coordinar orden de ejecucion de tareas (Pipeline)