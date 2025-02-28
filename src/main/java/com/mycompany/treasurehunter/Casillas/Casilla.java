/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Jugador.Jugador;

/**
 *
 * @author kenny
 */
public abstract class Casilla {
    
    private Jugador jugador;
    private String nombre;
    private String colorCasilla;
    private int posicionX;
    private int posicionY;

    public Casilla(Jugador jugador, String nombre, String colorCasilla, int posicionX, int posicionY) {
        this.jugador = jugador;
        this.nombre = nombre;
        this.colorCasilla = colorCasilla;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    
    public abstract void efectoDeCasilla();
    
}
