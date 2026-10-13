
package cu4.modelo;

import java.util.Objects;

public class Jugador {
    
    private final String nombre;

    public Jugador(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Jugador j && j.nombre.equals(nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
