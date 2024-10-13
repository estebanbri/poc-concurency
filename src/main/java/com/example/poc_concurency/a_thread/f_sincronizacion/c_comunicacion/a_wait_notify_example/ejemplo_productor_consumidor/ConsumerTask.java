package com.example.poc_concurency.a_thread.f_sincronizacion.c_comunicacion.a_wait_notify_example.ejemplo_productor_consumidor;

import java.util.Queue;

public class ConsumerTask implements Runnable {
    private final Queue<String> queue; // Shared Resource

    public ConsumerTask(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        this.consumir();
    }

    private synchronized void consumir() {
        while (queue.isEmpty()) {
            try {
                wait();  // Espera hasta que haya un elemento para consumir
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String fileName = queue.remove();
        System.out.println("Consumido y procesando archivo: " + fileName);
        this.processXml(fileName);
        notify();  // Notifica al productor que puede producir
    }

    private void processXml(String fileName) {
        // Aca cargarias el archivo xml de disco a memoria ram y lo procesarias
    }
}
