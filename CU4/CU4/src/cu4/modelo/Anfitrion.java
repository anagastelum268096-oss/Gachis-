package cu4.modelo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

public class Anfitrion {
    
     private final String idAnfitrion;
    private final List<Jugador> solicitudesPendientes = new CopyOnWriteArrayList<>();
    // Quién decide si se acepta o no (la interfaz del anfitrión.
    private final Predicate<Jugador> criterioDecision;

    public Anfitrion(String idAnfitrion, Predicate<Jugador> criterioDecision) {
        this.idAnfitrion = idAnfitrion;
        this.criterioDecision = criterioDecision;
    }

    /** Registra la solicitud, obtiene la decisión del anfitrión y la manda. */
    public boolean recibirSolicitud(Jugador jugador) {
        solicitudesPendientes.add(jugador);
        boolean acepta = criterioDecision.test(jugador);
        if (acepta) {
            aceptarSolicitud(jugador);
        } else {
            rechazarSolicitud(jugador);
        }
        return acepta;
    }

    public void aceptarSolicitud(Jugador jugador) {
        solicitudesPendientes.remove(jugador);
    }

    public void rechazarSolicitud(Jugador jugador) {
        solicitudesPendientes.remove(jugador);
    }

    public String getIdAnfitrion() {
        return idAnfitrion;
    }

    public List<Jugador> getSolicitudesPendientes() {
        return List.copyOf(solicitudesPendientes);
    }
    
}
