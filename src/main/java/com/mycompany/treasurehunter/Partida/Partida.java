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
    
    private Mapa mapa;

    public Partida(Mapa mapa) {
        this.mapa = mapa;
    }
    
    //Metodo encargado de mantener la partida activa
    public void iniciarPartida(){
        MenuJuego menu = new MenuJuego(mapa);
        
        while(true){
            comprobarPartidaGanada();
            menu.mostrarMenu();
        }
    }
    
    /**
     * Metodo encargado de ir verificando si el usuario a ganado la partida
     * @return un booleano false hasta que se gane la partida.
     */
    private boolean comprobarPartidaGanada(){
        return false;
    }
}
