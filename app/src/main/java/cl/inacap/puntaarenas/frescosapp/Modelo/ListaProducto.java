package cl.inacap.puntaarenas.frescosapp.Modelo;

/**
 * Created by Pablo on 01/12/2017.
 */

public class ListaProducto {

    private String numPedido;
    private String producto;
    private int cantidad;
    private int precio;

    public ListaProducto(String numPedido, String producto, int cantidad, int precio) {
        this.numPedido = numPedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  "producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
