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
    private int coordenadaXModificada;
    private int opcionHuirDeCasilla;
    
    public CasillaCombate(Jugador jugador, Mapa mapa) {
        super(jugador, "Casilla combate", mapa);
        this.controlador = new ControladorMetodos();
    } 
     

    @Override
    public void efectoDeCasillaNormal() {
        Enemigo enemigo = new Enemigo();
        Batalla batalla = new Batalla(jugador, enemigo, this);
        
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
        Scanner scanner = new Scanner(System.in);
        
        boolean casillaModificada = true;
        setCasillaModificada(casillaModificada);
        int coordenadaX = -1;
        int coordenadaY = -1;

        
        while (coordenadaX <= 0 || coordenadaX > mapa.getCantidadColumnas() || 
       coordenadaY <= 0 || coordenadaY > mapa.getCantidadFilas()) {
            try{
                System.out.println("===========================================");
                System.out.println("||     Menu de modificacion de la        ||");
                System.out.println("|| casilla " + getNombre() + " ");
                System.out.println("===========================================");
                System.out.println("|| Ingrese la coordenada en X en la que  ||");
                System.out.println("|| quieres ser reubicado luego de perder ||");
                System.out.println("==========================================");
                System.out.print("Coordenada en X: ");
                coordenadaX = scanner.nextInt();
                
                System.out.println("===========================================");
                System.out.println("|| Ingrese la coordenada en X en la que  ||");
                System.out.println("|| quieres ser reubicado luego de perder ||");
                System.out.println("==========================================");
                System.out.print("Coordenada en Y: ");
                coordenadaY = scanner.nextInt();
                
                
                System.out.println("=========================================");
                System.out.println("|| Desea que esta casilla te deje huir ||");
                System.out.println("|| del combate.                        ||");
                System.out.println("=========================================");
                System.out.println("|| 1. Si                               ||");
                System.out.println("|| 2. No                               ||");
                System.out.println("==========================================");
                opcionHuirDeCasilla = scanner.nextInt();
                
                if(opcionHuirDeCasilla >= 1 && opcionHuirDeCasilla <= 2){
                    if(opcionHuirDeCasilla == 1){
                        escaparDeCombate = true;
                    } else{
                        escaparDeCombate = false;
                    }
                } else{
                    System.out.println("Opcion incorrecta, intente de nuevo.");
                }
                
            } catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("Opcion incorrecta, intente de nuevo. ");
            }
        }
        
    }

    @Override
    public void menuDeModificacion() {

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

    @Override
    public void efectoDeCasillaModificado() {

    }

    @Override
    public void aplicarEfecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
