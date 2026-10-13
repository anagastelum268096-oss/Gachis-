package com.marienannie;

public class Principal {
    public static void Inicia() {
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(modelo);
        Vista vista = new Vista();

        vista.setControlador(controlador);
        vista.jugadoresEnLobby();
        vista.iniciarPartida();
    }

    public static void main(String[] args) {
        Inicia();
    }
}
