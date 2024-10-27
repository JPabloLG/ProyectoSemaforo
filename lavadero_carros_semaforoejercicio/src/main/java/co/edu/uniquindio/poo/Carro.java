package co.edu.uniquindio.poo;

public class Carro extends Thread{
    private final String nombre;
    Lavadero lavadero;

    public Carro(String nombre, Lavadero lavadero) {
        this.nombre = nombre;
        this.lavadero = lavadero;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        lavadero.lavarAuto();
        System.out.println("El " + getNombre() + " ingresó al lavadero");
        
        try {
            Thread.sleep(3000);

            lavadero.terminarLavado();
            System.out.println("El " + getNombre() + " terminó su lavado");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
