package com.marienannie;

import java.util.Scanner;

public class Vista {
    private Controlador controlador;
    private Scanner scanner;

    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void jugadoresEnLobby() {
        System.out.println("\n========================================");
        System.out.println("          LOBBY DEL ANFITRIÓN           ");
        System.out.println("========================================");
        System.out.println("   [VISTA] Mostrando lista de jugadores en el lobby...");
        System.out.println("   - Jugador 1 (Anfitrión) [LISTO]");
        System.out.println("   - Jugador 2             [LISTO]");
        System.out.println("   - Jugador 3             [LISTO]");
        System.out.println("   - Jugador 4             [LISTO]");
        System.out.println("========================================");
    }

    public void iniciarPartida() { //[cite: 4]
        System.out.print("\nActor Anfitrión, presione '1' y Enter para Comenzar el Juego: ");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            System.out.println("\n   [VISTA] El anfitrión ha presionado 'Comenzar Juego'. Delegando al Controlador...");
            controlador.procesaInicio();
        } else {
            System.out.println("\n   [VISTA] Acción cancelada. Saliendo del lobby...");
        }
        scanner.close();
    }
}
