/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class CasillaTesoro extends Casilla {

    public CasillaTesoro(Jugador jugador, Mapa mapa) {
        super(jugador, "Casilla Tesoro",mapa);
    }

    @Override
    public void modificarCasilla() {
    }

    @Override
    public void menuDeModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void efectoDeCasillaNormal() {
        System.out.println("EnhoraBuena has encontrado el tesoro");
    }

    @Override
    public void efectoDeCasillaModificado() {
        
    }

    @Override
    public void aplicarEfecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
