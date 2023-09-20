/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hilosadivinosdenumeros;

import java.util.logging.Level;
import java.util.logging.Logger;


public class HilosAdivinosDeNumeros  {

    private static final int NUM_HILOS = 100;
    
    
    public static void main(String[] args) {
        //el recurso compartido
        NumeroOculto oculto = new NumeroOculto();
        
        //vemos el numero que hay que adivinar 
        System.out.println("El numero a adivinar es el "+ oculto.getNumOculto());
        Thread[] hilos = new Thread[NUM_HILOS];

        //se ejecuta tantas veces como numero de hilos queremos que se genere
        for (int i = 0; i < NUM_HILOS; i++) {
            Thread h = new Thread();

            h.start();
            hilos[i] = h;

            int num = (int) (Math.random() * 100 + 1);
            System.out.println("El hilo " + i + " genera el numero " + num);
            
            //utilizamos un switch puesto que en este caso es mejor para ver si
            //el relutado es -1,1 o 0 relacionados con la clase NuemroOculto
            
            switch (oculto.propuestaNuemro(num)) {
                case -1:
                   System.out.println("\t\t --!Los numeros han coincidio!--");
                return ;
                //Si entra en este caso saldra sin terminar de crearel resto de hilos
                case 1:
                     System.out.println("\t NO SE HAN ADIVINADO EL NUMERO OCULTO");
                    break;
                default:
                    System.out.println("\t Ha sucedido algo inesperado");
                    break;
            }
            try {
                h.join();
                } catch (InterruptedException ex) {
                Logger.getLogger(HilosAdivinosDeNumeros.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }
    }

}
