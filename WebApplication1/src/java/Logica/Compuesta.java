package Logica;
import java.util.*;
/**
 *
 * @author Herobrine
 */
public class Compuesta extends Categoria {
    
    public DataCompuesta GetData(){
        DataCompuesta dc = new DataCompuesta();
        dc.SetNombre(this.GetNombre());
        dc.SetTipo('t');
        return dc;
    }
}