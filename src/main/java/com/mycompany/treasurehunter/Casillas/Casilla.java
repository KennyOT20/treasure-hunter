/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Personaje.Jugador;
import java.io.Serializable;

/**
 *
 * @author kenny
 */
public abstract class Casilla implements Serializable {
    
    protected Jugador jugador;
    private String nombre;
    private int posicionX;
    private int posicionY;

    public Casilla(Jugador jugador, String nombre, int posicionX, int posicionY) {
        this.jugador = jugador;
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    
    public abstract void efectoDeCasilla();
    public abstract void modificarCasilla();
}
