package cl.inacap.puntaarenas.frescosapp.Modelo;

/**
 * Created by Pablo on 19/10/2017.
 */

public class Cliente {
    private String rutCliente;
    private String nombreLocal;
    private String nombreContacto;
    private String direccion;
    private String telefono;
    private String activo;

    public Cliente(String rutCliente, String nombreLocal, String nombreContacto, String direccion, String telefono, String activo) {
        this.rutCliente = rutCliente;
        this.nombreLocal = nombreLocal;
        this.nombreContacto = nombreContacto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.activo = activo;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return
                "Rut Cliente: " + rutCliente +"\n"+
                "Empresa:     " + nombreLocal +"\n"+
                "Contacto:    " + nombreContacto +"\n"+
                "Direccion:   " + direccion +"\n"+
                "Telefono:    " + telefono +"\n"+
                "Activo:      " + activo +"";
    }
}
