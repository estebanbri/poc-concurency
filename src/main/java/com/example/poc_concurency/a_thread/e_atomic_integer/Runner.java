package com.example.poc_concurency.a_thread.e_atomic_integer;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create multiple threads that increment the counter
        Thread thread1 = new Thread(new CounterTask(counter));
        Thread thread2 = new Thread(new CounterTask(counter));

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
    }
}