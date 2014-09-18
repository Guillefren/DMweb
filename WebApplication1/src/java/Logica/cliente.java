/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;
import Conexionbd.*;
import java.util.*;

/**
 *
 * @author Agustin
 */
public class cliente extends Usuario{
        private List<OrdenDeCompra> listaordenes;
        private List<Comentario> listacomentarios;
        
   public cliente(){
       listaordenes = new LinkedList();
       listacomentarios = new LinkedList();
    }

    public List<OrdenDeCompra> getListaordenes() {
        return listaordenes;
    }

    public void setListaordenes(List<OrdenDeCompra> listaordenes) {
        this.listaordenes = listaordenes;
    }

    public List<Comentario> getListacomentarios() {
        return listacomentarios;
    }

    public void setListacomentarios(List<Comentario> listacomentarios) {
        this.listacomentarios = listacomentarios;
    }
    
   public void addComentario(Comentario c){
   agregar ag = new agregar();
  ag.agregarComentario(c);
        
   }

  public void ComentarProducto(Comentario c, producto p){
  
  Comentario cc = new Comentario();
  cc = c;
  cc.setProducto(p);
 
  agregar ag = new agregar();
  ag.agregarComentario(cc);
  
  }
   
   public void setDatos(String nick, String nombre, String apellido, String email, Date fnac, String Imagen,String contra){
        this.apellido = apellido;
        this.email = email;
        this.imagen = Imagen;
        this.nick = nick;
        this.nombre = nombre;
        this.fnac = fnac;   
        this.contraseña = contra;
   }
   public cliente(String ni,String nom, String ap){
        
       this.nick = ni;
       this.nombre = nom;
       this.apellido = ap;
       listaordenes = new LinkedList();
   }
   public void agregarCli(cliente cli){
       
       agregar ag = new agregar();
       ag.agregarcliente(cli);
   }
   
    public DataCliente getData(){
            DataCliente dc = new DataCliente();
             
            dc.setDatos(nick, nombre, apellido, email, fnac, imagen);
   return dc;
   }
    
    public void CrearOrden(Date fecha,List<ProductosOrdenCompra> prods){
        double ptotal = 0;
        ControladorProductoyEspecificaciones cpe = new ControladorProductoyEspecificaciones();
        for (int i = 0;i < prods.size();i++){
            producto p = cpe.SeleccionarProducto(prods.get(i).getProducto());
            double pparcial = p.getPrecio().getValor()*prods.get(i).getCantidad();
            ptotal = ptotal+pparcial;
        }
        Money pt = new Money();
        pt.setValor(ptotal);
        getLista gl = new getLista();
        agregar a = new agregar();
        OrdenDeCompra oc = new OrdenDeCompra();
        oc.setFecha(fecha);
        oc.setNumero(gl.getMaxNumOrdenCompra()+1);
        oc.setPrecioTotal(pt);
        a.agregarOrden(oc, prods, nick);
    }
    
public void addOrden(OrdenDeCompra o){

    this.listaordenes.add(o);

}
  
public void EliminarOrdenCompra(OrdenDeCompra o){


}
   
}
