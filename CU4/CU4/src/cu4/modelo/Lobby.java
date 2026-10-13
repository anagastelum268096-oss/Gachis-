package cu4.modelo;

import cu4.reglas.IReglasNegocio;
import java.util.ArrayList;
import java.util.List;

public class Lobby {
    
    public static final int MAX_JUGADORES = 4;

    private final String codigo;
    private final List<Jugador> jugadores = new ArrayList<>();
    private EstadoLobby estado = EstadoLobby.ESPERANDO_JUGADORES;
    private final Anfitrion anfitrion;
    private final IReglasNegocio reglas;

    public Lobby(String codigo, Jugador creador, Anfitrion anfitrion, IReglasNegocio reglas) {
        this.codigo = codigo;
        this.anfitrion = anfitrion;
        this.reglas = reglas;
        this.jugadores.add(creador);
    }

    /** valida el código, pide aprobación al anfitrión y agrega al jugador. */
    public synchronized ResultadoUnion solicitarUnirse(String codigoIngresado, Jugador jugador) {
        if (!reglas.validarCodigoSala(codigoIngresado) || !codigo.equals(codigoIngresado)) {
            return ResultadoUnion.CODIGO_INVALIDO;
        }
        if (!notificarAnfitrion(jugador)) {
            return ResultadoUnion.RECHAZADO;
        }
        if (!reglas.validarUnion(jugador, this)) {
            return ResultadoUnion.UNION_NO_PERMITIDA;
        }
        agregarJugador(jugador);
        return ResultadoUnion.UNIDO;
    }

    public boolean notificarAnfitrion(Jugador jugador) {
        return anfitrion.recibirSolicitud(jugador);
    }

    public synchronized void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
        if (jugadores.size() >= MAX_JUGADORES) {
            estado = EstadoLobby.LLENO;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public synchronized List<Jugador> getJugadores() {
        return List.copyOf(jugadores);
    }

    public synchronized EstadoLobby getEstado() {
        return estado;
    }
    
}
