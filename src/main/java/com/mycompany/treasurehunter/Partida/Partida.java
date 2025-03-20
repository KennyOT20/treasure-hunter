/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Partida;

import com.mycompany.treasurehunter.Mapa.Mapa;
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
        
        //mapa.getJugador().getVidaPersonaje() > 0
        
        while(true){
            
            menu.mostrarMenu();
        }
        
        //System.out.println("Has perdido, no has logrado encontrare el tesoro :( ");
    }
    
}
