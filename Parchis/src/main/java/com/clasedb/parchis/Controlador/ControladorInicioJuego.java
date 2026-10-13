
package com.clasedb.parchis.controlador;

import com.clasedb.parchis.modelo.ModeloInicioJuego;
import com.clasedb.parchis.mock.JuegoMock;

public class ControladorInicioJuego {
    private ModeloInicioJuego modelo;

    public ControladorInicioJuego(ModeloInicioJuego modelo) {
        this.modelo = modelo;
    }

    public void actualizaEstado() {
        modelo.setEstadoJugador("LISTO");
        
        // Simulación de la pantalla de transición y proceso interno requerida en el storyboard
        System.out.println("\n=================================");
        System.out.println("     ESTADO ACTUALIZADO CON EXITO");
        System.out.println("=================================");
        System.out.println(" > Su estado ha cambiado a: " + modelo.getEstadoJugador() + ".");
        System.out.println(" > Verificando condiciones minimas en servicio...");
        
        boolean listoParaJugar = JuegoMock.solicitarInicioPartida(modelo.getCodigoSala(), modelo.getIdJugador());
        
        if (listoParaJugar) {
            System.out.println("Todos los jugadores estan listos.");
            System.out.println("El Anfitrion ha autorizado el incio del juego.\n");
            gestionarInicioPartida();
        } else {
            System.out.println("Aun faltan jugadores por confirmar.");
        }
    }

    public void gestionarInicioPartida() {
        System.out.println(" Cargando primera ronda... ¡Iniciando partida!");
        System.out.println("=================================");
    }
}