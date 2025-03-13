/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Personaje;

import java.util.Random;

/**
 *
 * @author kenny
 */
public abstract class Personaje {

    private String nombre;
    private int hp;
    private int ataque;

    public Personaje(String nombre, int hp, int ataque) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
    }
    
    /**
     * Metodo encargado de recibir dos numeros y aleatorizarlos
     * @param min es el minimo en el intervalor entre los dos numeros
     * @param max es el maximo en el intervalo entre los dos numeros
     * @return retorna un numero aleatorio entre los numeros obtenidos de <code>max</code> y <code>min</code>
     */
    protected int calcularNumerosRandom(int min, int max){
        Random random = new Random();
        int numeroRandom = random.nextInt(min, max);
        return numeroRandom;
    }
    
    //Metodo abstracto encargado de aplicar el ataque del personaje a uno de los dos objetivos 
    public abstract void aplicarAtaque(Personaje objetivo);
}
