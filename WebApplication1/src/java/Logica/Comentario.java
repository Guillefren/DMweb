/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.util.Date;

/**
 *
 * @author Guilleeu
 */
public class Comentario {
    
    private int idPadre;
    private int id;
    private String texto;
    private Date fecha;
    private producto Producto;
    private cliente cliente;
    
    public Comentario(){
    
    idPadre = 0;
    id = 0;
    texto = "";
    fecha = new Date();
    Producto = new producto();
    cliente = new cliente();
    
    }

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public producto getProducto() {
        return Producto;
    }

    public void setProducto(producto Producto) {
        this.Producto = Producto;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public DataComentario getData(){
    
    DataComentario dc = new DataComentario();
    
    dc.setDatos(id, id, fecha, texto, texto, texto);
    return dc;
    }
    
    
}
