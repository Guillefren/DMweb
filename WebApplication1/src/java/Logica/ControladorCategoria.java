
package Logica;
import java.util.*;
import Conexionbd.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Herobrine
 */
public class ControladorCategoria {
    private List<Compuesta> ListaCompuesta;
    private List<Hoja> ListaHoja;
    
   
    
    public void ControladorCategoria(){
        ListaCompuesta = new LinkedList();
        ListaHoja = new LinkedList();
        
    }
    
public List<DataHoja> ListarHojaConProd(){
        
    getLista gl = new getLista();
    ListaHoja = gl.getListaHojaConProd();
    List<DataHoja> DataListaHoja = new LinkedList();
    DataHoja dh = new DataHoja();
    for(int i=0; i<ListaHoja.size();i++){
         dh = ListaHoja.get(i).GetData();
         //dh=h.getData();
         DataListaHoja.add(dh);
     }
        return DataListaHoja;
            
    }
   // public List<DataHoja> ListarHojaConProd(){

public Hoja SeleccionarHoja(String nombre){
        
        getLista gl = new getLista();
        ListaHoja = gl.getListaHoja();
        
       //Iterator it = ListaHoja.iterator();
       
       for(int i=0; i<=ListaHoja.size();i++){
           Hoja h = new Hoja();
            //if(it instanceof Hoja){
                
                h = ListaHoja.get(i);
                if (nombre.equals(h.GetNombre())){
                    return h;
                }
            
            }
       
    
    return null;
    }


    public void AltaCategoria(String nombre, Boolean contieneProducto, String padre){
        if(contieneProducto){
            Hoja h = new Hoja();
            h.SetNombre(nombre);
            h.SetTipo('h');
            h.SetPadre(padre);
            
            agregar ag = new agregar();
            ag.agregarHoja(h);
        }
       

        else{
            Compuesta c = new Compuesta();
            c.SetNombre(nombre);
            c.SetTipo('c');
            if(padre!=null){
                c.SetPadre(padre);
                
            }
            else{
                c.SetPadre("Raiz");
                
            }
            agregar ag = new agregar();
                //System.out.println(c.GetPadre().GetNombre());

            
            
            
            ag.agregarCompuesta(c);
            
        }
    
    }

    public List<producto> ObtenerProductosCat(String cat){
    getLista g1 = new getLista();
    return g1.getProductosxCat(cat);
    }
    
    public Compuesta SeleccionarCompuesta (String nombre){
        getLista gl = new getLista();
        ListaCompuesta = gl.getListaCompuesta();
        
        for (int i=0; i<ListaCompuesta.size(); i++){
                if (ListaCompuesta.get(i).GetNombre().equals(nombre)){
                    return ListaCompuesta.get(i);
                 }
              }
        return null;
  
    }
    
    
    public List<DataCompuesta> ListarCompuestas(){
      
        getLista gl = new getLista();
        ListaCompuesta = gl.getListaCompuesta();
        List<DataCompuesta> dataListaCompuesta = new LinkedList();
        DataCompuesta dc = new DataCompuesta();
        Iterator it = ListaCompuesta.iterator();
        for(int i = 0;i < ListaCompuesta.size();i++){
            
                Compuesta c =ListaCompuesta.get(i);

                dc = c.GetData();
                dataListaCompuesta.add(dc);
           

        
        }
        return dataListaCompuesta;        
        
    }
    public List<DataHoja> ListarHojas(){
       
        getLista gl = new getLista();
        ListaHoja = gl.getListaHoja();
        List<DataHoja> dataListaHoja = new LinkedList();
        DataHoja dc = new DataHoja();
        //Iterator it = ListaHoja.iterator();
        for(int i = 0;i < ListaHoja.size();i++){
    
                Hoja c =ListaHoja.get(i);
 
                dc = c.GetData();
                dataListaHoja.add(dc);
    
    
        }
        return dataListaHoja;        
    }
    
 
    

    /*
      public List<DataCompuesta> ListarCompuestas(){
        getLista gl = new getLista();
        LinkedList<Compuesta> Compuesta = gl.getListaCliente2();
        List<DataCliente> DataListaClientes = new LinkedList();
        DataCliente dc = new DataCliente();
        for(int i=0; i<clientes.size(); i++){
            cliente cc = new cliente();
            cc = clientes.get(i);
            dc = cc.getData();
            DataListaClientes.add(dc);
        }
        return DataListaClientes;
// no se si esta devolviendo bien la lista 
}
    
    
    
    */
    
}
