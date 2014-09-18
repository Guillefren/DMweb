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
public class DataComentario {
    private int idPadre;
    private int id;
    private String texto;
    private Date fecha;
    private String nombreProducto;
    private String nickCliente;

    public DataComentario(){
    
    this.fecha=new Date();
    this.id = 0;
    this.idPadre= 0;
    this.nickCliente = "";
    this.nombreProducto = "";
    this.texto = "";
    
    
    }
    public void setDatos(int id, int idp, Date fecha, String nick,String nombrep,String texto){
    this.fecha= fecha;
    this.id = id;
    this.idPadre= idp;
    this.nickCliente = nick;
    this.nombreProducto = nombrep;
    this.texto = texto;
    
    
    
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

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNickCliente() {
        return nickCliente;
    }

    public void setNickCliente(String nickCliente) {
        this.nickCliente = nickCliente;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
