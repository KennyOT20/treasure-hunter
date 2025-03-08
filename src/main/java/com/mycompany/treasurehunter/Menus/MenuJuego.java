/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Menus;

import com.mycompany.treasurehunter.Mapa.Mapa;
import java.util.Scanner;

/**
 *Clazse encargada de gestionar los movimientos del jugador 
 * @author kenny
 */
public class MenuJuego{

    private Mapa mapa;
 
    public MenuJuego(Mapa mapa) {
        this.mapa = mapa;
    }

    public void mostrarMenu() {
        
        Scanner scanner = new Scanner(System.in);
        
            String opcion;
            
            System.out.println("");
            System.out.print("a : Derecha| |d: Izquierda| |w: Arriba| |s: Abajo| ");
            System.out.println("");
            System.out.println("1. Ver pista                  ");
            System.out.println("2. Ver todas las pistas       ");
            System.out.println("3. Ver estado del personaje   ");
            System.out.println("4. Guardar partida            ");
            System.out.println("5. Regresar al menu           ");
            System.out.print("Ingrese una opcion:");
            
            opcion = scanner.nextLine();
            ejecutarOpcion(opcion);
    }

    private void ejecutarOpcion(String opcion) {
        
        switch(opcion.toUpperCase()){
            case "W" -> {
                limpiarPantalla();
                mapa.movimientoArriba();
            }
            case "A" -> {
                limpiarPantalla();
                mapa.movimientoIzquierda();
            }
            case "S" -> {
                limpiarPantalla();
                mapa.movimientoAbajo();
            }
            case "D" -> {
                limpiarPantalla();
                mapa.movimientoDerecha();
            }
            default -> {
                limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo");
                mapa.generarMapa();
            }
        }   
    }  
    
    private void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
