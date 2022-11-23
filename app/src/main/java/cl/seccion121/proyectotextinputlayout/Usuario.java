package cl.seccion121.proyectotextinputlayout;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String correo;
    private String nombre;
    private String clave;

    public Usuario(){}

    public Usuario(String correo, String nombre, String clave) {
        this.correo = correo;
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
