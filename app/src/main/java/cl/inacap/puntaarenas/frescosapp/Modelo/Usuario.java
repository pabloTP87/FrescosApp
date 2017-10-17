package cl.inacap.puntaarenas.frescosapp.Modelo;

/**
 * Created by 16652403-2 on 16/10/2017.
 */

public class Usuario {
    private String nombre;
    private String contraseña;

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }
}
