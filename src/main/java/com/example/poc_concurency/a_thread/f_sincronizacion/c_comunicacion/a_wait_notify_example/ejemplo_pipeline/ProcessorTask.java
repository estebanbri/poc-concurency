package com.example.poc_concurency.a_thread.f_sincronizacion.c_comunicacion.a_wait_notify_example.ejemplo_pipeline;

public class ProcessorTask implements Runnable {
        private final Pipeline pipeline;

        public ProcessorTask(Pipeline pipeline) {
            this.pipeline = pipeline;
        }

        @Override
        public void run() {
            try {
                pipeline.procesar();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
}
