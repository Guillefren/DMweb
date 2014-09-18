/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;


import java.util.Date;

/**
 *
 * @author Agustin
 */
public class DataCliente {
    private String nick;
    private String nombre;
    private String apellido;
    private String email;
    private Date fnac;
    private String imagen;
    
    
    public void DataCliente(){
    nick = "-";
    nombre = "-";
    apellido = "-";
    email = "-";
    fnac = new Date();
    imagen = "-";
    }
    
    public String getNick(){
        return nick;
    }
    public String getNombre(){
        return nombre;
    }
     public String getApellido(){
        return apellido;
    }
    public String getEmail(){
        return email;
    }
    public String getImagen(){
        return imagen;
    }
    
    public Date getFnac(){
    
        return fnac;
    }
    public void setDatos(String nick, String nombre, String apellido, String email, Date fnaci, String imagen){
    
        this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.imagen = imagen;
    this.nick = nick;
    fnac = fnaci;
    
    }
}