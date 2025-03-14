/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Personaje.Jugador;
import java.util.Random;

/**
 *
 * @author kenny
 */
public class CasillaTrampa extends Casilla {
    
    private static final Random random = new Random();
    
    public CasillaTrampa(Jugador jugador, String nombre, int posicionX, int posicionY) {
        super(jugador, nombre, posicionX, posicionY);
    }

    @Override
    public void efectoDeCasilla() {
      
        boolean elegirTrampa = random.nextBoolean();
        
            if(elegirTrampa == false){
                int puntosDeHpPerdido = calcularDañoTrampa(25,62);
                jugador.setVidaPersonaje(jugador.getVidaPersonaje() - puntosDeHpPerdido);
                System.out.println("¡Oh no, has caido en una trampa!");
                System.out.print("Has perdido " + puntosDeHpPerdido + " de hp");
            } else{
                int puntosDeMpPerdido = calcularDañoTrampa(5,8);
                jugador.setPuntosDeMana(jugador.getPuntosDeMana() - puntosDeMpPerdido);
                System.out.println("¡Oh no, has caido en una trampa!");
                System.out.print("Has perdido " + puntosDeMpPerdido + " de mp");
            }
    }
    
    /**
     * Metodo encargado de calcular el daño emitido de la casilla trampa
     * @param min recibe un numero que sera el minimo entre el un intervalo
     * @param max recibe el numero maximo del intervalo
     * @return un numero aleatoro entre el intervalo de <min> y <max> 
     */
    private int calcularDañoTrampa(int min, int max){
        int dañoTrampa = random.nextInt(min, max);
        return dañoTrampa;
    }

    @Override
    public void modificarCasilla() {
     
    }
    
}
