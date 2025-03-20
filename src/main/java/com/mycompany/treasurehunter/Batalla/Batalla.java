/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Batalla;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Menus.MenuBatalla;
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
    private final ControladorMetodos controlador;
    private boolean huirDeBatalla;
    private boolean terminarBatalla;

    public Batalla(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
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
        
        if(jugador.getVidaPersonaje() <= 0){
            System.out.println("Te ha vencido el pirata " + enemigo.getNombrePersonaje());
        } else{
            controlador.limpiarPantalla();
            System.out.println("Has vencido al pirata " + enemigo.getNombrePersonaje());
            recompensasGanarBatalla();
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
    
    public void recompensasGanarBatalla(){
        System.out.println("");
    }
    
}
