package cl.inacap.puntaarenas.frescosapp.Modelo;

/**
 * Created by Pablo on 19/10/2017.
 */

public class Cliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
