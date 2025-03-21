/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Partida;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Menus.MenuInicial;
import com.mycompany.treasurehunter.Menus.MenuJuego;


/**
 *
 * @author kenny
 */
public class Partida {
    
    private final Mapa mapa;

    public Partida(Mapa mapa) {
        this.mapa = mapa;
    }
    
    //Metodo encargado de mantener la partida activa
    public void iniciarPartida(){
        MenuJuego menu = new MenuJuego(mapa, mapa.getJugador());
        
        
        while(mapa.getJugador().getVidaMaxPersonaje() > 0 && mapa.getJugador().isTesoroEncontrado() == false){
            
            menu.mostrarMenu();
            
        }
        
        if(mapa.getJugador().isTesoroEncontrado() == true){
            ControladorMetodos controlador = new ControladorMetodos();
            MenuInicial menuInicial = new MenuInicial();
            
            controlador.limpiarPantalla();
            mapa.generarMapa();
            System.out.println("Enhorabuena, has encontrado el tesoro.");
            System.out.println("¿Que deseas realizar?");
            menuInicial.mostrarMenu();
            
        }
       
       
    }
    
}
