/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexionbd;

import Logica.Proveedor;
import Logica.cliente;
import java.sql.ResultSet;
import java.util.LinkedList;
import Logica.Hoja;
import Logica.Compuesta;
import Logica.ControladorUsuario;

import Logica.DataHoja;
import Logica.DataOrdenDeCompra;
import Logica.DataProducto;
import Logica.Especificacion;
import Logica.Money;
import Logica.OrdenDeCompra;
import Logica.producto;
import java.util.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Agustin
 */
public class getLista {
    
   
    
        public LinkedList<cliente> getListaCliente(){
        LinkedList<cliente> ListaCliente = new LinkedList();
        Conexionbd.conexion bd = new Conexionbd.conexion();
        try{
            bd.conectarBase();
            //ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM USUARIOS WHERE TIPO = 'C'");
            ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM USUARIOS WHERE TIPO = 'c'");
            while (rs.next()){ 
                cliente cli = new cliente();
                cli.setNick(rs.getString("NICK"));
                cli.setNombre(rs.getString("NOMBRE"));
                cli.setApellido(rs.getString("APELLIDO"));
                cli.setEmail(rs.getString("EMAIL"));
                cli.setImagen(rs.getString("IMAGEN"));
                java.sql.Date sqldate = rs.getDate("Nacimiento");
                Date d = new Date(sqldate.getTime());
                cli.setFnac(d);
                cli.setContraseña(rs.getString("CONTRASEÑA"));
                //System.out.print(cli.getData().getNombre());
                
             ResultSet rs1 = bd.sentencia.executeQuery("SELECT * FROM ORDENCOMPRA WHERE NOMBRE_CLI = '"+cli.getNombre()+"'");   
   //("SELECT * FROM CATxPROD cp,PRODUCTO p WHERE cp.NOMBRE_PROD = p.NOMBRE AND cp.NOMBRE_CAT ='"+cat+"'")
              while (rs1.next()){
              
                  OrdenDeCompra oc = new OrdenDeCompra();
                    java.sql.Date sqldate2 = rs1.getDate("FECHA");
                    Date d2 = new Date(sqldate2.getTime());
                    oc.setFecha(d2);
                
                  oc.setNumero(rs1.getInt("NUMERO"));
                  Money pr = new Money();
                  pr.setValor(Double.valueOf(rs1.getString("PREC_TOTAL")));
                  pr.setTipo("USD");
                  oc.setPrecioTotal(pr);
                  cli.addOrden(oc);
                  
              }
             
             
             
                ListaCliente.add(cli);
                 }
        }catch (SQLException e){
            
        }
        bd.desconectarBaseDeDatos();
        
        return ListaCliente;
        }
    
public List<OrdenDeCompra> getListaNumeroOrden(){
            List<OrdenDeCompra> lnumero = new LinkedList();
            Conexionbd.conexion bd = new Conexionbd.conexion();
                ControladorUsuario cont = new ControladorUsuario();
    try{
    bd.conectarBase();
    ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM ORDENCOMPRA");

    while (rs.next()){
        
        OrdenDeCompra orden = new OrdenDeCompra();
        java.sql.Date sqldate = rs.getDate("FECHA");
        Date d = new Date(sqldate.getTime());
        orden.setFecha(d);
        orden.setNumero(rs.getInt("NUMERO"));
        
        Money pre = new Money();
        pre.setValor(Double.valueOf(rs.getString("PREC_TOTAL")));
        pre.setTipo("USD");
        orden.setPrecioTotal(pre);
        orden.setCliente(cont.SeleccionarCliente(rs.getString("NOMBRE_CLI")));
        ResultSet rs2 = bd.sentencia.executeQuery("SELECT * FROM PRODUCTO,CANTPRODXORDENCOMPRA WHERE NOMBRE = NOMBRE_PROD AND NUM_OC ="+orden.getNumero()+"");
        List<producto> lprod = new LinkedList();
        
        while(rs2.next()){
           
            producto pro = new producto();
            pro.setNombre(rs2.getString("NOMBRE"));
            pro.setDescripcion(rs2.getString("DESCRIPCION"));
            pro.setNumRef(rs2.getInt("NUM_REF"));
            Money preuni = new Money();
            preuni.setValor(Double.valueOf(rs2.getString("PRECIO")));
            preuni.setTipo("USD");
            pro.setPrecio(preuni);
            pro.setEsp(null);
            // pro.setImagen(rs2.getString("IMAGEN"));
            lprod.add(pro);
} 
        orden.setLproducto(lprod);
        lnumero.add(orden); 
        
}
    }catch (Exception e){}
        bd.desconectarBaseDeDatos();
return lnumero;
}
    
public int getCantPro(String nom, int nu){
        int cant = 0; 
        Conexionbd.conexion bd = new Conexionbd.conexion();
        
        try{
            bd.conectarBase();
            ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM CANTPRODXORDENCOMPRA WHERE NOMBRE_PROD = '"+nom+"' AND NUM_OC = '"+nu+"'");
            while(rs.next()){
                
                cant = rs.getInt("CANTIDAD");
            
            }
         }catch (SQLException ex) {
                Logger.getLogger(getLista.class.getName()).log(Level.SEVERE, null, ex);
            }
        return cant;    
   }
        
        
  public List<producto> getListaProductoSolo(){
        List<producto> ListaProductoSolo = new LinkedList();
       
        Conexionbd.conexion bd = new Conexionbd.conexion();
        
            try{
            bd.conectarBase();
            ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM PRODUCTO p,ESPECIFICACIONESxPROD e WHERE p.NOMBRE = e.NOMBRE_PROD");
            while (rs.next()){
                producto prod = new producto();
                prod.setNombre(rs.getString("NOMBRE"));
                prod.setDescripcion(rs.getString("DESCRIPCION"));
                prod.setNumRef(rs.getInt("NUM_REF"));
          //      prod.setImagen(rs.getString("IMAGENES"));
                
                
                String imag = rs.getString("IMAGENES");
                //JOptionPane.showMessageDialog(null, imag);
                List<String> imagenes = new LinkedList();
                StringTokenizer st2 = new StringTokenizer(imag,"-");
                while(st2.hasMoreTokens()){
                    imagenes.add(st2.nextToken());
                    //JOptionPane.showMessageDialog(null, st.nextToken());
                }
                 prod.setImagen(imagenes);
                
                
                double i = Double.parseDouble(rs.getString("PRECIO"));
                Money prec = new Money();
                prec.setValor(i);
                prec.setTipo("USD");
                prod.setPrecio(prec);
                ControladorUsuario cu = new ControladorUsuario();
                Proveedor pr = new Proveedor();
                pr = cu.SeleccionarProv(rs.getString("NOMBRE_PROV"));
                prod.setProvee(pr);
                         
                ResultSet rs2 = bd.sentencia.executeQuery("SELECT * FROM CATxPROD WHERE NOMBRE_PROD = '"+prod.getNombre()+"'");
                List<Hoja> hojas = new LinkedList();
                while(rs2.next()){
                    String categ = rs2.getString("NOMBRE_CAT");
                    Hoja hoja = new Hoja();
                    hoja.SetNombre(categ);
                    hojas.add(hoja);
                    //JOptionPane.showMessageDialog(null, hoja.GetNombre());
                    prod.setCategorias(hojas);
                }
               
                ListaProductoSolo.add(prod);
            }
        }catch (SQLException e){
        }
        bd.desconectarBaseDeDatos();
        
        return ListaProductoSolo;
    }      
        
  
  
  
        
