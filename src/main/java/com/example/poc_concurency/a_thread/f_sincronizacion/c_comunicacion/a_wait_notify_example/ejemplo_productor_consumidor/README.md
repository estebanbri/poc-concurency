Este ejemplo de productor consumidor simula el procesamiento de archivos xml que imaginate que son muy grandes
y llevan mucho uso de cpu procesar cada uno, y ademas supone que no tenes un unico archivo xml a procesar
que tenes una lista de 100000 archivos xml. Procesar todos los archivos xml de una colapsaria la ram y el uso de 
cpu. Entonces con el modelo productor-consumidor, el productor va a ir poniendo en la cola solo los nombres
de los archivos xml y puede poner hasta 5 y el consumidor va a ir procesando de uno. Esto hace que no tengas
que cargar el millon de archivos en memoria.
Es decir sin uso del modelo productor consumidor y limitando a N la cola, vos si no usarias este modelo no tenes
manera de decir "procesame en bloques de N archivos" entonces esto es lo que te permite definir este modelo te da respuesta
cuando tenes que hacer procesamiento en batch.