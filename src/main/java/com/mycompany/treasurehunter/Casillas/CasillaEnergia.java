/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Mapa.Mapa;
import com.mycompany.treasurehunter.Personaje.Jugador;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class CasillaEnergia extends Casilla {
    
    private final ControladorMetodos controlador;
    private int hpRecuperado = -1;
    private int mpRecuperado = -1;
    private boolean casillaEditada;
    
    public CasillaEnergia(Jugador jugador, Mapa mapa) {
        super(jugador, "Casilla Energia ", mapa);
        this.casillaEditada = false;
        this.controlador = new ControladorMetodos();
    }

    @Override
    public void efectoDeCasillaNormal() {
     
        System.out.println("Has caído en una casilla de energía.");

        if (casillaEditada == false) {
            hpRecuperado = controlador.calcularNumerosAleatorios(15, 40);
            mpRecuperado = controlador.calcularNumerosAleatorios(8, 15);
        }

            jugador.setVidaPersonaje(jugador.getVidaPersonaje() + hpRecuperado);
            System.out.println("Has recuperado " + hpRecuperado + " puntos de vida.");

        if (jugador.getVidaPersonaje() >= jugador.getVidaMaxPersonaje()) {
            jugador.verificarAtributosMax(true);
            
           } else {
                jugador.setPuntosDeMana(jugador.getPuntosDeMana() + mpRecuperado);
                System.out.println("Has recuperado " + mpRecuperado + " puntos de maná.");

            if (jugador.getPuntosDeMana() >= jugador.getManaMax()) {
                jugador.verificarAtributosMax(false);
            }
        }
    }

    @Override
    public void modificarCasilla() {
        Scanner scanner = new Scanner(System.in);
        casillaEditada = true;
        
        while(mpRecuperado < 0 || hpRecuperado < 0){
            try{
            System.out.println("====================================");
            System.out.println("|| Ingrese la cantidad de Mp y Hp ||");
            System.out.println("|| que quieres recuperar.         ||");
            System.out.println("=====================================");
            System.out.print("Ingrese la cantidad de HP: ");
            hpRecuperado = scanner.nextInt();
            
            controlador.limpiarPantalla();
            
                System.out.println("===============================");
                System.out.println("|| Ingresa la cantidad de Mp ||");
                System.out.println("|| a recuperar.              ||");
                System.out.println("===============================");
                System.out.print("Cantidad de Mp: ");
                
                mpRecuperado = scanner.nextInt();
                
        } catch(InputMismatchException e){
            scanner.nextLine();
            System.out.println("Opcion no valida, intente de nuevo. ");
        }
        }
    }

    @Override
    public void menuDeModificacion() {

    }

    @Override
    public void efectoDeCasillaModificado() {
       
    }

    @Override
    public void aplicarEfecto() {
        
    }

}
