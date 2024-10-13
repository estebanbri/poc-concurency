package com.example.poc_concurency.a_thread.f_sincronizacion.c_comunicacion.a_wait_notify_example.ejemplo_pipeline;

public class ProducerTask extends Thread {
    private final Pipeline pipeline;

    public ProducerTask(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public void run() {
        try {
            pipeline.producir();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
