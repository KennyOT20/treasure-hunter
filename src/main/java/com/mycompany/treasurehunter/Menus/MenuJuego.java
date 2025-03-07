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
        
            String movimiento;

            System.out.println();
            System.out.print("|a : Derecha| |d: Izquierda| |w: Arriba| |s: Abajo| ");
            System.out.println("Ingrese una opcion:");
            movimiento = scanner.nextLine();
            ejecutarOpcion(movimiento);
    }

    private void ejecutarOpcion(String movimiento) {
        
        switch(movimiento.toUpperCase()){
            case "W" -> {
                mapa.movimientoArriba();
            }
            case "A" -> {
                mapa.movimientoIzquierda();
            }
            case "S" -> {
                mapa.movimientoAbajo();
            }
            case "D" -> {
                mapa.movimientoDerecha();
            }
            default -> {
                System.out.println("Opcion no valida, intente de nuevo");
            }
        }
        
        
    }
    
    
    
}
