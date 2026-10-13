package cu4.reglas;

import cu4.modelo.EstadoLobby;
import cu4.modelo.Jugador;
import cu4.modelo.Lobby;
import java.util.regex.Pattern;

public class ReglasJuegoMock implements IReglasNegocio {
    
    private static final Pattern FORMATO_CODIGO = Pattern.compile("^MESA-\\d{3}$");

    @Override
    public boolean validarCodigoSala(String codigo) {
        return codigo != null && FORMATO_CODIGO.matcher(codigo).matches();
    }

    @Override
    public boolean validarUnion(Jugador jugador, Lobby lobby) {
        return lobby.getEstado() == EstadoLobby.ESPERANDO_JUGADORES
                && !lobby.getJugadores().contains(jugador)
                && lobby.getJugadores().size() < Lobby.MAX_JUGADORES;
    }
    
}
