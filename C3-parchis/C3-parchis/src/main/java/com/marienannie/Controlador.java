package com.marienannie;

public class Controlador {
    private Modelo modelo;

    public Controlador(Modelo modelo) {
        this.modelo = modelo;
    }

    public void procesaInicio() {
        System.out.println("\n   [CONTROLADOR] Orden de iniciar recibida. Verificando estado con el Modelo...");
        modelo.iniciaPartida();
    }
}
