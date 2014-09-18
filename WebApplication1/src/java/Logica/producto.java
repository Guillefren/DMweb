/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import Conexionbd.agregar;
import Logica.*; 
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class producto {
    
    private String Nombre;
    private int NumRef;
    private String Descripcion;
    private Especificacion Esp;
    private Money Prec;
    private List<String> Imagen;
    private Proveedor provee;
    private List<Hoja> hojas;

    public List<Hoja> getHoja() {
        return hojas;
    }

    public void addHoja(Hoja h){
    
    hojas.add(h);
    
    }
    public void setCategorias(List<Hoja> hojas) {
        this.hojas = hojas;
    }

    public Money getPrec() {
        return Prec;
    }

    public void setPrec(Money Prec) {
        this.Prec = Prec;
    }

    public Proveedor getProvee() {
        return provee;
    }

    public void setProvee(Proveedor provee) {
        this.provee = provee;
    }
    
    public producto(){
        Nombre= "-";
        NumRef=0;
        Descripcion = "-";
        Imagen = new LinkedList();
        Esp = new Especificacion();
        Prec =new Money(); 
        provee = new Proveedor();
        hojas = new LinkedList();
       
    }
    public void setDatosProd(String Nombre, int NumRef, String Descripcion, Especificacion Especif , Money precio, Proveedor proveedor, List<String> Imagen,List<Hoja> hojas){
    
        this.Nombre = Nombre;
        this.NumRef = NumRef;
        this.Descripcion = Descripcion;
        this.Esp = Especif;
        this.Prec = precio;
        this.provee = proveedor;
        this.Imagen = Imagen;
        this.hojas = hojas;
        
    }
    
    
    public String getNombre(){
       return Nombre;
          }
    public int getNumRef(){
       return NumRef;
          } 
    public String getDescripcion(){
       return Descripcion;
          }
    public Especificacion getEsp(){
        return Esp;
    }

    public Money getPrecio() {
        return Prec;
    }

    public void setPrecio(Money Prec) {
        this.Prec = Prec;
    }
    
    public Proveedor DatoProveedor(producto p){
        return provee;
    }
    
 
    public List<String> getImagen(){
       return Imagen;
          }
    public void setNombre(String nom){
       this.Nombre = nom;
            }
    public void setNumRef(int numRef){
       this.NumRef = numRef;
            }
    public void setDescripcion(String desc){
       this.Descripcion = desc;
            }
    public void setEsp(Especificacion Esp){
       this.Esp= Esp;
            }
    /*public void setPrecio(Money prec){
      this.Prec = prec;
            }*/
    public void setImagen(List<String> imag){
       this.Imagen = imag;
            }
    
      public void agregarProd(producto pro){
       agregar ag;
       ag = new agregar();
      ag.agregarproducto(pro);
       
       
   }
    public void Modificardatos(int i, String n, String d, List<Especificacion> le, Money m){
    
    
    }
            
            
    public DataProducto getDataProd(){ //verinfoproducto
   
   DataProducto dpr = new DataProducto();
   dpr.setDataProd(Nombre, NumRef, Descripcion, Esp , Prec, provee, Imagen);
   return dpr;
   }
}