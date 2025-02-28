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
public class CasillaNormal extends Casilla{
    
    private static final String COLOR_BlANCO = "\\u001B[47m";
    public CasillaNormal(Jugador jugador, String nombre, String colorCasilla, int posicionX, int posicionY) {
        super(jugador, nombre, colorCasilla, posicionX, posicionY);
    }

   

    @Override
    public void efectoDeCasilla() {
        System.out.println("Casilla normal, puedes seguir avanzando");

    }
    
}
