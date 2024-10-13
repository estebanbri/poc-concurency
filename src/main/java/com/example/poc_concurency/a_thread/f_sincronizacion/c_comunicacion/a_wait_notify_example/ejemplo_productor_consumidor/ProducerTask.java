package com.example.poc_concurency.a_thread.f_sincronizacion.c_comunicacion.a_wait_notify_example.ejemplo_productor_consumidor;

import java.util.List;
import java.util.Queue;

public class ProducerTask implements Runnable {

    private final Queue<String> queue; // Shared Resource
    private final int capacity;
    List<String> dataToProduce;

    public ProducerTask(Queue<String> queue, int capacity, List<String> dataToProduce) {
        this.queue = queue;
        this.capacity = capacity;
        this.dataToProduce = dataToProduce;
    }
    @Override
    public void run() {
        try {
            for (String data : dataToProduce) {
                this.producir(data);  // Agregamos cada nombre de archivo xml a procesar.
                Thread.sleep(100); // Simula el tiempo de producción
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void producir(String data) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();  // Espera hasta que haya espacio en la cola
        }
        queue.add(data);
        System.out.println("Producido: " + data);
        notify();  // Notifica al consumidor que puede consumir
    }
}
