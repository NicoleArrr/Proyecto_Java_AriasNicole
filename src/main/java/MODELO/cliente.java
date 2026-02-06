
package MODELO;

public class cliente extends Persona{
    int id;

    public cliente(int id, String nombre, String identificacion, String correo, String telefono) {
        super(id, nombre, identificacion, correo, telefono);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
