package modelo;

import mock.JuegoMock;

public class ModeloConfiguracion {
    private int cantidadJugadores;
    private String codigoSala;
    private JuegoMock juegoMock;

    public ModeloConfiguracion() {
        //Inicia la conexion con el simulador de juego
        this.juegoMock = new JuegoMock();
    }

    public void crearLobby(int cantidad) {
        //Guarda la cantidad de jugadores van a jugar
        this.cantidadJugadores = cantidad;
        // Peticion de generacion de codigo
        this.codigoSala = juegoMock.generarCodigoYJugadores(cantidad);
    }

    //Regresa cantidad de jugadores guardada
    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    //Regresa codigo de la sala que se genero
    public String getCodigoSala() {
        return codigoSala;
    }
}