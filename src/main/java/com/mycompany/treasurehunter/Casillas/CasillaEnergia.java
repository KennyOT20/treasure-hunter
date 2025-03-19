/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class CasillaEnergia extends Casilla {
    
    private int hpRecuperado;
    private int mpRecuperado;
    
    public CasillaEnergia(Jugador jugador, String nombre, String simboloCasilla, int posicionX, int posicionY) {
        super(jugador, nombre, simboloCasilla, posicionX, posicionY);
    }

    

    @Override
    public void efectoDeCasilla() {
     
        ControladorMetodos controlador = new ControladorMetodos();
        
        boolean recuperarRecursos = controlador.opcionesActivas();
        
        System.out.println("Has caido en una casilla de energia");
        
        if(recuperarRecursos == false ){
            hpRecuperado = controlador.calcularNumerosAleatorios(15, 40);
            jugador.setVidaPersonaje(jugador.getVidaPersonaje() + hpRecuperado);
            System.out.println("Has recuperado " + hpRecuperado + " puntos de vida");
            
            if(jugador.getVidaPersonaje() >= jugador.getVidaMaxPersonaje()){
                jugador.verificarAtributosMax(true);
                
            } else{
                mpRecuperado = controlador.calcularNumerosAleatorios(8, 15);
                jugador.setPuntosDeMana(jugador.getPuntosDeMana() + mpRecuperado);
                System.out.println("Has recuperado " + mpRecuperado + " puntos de vida");
                
                if(jugador.getPuntosDeMana() >= jugador.getManaMax()){
                    jugador.verificarAtributosMax(false);
                }
            }
        }
    }

    @Override
    public void modificarCasilla() {
       
    }
    
}
