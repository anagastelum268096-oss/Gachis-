
package vista;

import controlador.ControladorRegistroJugador;
import modelo.ModeloRegistroJugador;
import java.util.Scanner;

public class VistaRegistroJugador {
    private ControladorRegistroJugador controlador;
    private Scanner scanner;

    public VistaRegistroJugador(ControladorRegistroJugador controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarRegistro() {
        System.out.println("========================================");
        System.out.println("     GACHIS TRIVIAL - REGISTRO");
        System.out.println("========================================");
        
        System.out.print("Escribe tu apodo o nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Selecciona tu avatar (Rojo, Azul, Verde, Amarillo): ");
        String avatar = scanner.nextLine();
        
        boolean resultado = controlador.procesarRegistro(nombre, avatar);
        
        if (resultado) {
            System.out.println("\n========================================");
            System.out.println("         ¡REGISTRO EXITOSO!");
            System.out.println("========================================");
            System.out.println("Bienvenido a la mesa, " + nombre + "!");
            System.out.println("Avatar asignado: " + avatar);
        } else {
            System.out.println("\n[Error] El nombre ya está en uso o es inválido. Intenta de nuevo.");
        }
    }

    // Método principal para pruebas independientes en consola
    public static void main(String[] args) {
        ModeloRegistroJugador modelo = new ModeloRegistroJugador();
        ControladorRegistroJugador controlador = new ControladorRegistroJugador(modelo);
        VistaRegistroJugador vista = new VistaRegistroJugador(controlador);
        
        vista.iniciarRegistro();
    }
}

