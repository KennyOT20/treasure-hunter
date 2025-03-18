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
public class CasillaPista extends Casilla {
    
    private String[] pistas ={ "El tesoro se encuentra arriba por la izquierda o por la derecha...",
        "Estas casi cerca, solo te falta regresar por donde estabas",
        "Casi lo encuentras...",
        "Estas muy lejos, la proxima agarra otro camino"
    };

    public CasillaPista(Jugador jugador, String nombre, String simboloCasilla, int posicionX, int posicionY) {
        super(jugador, nombre, simboloCasilla, posicionX, posicionY);
    }

    

    @Override
    public void efectoDeCasilla() {
        
    }

    @Override
    public void modificarCasilla() {
          }
    
}
