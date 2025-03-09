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
    
    protected int nombre;
    protected int hpMax;
    protected int ataque;

    public Personaje(int nombre, int hpMax, int ataque) {
        this.nombre = nombre;
        this.hpMax = hpMax;
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
    
    public abstract void aplicarAtaque();
}
