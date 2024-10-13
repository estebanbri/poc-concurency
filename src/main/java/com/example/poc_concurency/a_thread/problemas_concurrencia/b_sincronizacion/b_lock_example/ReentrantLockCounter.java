package com.example.poc_concurency.a_thread.problemas_concurrencia.b_sincronizacion.b_lock_example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {
    private int count = 0;
    private final Lock lock = new ReentrantLock(); // Creamos un ReentrantLock

    // Método para incrementar el contador
    public void increment() {
        lock.lock(); // Adquirimos el bloqueo
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " - Count is: " + count);
        } finally {
            lock.unlock(); // Liberamos el bloqueo
        }
    }
}
