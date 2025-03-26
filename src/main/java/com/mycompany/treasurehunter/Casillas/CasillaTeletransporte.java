/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Personaje.Jugador;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class CasillaTeletransporte extends Casilla {
    
    private final ControladorMetodos controlador;
    private int nuevaCoordenadaX;
    private int nuevaCoordenadaY;
    private int coordenadaXModificada;
    private String letraCoordenada;
    private int coordenadaYModificada;
    private boolean casillaModificada = false;
    private static final Scanner scanner = new Scanner(System.in);

    public CasillaTeletransporte(Jugador jugador, Mapa mapa) {
        super(jugador, "Casilla de teletransporte", mapa);
        this.controlador = new ControladorMetodos();
        this.casillaModificada = false;
    }
    
    
    @Override
    public void efectoDeCasillaNormal() {
        
        System.out.println("Has pisado una casilla de Teletransporte ");

        if (casillaModificada == true) {
            nuevaCoordenadaX = coordenadaXModificada;
            nuevaCoordenadaY = coordenadaYModificada;
        } else {
            nuevaCoordenadaX = controlador.calcularNumerosAleatorios(0, mapa.getCantidadColumnas());
            nuevaCoordenadaY = controlador.calcularNumerosAleatorios(0, mapa.getCantidadFilas());
        }

        jugador.setPosicionX(nuevaCoordenadaX);
        jugador.setPosicionY(nuevaCoordenadaY);
        System.out.println("Has sido teletransportado a otra casilla");
    }

    @Override
    public void modificarCasilla() {
        
        
        boolean opcionValida = false; 
        int opcionMenu;
        
        while(opcionValida == false){
            try{
                System.out.println("========================================");
                System.out.println("|| Deseas modificar el teletransporte ||");
                System.out.println("|| de esta casilla?                   ||");
                System.out.println("========================================");
                System.out.println("|| 1. Si                              ||");
                System.out.println("|| 2. No                              ||");
                System.out.println("========================================");
                System.out.print("Seleccione una opcion: ");
                opcionMenu = scanner.nextInt();
                
                if(opcionMenu >= 1 && opcionMenu <= 2 ){
                    if(opcionMenu == 1){
                        controlador.limpiarPantalla();
                        menuDeModificacion();
                        casillaModificada = true;
                        opcionValida = true;
                        
                    } else{
                        controlador.limpiarPantalla();
                        System.out.println("Continuando con la edicion del mapa");
                        opcionValida = true;
                    }
                } else{
                    controlador.limpiarPantalla();
                    System.out.println("Opcion no valida, intente de nuevo");
                }
            } catch(InputMismatchException e){
                scanner.nextLine();
                controlador.limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo.");
                
            }
            
        }


    }

    @Override
    public void menuDeModificacion() {
        
        boolean filaValida = false;
        
        while(filaValida == false ){
            try{
                System.out.println("================================");
                System.out.println("|| Ingrese la fila en la que  ||");
                System.out.println("|| que quieres ser reubicado  || ");
                System.out.println("================================");
                System.out.print("Ingrese una coordenada (1," + (mapa.getCantidadFilas()) + "): " );
                
                coordenadaYModificada = scanner.nextInt();
                scanner.nextLine();
                
                if(coordenadaYModificada > 0 && coordenadaYModificada <= mapa.getCantidadFilas()){
                    controlador.limpiarPantalla();
                    obtenerCoordenadaColumna();
                    filaValida = true;
                } else{
                    System.out.println("Opcion no valida, intente de nuevo.");
                }
                
                
            } catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("Opcion no valida, intente de nuevo.");
            }
            
        }
    }
    
    private void obtenerCoordenadaColumna(){
        boolean columnaValida = false; 
        String letraPrincipal;
        
        while (columnaValida == false) {
         try {
             System.out.println("==================================");
             System.out.println("|| Ingrese la columna deseada   ||");
             System.out.println("|| usando una letra             ||");
             System.out.println("==================================");
             System.out.print("Columna (A, " + colocarLetrasDeIndice(mapa.getCantidadColumnas() - 1 ) + "): ");

             letraPrincipal = scanner.nextLine().trim().toUpperCase();

             if (letraPrincipal.length() == 1 && letraPrincipal.charAt(0) >= 'A' && letraPrincipal.charAt(0) < 'A' + mapa.getCantidadColumnas()) {
                 letraCoordenada = letraPrincipal;
                 coordenadaXModificada = letraPrincipal.charAt(0) - 'A' + 1; 
                 System.out.println("Seras teletransportado a la casilla: (" + coordenadaYModificada + ","+ coordenadaXModificada  + ")");
                 columnaValida = true;
             } else {
                 System.out.println("Columna no valida, intent de nuevo. ");
             }
         } catch (Exception e) {
             controlador.limpiarPantalla();
             System.out.println("Error, opcion no valida, intente de nuevo. ");
         }
     }
        
        
    }
    
    @Override
    public void efectoDeCasillaModificado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aplicarEfecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
       * Metodo encargado de mostrarLasLetras del indice en mayuscula 
       * @param j recibe este parametro desde el metodo de validacion de casillas
       * @return retorna una letra del abecedario segun el valor de <code> j <code> 
       */
      private char colocarLetrasDeIndice(int j){
          return(char) ('A' + j);
      }
    
}
