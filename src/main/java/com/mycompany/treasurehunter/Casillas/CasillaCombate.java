/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Batalla.Batalla;
import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Personaje.Enemigo;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class CasillaCombate extends Casilla {
    
    private boolean escaparDeCombate;
    private int hpAnterior;
    private int mpAnterior;
    private int defensaAnterior;
    
    public CasillaCombate(Jugador jugador) {
        super(jugador, "Casilla combate");
    } 
     

    @Override
    public void efectoDeCasillaNormal() {
        Enemigo enemigo = new Enemigo();
        Batalla batalla = new Batalla(jugador, enemigo, this);
        ControladorMetodos controlador = new ControladorMetodos();
        
        hpAnterior = jugador.getVidaPersonaje();
        mpAnterior = jugador.getPuntosDeMana();
        defensaAnterior = jugador.getPuntosDeDefensa();
        
        escaparDeCombate = controlador.opcionesActivas();
        
        controlador.limpiarPantalla();
        System.out.println("¡Oh no!, has caido en una casilla de combate.");
        
        enemigo.generarEnemigos(jugador);
        
        System.out.println("Te aparecio el pirata " + enemigo.getNombrePersonaje() + " para defender el tesoro.");
        System.out.println("");
        batalla.iniciarBatalla(escaparDeCombate);
        
    }


    @Override
    public void modificarCasilla() {

    }

    @Override
    public void menuDeModificacion() {

    }

    public int getHpAnterior() {
        return hpAnterior;
    }

    public int getMpAnterior() {
        return mpAnterior;
    }

    public int getDefensaAnterior() {
        return defensaAnterior;
    }

    @Override
    public void efectoDeCasillaModificado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
