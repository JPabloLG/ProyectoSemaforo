package co.edu.uniquindio.poo;

import java.util.concurrent.Semaphore;

public class Lavadero extends Thread{
    private String nombre;
    Semaphore trabajador = new Semaphore(5);

    public Lavadero(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            Carro carro = new Carro("Carro " + i, this);
            carro.start();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void lavarAuto(){
        try {
            trabajador.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void terminarLavado(){
        trabajador.release();
    }
}
