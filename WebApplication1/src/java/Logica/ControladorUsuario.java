/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;
import java.util.*; 
import Conexionbd.*;
import javax.servlet.http.HttpSession;

import javax.swing.JOptionPane;
/**
 *
 * @author Guilleeu
 */
public class ControladorUsuario {
    
    
    private List<cliente> ListaClientes;
    private List<Proveedor> ListaProveedores;
    private List<OrdenDeCompra> ListaOrdenes;
    private List<Comentario> ListaComentarios;
    HttpSession sessionControlador = null;
    public void ControladorUsuario(){
        
     ListaClientes = new LinkedList();
    ListaProveedores = new LinkedList();
    ListaOrdenes = new LinkedList();
    ListaComentarios = new LinkedList();
    
// sintaxis List<Persona> listalinked = new LinkedList<Persona>();
    }
    
    
    public HttpSession getSessionControlador() {
        return sessionControlador;
    }

    public void setSessionControlador(HttpSession sessionControlador) {
        this.sessionControlador = sessionControlador;
    }
    
  public List<OrdenDeCompra> getNumeroOrden(){
        getLista gl = new getLista();
        ListaOrdenes = gl.getListaNumeroOrden();
    return ListaOrdenes;
}
  
  public List<DataComentario> getListaComentarios(){
        getLista gl = new getLista();
        List<DataComentario> ldatac = new LinkedList();
        List<Comentario> lcoment = gl.getListaComentarios();
        for(int i=0; i<lcoment.size();i++){
                DataComentario dc = new DataComentario();
                dc.setFecha(lcoment.get(i).getFecha());
                dc.setId(lcoment.get(i).getId());
                dc.setIdPadre(lcoment.get(i).getIdPadre());
                dc.setNickCliente(lcoment.get(i).getCliente().getNick());
                dc.setNombreProducto(lcoment.get(i).getProducto().getNombre());
                dc.setTexto(lcoment.get(i).getTexto());
                
                ldatac.add(dc);
        }
        return ldatac;
}
  
  
  public List<DataOrdenDeCompra> getListaOrdenCompra(){
        getLista gl = new getLista();
        List<DataOrdenDeCompra> ldorden = new LinkedList();
        List<OrdenDeCompra> lisorden = gl.getListaNumeroOrden();
        for(int i=0; i<lisorden.size();i++){
                DataOrdenDeCompra dorden = new DataOrdenDeCompra();
                dorden.setPrecioTotal(lisorden.get(i).getPrecioTotal());
                dorden.setFecha(lisorden.get(i).getFecha());
                dorden.setCli(lisorden.get(i).getCliente().getNick());
                dorden.setProd(lisorden.get(i).getLproducto());
                dorden.setNumero(lisorden.get(i).getNumero());
                ldorden.add(dorden);
        }
        return ldorden;
}
     public void RegistrarCliente(String nick, String nombre, String apellido, String email, Date fnac, String Imagen,String contraseña){
        System.out.println("entro");
        cliente c = new cliente();
        c.setDatos(nick, nombre, apellido, email, fnac, Imagen,contraseña);
        //ListaClientes.add(c);
        agregar ag = new agregar();
        ag.agregarcliente(c);
        
    }
    public void RegistrarProveedor(String nick, String nombre, String apellido, String email, Date fnac, String Imagen, String nombreComp, String linkPag,String contraseña){
    
    Proveedor p = new Proveedor();
    p.setdatos(nick, nombre, apellido, email,fnac, Imagen, nombreComp,linkPag,contraseña);
//    ListaProveedores.add(p);
    agregar ag = new agregar();
    ag.agregarproveedor(p);
    
    }
    public List<DataCliente> ListarClientes(){
        getLista gl = new getLista();
        ListaClientes = gl.getListaCliente();
        List<DataCliente> DataListaClientes = new LinkedList();
        DataCliente dc = new DataCliente();
        for(int i=0; i < ListaClientes.size(); i++){
            cliente cc  = new cliente();
            cc = ListaClientes.get(i);
            dc = cc.getData();
            DataListaClientes.add(dc);
        }
        return DataListaClientes;
    }
    public cliente SeleccionarCliente(String nick){
    
         getLista gl = new getLista();
         ListaClientes = gl.getListaCliente();
         for (int i=0; i<ListaClientes.size(); i++){
                if (ListaClientes.get(i).nick.equals(nick)){
                    return ListaClientes.get(i);
                 }
              }
        return null;
    }
    
