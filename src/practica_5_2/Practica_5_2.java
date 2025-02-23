/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_5_2;

import java.util.Scanner;

/**
 *Clase principal en donde representamos una lista graficamente
 * @author Juan Carlos Huerta Llamas
 * version Lab Algoritmos, Fecha de inicio: 2019.10.08
 * Fecha de finalizacion: 2019.10.29
 */
public class Practica_5_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu= new Menu();
        char op;
        String elemento,color;
        Scanner scanner= new Scanner(System.in);
        Scanner scannerletras = new Scanner(System.in);
        Scanner scannerletras2= new Scanner(System.in);
        do{
            System.out.println("a. Insertar de un elemento nuevo después de uno existente (El usuario\n" +
                    "captura desde el teclado el nuevo elemento a insertar, así como el\n" +
                    "elemento después del que lo insertará).");
            System.out.println("b. Insertar un nuevo elemento al inicio");
            System.out.println("c. Insertar un nuevo elemento al final");
            System.out.println("d. Eliminar un elemento que el usuario captura desde el teclado");
            System.out.println("e. Eliminar el primer elemento");
            System.out.println("f. Eliminar el último elemento");
            System.out.println("g. Mostrar el contenido de la lista.");
            System.out.println("h. Salir");
            
            op=scanner.next().charAt(0);
            switch(op){
                case 'a':
                    System.out.println("Ingrese el color a insertar despues: ");
                    elemento=scannerletras.nextLine();
                    System.out.println("Ingrese el color nuevo: ");
                    color=scannerletras2.nextLine();
                    menu.InsertardespuesX(elemento, color);
                    break;
                case 'b':
                    System.out.println("Ingrese el color nuevo: ");
                    color=scannerletras.nextLine();
                    menu.InsertarInicio(color);
                    break;
                case 'c':
                    System.out.println("Ingrese el color nuevo: ");
                    color=scannerletras.nextLine();
                    menu.InsertarFinal(color);
                    break;
                case 'd':
                    System.out.println("Ingrese el color a eliminar: ");
                    color=scannerletras.nextLine();
                    menu.EliminaElemento(color);
                    break;
                case 'e':
                    System.out.println("Eliminando primero: ");
                    menu.EliminaPrimero();
                    break;
                case 'f':
                    System.out.println("Eliminando ultimo: ");
                    menu.EliminaUltimo();
                    break;
                case 'g':
                    System.out.println("Mostrando: ");
                    menu.Mostrar();
                    break;
                case 'h':
                    System.out.println("Saliendo");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(op!='h');
        
    }
    
}
