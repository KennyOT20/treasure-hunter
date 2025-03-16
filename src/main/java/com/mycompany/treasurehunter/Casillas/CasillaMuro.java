/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class CasillaMuro extends Casilla {

    public CasillaMuro(Jugador jugador, String nombre, String simboloCasilla, int posicionX, int posicionY) {
        super(jugador, nombre, simboloCasilla, posicionX, posicionY);
    }

    @Override
    public void efectoDeCasilla() {
        int coordenadaInicialY = jugador.getPosicionY();
        int coordenadaInicialX = jugador.getPosicionX();
        
        
    }

    @Override
    public void modificarCasilla() {
        System.out.println("Esta casilla no se puede modificar :( ");  
    }
    
}
