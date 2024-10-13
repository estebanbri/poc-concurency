package com.example.poc_concurency.a_thread.problemas_concurrencia.a_visibilidad.volatile_example;


import com.example.poc_concurency.thread_util.ThreadUtil;

public class ReaderTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Reader Thread: Empezando a leer...");
        // El hilo se ejecutará mientras 'flag' sea true
        int count = 1;
        while (MyRunner.running) {
            // Puedes agregar alguna lógica si es necesario
            System.out.println(Thread.currentThread().getName() + " - Reader Thread is running (" + count++ + " veces)...");
            // Agrega una pequeña pausa en el ciclo para evitar que el hilo se ejecute demasiadas veces en una iteración, lo que puede dar la impresión de que el ciclo tarda en terminar.
            ThreadUtil.sleep(10); // Agrega un pequeño retraso para obtener un resultado esperado de coordinacion entre writer y reader thread.
        }
        System.out.println(Thread.currentThread().getName() + " - Reader Thread will shutdown...");
    }

}