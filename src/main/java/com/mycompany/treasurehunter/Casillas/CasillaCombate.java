/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Batalla.Batalla;
import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Personaje.Enemigo;
import com.mycompany.treasurehunter.Personaje.Jugador;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class CasillaCombate extends Casilla {
    
    private final ControladorMetodos controlador;
    private boolean escaparDeCombate;
    private int hpAnterior;
    private int mpAnterior;
    private int defensaAnterior;
    private int coordenadaYModificada;
    private int coordenadaXPenalizacion;
    private int coordeanadaYPenalizacion; 
    private int coordenadaXModificada;
    private int opcionHuirDeCasilla;
    private boolean casillaModificada;
    private static final Scanner scanner = new Scanner(System.in);
    
    public CasillaCombate(Jugador jugador, Mapa mapa) {
        super(jugador, "Casilla combate", mapa);
        this.escaparDeCombate = false;
        this.casillaModificada = false;
        this.controlador = new ControladorMetodos();
    } 
     

    @Override
    public void efectoDeCasillaNormal() {
        Enemigo enemigo = new Enemigo();
        Batalla batalla = new Batalla( enemigo, this, mapa);
        
        hpAnterior = jugador.getVidaPersonaje();
        mpAnterior = jugador.getPuntosDeMana();
        defensaAnterior = jugador.getPuntosDeDefensa();
        
        escaparDeCombate = controlador.opcionesActivas();
        
        controlador.limpiarPantalla();
        System.out.println("¡Oh no!, has caido en una casilla de combate.");
        
        enemigo.generarEnemigos(jugador);
        
        System.out.println("Te aparecio el pirata " + enemigo.getNombrePersonaje() + " para defender el tesoro.");
        System.out.println("");
        batalla.iniciarBatalla(escaparDeCombate);
        
    }

    /**
     * Metodo encargado de iniciar la modificacion de las casillas.
     * Este metodo se encarga pidiendo en que coordeana en x legustaria al jugador ser reubicado
     */
    @Override
    public void modificarCasilla() {
        
        casillaModificada = false;
        int opcionCorrecta = -1;
        
        while(opcionCorrecta < 1){
            try{
                System.out.println("===================================");
                System.out.println("|| Bienvenido al menu de edicion ||");
                System.out.println("=================================== ");
                System.out.println("|| ¿Desea que esta casilla deje  ||");
                System.out.println("|| huir al personaje durante una ||");
                System.out.println("|| batalla?                      ||");
                System.out.println("===================================");
                System.out.println("|| 1. Si                         ||");
                System.out.println("|| 2. No                         ||");
                System.out.println("===================================");
                System.out.print("Ingrese su opcion: ");
                opcionCorrecta = scanner.nextInt();
                
                if(opcionCorrecta >= 1 && opcionCorrecta <= 2){
                    if(opcionCorrecta == 1){
                        escaparDeCombate = true;
                        controlador.limpiarPantalla();
                        obtenerCoordenadas();
                        System.out.println("Ahora puedes huir durante un combate");
                    } else{
                        System.out.println("No podras huir durante una batalla");
                    }
                } else{
                    
                    System.out.println("Opcion no valida, intente de nuevo");
                   
                } 
           
            } catch(InputMismatchException e){
                scanner.nextLine();
                controlador.limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo");
            }
        }
        
        
    }

    /**
     * Metodo encargado de obtener las coordenadas del jugador, estas coordenadas sive para 
     * que cuando el jugador piuerd la batalla puesa ser penalizado segun el usuario.
     */
    private void obtenerCoordenadas(){
        
        
        while(coordenadaXModificada > 0 && coordenadaXModificada <= mapa.getCantidadColumnas()){
            try{
                System.out.println("=========================================");
                System.out.println("|| Ahora debes de colocar la           ||");
                System.out.println("|| coordenada en X donde quieres       ||");
                System.out.println("|| ser reubicado cuando seas derrotado ||");
                System.out.println("=========================================");
                System.out.print("Ingrese la coordenada en X ( " + mapa.getCantidadColumnas() + 1 + " ): " );
                coordenadaXModificada = scanner.nextInt();
                
                if(coordenadaXModificada > 0 && coordenadaXModificada <= mapa.getCantidadColumnas()){
                    jugador.setPosicionX(coordenadaXModificada - 1);
                    System.out.println("Has colocado una nueva coordenada");
                } else{
                    controlador.limpiarPantalla();
                    System.out.println("Coordenada no disponible, intente de nuevo");
                }
            }catch(InputMismatchException e ){
                scanner.nextLine();
                controlador.limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo. ");
            }
                   
        }
        
        controlador.limpiarPantalla();
        
        while(coordenadaYModificada > 0 && coordenadaYModificada <= mapa.getCantidadFilas()){
            try{
                System.out.println("=========================================");
                System.out.println("|| Ahora debes de colocar la           ||");
                System.out.println("|| coordenada en Y donde quieres       ||");
                System.out.println("|| ser reubicado cuando seas derrotado ||");
                System.out.println("=========================================");
                System.out.print("Ingrese la coordenada en Y ( " + mapa.getCantidadFilas() + 1 + " ): " );
                coordenadaYModificada = scanner.nextInt();
                
                if(coordenadaYModificada > 0 && coordenadaYModificada <= mapa.getCantidadColumnas()){
                    jugador.setPosicionX(coordenadaYModificada - 1);
                    System.out.println("Has colocado una nueva coordenada");
                } else{
                    controlador.limpiarPantalla();
                    System.out.println("Coordenada no disponible, intente de nuevo");
                }
            } catch(InputMismatchException e){
                scanner.nextLine();
                controlador.limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo.");
            }
        }
    }
    
     @Override
    public void efectoDeCasillaModificado() {

    }
    
    @Override
    public void menuDeModificacion() {

    }

    @Override
    public void aplicarEfecto() {
      
    }
    
    public int getHpAnterior() {
        return hpAnterior;
    }

    public int getMpAnterior() {
        return mpAnterior;
    }

    public int getDefensaAnterior() {
        return defensaAnterior;
    }
    
}
