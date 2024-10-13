# ThreadLocal (scope local a nivel de thread)
Lo bueno que es ThreadLocal te permite guardar informacion unicamente visible dentro del thread actual que lo ejecuta,
haciendo dicho dato guardado dentro del threadlocal innaccesible para los demas threads, pero lo bueno es que 
dentro de la ejecucion de un request un mismo thread puede involucrar pasar por varias clases y con thread local
podes ir capturando la data sin necesidad de pasar la data como parametro, con lo cual agregarlo como parametro no
se corresponde con lo que hace el metodo. Esto te paso en supervielle cuando necesitabamos pasar por todas las clases
por las que pasaba cada request la data de session del usuario y el chavon hizo la negrada de modificar todos los
metodos del controller, services, repositories agregando un nuevo parametro para ir pasandole la data de session, Con
thread local no hubiera sido necesario agregar este parametro modificando la signaturas de esos metodos.

Mecanismos para ocultar data dentro de un thread:
1 - Campos privates: obviamente un campo private es innaccesible para los demas thread.
2 - ThreadLocal: no puede ser leeido ni modificado por los demas threads.

output:
```
Processing in UserService user ID: 222-User2
Processing in UserService user ID: 111-User1
Processing in UserRepository user ID: 111-User1
Processing in UserRepository user ID: 222-User2
```