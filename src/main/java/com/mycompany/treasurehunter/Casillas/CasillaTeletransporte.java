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

    public CasillaTeletransporte(Jugador jugador, Mapa mapa) {
        super(jugador, "Casilla de teletransporte", mapa);
    }
    
    
    @Override
    public void efectoDeCasillaNormal() {
        ControladorMetodos controlador = new ControladorMetodos();
        
        System.out.println("Has pisado una casilla de Teletransporte ");
        nuevaCoordenadaX = controlador.calcularNumerosAleatorios(0, 23 );
        nuevaCoordenadaY = controlador.calcularNumerosAleatorios(0, 23 );
        
        jugador.setPosicionX(nuevaCoordenadaX);
        jugador.setPosicionY(nuevaCoordenadaY);
        System.out.println("Has sido teletransportado a otra casilla");
    }

    @Override
    public void modificarCasilla() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void menuDeModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
