/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Menus;

import com.mycompany.treasurehunter.Batalla.Batalla;
import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Personaje.Enemigo;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class MenuBatalla extends MenuBase{
    
    private final Jugador jugador;
    private final Enemigo enemigo;
    private final Batalla batalla;

    public MenuBatalla(Jugador jugador, Enemigo enemigo, Batalla batalla) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.batalla = batalla;
    }

    
    @Override
    public void mostrarMenu() {
        
        jugador.mostrarEstadoPersonaje();
        enemigo.mostrarEstadoPersonaje();
        
        System.out.println("¡Tu turno! ");
        System.out.println("");
        System.out.println("===========================");
        System.out.println("||     Menu Batalla      ||");
        System.out.println("||=======================||");
        System.out.println("|| 1. Atacar             ||");
        System.out.println("|| 2. Defender           ||");
        System.out.println("|| 3. Curar              ||");
        System.out.println("|| 4. Huir               ||");
        System.out.println("===========================");
        System.out.print("Elige una opcion: ");
        validarOpcion();
    }

    
    @Override
    public void ejecutarOpcion(int opcionMenu) {
        ControladorMetodos controlador = new ControladorMetodos();
        
        switch(opcionMenu){
            case 1:
                controlador.limpiarPantalla();
                jugador.aplicarAtaque(enemigo);
                jugador.mostrarEstadoPersonaje();
                enemigo.mostrarEstadoPersonaje();
                break;
            case 2:
                
                break;
            case 3:
                controlador.limpiarPantalla();
                jugador.curarJugador();
                break;
            case 4:
                controlador.limpiarPantalla();
                batalla.huirDeBatalla();
                break;
            default:
                controlador.limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo");
                mostrarMenu();
                break;
                
                
        }
    }
    
}
