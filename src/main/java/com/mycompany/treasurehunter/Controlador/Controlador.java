/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Controlador;

import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Partida.Partida;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class Controlador {
    
    //Metodo encargado de iniciar la partida nueva del jugador
    public void iniciarPartida(){
        Jugador jugador = new Jugador();
        Mapa mapa = new Mapa(jugador);
        Partida partida = new Partida(mapa);
        
        limpiarConsola();
        jugador.obtenerNombre();
        
        limpiarConsola();
        mapa.generarMapaPorDefecto();
        partida.iniciarPartida();
        
    }
    
    private void limpiarConsola(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
