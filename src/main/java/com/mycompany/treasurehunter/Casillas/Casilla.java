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
    private String simboloCasilla;
    private int posicionX;
    private int posicionY;

    public Casilla(Jugador jugador, String nombre, String simboloCasilla, int posicionX, int posicionY) {
        this.jugador = jugador;
        this.nombre = nombre;
        this.simboloCasilla = simboloCasilla;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    
    public abstract void efectoDeCasilla();
    public abstract void modificarCasilla();
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimboloCasilla() {
        return simboloCasilla;
    }

    public void setSimboloCasilla(String simboloCasilla) {
        this.simboloCasilla = simboloCasilla;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }


    
}
