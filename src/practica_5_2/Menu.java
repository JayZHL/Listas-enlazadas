/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_5_2;

import javax.swing.JFrame;

/**
 *En esta clase se maneja graficamente la lista
 * @author Juan Carlos Huerta Llamas
 * version Lab Algoritmos, Fecha de inicio: 2019.10.08
 * Fecha de finalizacion: 2019.10.29
 */
public class Menu<T> extends JFrame{
    Square cuadrado;
    Square cuadrado2;
    Circle circulo;
    Lista<Square> lista= new Lista();
    Lista<Square> lista2= new Lista();
    public Menu() {
        circulo=new Circle(50,100,100,"negro",true);
        circulo.makeVisible();

    }
    /**
     * Inserta al inicio de la lista
     * @param color 
     */
    public void InsertarInicio(String color){
        boolean existe=Compruebacolores(color);
        if(existe){
         if(lista.EstaVacia()){
           cuadrado= new Square(50,100,100,color,true);
           cuadrado2=new Square(50,130,100,"negro",true);
           lista.Insertainicio(cuadrado);
           lista2.Insertainicio(cuadrado2);
            cuadrado2.slowMoveHorizontal(130);
           cuadrado.slowMoveHorizontal(100);
       }else{
            boolean bandera=Compruebaelemento(color);
           if(!bandera){  
           int cont=lista.Tamano();
           do{
              lista2.ObtieneElementoPosicion(cont).slowMoveHorizontal(150);
              lista.ObtieneElementoPosicion(cont).slowMoveHorizontal(150);
               cont--;
           }while(cont>=0);
           cuadrado= new Square(50,100,100,color,true);
           cuadrado2=new Square(50,130,100,"negro",true);
           cuadrado2.slowMoveHorizontal(130);
           cuadrado.slowMoveHorizontal(100);
           lista.Insertainicio(cuadrado);
           lista2.Insertainicio(cuadrado2);
           }else{
               System.out.println("Ya existe el elemento");
           }
       }
        }else{
            System.out.println("No existe el color");
        }
    }
    /**
     * Inserta al final de lista
     * @param color 
     */
    public void InsertarFinal(String color){
        boolean existe=Compruebacolores(color);
        int cont;
        if(existe){
        if(lista.EstaVacia()){
           cuadrado= new Square(50,100,100,color,true);
           cuadrado2=new Square(50,130,100,"negro",true);

           cuadrado2.slowMoveHorizontal(130);
           cuadrado.slowMoveHorizontal(100);
           lista.Insertainicio(cuadrado);
           lista2.Insertainicio(cuadrado2);
        }else{
            boolean bandera=Compruebaelemento(color);
            if(!bandera){
             if(lista.Tamano()==1){
             cont=lista.Tamano();
             cuadrado= new Square(lista.ObtieneElementoPosicion(cont).getSize(),
                     lista.ObtieneElementoPosicion(cont).getxPosition(),lista.ObtieneElementoPosicion(cont).getyPosition(),
                     color,true);
             cuadrado2= new Square(lista2.ObtieneElementoPosicion(cont).getSize(),
                     lista2.ObtieneElementoPosicion(cont).getxPosition(),lista2.ObtieneElementoPosicion(cont).getyPosition(),
                     lista2.ObtieneElementoPosicion(cont).getColor(),true);
            cuadrado2.slowMoveHorizontal(150);
           cuadrado.slowMoveHorizontal(150);
           lista.InsertarFin(cuadrado);
           lista2.InsertarFin(cuadrado2);
             }else{
                    cont=lista.Tamano();
                    cuadrado= new Square(lista.ObtieneElementoPosicion(cont).getSize(),
                        lista.ObtieneElementoPosicion(cont).getxPosition(),lista.ObtieneElementoPosicion(cont).getyPosition(),
                        color,true);
                    cuadrado2= new Square(lista2.ObtieneElementoPosicion(cont).getSize(),
                     lista2.ObtieneElementoPosicion(cont).getxPosition(),lista2.ObtieneElementoPosicion(cont).getyPosition(),
                     lista2.ObtieneElementoPosicion(cont).getColor(),true);
                    cuadrado2.slowMoveHorizontal(150);
                    cuadrado.slowMoveHorizontal(150);
                    lista.InsertarFin(cuadrado);
                    lista2.InsertarFin(cuadrado2);
             }
            }else{
                System.out.println("Ya existe el elemento");
            }   
        }
        }else{
            System.out.println("No existe el color");
        }
    }
    /**
     * Inserta despues de un elemento de la lista
     * @param x
     * @param color 
     */
    public void InsertardespuesX(String x, String color ){
        boolean existe=Compruebacolores(color);
        if(existe){
        if(lista.EstaVacia()){
           cuadrado= new Square(50,100,100,color,true);
           cuadrado2=new Square(50,130,100,"negro",true);
           cuadrado2.slowMoveHorizontal(130);
           cuadrado.slowMoveHorizontal(100);
           lista.Insertainicio(cuadrado);
           lista2.Insertainicio(cuadrado2);
        }else{
            boolean comprueba=Compruebaelemento(color);
            boolean bandera=lista.Busca2(x);
            if(!comprueba){
            if(bandera){
                int cont=lista.Tamano();
                boolean bandera2=false;
                do{
                    if(lista.ObtieneElementoPosicion(cont).getColor().equalsIgnoreCase(x)){
                        bandera2=true;
                        cuadrado= new Square(50,lista.ObtieneElementoPosicion(cont).getxPosition(),
                                lista.ObtieneElementoPosicion(cont).getyPosition(),color,true);
                        cuadrado2= new Square(50,lista2.ObtieneElementoPosicion(cont).getxPosition(),
                                lista2.ObtieneElementoPosicion(cont).getyPosition(),"negro",true);
                        cuadrado.slowMoveHorizontal(150);
                        cuadrado2.slowMoveHorizontal(150);
                        lista.InsertardespuesX(x, cuadrado);
                        lista2.InsertarenPosicion(cuadrado2, cont);
                    }else{
                    
                        lista2.ObtieneElementoPosicion(cont).slowMoveHorizontal(150);
                        lista.ObtieneElementoPosicion(cont).slowMoveHorizontal(150);
                    }
                    
                    cont--;
                }while(bandera2==false);
            }
            }else{
                System.out.println("Ya existe el elemento");
            }
        }
        }else{
            System.out.println("No existe el color");
        }
    }
    /**
     * Elimina el primer elemento de la lista
     */
    public void EliminaPrimero(){
        if(lista.EstaVacia()){
            System.out.print("Lista Vacia");
        }else{
            lista.getInicio().getInfo().slowMoveVertical(-100);
            lista.getInicio().getInfo().erase();
            lista2.getInicio().getInfo().slowMoveVertical(-130);
            lista2.getInicio().getInfo().erase();
            lista.eliminaInicio();
            lista2.eliminaInicio();
            
             int cont=0;
            do{
                lista.ObtieneElementoPosicion(cont).slowMoveHorizontal(-150);
                lista2.ObtieneElementoPosicion(cont).slowMoveHorizontal(-150);
                cont++;
            }while(cont<=lista.Tamano());
        }
    }
    /**
     * Elimina el ultimo elemento de la lista
     */
    public void EliminaUltimo(){
        if(lista.EstaVacia()){
            System.out.print("Lista Vacia");
        }else{
            lista2.ObtieneElementoPosicion(lista2.Tamano()).slowMoveHorizontal(100);
            lista2.ObtieneElementoPosicion(lista2.Tamano()).erase();
            lista.ObtieneElementoPosicion(lista.Tamano()).slowMoveHorizontal(100);
            lista.ObtieneElementoPosicion(lista.Tamano()).erase();
            lista.eliminaFin();
            lista2.eliminaFin();
        }
    }
    /**
     * Elimina un elemento x de la lista
     * @param color 
     */
    public void EliminaElemento(String color){
        if(lista.EstaVacia()){
            System.out.print("Lista Vacia");
        }else{
            boolean bandera=lista.Busca2(color);
            if(bandera){
                int cont=0;
                boolean bandera2=false;
                do{
                    if(lista.ObtieneElementoPosicion(cont).getColor().equalsIgnoreCase(color)){
                        bandera2=true;
                        lista2.ObtieneElementoPosicion(cont).slowMoveVertical(-100);
                        lista2.ObtieneElementoPosicion(cont).erase();
                        lista.ObtieneElementoPosicion(cont).slowMoveVertical(-100);
                        lista.ObtieneElementoPosicion(cont).erase();
                        lista.Eliminaelemento(color);
                        lista2.eliminaPosicion(cont);
                    }
                    if(bandera2){
                        
                        lista.ObtieneElementoPosicion(cont).slowMoveHorizontal(-150);
                        lista2.ObtieneElementoPosicion(cont).slowMoveHorizontal(-150);
                    }
                    cont++;
                }while(cont<=lista.Tamano());
            }
        }
    }
    /**
     * Muestra los elementos de la lista
     */
    public void Mostrar(){
        lista.Mostrar();
    }
    /**
     * Imprime el tamano de la lista
     */
    public void Tamano(){
         System.out.print(lista.Tamano());
    }
    /**
     * Comprueba si elelemento ya existe
     * @param color
     * @return 
     */
    public boolean Compruebaelemento(String color){
        boolean bandera=false;
        for(int i=0; i<=lista.Tamano();i++){
            if(lista.ObtieneElementoPosicion(i).color.equalsIgnoreCase(color)){
                bandera=true;
            }
        }
        if(bandera){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Comprueba los colores existentes
     * @param color
     * @return 
     */
    public boolean Compruebacolores(String color){
        if(color.equalsIgnoreCase("rojo")||color.equalsIgnoreCase("verde")
                ||color.equalsIgnoreCase("amarillo")||color.equalsIgnoreCase("azul")
            ||color.equalsIgnoreCase("negro")||color.equalsIgnoreCase("blanco")||
                color.equalsIgnoreCase("magenta")|| color.equalsIgnoreCase("naranja")
                || color.equalsIgnoreCase("rosa")||color.equalsIgnoreCase("gris")
                ||color.equalsIgnoreCase("cian")||color.equalsIgnoreCase("cafe")){
                return true;
            }else{
            return false;
        }
    }
}

