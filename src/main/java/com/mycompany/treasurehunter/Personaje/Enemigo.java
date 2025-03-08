 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Personaje;

/**
 *
 * @author kenny
 */
public class Enemigo {
    
    private Jugador jugador;

    public Enemigo(Jugador jugador) {
        this.jugador = jugador;
    }
    private String nombreEnemigo;
    private int puntosHP;
    private int dañoEnemigo;
    
    public void generarEnemigos(){
        
    }
    
    private int calcularDañoEnemigo(){
        int daño = 15;
        return daño;
    }
}
