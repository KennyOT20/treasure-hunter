/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class CasillaTeletransporte extends Casilla {
    
    private int nuevaCoordenadaX;
    private int nuevaCoordenadaY;

    public CasillaTeletransporte(Jugador jugador, String nombre, String simboloCasilla, int posicionX, int posicionY) {
        super(jugador, nombre, simboloCasilla, posicionX, posicionY);
    }
    
    
    
    @Override
    public void efectoDeCasilla() {
        Mapa mapa = new Mapa(jugador);
        
        nuevaCoordenadaX = ControladorMetodos.calcularNumerosAleatorios(0, 23 );
        nuevaCoordenadaY = ControladorMetodos.calcularNumerosAleatorios(0, 23 );
        
        jugador.setPosicionX(nuevaCoordenadaX);
        jugador.setPosicionY(nuevaCoordenadaY);
        System.out.println("Has sido teletransportado a otra casilla");
    }

    @Override
    public void modificarCasilla() {
       
    }
    
}
