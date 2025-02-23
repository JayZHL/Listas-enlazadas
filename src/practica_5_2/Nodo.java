/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_5_2;

/**
 *La clase que representa el Nodo
 * @author Juan Carlos Huerta Llamas
 * version Lab Algoritmos, Fecha de inicio: 2019.10.08
 * Fecha de finalizacion: 2019.10.29
 */
public class Nodo<T> {
    Square info;
    Nodo<T> sig;

    public Nodo(Square info, Nodo sig) {
        this.info = info;
        this.sig = sig;
    }
    
    public Nodo(){
        info=null;
        sig=null;
    }

    public Square getInfo() {
        return info;
    }


    public void setInfo(Square info) {
        this.info = info;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "Nodo{" + "info=" + info + ", sig=" + sig + '}';
    }
    
    
}

