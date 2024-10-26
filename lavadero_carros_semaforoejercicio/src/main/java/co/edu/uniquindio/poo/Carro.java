package co.edu.uniquindio.poo;

public class Carro extends Thread{
    private final String nombre;
    private final Lavadero lavadero;

    public Carro(String nombre, Lavadero lavadero) {
        this.nombre = nombre;
        this.lavadero = lavadero;
    }

    @Override
    public void run() {
        lavadero.lavarAuto(nombre);
    }
}
