
package modelo;

public class ModeloRegistroJugador {
   private String nombre;
    private String avatar;

    public ModeloRegistroJugador() {
        this.nombre = "";
        this.avatar = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
} 

