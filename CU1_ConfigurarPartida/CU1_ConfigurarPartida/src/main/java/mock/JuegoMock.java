package mock;

public class JuegoMock {

    // Inventa codigo de sala para simular que la partida se creo
    public String generarCodigoYJugadores(int cantidad) {
        // Genera numero al azar de 3 digitos entre 100 y 999
        int numeroAleatorio = (int) (Math.random() * 900) + 100;
        //Regresa codigo con formato MESA-###
        return "MESA-" + numeroAleatorio;
    }
}