   public List<Proveedor> getListaProveedor(){
        List<Proveedor> ListaProveedor = new LinkedList();
        Conexionbd.conexion bd = new Conexionbd.conexion();
        List<producto> lp = new LinkedList();
        try{
            bd.conectarBase();
            ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM USUARIOS WHERE TIPO = 'p'");
            while (rs.next()){
                Proveedor prov = new Proveedor();
               
                prov.setNick(rs.getString("NICK"));
                
                prov.setApellido(rs.getString("APELLIDO"));
//                System.out.print(prov.getNick());
                prov.setEmail(rs.getString("EMAIL"));
                prov.setImagen(rs.getString("IMAGEN"));
                prov.setLinkPagina(rs.getString("LINK_COMP"));
                prov.setNombre(rs.getString("NOMBRE"));
                prov.setNombreCompañia(rs.getString("NOM_COMP"));
                prov.setContraseña(rs.getString("CONTRASEÑA"));
                java.sql.Date sqldate = rs.getDate("NACIMIENTO");
                Date d = new Date(sqldate.getTime());
                prov.setFnac(d);
                
            
            ResultSet rs2 = bd.sentencia.executeQuery("SELECT * FROM PRODUCTO WHERE NOMBRE_PROV = "
                    + "'"+prov.getNick()+"'");    
                
                while(rs2.next()){
                
                producto prod = new producto();
                prod.setNombre(rs2.getString("NOMBRE"));
                prod.setDescripcion(rs2.getString("DESCRIPCION"));
                prod.setNumRef(rs2.getInt("NUM_REF"));
                
                
                
                String imag = rs2.getString("IMAGENES");
                //JOptionPane.showMessageDialog(null, imag);
                List<String> imagenes = new LinkedList();
                StringTokenizer st2 = new StringTokenizer(imag,"-");
                while(st2.hasMoreTokens()){
                    imagenes.add(st2.nextToken());
                    //JOptionPane.showMessageDialog(null, st2.nextToken());
                }
                 prod.setImagen(imagenes);
                
                
                double i = Double.parseDouble(rs2.getString("PRECIO"));
                Money prec = new Money();
                prec.setValor(i);
                prec.setTipo("USD");
                prod.setPrecio(prec);
                prod.setProvee(prov);
                
                         
                ResultSet rs3 = bd.sentencia.executeQuery("SELECT * FROM CATxPROD WHERE NOMBRE_PROD = "
                        + "'"+prod.getNombre()+"'");
                
                List<Hoja> hojas = new LinkedList();
                while(rs3.next()){
                    String categ = rs3.getString("NOMBRE_CAT");
                    Hoja hoja = new Hoja();
                    hoja.SetNombre(categ);
                    hojas.add(hoja);
                    //JOptionPane.showMessageDialog(null, hoja.GetNombre());
                    prod.setCategorias(hojas);
                }
               lp.add(prod);
                
                
                }
                prov.setListaproductos(lp);
            
                
                ListaProveedor.add(prov);
                
            }
        }catch (Exception e){
            
        }
        bd.desconectarBaseDeDatos();
        
        return ListaProveedor;
    
    }
   
