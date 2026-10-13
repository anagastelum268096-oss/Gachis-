package controlador;

import modelo.ModeloConfiguracion;

public class ControladorConfiguracion {
    private ModeloConfiguracion modelo;

    public ControladorConfiguracion(ModeloConfiguracion modelo) {
        //referencia al modelo para la comunicacion con el
        this.modelo = modelo;
    }

    public String procesarConfiguracion(int cantidad) {
        //Prepara la sala con cantidad de jugadores elegidos
        modelo.crearLobby(cantidad);
        //Obtiene codigo de sala que creo el JuegoMock y lo regresa a la vista
        return modelo.getCodigoSala();
    }
}