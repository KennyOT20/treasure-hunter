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
                System.out.println("=================================");
                System.out.println("|| Ahora puedes crear tu  mapa || ");
                System.out.println("|| personalizado!              ||");
                System.out.println("=================================");
                System.out.println("||Ingrese la cantidad de       ||");
                System.out.println("||filas                        ||");
                System.out.println("=================================");
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
    
    //Metodo encargado de que el usuario pueda colocar al jugador en el mapa
    public void colocarJugadorEnMapa(){
        int coordenadaX;
        
        boolean coordenadaCorrecta = false;
        
        while (coordenadaCorrecta == false ){
            try{
                System.out.println("=======================================");
                System.out.println("|| Es hora de colocar a tu personaje ||");
                System.out.println("|| en el mapa.                       ||");
                System.out.println("=======================================");
                System.out.println("|| Ingrese que fila quieres iniciar  ||");
                System.out.println("|| (1," + mapa.getCantidadFilas() + " )");
                System.out.println("=======================================");
                System.out.print("Coordenada en X : ");
                coordenadaX = scanner.nextInt();
                
                if(coordenadaX > 0 && coordenadaX <= mapa.getCantidadFilas() ){
                    mapa.getJugador().setPosicionX(coordenadaX - 1 );
                    controlador.limpiarPantalla();
                    colocarJugadorCoordenadaY();
                    coordenadaCorrecta = true;
                } else{
                    controlador.limpiarPantalla();
                    System.out.println("Error, la fila no esta disponible");
                }
            } catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("Opcion no valida, intente de nuevo");
            }
            
            
        }
    }
        
      private void colocarJugadorCoordenadaY(){
          
          int coordenadaY;
          boolean coordenadaCorrecta = false;
          
          while(coordenadaCorrecta == false){
              try{
                  System.out.println("===================================");
                  System.out.println("|| Ingrese en que columna desea  ||");
                  System.out.println("|| iniciar.                      ||");
                  System.out.println("|| (1, " + mapa.getCantidadColumnas() + " ) " );
                  System.out.println("=====================================");
                  System.out.print("Coordenada Y: ");
                  coordenadaY = scanner.nextInt();
                  
                  if(coordenadaY > 0 && coordenadaY <= mapa.getCantidadColumnas()){
                      mapa.getJugador().setPosicionY(coordenadaY - 2);
                      coordenadaCorrecta = true;
                  } else{
                      controlador.limpiarPantalla();
                      System.out.println("Error, la columna no esta disponible");
                  }
                  
              }catch(InputMismatchException e){
                  scanner.nextLine();
                  System.out.println("Opcion no valida, intente de nuevo");
              }
          }
      }  
      
      /**
       * Metodo encargado de ir colocando las casillas en el mapa, ademas se encarga de validar
       * que haya solo un tesoro en el mapa y asi vitar que hayan mas tesoros.
       */
      public void colocarCasillasEnMapa(){
          
         String simboloCasilla;
         boolean tesoroColocado = false;
         int opcionDeCasilla;
         
          for (int i = 0; i < mapa.getCantidadFilas(); i++) {
              for (int j = 0; j < mapa.getCantidadColumnas(); j++) {
                  
                  boolean opcionCorrecta = false;
                  
                  while(opcionCorrecta == false){
                      try{
                          mostrarMenuDeCasillas();
                          opcionDeCasilla = scanner.nextInt();
                          opcionCorrecta = true;
                      } catch(InputMismatchException e){
                          scanner.nextLine();
                          controlador.limpiarPantalla();
                          System.out.println("Opcion incorrecta, intente de nuevo. ");
                          
                      }
                      
                  }
                  
              }
          }
      }
      
      private void mostrarMenuDeCasillas(){
          
          System.out.println("==========================================");
          System.out.println("|| Ahora puedes colocar las casillas    ||");
          System.out.println("|| que deseas.                          ||");
          System.out.println("==========================================");
          System.out.println("|| 1. Casilla Trampa                    ||");
          System.out.println("|| 2. Casilla Teletransporte            ||");
          System.out.println("|| 3. Casilla Energia                   ||");
          System.out.println("|| 4. Casilla Muro                      ||");
          System.out.println("|| 5. Casilla Pista                     ||");
          System.out.println("|| 6. Casilla Combate                   ||");
          System.out.println("|| 7. Casilla Tesoro                    ||");
          System.out.println("|| 8. Salir de edicion                  ||");
          System.out.println("==========================================");
          System.out.print("Ingrese una opcion: ");
          
      }
          
      
}