     public String SeleccionarContraseña(String nick){
    
         getLista gl = new getLista();
         ListaClientes = gl.getListaCliente();
         for (int i=0; i<ListaClientes.size(); i++){
                if (ListaClientes.get(i).nick.equals(nick)){
                    return ListaClientes.get(i).getContraseña();
                 }
              }
         
         ListaProveedores = gl.getListaProveedor();
         for (int i=0; i<ListaProveedores.size(); i++){
                if (ListaProveedores.get(i).nick.equals(nick)){
                    return ListaProveedores.get(i).getContraseña();
                 }
              }
         
        return null;
    }
    
    
    public List<DataProveedor> ListarProveedores(){
        
        List<DataProveedor> dataListaProveedores = new LinkedList();
        getLista gl = new getLista();
        ListaProveedores = gl.getListaProveedor();
        
        
        DataProveedor dp = new DataProveedor();

        for(int i = 0;i < ListaProveedores.size();i++){
            
                Proveedor p =ListaProveedores.get(i);
                dp = p.getData();
                dataListaProveedores.add(dp);  
      }
        
       
         return dataListaProveedores;
        }
     public DataProveedor SeleccionarProveedor(String nick){
        
         getLista gl = new getLista();
        ListaProveedores = gl.getListaProveedor();
        

        for(int i = 0;i<ListaProveedores.size();i++){
            
                Proveedor p =new Proveedor();
                p = ListaProveedores.get(i);
                if (p.getNick().equals(nick)){
                    DataProveedor dp = p.getData();
                    return dp;
                }
            }
            
        return null;
        }
      public Proveedor SeleccionarProv(String nick){
        
         getLista gl = new getLista();
        ListaProveedores = gl.getListaProveedor();
        

        for(int i = 0;i<ListaProveedores.size();i++){
            
                Proveedor p =new Proveedor();
                p = ListaProveedores.get(i);
                if (p.getNick().equals(nick)){
                    
                    return p;
                }
            }
            
        return null;
        }
     public boolean existeCliente(String nick, String email){
     
     getLista g = new getLista();
     ListaClientes = g.getListaCliente();
     ListaProveedores = g.getListaProveedor();
     for(int i = 0;i<ListaClientes.size();i++){
     
         if(ListaClientes.get(i).getNick().equals(nick) || ListaClientes.get(i).getEmail().equals(email)){
         
             return true;
         }
        
             
     }
     
     for(int i = 0;i<ListaProveedores.size();i++){
      if(ListaProveedores.get(i).getNick().equals(nick) || ListaProveedores.get(i).getEmail().equals(email)){
             return true;
         
         }
     }
     return false;
     }
     
     
     public String[] obtenerDatosUsr(String nombre){
         ControladorUsuario cont = new ControladorUsuario();
         String[] datos = new String[6];
         if(cont.getTipo(nombre)=='c'){
             cliente cli = new cliente();
             cli=cont.SeleccionarCliente(nombre);
             datos[0]=cli.getNick();
             datos[1]=cli.getNombre();
             datos[2]=cli.getApellido();
             datos[3]=cli.getEmail();
             datos[4]="clientes";
             return datos;
         }
         else{
             Proveedor prov = new Proveedor();
             prov = cont.SeleccionarProv(nombre);
             datos[0]=prov.getNick();
             datos[1]=prov.getNombre();
             datos[2]=prov.getApellido();
             datos[3]=prov.getEmail();
             datos[4]="proveedor";
             datos[5]=prov.getLinkPagina();
             return datos;
                     
         }
         
     }
     
      public char getTipo(String nombre){
         getLista g = new getLista();
        ListaClientes = g.getListaCliente();
        ListaProveedores = g.getListaProveedor();
        for(int i = 0;i<ListaClientes.size();i++){
     
         if(ListaClientes.get(i).getNick().equals(nombre)){
             
             return 'c';
         }
         if(ListaProveedores.get(i).getNick().equals(nombre)){
             return 'p';
         
         }
         
        }
        return 'n';
     
     }
   
      public boolean validarUsr(String nick, String psw){
        //System.out.println(nick);
        //System.out.println(psw);
        getLista g = new getLista();
        ListaClientes = g.getListaCliente();
        for(int i = 0;i<ListaClientes.size();i++){
           // System.out.println(ListaClientes.get(i).getNombre());
            //System.out.println(ListaClientes.get(i).getContraseña());
            
                if(ListaClientes.get(i).getNick().equals(nick)){
                    if(ListaClientes.get(i).getContraseña().equals(psw)){
                        return true;
                        }
                    }    
                }
        
        getLista p = new getLista();
        ListaProveedores = p.getListaProveedor();
        for(int j=0; j<ListaProveedores.size();j++){
            //System.out.println(ListaProveedores.get(j).getNombre());
            if(ListaProveedores.get(j).getNick().equals(nick)){
                
                //System.out.println(nick);
                //System.out.println(psw);
                if(ListaProveedores.get(j).getContraseña().equals(psw)){
                    return true;
                }
            }
        }
        return false;
            
       }
      
}