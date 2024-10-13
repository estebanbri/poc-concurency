package com.example.poc_concurency.a_thread.e_atomic_integer;

class CounterTask implements Runnable {
    private final Counter counter;

    public CounterTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment(); // Increment the counter
            System.out.println(Thread.currentThread().getName() + " - Count is: " + counter.getCount());
        }
    }
}
