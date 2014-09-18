/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;
import java.util.*;
/**
 *
 * @author Agustin
 */
abstract class Usuario {
     String nick;
     String nombre;
     String apellido;
     String email;
     Date fnac;
     String imagen;
     String contraseña;
     
     public void Usuario(){
     
              nick = "-";
              nombre = "-";
              apellido = "-";
              email = "-";
              fnac = new Date();
              imagen = "-";
              contraseña = "-";
     
     }
     
     
      public String getNick(){
       return nick;
          }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
   
   public Date getNacimiento(){
   
   return fnac;
   }

    public Date getFnac() {
        return fnac;
    }

    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }
   
   public String getImagen(){
   
   return imagen;
   }
     
 }
