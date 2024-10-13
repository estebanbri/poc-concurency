package com.example.poc_concurency.a_thread.f_sincronizacion.c_comunicacion.b_conditions_example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Contenedor {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int CAPACIDAD = 5;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void producir(int valor) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == CAPACIDAD) {
                notFull.await();  // Espera hasta que haya espacio en la cola
            }
            queue.add(valor);
            System.out.println("Producido: " + valor);
            notEmpty.signal();  // Notifica al consumidor que puede consumir
        } finally {
            lock.unlock();
        }
    }

    public int consumir() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();  // Espera hasta que haya un elemento para consumir
            }
            int valor = queue.remove();
            System.out.println("Consumido: " + valor);
            notFull.signal();  // Notifica al productor que puede producir
            return valor;
        } finally {
            lock.unlock();
        }
    }
}

class Productor extends Thread {
    private final Contenedor contenedor;

    public Productor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                contenedor.producir(i);
                Thread.sleep(100); // Simula tiempo de producción
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumidor extends Thread {
    private final Contenedor contenedor;

    public Consumidor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                contenedor.consumir();
                Thread.sleep(150); // Simula tiempo de consumo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Runner {
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        Productor productor = new Productor(contenedor);
        Consumidor consumidor = new Consumidor(contenedor);

        productor.start();
        consumidor.start();
    }
}
