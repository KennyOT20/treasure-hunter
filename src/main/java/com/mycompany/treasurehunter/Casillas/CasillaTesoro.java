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
public class CasillaTesoro extends Casilla {
    

    
    public CasillaTesoro(Jugador jugador, String nombre, String simboloCasilla, int posicionX, int posicionY) {
        super(jugador, nombre, simboloCasilla, posicionX, posicionY);
    }

    @Override
    public void efectoDeCasilla() {
        
        System.out.println("Enhorabuena, has logrado encontrar el tesoro");
        boolean partidaGanada = true;
        jugador.setTesoroEncontrado(partidaGanada);
    }

    @Override
    public void modificarCasilla() {
    }
   
    
}
