package com.example.poc_concurency.a_thread.problemas_concurrencia.b_sincronizacion.a_synchronize_example;

import com.example.poc_concurency.thread_util.ThreadUtil;

public class CounterTask implements Runnable {
    private final SynchronizedCounter counter;

    // Constructor que recibe el contador compartido
    public CounterTask(SynchronizedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment(); // Incrementa el contador
            ThreadUtil.sleep(100); // Simula algún trabajo: Este sleep sirve unicamente para que se vea claro como el planificador de thread va a ir switcheando entre ambos thread sino es tan rapido el pocesamiento porque es un for de 5 vueltas que las haria todas el mismo thread 0 y despues el thread 1 y no se intercalaria la ejecucion
        }
    }
}
