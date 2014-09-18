/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

  
/**
 *
 * @author Agustin
 */
public class Especificacion {
    private List<String> listEsp;
    private producto prod;
    
    public Especificacion(){
    
    listEsp = new LinkedList();
    prod = null;
    
    }
    public void Especificacion(List<String> lesp){
        this.listEsp = lesp;
        
    }
    
    public List<String> getListaEspecificaciones(){
        return this.listEsp;
       
    }

    public List<String> getListEsp() {
        return listEsp;
    }

    public void setListEsp(List<String> listEsp) {
        this.listEsp = listEsp;
    }

    public producto getProd() {
        return prod;
    }

    public void setProd(producto prod) {
        this.prod = prod;
    }
    
    public void agregarEspecificacion(String esp){
        this.listEsp.add(esp);
          
    }
    public void setLista(List<String> l){
    this.listEsp = l;
    }
    
}
