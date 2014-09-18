/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;
import java.util.*;

/**
 *
 * @author Guilleeu
 */
public class Proveedor extends Usuario{
    
    private String nombreCompañia;
    private String linkPagina;
    private List<producto> listaproductos;

    public List<producto> getListaproductos() {
        return listaproductos;
    }

    public void setListaproductos(List<producto> listaproductos) {
        this.listaproductos = listaproductos;
    }
    

    public Proveedor(){
   
    nombreCompañia= "-";
    linkPagina = "-";
    listaproductos = new LinkedList();
    
    }
    public String getNombreCompañia(){
    
    return nombreCompañia;
    }
    
    public String getLinkPagina(){
    
    return linkPagina;
    }
    
    public void setNombreCompañia(String nc){
    
    this.nombreCompañia = nc;
    }
    
    public void setLinkPagina(String lp){
    
    this.linkPagina = lp;
    }
    
    
   
   public Proveedor(String ni,String nom, String ap, Date fnac,String nc, String lp){
        
       this.nick = ni;
       this.nombre = nom;
       this.apellido = ap;
       this.fnac = fnac;
       this.linkPagina = lp;
       this.nombreCompañia = nc;
     
   }
   
    
   public void setdatos(String nick, String nombre, String apellido, String email, Date fnac, String Imagen, String nc, String lp,String contra){

   this.apellido = apellido;
   this.email = email;
   this.imagen = Imagen;
   this.linkPagina = lp;
   this.nick = nick;
   this.nombre = nombre;
   this.nombreCompañia = nc;
   this.fnac = fnac;
   this.contraseña = contra;
   }
   
   public DataProveedor getData(){
   
       DataProveedor dp = new DataProveedor();
       dp.setDatos(nick, nombre, apellido, email, fnac, linkPagina, nombreCompañia, imagen);

       return dp;
   }
   
   
   
   
   
   
   
   
   
   
   
}












