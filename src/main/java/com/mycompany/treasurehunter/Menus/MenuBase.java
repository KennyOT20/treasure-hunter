/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kenny
 */
public abstract class MenuBase {
    
    public void mostrarMenu(){
        
    }
    
    
    /**
     * Metodo encargado de validar las opciones del jugador.
     * El jugador solo puede ingresar opciones numericas enteras.
     * Si el jugador ingresa un simbolo o letra se muestra un mnsaje de error
     * @throws  InputMismatchException e se encarga de validar que solo sean numeros enteros ingresados
     * por el usuario
     */
    protected void validarOpcion(){
        
        Scanner scanner = new Scanner(System.in);
            
            boolean opcionValida = false;
            int opcionMenu;
                
                try{
                    while(!opcionValida){
                        opcionMenu = scanner.nextInt();
                        ejecutarOpcion(opcionMenu);
                        opcionValida = true;
                    }
                } catch(InputMismatchException e){
                    scanner.nextLine();
                    limpiarPantalla();
                    System.out.println("Opcion no valida, intente de nuevo");
                    mostrarMenu();
                    
                }
        
    }
    
    protected void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public abstract void ejecutarOpcion(int opcionMenu);
}
