/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Menus;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Personaje.Enemigo;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class MenuBatalla extends MenuBase{
    
    private Jugador jugador;
    private Enemigo enemigo;

    public MenuBatalla(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
    }

    
    @Override
    public void mostrarMenu() {
    
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
        
        switch(opcionMenu){
            case 1:
                jugador.aplicarAtaque(enemigo);
                break;
            case 2:
                
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                ControladorMetodos.limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo");
                mostrarMenu();
                break;
                
                
        }
    }
    
}
