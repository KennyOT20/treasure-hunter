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
public class CasillaTrampa extends Casilla {
    
    private int puntosDeHpPerdido;
    private int puntosDeMpPerdido;
    
    public CasillaTrampa(Jugador jugador, String nombre, String simboloCasilla, int posicionX, int posicionY) {
        super(jugador, nombre, simboloCasilla, posicionX, posicionY);
    }

    @Override
    public void efectoDeCasilla() {
      
        boolean elegirTrampa = ControladorMetodos.opcionesActivas();
        
            if(elegirTrampa == false){
                puntosDeHpPerdido = ControladorMetodos.calcularNumerosAleatorios(15, 28);
                jugador.setVidaPersonaje(jugador.getVidaPersonaje() - puntosDeHpPerdido);
                
                if(jugador.getVidaPersonaje() <= 0){
                    jugador.verifivarAtributosMin(true);
                }
                
                System.out.println("¡Oh no, has caido en una trampa!");
                System.out.print("Has perdido " + puntosDeHpPerdido + " de hp");
                System.out.println("");
                
            } else{
                puntosDeMpPerdido = ControladorMetodos.calcularNumerosAleatorios(10, 14);
                jugador.setPuntosDeMana(jugador.getPuntosDeMana() - puntosDeMpPerdido);
                
                if(jugador.getPuntosDeMana() <= 0){
                    jugador.verifivarAtributosMin(false);
                }
                
                System.out.println("¡Oh no, has caido en una trampa!");
                System.out.print("Has perdido " + puntosDeMpPerdido + " de mp");
                System.out.println("");
            }
    }

    @Override
    public void modificarCasilla() {
     
    }
    
}
