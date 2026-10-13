package com.clasedb.parchis.mock;

public class JuegoMock {
    private static boolean partidaIniciada = false;

    public static boolean solicitarInicioPartida(String codigoSala, String idJugador) {
        System.out.println("[Mock Backend] Conectando con servidor de Gachis Trivial...");
        System.out.println("[Mock Backend] Verificando sala " + codigoSala + " para el usuario " + idJugador + "...");
        
        // Simula la validación de condiciones mínimas en el servicio
        partidaIniciada = true;
        return partidaIniciada;
    }
}