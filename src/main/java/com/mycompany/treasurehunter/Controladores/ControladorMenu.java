/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Controladores;

import com.mycompany.treasurehunter.Mapa.CrearMapa;
import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Partida.Partida;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class ControladorMenu {
    
    private final Jugador jugador;
    private final Mapa mapa;

    public ControladorMenu() {
        this.jugador = new Jugador();
        this.mapa = new Mapa(jugador);
    }
    
    
    
    //Metodo encargado de iniciar una partida nueva para el jugador
    public void iniciarPartida(){
        Partida partida = new Partida(mapa);
        
        limpiarConsola();
        jugador.obtenerNombre();
        
        limpiarConsola();
        System.out.println("Partida de: " + jugador.getNombrePersonaje() );
        mapa.generarMapaPorDefecto();
        partida.iniciarPartida();
        
    }
    
    //Metodo encargado de la creacion del mapa
    public void crearMapa(){
        CrearMapa crearMapa = new CrearMapa(mapa);
        jugador.obtenerNombre();
        
        limpiarConsola();
         crearMapa.obtenerCantidadFilas();
        
        limpiarConsola();
        crearMapa.obtenerCantidadColumnas();
        
        limpiarConsola();
        crearMapa.colocarJugadorEnMapa();
        mapa.mapaCreado();
        crearMapa.validarColocacionDeCasillas();

        
        
    }
    
    private void limpiarConsola(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
