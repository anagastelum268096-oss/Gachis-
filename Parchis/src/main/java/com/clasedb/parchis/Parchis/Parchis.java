
package com.clasedb.parchis.Parchis;

import com.clasedb.parchis.modelo.ModeloInicioJuego;
import com.clasedb.parchis.controlador.ControladorInicioJuego;
import com.clasedb.parchis.vista.VistaInicioJuego;

public class Parchis {
    public static void main(String[] args) {
        // Inicialización de componentes siguiendo la arquitectura MVC
        ModeloInicioJuego modelo = new ModeloInicioJuego("01", "#GTRIVIAL-402");
        ControladorInicioJuego controlador = new ControladorInicioJuego(modelo);
        VistaInicioJuego vista = new VistaInicioJuego(controlador);
        
        // Arranca la interfaz del lobby
        vista.inicia();
    }
}