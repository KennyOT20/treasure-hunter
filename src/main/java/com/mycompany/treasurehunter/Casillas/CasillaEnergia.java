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
public class CasillaEnergia extends Casilla {

    public CasillaEnergia(Jugador jugador, String nombre, int posicionX, int posicionY) {
        super(jugador, nombre, posicionX, posicionY);
    }

    @Override
    public void efectoDeCasilla() {
     
    }

    @Override
    public void modificarCasilla() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
