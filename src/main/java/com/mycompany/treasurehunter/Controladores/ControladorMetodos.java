/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Controladores;

import java.util.Random;

/**
 *
 * @author kenny
 */
public class ControladorMetodos {
    
    private static final Random random = new Random();
    
    /**
     * Metodo encargado de producir un numero aleatorio entre un rango. Se puede 
     * instanciar este metodo desde cualquier clase.
     * @param min recibe como parametro un numero minimo de un intervalo
     * @param max recibe como parametro un numero maximo de un intervalo
     * @return un numero aleatorio entre el intervalo de <code> min </code> y <code> max </code>  
     */
    public int calcularNumerosAleatorios(int min, int max){
        int numeroAleatorio = random.nextInt(min, max);
        return numeroAleatorio;
    }
    
    /**
     * Metodo encargado de aleatorizar una variable booleana 
     * @return aleatorizamente un true o un false que nos sirve para otras clases
     */
    public boolean opcionesActivas(){
        boolean opcionActiva = random.nextBoolean();
        return opcionActiva;
    }
    
    //Metodo creado con el proposito de ir limpiando la consola mediante un flush
    public void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
