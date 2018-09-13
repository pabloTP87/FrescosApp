package cl.inacap.puntaarenas.frescosapp.Modelo;

/**
 * Created by Pablo on 19/10/2017.
 */

public class Producto {
    private String nomProducto;
    private int precio;
    private int imagen;

    public Producto(String nomProducto, int precio, int imagen) {
        this.nomProducto = nomProducto;
        this.precio = precio;
        this.imagen = imagen;

    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return nomProducto + ": $" + precio;
    }
}
