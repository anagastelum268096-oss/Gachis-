package cu4.reglas;

import cu4.modelo.Jugador;
import cu4.modelo.Lobby;

public interface IReglasNegocio {
    
         boolean validarCodigoSala(String codigo);

         boolean validarUnion(Jugador jugador, Lobby lobby);
    
}
