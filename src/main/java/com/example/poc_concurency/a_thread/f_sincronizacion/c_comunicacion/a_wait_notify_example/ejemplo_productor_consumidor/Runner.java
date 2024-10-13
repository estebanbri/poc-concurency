package com.example.poc_concurency.a_thread.f_sincronizacion.c_comunicacion.a_wait_notify_example.ejemplo_productor_consumidor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Runner {
    public static void main(String[] args) {
        final int QUEUE_CAPACITY = 5;
        // Crear el contenedor compartido
        Queue queue = new LinkedList();
        List<String> xmlFileNames = // Imagina que tenes que procesar 1 millon de archivos xml's
                List.of("persona-data-1.xml", "persona-data-2.xml", "persona-data-3.xml", "persona-data-4.xml", "persona-data-5.xml"); // dataToProduce

        // Crear y empezar los hilos de productor y consumidor
        Thread productorThread = new Thread(new ProducerTask(queue, QUEUE_CAPACITY, xmlFileNames));
        Thread consumidorThread = new Thread(new ConsumerTask(queue));

        productorThread.start();
        consumidorThread.start();

        // Esperar a que los hilos terminen (opcional)
        try {
            productorThread.join();
            consumidorThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restablecer el estado de interrupción
            e.printStackTrace();
        }
    }
}
