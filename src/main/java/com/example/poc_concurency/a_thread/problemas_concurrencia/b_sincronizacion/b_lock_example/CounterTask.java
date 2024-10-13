package com.example.poc_concurency.a_thread.problemas_concurrencia.b_sincronizacion.b_lock_example;

public class CounterTask implements Runnable {
    private final ReentrantLockCounter counter;

    // Constructor que recibe el contador compartido
    public CounterTask(ReentrantLockCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment(); // Incrementa el contador
            try {
                Thread.sleep(100); // Simula algún trabajo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
