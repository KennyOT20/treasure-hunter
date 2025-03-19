/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Batalla;

import com.mycompany.treasurehunter.Menus.MenuBatalla;
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
        
        MenuBatalla menu = new MenuBatalla(jugador, enemigo);
        Random random = new Random();
        
        boolean turnos = random.nextBoolean();
       

        while(jugador.getVidaPersonaje() > 0 && enemigo.getVidaPersonaje() > 0){
            if(turnos == false){
                jugador.mostrarEstadoPersonaje();
                enemigo.mostrarEstadoPersonaje();
                System.out.println("Tu turno");
                menu.mostrarMenu();
            } else{
                System.out.println("Turno de " + enemigo.getNombrePersonaje());
                enemigo.aplicarAtaque(jugador);
            }
            turnos = !turnos;
        }
        
        if(jugador.getVidaPersonaje() <= 0){
            System.out.println("Te ha vencido el pirata " + enemigo.getNombrePersonaje());
        } else{
            System.out.println("Has vencido al pirata " + enemigo.getNombrePersonaje());
        }
    }
    
}
