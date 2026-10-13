
package cu4.controller;

import cu4.modelo.Jugador;
import cu4.modelo.Lobby;
import cu4.modelo.ResultadoUnion;
import cu4.vista.Vista;
import java.util.List;

public class Controller {
        private final Vista vista;
    private final Lobby lobby;
    private final Jugador jugador;
    private boolean unido = false;

    public Controller(Vista vista, Lobby lobby, Jugador jugador) {
        this.vista = vista;
        this.lobby = lobby;
        this.jugador = jugador;
    }

    /** Pide el código a la Vista hasta que el jugador entre al lobby o escriba SALIR. */
    public void iniciar() {
        while (!unido) {
            String codigo = vista.solicitarCodigo();
            if (codigo.equals("SALIR")) {
                vista.mostrarMensaje("Saliste de la aplicación.");
                return;
            }
            enviarCodigo(codigo);
        }
    }

    /** Recibe el código de la Vista y lo manda al Lobby. */
    public void enviarCodigo(String codigo) {
        vista.mostrarEspera();
        ResultadoUnion resultado = lobby.solicitarUnirse(codigo, jugador);
        actualizarEstado(resultado);
    }

    /** Traduce el resultado del Lobby a lo que debe mostrar la Vista. */
    public void actualizarEstado(ResultadoUnion resultado) {
        switch (resultado) {
            case UNIDO -> {
                unido = true;
                List<String> nombres = lobby.getJugadores().stream().map(Jugador::getNombre).toList();
                vista.mostrarLobby(lobby.getCodigo(), nombres, Lobby.MAX_JUGADORES);
            }
            case CODIGO_INVALIDO -> vista.mostrarError("Código de sala inválido.");
            case RECHAZADO -> vista.mostrarError("El anfitrión rechazó tu solicitud.");
            case UNION_NO_PERMITIDA -> vista.mostrarError("No es posible unirse a esta sala.");
        }
    }
}
