/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Mapa;

import com.mycompany.treasurehunter.Casillas.Casilla;
import com.mycompany.treasurehunter.Casillas.CasillaCombate;
import com.mycompany.treasurehunter.Casillas.CasillaEnergia;
import com.mycompany.treasurehunter.Casillas.CasillaNormal;
import com.mycompany.treasurehunter.Casillas.CasillaPista;
import com.mycompany.treasurehunter.Casillas.CasillaTeletransporte;
import com.mycompany.treasurehunter.Casillas.CasillaTrampa;
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
    private boolean tesoroColocado = false;
   

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
                      mapa.getJugador().setPosicionY(coordenadaY - 1 );
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
      public void validarColocacionDeCasillas(){
          
         String simboloCasilla;
         int opcionDeCasilla;
         
          for (int i = 0; i < mapa.getCantidadFilas(); i++) {
              for (int j = 0; j < mapa.getCantidadColumnas(); j++) {
                  
                  boolean opcionCorrecta = false;
                  
                  while(opcionCorrecta == false){
                      try{
                          char letraIndice = colocarLetrasDeIndice(j);
                          System.out.println("Posicion de casilla: ( " + (i + 1) + ", " + letraIndice + ")");
                          mostrarMenuDeCasillas();
                          opcionDeCasilla = scanner.nextInt();
                          
                          if(opcionDeCasilla >= 1 && opcionDeCasilla <= 8){
                              Casilla casilla = obtenerMenuEdicionCasilla(opcionDeCasilla);
                              
                              if(opcionDeCasilla == 7){
                                  if(tesoroColocado == false){
                                      
                                    simboloCasilla = colocarCasilla(opcionDeCasilla);
                                    mapa.editarCasillas(i, j, simboloCasilla);
                                    tesoroColocado = true;
                                    
                                      System.out.println("Has colocado el tesoro");
                                      System.out.println("Memoriza la posciocion.");
                                      
                                  } else{
                                      System.out.println("Ya has colocado el tesoro, intenta de nuevo");
                                      continue;
                                  }
                              } else{
                                  simboloCasilla = colocarCasilla(opcionDeCasilla);
                                  mapa.editarCasillas(i, j, simboloCasilla);
                              }            

                              if(casilla != null){
                                  menuEdicionDeCasilla(casilla);
                              }
                              controlador.limpiarPantalla();
                              mapa.generarMapa();                
                              opcionCorrecta = true;
                              
                          }else{
                              System.out.println("Opcion no valida, intente de nuevo. ");
                          }
                      } catch(InputMismatchException e){
                          scanner.nextLine();
                          controlador.limpiarPantalla();
                          System.out.println("Opcion incorrecta, intente de nuevo. ");
                          
                      }
                      
                  }
                  
              }
          }
      }
      
      /**
       * Metodo encargado de ir mostrando el menu de casillas disponibles.
       */
      private void mostrarMenuDeCasillas(){
          
          System.out.println("==========================================");
          System.out.println("|| Ahora puedes colocar las casillas    ||");
          System.out.println("|| que deseas.                          ||");
          System.out.println("==========================================");
          System.out.println("|| 1. Casilla Normal                    ||");
          System.out.println("|| 2. Casilla Combate                   ||");
          System.out.println("|| 3. Casilla Energia                   ||");
          System.out.println("|| 4. Casilla Muro                      ||");
          System.out.println("|| 5. Casilla Pista                     ||");
          System.out.println("|| 6. Casilla Teletransporte            ||");
          System.out.println("|| 7. Casilla Tesoro                    ||");
          System.out.println("|| 8. Casilla Trampa                    ||");
          System.out.println("|| 9. Terminar Edicion de Mapa          ||");
          System.out.println("==========================================");
          System.out.print("Ingrese una opcion: ");
          
      }
      
      /**
       * Metodo encargado de mostrarLasLetras del indice en mayuscula 
       * @param j recibe este parametro desde el metodo de validacion de casillas
       * @return retorna una letra del abecedario segun el valor de <code> j <code> 
       */
      private char colocarLetrasDeIndice(int j){
          return(char) ('A' + j);
      }
      
      /**
       * Metodo encargado de ir colocando las letras correspondientes al mapa para
       * poder realizar la creacion correctamente
       * @param opcionDeCasilla recibe una opcion ingresada por el usuario
       * @return una letra del arreglo que se encuentra en la clase <Mapa> 
       */
      private String colocarCasilla(int opcionDeCasilla){
       //     SIMBOLOS_CASILLAS = {"N", "C","E","M","P", "T","R"};
          switch(opcionDeCasilla){
              case 1 -> {
                  return Mapa.getSIMBOLOS_CASILLAS()[0];
            }
              case 2 -> {
                   return Mapa.getSIMBOLOS_CASILLAS()[1];
            }
              case 3 -> {
                   return Mapa.getSIMBOLOS_CASILLAS()[2];
            }
              case 4 -> {
                   return Mapa.getSIMBOLOS_CASILLAS()[3];
            }
              case 5 -> {
                   return Mapa.getSIMBOLOS_CASILLAS()[4];
            }
              case 6 -> {
                   return Mapa.getSIMBOLOS_CASILLAS()[5];
            }
              case 7 -> {
                   return Mapa.getSIMBOLO_CASILLA_TESORO();
            }
              case 8 -> {
                   return Mapa.getSIMBOLOS_CASILLAS()[6];
              }
              default -> {
                   return null;
            }
          }
          
      }
      
      /**
       * Metodo encargado de instanciar a una casilla para poder acceder al menu de modificacion
       * para que el usuario pueda modificarla 
       * @param opcion recibe una opcion quer el usuario colque
       * @return un objeto de las clases casillas.
       */
      private Casilla obtenerMenuEdicionCasilla(int opcion){
          switch(opcion){
              case 1 -> {
                  return null;
            }
              case 2 -> {
                  return new CasillaCombate(mapa.getJugador());
            }
              case 3 -> {
                  return new CasillaEnergia(mapa.getJugador());
            }
              case 4 -> {
                  return null;
            }
              case 5 -> {
                  return new CasillaPista(mapa.getJugador());
            }
              case 6 -> {
                  return new CasillaTeletransporte(mapa.getJugador());
            }
              case 7 -> {
                  return null;
            }
              case 8 -> {
                  return new CasillaTrampa(mapa.getJugador());
            }
              default -> {
                  return null;
            }
          }
      }
          
      private void menuEdicionDeCasilla(Casilla casillaObjetivo){
          
          int opcionEdicion;
          System.out.println("===================================");
          System.out.println("|| Desea modificar los atributos ||");
          System.out.println("|| de esta casilla " + casillaObjetivo.getNombre() + " ?");
          System.out.println("===================================");
          System.out.println("|| 1. SI                         ||");
          System.out.println("|| 2. NO                         ||");
          System.out.println("===================================");
          System.out.print("Ingrese una opcion: ");
          opcionEdicion = scanner.nextInt();
          
          if(opcionEdicion >= 1 && opcionEdicion <=2) {
              if(opcionEdicion > 1){
                  casillaObjetivo.modificarCasilla();
              } else{
                  System.out.println("Continuando con la colocacion de las casillas");
              }
          } else{
              System.out.println("Error, opcion no valida, intente de nuevo.");
              menuEdicionDeCasilla(casillaObjetivo);
              
          }
      }
}
