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
     
        boolean recuperarRecursos = ControladorMetodos.opcionesActivas();
        
        if(recuperarRecursos == false ){
            hpRecuperado = ControladorMetodos.calcularNumerosAleatorios(15, 260);
            jugador.setVidaPersonaje(hpRecuperado);
            
            if(jugador.getVidaPersonaje() >= jugador.getVidaMaxPersonaje()){
                jugador.verificarAtributosMax(true);
            } else{
                mpRecuperado = ControladorMetodos.calcularNumerosAleatorios(8, 15);
                jugador.setPuntosDeMana(mpRecuperado);
                
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
