/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import Conexionbd.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorProductoyEspecificaciones {
  
    public List<producto> ListaProductos;
    public   List<Especificacion>  ListaEspecificaciones;
    
    public void ControladorProductoyEspecificaciones(){
        
     ListaProductos = new LinkedList();
     ListaEspecificaciones = new LinkedList();
    
    }
    public int getCantidadPro(String nom, int orden){
            getLista gl = new getLista();
            return gl.getCantPro(nom,orden);
        }
  
    public void RegistrarEspecificaciones(){
         //lista especificaciones, guarda todas las que se ingresen
         //se insertan en bd.sentencia.executeQuery("INSERT INTO PRODUCTO(ESPECIFICACIONES)VALUES('?')");
        
    }
    
    public List<DataOrdenDeCompra> getListaOrdenCompra(){
        getLista gl = new getLista();
        List<DataOrdenDeCompra> ldorden = new LinkedList();
        List<OrdenDeCompra> lisorden = gl.getListaNumeroOrden();
        for(int i=0; i<lisorden.size();i++){
                DataOrdenDeCompra dorden = new DataOrdenDeCompra();
                dorden.setPrecioTotal(lisorden.get(i).getPrecioTotal());
                dorden.setFecha(lisorden.get(i).getFecha());
                dorden.setProd(lisorden.get(i).getLproducto());
                dorden.setNumero(lisorden.get(i).getNumero());
                ldorden.add(dorden);
        }
        return ldorden;
}
    
    public boolean existeProducto(String nombre, int numRef){
        getLista g = new getLista();
        ListaProductos = g.getListaProductoSolo();
        for(int i = 0;i<ListaProductos.size();i++){
            if(ListaProductos.get(i).getNombre().equals(nombre) || ListaProductos.get(i).getNumRef()==numRef){
                return true;
            }
        }
    return false;
}
    
    public void RegistrarProducto(String Nombre, int NumRef, String Descripcion, List<String> Especif, Money precio, String nomprov, List<String> Imagen, List<Hoja> hojas){
    
      
        producto p = new producto();
         Especificacion Esp = new Especificacion();
         Esp.setLista(Especif);
         ControladorUsuario cu = new ControladorUsuario();
         Proveedor pr = cu.SeleccionarProv(nomprov);
         //JOptionPane.showMessageDialog(null, Esp.getListaEspecificaciones().size());        
         //System.out.print(pr.getData().getNombre());
         p.setDatosProd(Nombre, NumRef, Descripcion, Esp, precio, pr, Imagen, hojas);
         agregar ag = new agregar();
         ag.agregarproducto(p);
         
          
    
}
          
           /* CargarImagen(jpg)*/
          
    public List<DataProducto> ListarProductos(String cat){
        
    getLista gl = new getLista();
    ListaProductos = gl.getListaProducto(cat);
    List<DataProducto> DataListaProducto = new LinkedList();
    producto p = new producto();
    DataProducto dp = new DataProducto();
    
         for(int i=0; i<ListaProductos.size();i++){
             p = ListaProductos.get(i);
             dp=p.getDataProd();
             DataListaProducto.add(dp);
         }
        return DataListaProducto;
              

    }
    
    
    
     public producto SeleccionarProducto(String Nombre){
              
        getLista gl = new getLista();
       
        ListaProductos = gl.getListaProductoSolo();
      
        
        for(int i=0; i<ListaProductos.size();i++){
            
            if (ListaProductos.get(i).getNombre().equals(Nombre)){
               // if(ListaProductos.get(i).getProvee()== null)
                    
                return ListaProductos.get(i);
            }
        
         
     }
            return null;
       
    }  
     
     public Especificacion getEspecificacionesProd(producto prod){
         getLista gl = new getLista();
         return gl.getEspecificacionesProd(prod);
     }
    
    
}
