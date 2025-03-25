/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Personaje.Jugador;
import java.io.Serializable;


/**
 *
 * @author kenny
 */
public abstract class Casilla implements Serializable {
    
    protected Jugador jugador;
    protected Mapa mapa;
    private String nombre;
    private boolean casillaModificada;
    private final ControladorMetodos controlador;

    public Casilla(Jugador jugador, String nombre, Mapa mapa) {
        this.jugador = jugador;
        this.nombre = nombre;
        this.mapa = mapa;
        this.casillaModificada = false;
        this.controlador = new ControladorMetodos();
    }
    
    
    public abstract void modificarCasilla();
    public abstract void menuDeModificacion();
    public abstract void efectoDeCasillaNormal();
    public abstract void efectoDeCasillaModificado();
    public abstract void aplicarEfecto();
    
    
 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean isCasillaModificada() {
        return casillaModificada;
    }

    public void setCasillaModificada(boolean casillaModificada) {
        this.casillaModificada = casillaModificada;
    }

    public ControladorMetodos getControlador() {
        return controlador;
    }

    public Mapa getMapa() {
        return mapa;
    }
    
    

}
