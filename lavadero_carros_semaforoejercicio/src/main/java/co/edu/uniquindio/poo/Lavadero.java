package co.edu.uniquindio.poo;

import java.util.concurrent.Semaphore;

public class Lavadero {
    private final Semaphore semaforo;

    public Lavadero(int espacios) {
        // Inicializamos el semáforo con la cantidad máxima de espacios disponibles
        this.semaforo = new Semaphore(espacios);
    }

    public void lavarAuto(String auto) {
        try {
            System.out.println(auto + " está esperando para entrar al lavadero.");
            // Adquirimos un permiso para entrar al lavadero
            semaforo.acquire();
            synchronized (this) {
                System.out.println(auto + " está siendo lavado.");
                // Simulamos el tiempo que toma lavar el auto
                Thread.sleep(2000);
                System.out.println(auto + " ha terminado de ser lavado.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Liberamos el permiso para que otro auto pueda entrar
            semaforo.release();
        }
    }
}
