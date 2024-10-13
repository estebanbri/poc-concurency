package com.example.poc_concurency.a_thread.f_sincronizacion.c_comunicacion.a_wait_notify_example.ejemplo_pipeline;
public class Pipeline {

    // Ojo si defines en clases separadas a producir(), procesar(), validar() vas a tener el problema de visiblidad si no defines a los flags como volatile
    private boolean datosGenerados = false;
    private boolean datosProcesados = false;

    public synchronized void producir() throws InterruptedException {
        System.out.println("Produciendo datos...");
        datosGenerados = true;
        notifyAll();  // Despierta a los hilos esperando por datos generados
    }

    public synchronized void procesar() throws InterruptedException {
        while (!datosGenerados) {
            wait();  // Espera hasta que se generen los datos
        }
        System.out.println("Procesando datos...");
        datosProcesados = true;
        notifyAll();  // Despierta a los hilos esperando por datos procesados
    }

    public synchronized void validar() throws InterruptedException {
        while (!datosProcesados) {
            wait();  // Espera hasta que los datos sean procesados
        }
        System.out.println("Validando datos...");
    }
}
