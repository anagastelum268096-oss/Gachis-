
package mock;

import java.util.ArrayList;
import java.util.List;

public class JuegoMock {
    private static List<String> jugadoresRegistrados = new ArrayList<>();

    public boolean registrarJugador(String nombre, String avatar) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (jugadoresRegistrados.contains(nombre)) {
            return false; // Evita nombres duplicados
        }
        jugadoresRegistrados.add(nombre);
        System.out.println("[Mock Backend] Jugador '" + nombre + "' registrado con avatar " + avatar + ".");
        return true;
    }
}

