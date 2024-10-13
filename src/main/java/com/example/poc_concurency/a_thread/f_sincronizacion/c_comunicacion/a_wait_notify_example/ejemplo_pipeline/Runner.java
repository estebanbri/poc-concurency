package com.example.poc_concurency.a_thread.f_sincronizacion.c_comunicacion.a_wait_notify_example.ejemplo_pipeline;

public class Runner {
    public static void main(String[] args) {
        Pipeline pipeline = new Pipeline();

        Runnable producerTask = new ProducerTask(pipeline);
        Runnable processorTask = new ProcessorTask(pipeline);
        Runnable validatorTask = new ValidatorTask(pipeline);

        Thread productor = new Thread(producerTask);
        Thread procesador = new Thread(processorTask);
        Thread validador = new Thread(validatorTask);

        productor.start();
        procesador.start();
        validador.start();
    }
}
