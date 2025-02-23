/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_5_2;


import javax.swing.JFrame;

/**
 *Esta clase representa la lista simple
 * @author Juan Carlos Huerta Llamas
 * version Lab Algoritmos, Fecha de inicio: 2019.10.08
 * Fecha de finalizacion: 2019.10.29
 */
public class Lista<T> extends JFrame{
    Nodo<T> inicio;
    Square cuadrado;
    Square cuadrado2;
    public Lista(Nodo<T> inicio) {
        this.inicio = inicio;        
    }

    public Lista(){
        inicio=null;
        
    }
 
    /**
     * Inserta dato en el inicio
     * @param dato 
     */
    public void Insertainicio(Square dato){
       Nodo<T> n=new Nodo();
       n.setInfo(dato);
       n.setSig(inicio);
       inicio=n;
            
    }
    /**
     * Inserta dato hacia el final
     * @param dato 
     */
    public void InsertarFin(Square dato){
        Nodo<T> n=new Nodo();
        n.info=dato;
        if(inicio==null){
            n.sig=inicio;
            inicio=n;
        }else{
            Nodo<T> r=inicio;
            while(r.sig!=null){
                r=r.sig;
            }
            r.sig=n;
            n.sig=null;
        }
    }
    /**
     * Se inserta despues de un elemento que ya existe 
     * @param x
     * @param color
     * @return 
     */
    public boolean InsertardespuesX(String x, Square color){
        Nodo<T> prev= Busca(x);
        if(prev!=null){
            Nodo<T> n= new Nodo();
            n.setInfo(color);
            n.sig=prev.sig;
            prev.sig=n;
            return true;
        }else{
            System.out.println("No se encontro el color");
            return false;
        }
    }
    /**
     * Inserta en la posicion de la lista
     * @param dato
     * @param pos 
     */
    public void InsertarenPosicion(Square dato, int pos){
        if(pos<0){
            System.out.println("Posicion invalida");
            return;
        }else{
            Nodo<T> n= new Nodo();
            n.setInfo(dato);
            if(pos==0){
                n.sig=inicio;
                inicio=n;
            }else{
                Nodo<T> r;
                r=inicio;
                int cont=0;
                while(cont< pos-1){
                    r=r.sig;
                    cont++;
                }
                Nodo<T> act= r.sig;
                n.sig=act;
                r.sig=n;
                
            }
        }
    }
    
    /**
     * Busca un elemento de la lista y retorna su nodo, esto para el metodo
     * insertar despues
     * @param dato
     * @return 
     */
    public Nodo Busca(String dato){
        boolean bandera=false;
        int num=0;
        int cont=0;
        if(inicio==null){
            System.out.println("Vacia");
            return null;
        }else{
            Nodo<T> n=inicio;
            while(n!=null){
                if(n.getInfo().getColor().equals(dato)){
                    String cadena=n.getInfo().toString();
                    bandera=true;
                    return n;
                }
                n=n.getSig();
                cont++;
            }
            if(!bandera){
                System.out.println("No se encontro el elemento");
                return null;
            }else{
                 return n;
            }
            
        }
    }
    
    /**
     * Busca un elemento de la lista y retorna un valor booleano
     * @param dato
     * @return 
     */
    public boolean Busca2(String dato){
        boolean bandera=false;
        int num=0;
        int cont=0;
        if(inicio==null){
            System.out.println("Vacia");
            return false;
        }else{
            Nodo<T> n=inicio;
            while(n!=null){
                if(n.getInfo().getColor().equals(dato)){
                    String cadena=n.getInfo().toString();
                    bandera=true;
                    return true;
                }
                n=n.getSig();
                cont++;
            }
            if(!bandera){
                System.out.println("No se encontro el elemento");
                return false;
            }else{
                 return true;
            }
            
        }
    }
    /**
     * Elimina el inicio de la lista
     */
    public void eliminaInicio(){
        if(inicio ==null){
            System.out.println("Lista vacia");
        }else{
            inicio=inicio.sig;
        }
    }
    /**
     * Elimina el elemento en el fin de la lista
     */
    public void eliminaFin(){
        Nodo<T> r=null;
        Nodo<T> a=null;
        if (inicio==null){
            System.out.println("Lista Vacia");
        }else{
            if(inicio.sig==null){
                inicio=null;
            }else{
                r=inicio;
            }
            a=r;
        }
        while(r.sig!=null){
            a=r;
            r=r.sig;
        }
        a.sig=null;
    }
    
     
     
     /**
      * Elmina un elemento x
      * @param color 
      */
    public void Eliminaelemento(String color){ 
        Nodo n=inicio;
        Nodo r= new Nodo();
        boolean bandera=true;
        while(!n.getInfo().getColor().equalsIgnoreCase(color) &&  bandera==true){
            if(n.getSig()!=null){
                r=n;
                n=n.getSig();
            }else{
                bandera=false;
            }
        }
        if(bandera==false){
            System.out.println("Elemento no se encuentra en la lista");
        }else{
            if(inicio==n){
                inicio=n.getSig();
            }else{
                r.sig=n.sig;
            }
        }
    }
   /**
    * Imprime los elementos de la lista
    */ 
   public void Mostrar(){
        Nodo<T> n;
        n=inicio;
        if(inicio==null){
            System.out.println("Lista Vacia");
        }else{
            while(n!=null){
                System.out.println(n.getInfo());
                n=n.getSig();
            }
        }
   }
    /**
     * Obtiene el tamano de la lista
     * @return 
     */
    public int Tamano(){
        Nodo<T> n=new Nodo();
        n=inicio;
        int cont=-1;
         if(inicio==null){
            System.out.println("Lista Vacia");
            return cont;
        }else{
		while(n!=null){
                    cont++;
                    n=n.getSig();
                }
            return cont;    
        }
    }
    /**
     * Verifica si esta vacia
     * @return 
     */
    public boolean EstaVacia(){
        if(inicio==null){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Regresa el cuadrado en base a la posicion para que nos ayude a moverlo en
     * en la clase menu
     * @param pos
     * @return 
     */
    public Square ObtieneElementoPosicion(int pos){
        Square valor= new Square();
        if(pos<0){
            System.out.println("Posicion invalida");
            return null;
        }else{
            Nodo n= new Nodo();
            n=inicio;
            int cont=0;
            while(n!=null){
                if(cont==pos){
                    valor= n.getInfo();
                    
                }
                cont++;
                n=n.getSig();
            }    
            }
        return valor;
    }
    /**
     * Elimina el elemento en base a la posicion, solo se ocupara borrar el nodo
     * que siempre suele ser color negro
     * @param pos 
     */
    public void eliminaPosicion(int pos){
        if(pos <0){
            System.out.println("Es menor a cero");
        }else{
            if(pos==0){
                Nodo<T> temp=inicio;
                inicio=inicio.sig;
                temp.sig=null;
            }else{
                Nodo<T> r=inicio;
                int cont=0;
                while(cont<pos-1){
                    r=r.sig;
                    cont++;
                }
                Nodo<T> act=r.sig;
                r.sig=act.sig;
                act.sig=null;
            }
        }
    }
    
    @Override
    public String toString() {
        return "Lista{" + "inicio=" + inicio + '}';
    }
    
    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }
    
    
}
