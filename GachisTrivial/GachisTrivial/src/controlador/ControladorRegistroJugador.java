
package controlador;

import modelo.ModeloRegistroJugador;
import mock.JuegoMock;

public class ControladorRegistroJugador {
    private ModeloRegistroJugador modelo;
    private JuegoMock juegoMock;

    public ControladorRegistroJugador(ModeloRegistroJugador modelo) {
        this.modelo = modelo;
        this.juegoMock = new JuegoMock();
    }

    public boolean procesarRegistro(String nombre, String avatar) {
        modelo.setNombre(nombre);
        modelo.setAvatar(avatar);
        
        // Invoca al mock backend para validar y registrar
        boolean exito = juegoMock.registrarJugador(nombre, avatar);
        return exito;
    }
}

