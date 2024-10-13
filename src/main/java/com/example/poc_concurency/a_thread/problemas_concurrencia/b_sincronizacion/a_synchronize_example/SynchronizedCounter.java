package com.example.poc_concurency.a_thread.problemas_concurrencia.b_sincronizacion.a_synchronize_example;

public class SynchronizedCounter {
    private int count = 0;

    // Método sincronizado para incrementar el contador
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " - Count is: " + count);
    }
}