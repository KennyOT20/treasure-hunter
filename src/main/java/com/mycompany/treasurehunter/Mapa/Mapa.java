/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Mapa;

import com.mycompany.treasurehunter.Jugador.Jugador;
import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class Mapa {
    
    private Jugador jugador;
    private static Scanner scanner = new Scanner(System.in); 
    private int cantidadFilas;
    private int cantidadColumnas;
    private String [][] mapa;

    public Mapa(Jugador jugador) {
        this.jugador = jugador;
    }
    
    //Metodo encargado de generar un mapa por defecto de 27 *27 
    public void generarMapaPorDefecto(){
        cantidadFilas = 27;
        cantidadColumnas = 27;
        mapa = new String[cantidadFilas][cantidadColumnas];
        inicializarMapa();
        generarMapa();
        
    }
    
    //metodo encargado de hacer que el usuario pueda configurar los mapas.
    public void configurarMapa(){
        
    }
   
    //Metodo encargado de generar el indice de letrar horizonal(a,b,c,d,e,f,g....x,y,z)
    private void generarIndiceHorizontal(){
        
        System.out.print("    ");
        for (int j = 0; j < mapa[0].length; j++) {
            System.out.print((char) ('A' + j) + "  ");
        }
        System.out.println();
    }
    
    //Metodo encargado de imprimir el mapa con los indices ya bien definido
    private void imprimirMapa(){
        
        for (int i = 0; i < cantidadFilas; i++) {
            System.out.printf("%2d ", (i + 1)); //.printf para darle 2 espacios definidos al indce
            for (int j = 0; j < cantidadColumnas; j++) {
                System.out.print("[" + mapa[i][j] +  "]");
            }
            System.out.println();
        }
    }
    
    //metodo encargado de iniciar el mapa con espacios vacios
    private void inicializarMapa(){
        
        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j <cantidadColumnas; j++) {
                mapa[i][j] = " ";
            }
        }
    }
    
    //Metodo encargado de colocar el simbolo del jugador en el mapa
    private void colocarJugadorEnMapa(){
       
        jugador.setPosicionX(15);
        jugador.setPosicionY(8);
        
        int posicionX = jugador.getPosicionX();
        int posicionY = jugador.getPosicionY();
        
        mapa[posicionX][posicionY] = String.valueOf(jugador.getSimboloJugador());//Value of para capturar el simbolo char del jugador
    }
    
    //Metodo encargado de generar el mapa ya con todas las validaciones posibles
    public void generarMapa(){
        
        generarIndiceHorizontal();
        colocarJugadorEnMapa();
        imprimirMapa();
        
    }
    
    //Metodo ebncargado de realizar los movimientos 
    public void realizarMovimiento(){
        
        String movimiento;
        
            System.out.print("|a: Izquierda|, ");
            System.out.print("|w: arriba|, ");
            System.out.print("|s: Abajo|, ");
            System.out.print("|d: derecha");
            System.out.println("");
            System.out.print("Elija una opcion: ");
            movimiento = scanner.nextLine();
        
            switch(movimiento.toUpperCase()){
                case "W":
                    movimientoW();
                    break;
                case "A":
                    movimientoA();
                    break;
                case "S":
                    movimientoS();
                    break;
                case "D":
                    movimientoD();
                    break;
                default:
                    System.out.println("Opcion no valida, intente de nuevo");
                    realizarMovimiento();
                    break;
                    
                    
            };
        
    }
    
    //Metodo encargado de realizar los movimientos hacia arriba del mapa
    public void movimientoW(){
        
    }
    
    //Metodo encargado de realizar los movimientos hacia la izquierda
    public void movimientoA(){
        
    }
    
    //Metodo encargado de realizar los movimientos hacia la abajo
    public void movimientoS(){
        
    }
    
    //Metodo encargado de realizar los miviemntos hacia la Derecha
    public void movimientoD(){
        
    }
}
