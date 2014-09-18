package Logica;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class DataProducto {
    
    private String Nombre;
    private int NumRef;
    private String Descripcion;
    private Especificacion Esp;
    private Money Precio;
    private List<String> Imagen;
    private Proveedor proveedor;
    
    public void DataProducto(){
        Nombre=null;
        Descripcion=null;
        Esp=null;
        Precio=null;
        Imagen=null;
        proveedor = null;
    }

    void setDataProd(String Nombre, int NumRef, String Descripcion, Especificacion Especif, Money Precio, Proveedor proveedor, List<String> Imagen) {
        this.Nombre=Nombre;
        this.NumRef=NumRef;
        this.Descripcion=Descripcion;
        this.Esp=Especif;
        this.Precio=Precio;
        this.Imagen=Imagen;
        this.proveedor= proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumRef() {
        return NumRef;
    }

    public void setNumRef(int NumRef) {
        this.NumRef = NumRef;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Especificacion getEsp() {
        return Esp;
    }

    public void setEsp(Especificacion Esp) {
        this.Esp = Esp;
    }

    public Money getPrecio() {
        return Precio;
    }

    public void setPrecio(Money Precio) {
        this.Precio = Precio;
    }

    public List<String> getImagen() {
        return Imagen;
    }

    public void setImagen(List<String> Imagen) {
        this.Imagen = Imagen;
    }
    
}
