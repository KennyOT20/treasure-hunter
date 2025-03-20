/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Menus;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class RecompensasBatalla extends MenuBase{
    
    private final ControladorMetodos controlador;
    private final  Jugador jugador;
    
    public RecompensasBatalla(Jugador jugador) {
        this.jugador = jugador;
        this.controlador = new ControladorMetodos();
    }
    
    
    
    @Override
    public void mostrarMenu() {
        
        
        System.out.println("====================================");
        System.out.println("|| ¡Has ganado la batalla!        ||");
        System.out.println("||================================||");
        System.out.println("|| Escoje una recompensa          ||");
        System.out.println("||================================||");
        System.out.println("|| 1. Aumentar 10 puntos de hp    ||");
        System.out.println("|| 2. Aumentar 1 punto de mp      ||");
        System.out.println("|| 3. Aumentar 1 punto de defensa ||");
        System.out.println("====================================");
        System.out.print("Escoge una opcion: ");
        validarOpcion();
    }

    
    @Override
    public void ejecutarOpcion(int opcionMenu) {
        
        switch(opcionMenu){
            case 1 -> {
                controlador.limpiarPantalla();
                jugador.setVidaMaxPersonaje(jugador.getVidaMaxPersonaje() + 10 );
                jugador.setVidaPersonaje(jugador.getVidaMaxPersonaje());
                System.out.println("Has aumentado 10 puntos mas de hp");
            }
            case 2 -> {
                controlador.limpiarPantalla();
                jugador.setManaMax(jugador.getManaMax() + 1);
                jugador.setPuntosDeMana(jugador.getManaMax());
                System.out.println("Has aumentado 1 punto mas de mp");
            }
            case 3 -> {
                controlador.limpiarPantalla();
                jugador.setDefensaMax(jugador.getDefensaMax() + 1);
                jugador.setPuntosDeDefensa(jugador.getDefensaMax());
                System.out.println("Has aumentado 1 punto de defensa");
            }
            default -> {
                controlador.limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo");
                mostrarMenu();
            }
        }
    }
    
}
