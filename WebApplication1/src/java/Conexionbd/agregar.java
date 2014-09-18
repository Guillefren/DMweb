/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexionbd;
import Logica.cliente;
import Logica.Proveedor;
import Logica.Compuesta;
import Logica.DataProveedor;
import Logica.Hoja;

import Logica.OrdenDeCompra;
import Logica.ProductosOrdenCompra;
import Logica.producto;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Agustin
 */
public class agregar {
    public void agregarcliente(cliente cli){
     Conexionbd.conexion bd;
     bd = new Conexionbd.conexion();
     bd.conectarBase();
         try {
           //  java.sql.Date.valueOf(cli.getNacimiento().toString())
         //cli.getNacimiento().getYear()+"-"+cli.getNacimiento().getMonth()+"-"+cli.getNacimiento().getDay()+
           java.sql.Date fecha = new java.sql.Date(cli.getNacimiento().getTime());
            String tipo = "c";  
              
              //cal.getTime().getYear()+"-"+cal.getTime().getMonth()+"-"+cal.getTime().getDay()
             bd.sentencia.executeQuery("INSERT INTO USUARIOS(NICK,NOMBRE,APELLIDO,EMAIL,NACIMIENTO,IMAGEN,TIPO,CONTRASEÑA)VALUES('"+cli.getNick()+"','"+cli.getNombre()+"','"+cli.getApellido()+"','"+cli.getEmail()+"','"+fecha+"','"+cli.getImagen()+"','"+tipo+"','"+cli.getContraseña()+"')");
         
         
         } catch (SQLException ex) {
             System.out.println("No se pudo agregar a Base de datos");
             Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
         }
         bd.desconectarBaseDeDatos();
     
     
     
     }
     public void agregarCompuesta(Compuesta comp){
            Conexionbd.conexion bd;
            bd = new Conexionbd.conexion();
            bd.conectarBase();
            try {
                bd.sentencia.executeQuery("INSERT INTO CATEGORIA(Tipo, Nombre, Padre)VALUES('"+comp.GetTipo()+"','"+comp.GetNombre()+"','"+comp.GetPadre().GetNombre()+"')");
            } 
            catch (SQLException ex) {
                System.out.println("No se pudo agregar a Base de datos");
                Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            bd.desconectarBaseDeDatos();

}

public void agregarHoja(Hoja hoj){
    Conexionbd.conexion bd;
    bd = new Conexionbd.conexion();
    bd.conectarBase();
    try {
            bd.sentencia.executeQuery("INSERT INTO CATEGORIA(Tipo, Nombre, Padre)VALUES('"+hoj.GetTipo()+"','"+hoj.GetNombre()+"','"+hoj.GetPadre().GetNombre()+"')");
    } 
    catch (SQLException ex) {
        System.out.println("No se pudo agregar a Base de datos");
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    bd.desconectarBaseDeDatos();

}

      public void agregarproveedor(Proveedor cli){
     Conexionbd.conexion bd;
     bd = new Conexionbd.conexion();
     bd.conectarBase();
         try {
             String tipo = "p";
             java.sql.Date fecha = new java.sql.Date(cli.getNacimiento().getTime());
             bd.sentencia.executeQuery("INSERT INTO USUARIOS(NICK, NOMBRE, APELLIDO,EMAIL,NACIMIENTO,NOM_COMP,LINK_COMP,IMAGEN,TIPO,CONTRASEÑA)VALUES('"+cli.getNick()+"','"+cli.getNombre()+"','"+cli.getApellido()+"','"+cli.getEmail()+"','"+fecha+"','"+cli.getNombreCompañia()+"','"+cli.getLinkPagina()+"','"+cli.getImagen()+"','"+tipo+"','"+cli.getContraseña()+"')");
         } catch (SQLException ex) {
             System.out.println("No se pudo agregar a Base de datos");
             Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
         }
     
         bd.desconectarBaseDeDatos();
     
     
     }
     
     
    
     public void agregarproducto(producto p) {
            Conexionbd.conexion bd;
            bd = new Conexionbd.conexion();
            bd.conectarBase();
        try {
            Proveedor pr= new Proveedor();
            pr = p.getProvee();
        //    if(pr==null)
        //        System.out.print("coso");

            DataProveedor dp = pr.getData();
            String nick = dp.getNick();
            String imagenes = p.getImagen().get(0);
            String im;
            for(int i = 1; i<p.getImagen().size(); i++){
                im = p.getImagen().get(i);
                imagenes = imagenes+"-"+im;
                 //JOptionPane.showMessageDialog(null, imagenes);
                }


            //String nombre = p.getProvee().getData().getNombre();
            bd.sentencia.executeQuery("INSERT INTO PRODUCTO(NOMBRE, NUM_REF,DESCRIPCION, PRECIO, NOMBRE_PROV, IMAGENES)VALUES('"+p.getNombre()+"','"+p.getNumRef()+"','"+p.getDescripcion()+"','"+p.getPrecio().getValor()+"','"+nick+"','"+imagenes+"')");
            //String signo = "-";
            String lista = p.getEsp().getListaEspecificaciones().get(0);
            String s;
            //lista = p.getEsp().getListaEspecificaciones().get(0);
            for(int i = 1; i<p.getEsp().getListaEspecificaciones().size(); i++){
                s = p.getEsp().getListaEspecificaciones().get(i);
                /*lista.concat(signo);
                lista.concat(s);*/
                lista = lista+"-"+s;
            //JOptionPane.showMessageDialog(null, lista);
            }
            bd.sentencia.executeQuery("INSERT INTO ESPECIFICACIONESXPROD (NOMBRE_PROD,ESPECIFICACIONES) VALUES ('"+p.getNombre()+"','"+lista+"') ");

            for(int i = 0;i < p.getHoja().size();i++){
                bd.sentencia.executeQuery("INSERT INTO CATxPROD VALUES('"+p.getNombre()+"','"+p.getHoja().get(i).GetNombre()+"')");
            }
            bd.desconectarBaseDeDatos();
        } catch (SQLException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     
     public void agregarOrden (OrdenDeCompra oc,List<ProductosOrdenCompra> prods,String n){
         Conexionbd.conexion bd = new Conexionbd.conexion();
         java.sql.Date forcom = new java.sql.Date(oc.getFecha().getTime());
         try {
             bd.conectarBase();
             bd.sentencia.executeUpdate("INSERT INTO ORDENCOMPRA VALUES("+oc.getNumero()+",'"+forcom+"','"+oc.getPrecioTotal().getValor()+"','"+n+"')");
             for (int i = 0;i < prods.size();i++){
                 bd.sentencia.executeUpdate("INSERT INTO CANTPRODxORDENCOMPRA VALUES('"+prods.get(i).getProducto()+"',"+oc.getNumero()+","+prods.get(i).getCantidad()+")");
             }
         } catch (SQLException ex) {
             Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
}
