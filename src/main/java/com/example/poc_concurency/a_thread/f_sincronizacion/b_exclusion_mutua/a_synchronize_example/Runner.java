package com.example.poc_concurency.a_thread.f_sincronizacion.b_exclusion_mutua.a_synchronize_example;

public class Runner {
    public static void main(String[] args) {
        // Creamos una instancia compartida de SynchronizedCounter
        SynchronizedCounter counter = new SynchronizedCounter();

        // Creamos las instancias de los Runnables que usarán el contador
        Runnable task1 = new CounterTask(counter);
        Runnable task2 = new CounterTask(counter);

        // Creamos los hilos con los Runnables
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Iniciamos los hilos
        thread1.start();
        thread2.start();
    }
}