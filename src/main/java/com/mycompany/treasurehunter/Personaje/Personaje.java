/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Personaje;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author kenny
 */
public abstract class Personaje implements Serializable{
    
    private String nombrePersonaje;
    private int vidaPersonaje;
    private int vidaMaxPersonaje;
    private int ataquePersonaje;

    public Personaje(String nombrePersonaje, int vidaPersonaje, int vidaMaxPersonaje, int ataquePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
        this.vidaPersonaje = vidaPersonaje;
        this.vidaMaxPersonaje = vidaMaxPersonaje;
        this.ataquePersonaje = ataquePersonaje;
    }

    /**
     * Metodo encargado de recibir el ataque del personaje segun el turno de cada personaje
     * puede ser usado para tanto para el jugador o para el enemigo
     * Se encarga de realizar la validacion para que la vida del personaje no sea menor que cero
     * @param ataque recibe el ataque del jugador o del enemigo para poder aplicar el daño
     */
    protected void recibirAtaque(int ataque){
         
        vidaPersonaje -= ataque;
        
        if (vidaPersonaje <= 0){
            vidaPersonaje = 0;
        } else{
            System.out.println();
        }
    }
    
    /**
     * Metodo abstracto encargado de realizar el ataque ya sea del enemigo o del jugador.
     * @param objetivo 
     */
    public abstract void aplicarAtaque(Personaje objetivo);
    
    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public int getVidaPersonaje() {
        return vidaPersonaje;
    }

    public void setVidaPersonaje(int vidaPersonaje) {
        this.vidaPersonaje = vidaPersonaje;
    }

    public int getVidaMaxPersonaje() {
        return vidaMaxPersonaje;
    }

    public void setVidaMaxPersonaje(int vidaMaxPersonaje) {
        this.vidaMaxPersonaje = vidaMaxPersonaje;
    }

    public int getAtaquePersonaje() {
        return ataquePersonaje;
    }

    public void setAtaquePersonaje(int ataquePersonaje) {
        this.ataquePersonaje = ataquePersonaje;
    }
    
}
