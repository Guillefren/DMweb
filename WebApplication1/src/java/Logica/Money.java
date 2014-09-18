/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

/**
 *
 * @author Agustin
 */
public class Money {

    private double valor;
    private String tipo;
    
    public void Money(){
      valor = 0;
      tipo = null;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {

        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
