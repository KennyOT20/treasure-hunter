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
public class CasillaCombate extends Casilla {

    public CasillaCombate(Jugador jugador, String nombre, String colorCasilla, int posicionX, int posicionY) {
        super(jugador, nombre, colorCasilla, posicionX, posicionY);
    }

    @Override
    public void efectoDeCasilla() {
    }
    
}
