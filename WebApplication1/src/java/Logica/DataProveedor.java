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
public class DataProveedor {
    
    String apellido;
    String email;
    Date fnac;
    String linkPagina;
    String nombreCompañia;
    String imagen;
    String nick;
    String nombre;
    
    public void DataProveedor(){
    nick = "-";
    nombre = "-";
    apellido = "-";
    email ="-";
    fnac = new Date();
    linkPagina = "-";
    nombreCompañia = "-";
    imagen = "-";
    
    }
    

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFnac() {
        return fnac;
    }

    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    public String getLinkPagina() {
        return linkPagina;
    }

    public void setLinkPagina(String linkPagina) {
        this.linkPagina = linkPagina;
    }

    public String getNombreCompañia() {
        return nombreCompañia;
    }

    public void setNombreCompañia(String nombreCompañia) {
        this.nombreCompañia = nombreCompañia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
   public void setDatos(String nick,String nombre, String apellido, String email,Date fnac, String linkPagina,String nombreCompañia,String imagen){
   
       this.nick = nick;
       this.apellido = apellido;
       this.email = email;
       this.fnac = fnac;
       this.linkPagina = linkPagina;
       this.nombre = nombre;
       this.nombreCompañia = nombreCompañia;
       this.imagen = imagen;

   }
   
 
    
    
    
    
    
    
    
    
    
    
    
    
    
}
