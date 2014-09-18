
package Logica;

/**
 *
 * @author Herobrine
 */
abstract class Categoria {
    private String Nombre;
    private Compuesta Padre;
    private char tipo;
    
    

    public void Categoria(){
        this.Nombre = null;
        this.tipo = '-';
        this.Padre = null;
    
    }
    
    public void SetNombre(String nombre){
        this.Nombre = nombre;
    }
    
    public void SetTipo (char tipo){
        this.tipo = tipo;
    }
    
    public String GetNombre(){
        
        return this.Nombre;
        
        }

    public char GetTipo(){
        return this.tipo;
    }

    public void SetPadre(String nombre){
        ControladorCategoria cont = new ControladorCategoria();
        this.Padre = cont.SeleccionarCompuesta(nombre);
    }
    
    public Compuesta GetPadre(){
        return this.Padre;
    }
    
}
