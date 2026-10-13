
package cu4.vista;

import java.util.List;
import java.util.Scanner;

public class Vista {
    
    private final Scanner entrada;
    private String codigoIngresado = "";

    public Vista(Scanner entrada) {
        this.entrada = entrada;
    }

    public String solicitarCodigo() {
        System.out.print("Ingresa el código de la sala (o SALIR): ");
        codigoIngresado = entrada.nextLine().trim().toUpperCase();
        return codigoIngresado;
    }

    public String getCodigoIngresado() {
        return codigoIngresado;
    }

    public void mostrarEspera() {
        System.out.println("Esperando que el anfitrión acepte tu solicitud...");
    }

    public void mostrarLobby(String codigo, List<String> jugadores, int maxJugadores) {
        System.out.println();
        System.out.println("Código de la sala: " + codigo);
        System.out.println("Jugadores en mesa (" + jugadores.size() + "/" + maxJugadores + "):");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + jugadores.get(i));
        }
        System.out.println("Esperando a que el anfitrión inicie la partida...");
    }

    public void mostrarError(String mensaje) {
        System.out.println();
        System.out.println("[ERROR] " + mensaje);
        System.out.println();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}
