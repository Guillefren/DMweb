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
public class DataOrdenDeCompra {
private int numero;
private Date fecha;
private Money precioTotal;
private List<producto> prod;
private String NickCli;
private String NombreCliente;


public List<producto> getProd() {
return prod;
}
public void setProd(List<producto> prod) {
this.prod = prod;
}

public Date getFecha() {
return fecha;
}
public void setFecha(Date fecha) {
this.fecha = fecha;
}
public Money getPrecioTotal() {
return precioTotal;
}
public void setPrecioTotal(Money precioTotal) {
this.precioTotal = precioTotal;
}

public void DataOrdenDeCompra(){
numero = 0;
fecha = null;
precioTotal = null;
NickCli = "-";
NombreCliente = "-";

}

    public String getCli() {
        return NickCli;
    }

    public void setCli(String Cli) {
        this.NickCli = Cli;
    }
public int getNumero(){
return numero;
};
public void setNumero(int num){
this.numero = num;
}
public void setDatos(int num, Date fec, Money pre){
this.numero = num;
this.fecha = fec;
this.precioTotal = pre;
}

   

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }




}