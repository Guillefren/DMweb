/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

/**
 *
 * @author Herobrine
 */
public class DataHoja {
    
    private String nombre;
    private String padre;
    private char tipo;
    
    public void DataHoja(){
        this.nombre=null;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    public void DataHoja(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }
    
    



}
