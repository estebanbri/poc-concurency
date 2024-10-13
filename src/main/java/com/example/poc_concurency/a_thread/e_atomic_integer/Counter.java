package com.example.poc_concurency.a_thread.e_atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    // AtomicInteger to hold the count
    private final AtomicInteger count = new AtomicInteger(0);

    // Method to increment the count
    public void increment() {
        count.incrementAndGet(); // Atomically increments by 1
    }

    // Method to get the current count
    public int getCount() {
        return count.get(); // Returns the current value
    }
}
