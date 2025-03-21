/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Mapa;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class CrearMapa {
    
    private final Mapa mapa;
    private final ControladorMetodos controlador;
    private static final Scanner scanner = new Scanner(System.in);
   

    public CrearMapa(Mapa mapa) {
        this.mapa = mapa;
        this.controlador = new ControladorMetodos();
    }
    
    
    public void obtenerCantidadFilas(){
        
        int cantidadDeFilas; 
        boolean cantidadCorrecta = false;
        
        while(cantidadCorrecta == false){
        
            try{ 
                System.out.println("=============================");
                System.out.println("|| Ahora puedes crear tu   || ");
                System.out.println("|| personalizado!          ||");
                System.out.println("=============================");
                System.out.println("||Ingrese la cantidad de   ||");
                System.out.println("||filas                    ||");
                System.out.println("=============================");
                System.out.print("CantidadDeFilas: ");
                cantidadDeFilas = scanner.nextInt();
                
                if(cantidadDeFilas > 0){
                    mapa.setCantidadFilas(cantidadDeFilas);
                    cantidadCorrecta = true;
                }else{
                    controlador.limpiarPantalla();
                    System.out.println("Error, la cantidad debe de ser mayor a 0 ");
                }
                
        } catch(InputMismatchException e){
            scanner.nextLine();
            controlador.limpiarPantalla();
            System.out.println("Opcion no valida, intente de nuevo");
        }
    }
    
    }
    
    public void obtenerCantidadColumnas(){
        
        int cantidadColumnas;
        boolean cantidadCorrecta = false;
        
        while(cantidadCorrecta == false ){
            try{
                System.out.println("============================");
                System.out.println("|| Ingrese la cantidad de ||");
                System.out.println("|| columnas               ||");
                System.out.println("============================");
                System.out.print("Cantidad de columnas: ");
                cantidadColumnas = scanner.nextInt();
                
                if(cantidadColumnas > 0 ){
                mapa.setCantidadColumnas(cantidadColumnas);
                cantidadCorrecta = true;
                } else{
                    controlador.limpiarPantalla();
                    System.out.println("Error, la cantidad debe de ser mayor a 0 ");
                    
                }
            } catch(InputMismatchException e){
                scanner.nextLine();
                controlador.limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo");
            }
        }
    }
    
    
}
