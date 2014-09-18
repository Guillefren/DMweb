/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;
import java.util.*;

/**
 *
 * @author Agustin
 */

import Conexionbd.getLista;

/**
*
* @author Agustin
*/
public class OrdenDeCompra {
    
    private int numero;
    private Date fecha;
    private Money precioTotal;
    private cliente cliente;
    private List<producto> lproducto;


public OrdenDeCompra(){
    this.lproducto = new LinkedList();
    this.cliente = null;
}
public List<producto> getLproducto() {
    return lproducto;
}
public void setLproducto(List<producto> lprod) {
    this.lproducto = lprod;
}
public int getNumero() {
    return numero;
}
public Date getFecha() {
    return fecha;
}
public Money getPrecioTotal() {
    return precioTotal;
}
public cliente getCliente() {
    return cliente;
}
public void setCliente(cliente cliente) {
    this.cliente = cliente;
}

public void setNumero(int num){
    this.numero = num;
}
public void setFecha(Date fec){
    this.fecha = fec;
}
public void setPrecioTotal(Money pre){
    this.precioTotal = pre;
}
public DataOrdenDeCompra getData(){
    DataOrdenDeCompra odc = new DataOrdenDeCompra();
    odc.setDatos(numero, fecha, precioTotal);
    return odc;
}

}