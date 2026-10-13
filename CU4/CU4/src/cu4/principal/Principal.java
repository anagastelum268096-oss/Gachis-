package cu4.principal;

import cu4.controller.Controller;
import cu4.modelo.Anfitrion;
import cu4.modelo.Jugador;
import cu4.modelo.Lobby;
import cu4.reglas.IReglasNegocio;
import cu4.reglas.ReglasJuegoMock;
import cu4.vista.Vista;
import java.util.Scanner;

public class Principal {
    
 private final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        new Principal().inicia();
    }

    public void inicia() {
        IReglasNegocio reglas = new ReglasJuegoMock();

        
        Anfitrion anfitrion = new Anfitrion("ANF-01", this::preguntarAlAnfitrion);
        Lobby lobby = new Lobby("MESA-402", new Jugador("Totoro_05"), anfitrion, reglas);

        Vista vista = new Vista(entrada);
        Controller controller = new Controller(vista, lobby, new Jugador("Pingui67"));

        System.out.println("=== Gachis Trivial: Unirse a una sala ===");
        controller.iniciar();
    }

    private boolean preguntarAlAnfitrion(Jugador solicitante) {
        System.out.println();
        System.out.println("[ANFITRIÓN] " + solicitante.getNombre() + " quiere unirse a tu sala.");
        System.out.print("[ANFITRIÓN] ¿Aceptar? (s/n): ");
        return entrada.nextLine().trim().equalsIgnoreCase("s");
    }
}
