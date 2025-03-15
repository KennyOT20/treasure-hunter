/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Batalla;

import com.mycompany.treasurehunter.Personaje.Enemigo;
import com.mycompany.treasurehunter.Personaje.Jugador;
import java.util.Random;

/**
 *
 * @author kenny
 */
public class Batalla {
    
    private Jugador jugador;
    private Enemigo enemigo;

    public Batalla(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
    }
    
    public void iniciarBatalla(){
        
        boolean turnos = opcionValida();
        
        while(jugador.getVidaPersonaje() > 0 && enemigo.getVidaPersonaje() > 0){
            if(turnos == false){
                enemigo.aplicarAtaque(jugador);
            } else{
                jugador.aplicarAtaque(enemigo);
            }
            
            turnos = !turnos;
        }
        
        if(enemigo.getVidaPersonaje() <= 0){
            System.out.println("Has vencido al pirata " + enemigo.getNombrePersonaje());
        } else{
            System.out.println("El pirata " + enemigo.getNombrePersonaje() + " te ha vencido");
        }
    }
    
    private boolean opcionValida(){
       Random random = new Random();
       boolean opcion = random.nextBoolean();
       return opcion;
    }
}
