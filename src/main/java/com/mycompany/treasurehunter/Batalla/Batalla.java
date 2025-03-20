/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Batalla;

import com.mycompany.treasurehunter.Casillas.CasillaCombate;
import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Menus.MenuBatalla;
import com.mycompany.treasurehunter.Menus.RecompensasBatalla;
import com.mycompany.treasurehunter.Personaje.Enemigo;
import com.mycompany.treasurehunter.Personaje.Jugador;
import java.util.Random;

/**
 *
 * @author kenny
 */
public class Batalla {
    
    private final Jugador jugador;
    private final Enemigo enemigo;
    private final CasillaCombate combate;
    private final ControladorMetodos controlador;
    private boolean huirDeBatalla;
    private boolean terminarBatalla;

    public Batalla(Jugador jugador, Enemigo enemigo, CasillaCombate combate) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.combate = combate;
        this.terminarBatalla = false;
        this.controlador = new ControladorMetodos();
    }
    
    public void iniciarBatalla(boolean rendirse){
        
        MenuBatalla menu = new MenuBatalla(jugador, enemigo, this);
        Random random = new Random();
        
        boolean turnos = random.nextBoolean();
        huirDeBatalla = rendirse;
        

        while(jugador.getVidaPersonaje() > 0 && enemigo.getVidaPersonaje() > 0 && terminarBatalla == false){
            if(turnos == false){
                menu.mostrarMenu();
            } else{
                System.out.println("");
                System.out.println("Turno de " + enemigo.getNombrePersonaje());
                enemigo.aplicarAtaque(jugador);
            }
            
            if(terminarBatalla){
                break;
            }
            
            turnos = !turnos;
        }
        
        if(enemigo.getVidaPersonaje() <= 0){
            RecompensasBatalla recompensa = new RecompensasBatalla(jugador);
            controlador.limpiarPantalla();
            System.out.println("Has vencido al enemigo " + enemigo.getNombrePersonaje());
            recompensa.mostrarMenu();
        } else if(jugador.getVidaPersonaje() <= 0){
            controlador.limpiarPantalla();
            System.out.println("Te ha vencido el enemigo " + enemigo.getNombrePersonaje());
            jugador.setVidaPersonaje(combate.getHpAnterior());
            jugador.setPuntosDeMana(combate.getMpAnterior());
            System.out.println("Tus estadisticas se reestablecen antes de entrar a la batalla");
            
            
        }
        
        
    }
    
    public void huirDeBatalla(){
        
        if(huirDeBatalla == true ){
            controlador.limpiarPantalla();
            terminarBatalla = true;
            System.out.println("Has logrado huir de la batalla.");
        } else{
            controlador.limpiarPantalla();
            System.out.println("No puedes huir de la batalla, sigue luchando");
        }
    }
    
    
    
}
