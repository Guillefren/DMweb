package Logica;

/**
 *
 * @author Herobrine
 */
public class DataCompuesta {
    private String nombre;
    private char tipo;
    
    public void DataCompuesta(){
        this.nombre = null;
    }
    
    public void SetNombre(String nombre){
        this.nombre = nombre;
           
    }
    
    public String GetNombre(){
        return this.nombre;
    }
    
    public void SetTipo(char t){
        this.tipo=t;
    
    }
    
    public char GetTipo(){
        return this.tipo;
    }
    
    
    
}
