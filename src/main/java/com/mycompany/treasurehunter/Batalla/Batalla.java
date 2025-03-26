/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Batalla;

import com.mycompany.treasurehunter.Casillas.CasillaCombate;
import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Mapa.Mapa;
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
    
    private final Enemigo enemigo;
    private final CasillaCombate combate;
    private final Mapa mapa;
    private final ControladorMetodos controlador;
    private boolean huirDeBatalla;
    private boolean terminarBatalla;

    public Batalla (Enemigo enemigo, CasillaCombate combate, Mapa mapa) {
        this.enemigo = enemigo;
        this.combate = combate;
        this.mapa = mapa;
        this.terminarBatalla = false;
        this.controlador = new ControladorMetodos();
    }
    
    public void iniciarBatalla(boolean rendirse){
        
        MenuBatalla menu = new MenuBatalla(mapa.getJugador(), enemigo, this);
        Random random = new Random();
        
        boolean turnos = random.nextBoolean();
        huirDeBatalla = rendirse;
        

        while(mapa.getJugador().getVidaPersonaje() > 0 && enemigo.getVidaPersonaje() > 0 && terminarBatalla == false){
            if(turnos == false){
                menu.mostrarMenu();
            } else{
                System.out.println("");
                System.out.println("Turno de " + enemigo.getNombrePersonaje());
                enemigo.aplicarAtaque(mapa.getJugador());
            }
            
            if(terminarBatalla){
                break;
            }
            
            turnos = !turnos;
        }
        
        if(enemigo.getVidaPersonaje() <= 0){
            RecompensasBatalla recompensa = new RecompensasBatalla(mapa.getJugador());
            controlador.limpiarPantalla();
            System.out.println("Has vencido al enemigo " + enemigo.getNombrePersonaje());
            recompensa.mostrarMenu();
        } else if(mapa.getJugador().getVidaPersonaje() <= 0){
            controlador.limpiarPantalla();
            System.out.println("Te ha vencido el enemigo " + enemigo.getNombrePersonaje());
            mapa.getJugador().setVidaPersonaje(combate.getHpAnterior());
            mapa.getJugador().setPuntosDeMana(combate.getMpAnterior());
            System.out.println("Tus estadisticas se reestablecen antes de entrar a la batalla");
            System.out.println("Y tendras una penalizacion de ser reubicado en otra casilla");
            
            int posicionX = controlador.calcularNumerosAleatorios(0, mapa.getCantidadColumnas());
            int posicionY = controlador.calcularNumerosAleatorios(0,mapa.getCantidadFilas());
            mapa.getJugador().setPosicionX(posicionX);
            mapa.getJugador().setPosicionY(posicionY);
            
            
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
