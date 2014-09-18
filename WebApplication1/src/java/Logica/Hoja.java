package Logica;
import java.util.*;
/**
 *
 * @author Herobrine
 */
public class Hoja extends Categoria {
    
    private List<producto> Listaproductos;
    
    
    public Hoja(){
    
    Listaproductos = new LinkedList();
    }

    public List<producto> getListaproductos() {
        return Listaproductos;
    }

    public void setListaproductos(List<producto> Listaproductos) {
        this.Listaproductos = Listaproductos;
    }
    public DataHoja GetData(){
        DataHoja dc = new DataHoja();
        dc.setNombre(this.GetNombre());
        dc.setTipo('h');
        
        return dc;
    }
    
    
    
    
    
}
