package com.clasedb.parchis.modelo;

public class ModeloInicioJuego {
    private String idJugador;
    private String codigoSala;
    private String estadoJugador;

    public ModeloInicioJuego(String idJugador, String codigoSala) {
        this.idJugador = idJugador;
        this.codigoSala = codigoSala;
        this.estadoJugador = "ESPERANDO";
    }

    public String getEstadoJugador() {
        return estadoJugador;
    }

    public void setEstadoJugador(String estadoJugador) {
        this.estadoJugador = estadoJugador;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public String getCodigoSala() {
        return codigoSala;
    }
}