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
public class CasillaMuro extends Casilla {

    public CasillaMuro(Jugador jugador, Mapa mapa) {
        super(jugador, "Casilla Muro", mapa );
    }

    @Override
    public void efectoDeCasillaNormal() {
        jugador.setPosicionX(jugador.getPosicionAnteriorX());
        jugador.setPosicionY(jugador.getPosicionAnteriosY());
        System.out.println("Te has topado una roca, busca otro camino");
        
    }

    @Override
    public void modificarCasilla() {
    }

    @Override
    public void menuDeModificacion() {

    }

    @Override
    public void efectoDeCasillaModificado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aplicarEfecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
