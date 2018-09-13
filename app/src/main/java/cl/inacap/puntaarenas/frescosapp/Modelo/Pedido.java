package cl.inacap.puntaarenas.frescosapp.Modelo;

import java.util.List;

/**
 * Created by Pablo on 21/11/2017.
 */

public class Pedido {

    private String numPedido;
    private String rutCliente;
    private String fechaEntrega;
    private int total;
    private String estado;

    public Pedido(String numPedido, String rutCliente, String fechaEntrega, int total, String estado) {
        this.numPedido = numPedido;
        this.rutCliente = rutCliente;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
        this.estado = estado;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  "Nº Pedido       : " + numPedido +"\n"+
                "Rut del Cliente : " + rutCliente +"\n" +
                "Fecha de entrega: " + fechaEntrega+"\n"+
                "Total           : " + total +"";
    }
}
