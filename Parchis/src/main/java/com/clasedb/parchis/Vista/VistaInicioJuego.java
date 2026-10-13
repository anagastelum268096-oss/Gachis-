package com.clasedb.parchis.vista;

import com.clasedb.parchis.controlador.ControladorInicioJuego;
import java.util.Scanner;

public class VistaInicioJuego {
    private ControladorInicioJuego controlador;
    private Scanner scanner;

    public VistaInicioJuego(ControladorInicioJuego controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void inicia() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n=================================");
            System.out.println("     GACHIS TRIVIAL - VESTIBULO (CU5)");
            System.out.println("=================================");
            System.out.println(" ID de sala: #GTRIVIAL-402");
            System.out.println(" Anfitrion: Jake (ID: 01)\n");
            System.out.println(" LISTA DE JUGADORES EN SALA:");
            System.out.println(" 1. Jake (Anfitrion) - [LISTO]");
            System.out.println(" 2. Totoro - [ESPERANDO]");
            System.out.println(" 3. Cat - [ESPERANDO]\n");
            System.out.println(" [1] Marcar \"Estoy listo\" / Cambiar Estado");
            System.out.println(" [0] Salir de la Sala");
            System.out.println("-----------------------------------");
            System.out.print(" Seleccione una opcion: ");
            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpieza del búfer de la consola
                
                switch (opcion) {
                    case 1:
                        jugadorListo();
                        opcion = 0; // Rompe el bucle al iniciar
                        break;
                    case 0:
                        System.out.println("\nSaliendo de la sala...");
                        break;
                    default:
                        System.out.println("\n[Error] Opción no válida. Intente de nuevo.");
                }
            } else {
                scanner.next(); // Limpiar entrada incorrecta
                System.out.println("\n[Error] Por favor, ingrese un número válido.");
            }
        }
    }

    public void jugadorListo() {
        controlador.actualizaEstado();
    }
}