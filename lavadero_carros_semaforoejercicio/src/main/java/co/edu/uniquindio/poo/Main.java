package co.edu.uniquindio.poo;

public class Main {
    public static void main(String[] args) {
        Lavadero lavadero = new Lavadero(7); // Máximo 7 autos a la vez

        // Creamos 10 autos que intentarán lavar al mismo tiempo
        for (int i = 1; i <= 10; i++) {
            Carro carro = new Carro("Carro " + i, lavadero);
            carro.start();
        }
    }
}
