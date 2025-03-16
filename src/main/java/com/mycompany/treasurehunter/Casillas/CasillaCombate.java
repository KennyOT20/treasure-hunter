/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Batalla.Batalla;
import com.mycompany.treasurehunter.Personaje.Enemigo;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class CasillaCombate extends Casilla {

    public CasillaCombate(Jugador jugador, String nombre, String simboloCasilla, int posicionX, int posicionY) {
        super(jugador, nombre, simboloCasilla, posicionX, posicionY);
    }
    

    

    @Override
    public void efectoDeCasilla() {
        Enemigo enemigo = new Enemigo();
        Batalla batalla = new Batalla(jugador, enemigo);
        
        enemigo.generarEnemigos(jugador);
        batalla.iniciarBatalla();
        
    }

    @Override
    public void modificarCasilla() {
       
    }
    
}
