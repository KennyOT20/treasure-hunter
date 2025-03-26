/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Personaje.Jugador;
import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class CasillaPista extends Casilla {
    
    private String pistaObtenida;
    private String[] pistas = { 
    "El tesoro está cerca.",
    "El tesoro está muy lejos.",
    "Prueba ir hacia el norte.",
    "Prueba ir hacia el sur.",
    "Prueba ir hacia el este.",
    "Prueba ir hacia el oeste."
};
    private boolean casillaModificada = false;

    public CasillaPista(Jugador jugador, Mapa mapa) {
        super(jugador, "Casilla pista", mapa );
    }

    

     @Override
    public void efectoDeCasillaNormal() {
 
}


    @Override
    public void modificarCasilla() {
        Scanner scanner = new Scanner(System.in);
        int opcionMenu;
        boolean opcionValida = false;

        while (!opcionValida) {
            try {
                System.out.println("========================================");
                System.out.println("|| Deseas modificar la pista?        ||");
                System.out.println("========================================");
                System.out.println("|| 1. Sí                             ||");
                System.out.println("|| 2. No                             ||");
                System.out.println("========================================");
                System.out.print("Seleccione una opción: ");
                opcionMenu = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcionMenu) {
                    case 1 -> {
                        System.out.println("=====================================");
                        System.out.println("|| Ingrese la nueva pista:         ||");
                        System.out.println("=====================================");
                        pistaObtenida = scanner.nextLine();
                        casillaModificada = true;
                        opcionValida = true;
                    }
                    case 2 -> {
                        System.out.println("Pista no modificada. Se mantiene las originslerd.");
                        opcionValida = true;
                    }
                    default -> System.out.println("Opcion no valida, intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida, intente de nuevo.");
                scanner.nextLine(); 
            }
        }
   
    }

    @Override
    public void menuDeModificacion() {

    }

    @Override
    public void efectoDeCasillaModificado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aplicarEfecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
