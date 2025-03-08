/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Personaje.Jugador;
import java.util.Random;

/**
 *
 * @author kenny
 */
public class CasillaTeletransporte extends Casilla {
    
    private int nuevaCoordenadaX;
    private int nuevaCoordenadaY;
    
    public CasillaTeletransporte(Jugador jugador,Mapa mapa, String nombre, int posicionX, int posicionY) {
        super(jugador, nombre, posicionX, posicionY);
    }

    @Override
    public void efectoDeCasilla() {
        Mapa mapa = new Mapa(jugador);
        Random random = new Random();
        
        nuevaCoordenadaX = random.nextInt(0, mapa.getCantidadFilas() - 1);
        nuevaCoordenadaY = random.nextInt(0, mapa.getCantidadColumnas() - 1);
        
        jugador.setPosicionX(nuevaCoordenadaX);
        jugador.setPosicionY(nuevaCoordenadaY);
        System.out.println("Has sido teletransportado a otra casilla");
            
    }

    @Override
    public void modificarCasilla() {
       
    }
    
}
