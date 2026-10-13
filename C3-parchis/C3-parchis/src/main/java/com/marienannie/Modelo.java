package com.marienannie;

public class Modelo {
    private int jugadoresListos;
    private MockPartidaEntidad subsistemaPartida;

    public Modelo() {
        this.jugadoresListos = 4;
        this.subsistemaPartida = new MockPartidaEntidad();
    }

    public void iniciaPartida() {
        System.out.println("   [MODELO] Validando la cantidad de jugadores listos (" + jugadoresListos + "/4)...");

        if (jugadoresListos >= 2) {
            System.out.println("   [MODELO] Validación correcta. Iniciando lógica interna de la partida...");
            subsistemaPartida.iniciarPartida();
        } else {
            System.out.println("   [MODELO] Error: Faltan jugadores para iniciar.");
        }
    }
}