    public LinkedList<Hoja> getListaHojaConProd(){
        LinkedList<Hoja> ListaHoja = new LinkedList();
        Conexionbd.conexion bd = new Conexionbd.conexion();
        try{
                
                bd.conectarBase();
                ResultSet rs = bd.sentencia.executeQuery("SELECT DISTINCT NOMBRE_CAT FROM CATxPROD");
                while (rs.next()){
                Hoja com = new Hoja();
                
                com.SetNombre(rs.getString("NOMBRE_CAT"));
                
                
                
                ListaHoja.add(com);
                
            }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        bd.desconectarBaseDeDatos();
        
        return ListaHoja;
    
    }
    
    
    public List<Hoja> getListaHoja(){
        LinkedList<Hoja> ListaHoja = new LinkedList();
        Conexionbd.conexion bd = new Conexionbd.conexion();
        
        try{
            bd.conectarBase();
            ResultSet rs;
            try {
                rs = bd.sentencia.executeQuery("SELECT * FROM CATEGORIA WHERE TIPO = 'h'");
                while (rs.next()){
                    Hoja dh = new Hoja();
                    //JOptionPane.showMessageDialog(null, rs.getString("NOMBRE"));
                    dh.SetNombre(rs.getString("NOMBRE"));
                    //JOptionPane.showMessageDialog(null, hoj.getNombre());
                    dh.SetPadre(rs.getString("PADRE"));
                    //JOptionPane.showMessageDialog(null, dh.getNombre());
                    
                    
                 ResultSet rs2 = bd.sentencia.executeQuery("SELECT * FROM PRODUCTO,CATXPROD WHERE NOMBRE = NOMBRE_PROD AND NOMBRE_CAT = '"+dh.GetNombre()+"'");    
               List<producto> lp = new LinkedList();
                  while (rs2.next()){
                  
                producto prod = new producto();
                prod.setNombre(rs2.getString("NOMBRE"));
                prod.setDescripcion(rs2.getString("DESCRIPCION"));
                prod.setNumRef(rs2.getInt("NUM_REF"));
                
               
                String imag = rs2.getString("IMAGENES");
                //JOptionPane.showMessageDialog(null, imag);
                List<String> imagenes = new LinkedList();
                StringTokenizer st2 = new StringTokenizer(imag,"-");
                while(st2.hasMoreTokens()){
                    imagenes.add(st2.nextToken());
                    //JOptionPane.showMessageDialog(null, st2.nextToken());
                }
                 prod.setImagen(imagenes);
                
                
                double i = Double.parseDouble(rs2.getString("PRECIO"));
                Money prec = new Money();
                prec.setValor(i);
                prec.setTipo("USD");
                prod.setPrecio(prec);
                
                ControladorUsuario cu = new ControladorUsuario();
                prod.setProvee(cu.SeleccionarProv(rs2.getString("NOMBRE_PROV")));
                prod.addHoja(dh);
                    lp.add(prod);
                }
               dh.setListaproductos(lp);
                  
                ListaHoja.add(dh);  
                  }  
                    
                
            } catch (SQLException ex) {
                Logger.getLogger(getLista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             
           
        }catch (Exception e){
            System.out.println("No anda guacho");
            
        }
        bd.desconectarBaseDeDatos();
        
        return ListaHoja;
    
    }
    
    
    
    public LinkedList<Compuesta> getListaCompuesta(){
        LinkedList<Compuesta> ListaCompuesta = new LinkedList();
        Conexionbd.conexion bd = new Conexionbd.conexion();
        
        try{
                bd.conectarBase();
                ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM CATEGORIA WHERE TIPO='c'");
        while (rs.next()){
                Compuesta comp = new Compuesta();
                //int cont = rs.getRow();
                comp.SetNombre(rs.getString("NOMBRE"));
                //comp.SetPadre(rs.getString("PADRE"));
                ListaCompuesta.add(comp);
        }
        }catch (Exception e){
                System.out.println("No anda ");
        }
        bd.desconectarBaseDeDatos();
        return ListaCompuesta;

    }
    
    public List<producto> getProductosxCat(String cat){
        List<producto> prodsxcat = new LinkedList();
        Conexionbd.conexion bd = new Conexionbd.conexion();
        try {
            bd.conectarBase();
            ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM CATxPROD cp,PRODUCTO p WHERE cp.NOMBRE_PROD = p.NOMBRE AND cp.NOMBRE_CAT ='"+cat+"'");
            while (rs.next()){
                producto p = new producto();
                p.setNombre(rs.getString("NOMBRE"));
                prodsxcat.add(p);
            }
        }catch (SQLException ex) {
                Logger.getLogger(getLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.desconectarBaseDeDatos();
        return prodsxcat;
    }
    
    public int getMaxNumOrdenCompra(){
        int num = -1;
        Conexionbd.conexion bd = new Conexionbd.conexion();
        try {
            bd.conectarBase();
            ResultSet rs = bd.sentencia.executeQuery("SELECT MAX(NUMERO) FROM ORDENCOMPRA");
            rs.next();
            num = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(getLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.desconectarBaseDeDatos();
        return num;
    }
    
    public producto SeleccionarProducto(String p){
        producto prod = new producto();
        Conexionbd.conexion bd = new Conexionbd.conexion();
        try {
            bd.conectarBase();
            ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM PRODUCTO WHERE NOMBRE = '"+p+"'");
            rs.next();
                prod.setNombre(rs.getString("NOMBRE"));
                Money prec = new Money();
                prec.setValor(Double.parseDouble(rs.getString("PRECIO")));
                prec.setTipo("USD");
                prod.setPrecio(prec);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(getLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.desconectarBaseDeDatos();
        return prod;
    }
    
    
   
    public List<producto> getListaProducto(String cat){
            List<producto> ListaProducto = new LinkedList();
            Conexionbd.conexion bd = new Conexionbd.conexion();
        try{
            bd.conectarBase();
            ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM CATXPROD WHERE NOMBRE_CAT='"+cat+"'");
    
                while (rs.next()){
                    producto prod = new producto();
                    prod.setNombre(rs.getString("NOMBRE_PROD"));

                    ListaProducto.add(prod);
                }
        }catch (SQLException e){
}
    bd.desconectarBaseDeDatos();
            return ListaProducto;
}
    
    
    
   public Especificacion getEspecificacionesProd(producto prod){
        Especificacion esp = new Especificacion();
        Conexionbd.conexion bd = new Conexionbd.conexion();
        bd.conectarBase();
        try {
            ResultSet rs = bd.sentencia.executeQuery("SELECT * FROM ESPECIFICACIONESxPROD WHERE NOMBRE_PROD = '"+prod.getNombre()+"'");
            while(rs.next()){
                esp.setProd(prod);
                String esps = rs.getString("ESPECIFICACIONES");
                //JOptionPane.showMessageDialog(null, esps);
                List<String> especificaciones = new LinkedList();
                StringTokenizer st = new StringTokenizer(esps,"-");
                while(st.hasMoreTokens()){
                    especificaciones.add(st.nextToken());
                    //JOptionPane.showMessageDialog(null, st.nextToken());
                }
                esp.setLista(especificaciones);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(getLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.desconectarBaseDeDatos();
        /*for (int i = 0;i < esp.getListaEspecificaciones().size();i++){
            JOptionPane.showMessageDialog(null, esp.getListaEspecificaciones().get(i));
        }*/
        return esp;
    }
    
    
}
