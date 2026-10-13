package vista;

import controlador.ControladorConfiguracion;
import modelo.ModeloConfiguracion;
import java.util.Scanner;

    public class VistaConfiguracion {
    private ControladorConfiguracion controlador;
    private Scanner scanner;

    public VistaConfiguracion(ControladorConfiguracion controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    //Pantalla 1: Captura la cantidad de jugadores seleccionada por el Anfitrion
    public void ingresarCantidadJugadores() {

        System.out.println("===== CONFIGURAR PARTIDA =====");

        System.out.println("Seleccione cantidad de jugadores:");
        System.out.println(" [2] 2 Jugadores");
        System.out.println(" [3] 3 Jugadores");
        System.out.println(" [4] 4 Jugadores");
        System.out.print("\nIngrese una opcion (2-4): ");

        int cantidad = scanner.nextInt();

        //Mensaje de error, solo ingresar 2-4 jugadores
        while (cantidad < 2 || cantidad > 4) {
            System.out.print("Opcion invalida. Ingrese una cantidad entre 2 y 4: ");
            cantidad = scanner.nextInt();
        }
        
        scanner.nextLine();

        // Envio al controlador la cantidad de jugadores seleccionados y regresa el codigo de la sala
        String codigoGenerado = controlador.procesarConfiguracion(cantidad);
        notificarLobbyListo(codigoGenerado, cantidad);
    }

    //Notificacion del sistema
    public void notificarLobbyListo(String codigoSala, int cantidad) {
        System.out.println("\n[SISTEMA] Configuracion procesada con exito...");
        mostrarLobby(codigoSala, cantidad);
    }
        

    //Pantalla 2: Interfaz del Lobby de espera con la sala y slots asignados
    public void mostrarLobby(String codigoSala, int cantidad) {
        System.out.println("");

        System.out.println(" ===== LOBBY DE ESPERA ===== ");

        System.out.println("  CODIGO DE LA SALA: " + codigoSala);
        System.out.println("  Comparte este codigo para jugar con amigos");
        System.out.println("------------------------------------------");
        System.out.println("  JUGADORES EN MESA (1/" + cantidad + "):");
        System.out.println("    - Jugador 1 (Anfitrion) [CREADOR]");
        for (int i = 2; i <= cantidad; i++) {
            System.out.println("    - Esperando Jugador " + i + "...");
        }
        System.out.println("==========================================");
        System.out.println("  [Presione ENTER para INICIAR PARTIDA]   ");
        System.out.println("==========================================");
        
        scanner.nextLine();
        
        System.out.println("\n [SISTEMA] Partida Iniciada Correctamente...");
    }

    public static void main(String[] args) {
        ModeloConfiguracion modelo = new ModeloConfiguracion();
        ControladorConfiguracion controlador = new ControladorConfiguracion(modelo);
        VistaConfiguracion vista = new VistaConfiguracion(controlador);

        vista.ingresarCantidadJugadores();
    }
}