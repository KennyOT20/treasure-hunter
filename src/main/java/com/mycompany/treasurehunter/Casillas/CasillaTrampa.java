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
public class CasillaTrampa extends Casilla {
    
    private final ControladorMetodos controlador;
    private int puntosDefinidosHpPerdido;
    private int puntosDefinidosMpPerdidos;
    private int puntosDeHpPerdido;
    private int puntosDeMpPerdido;
    private boolean casillaEditada;
    private static final Scanner scanner = new Scanner(System.in);
    
    public CasillaTrampa(Jugador jugador, Mapa mapa) {
        super(jugador, "Casilla Trampa ", mapa);
        this.casillaEditada = false;
        this.controlador = new ControladorMetodos();
    }

    @Override
    public void efectoDeCasillaNormal() {
       boolean elegirTrampa = controlador.opcionesActivas();

        if (!casillaEditada) { 
            if (!elegirTrampa) {
                puntosDeHpPerdido = controlador.calcularNumerosAleatorios(15, 28);
                jugador.setVidaPersonaje(jugador.getVidaPersonaje() - puntosDeHpPerdido);
            } else {
                puntosDeMpPerdido = controlador.calcularNumerosAleatorios(2, 8);
                jugador.setPuntosDeMana(jugador.getPuntosDeMana() - puntosDeMpPerdido);
            }
        } else { 
            if (!elegirTrampa) {
                jugador.setVidaPersonaje(jugador.getVidaPersonaje() - puntosDefinidosHpPerdido);
                puntosDeHpPerdido = puntosDefinidosHpPerdido;
            } else {
                jugador.setPuntosDeMana(jugador.getPuntosDeMana() -  puntosDefinidosMpPerdidos);
                puntosDeMpPerdido =  puntosDefinidosMpPerdidos;
            }
        }

        if (jugador.getVidaPersonaje() <= 0) {
            jugador.verifivarAtributosMin(true);
        }
        if (jugador.getPuntosDeMana() <= 0) {
            jugador.verifivarAtributosMin(false);
        }

        
        System.out.println("¡Oh no, caiste en una trampa!");
        if (!elegirTrampa) {
            System.out.println("Has perdido " + puntosDeHpPerdido + " de HP.");
        } else {
            System.out.println("Has perdido " + puntosDeMpPerdido + " de MP.");
        }
    }

    
    @Override
    public void modificarCasilla() {
        casillaEditada = true;
        while(puntosDefinidosHpPerdido < 1 ){
            try{
                System.out.println("================================");
                System.out.println("|| Ingrese la cantidad de Hp  ||");
                System.out.println("|| que deseas perder.         ||");
                System.out.println("================================");
                System.out.print("Cantidad de Hp: ");
                puntosDefinidosHpPerdido = scanner.nextInt();
                scanner.nextLine();
                
                if(puntosDefinidosHpPerdido > 0 ){
                    controlador.limpiarPantalla();
                    System.out.println("Ahora esta casilla te penalizara con:");
                    System.out.println(puntosDefinidosHpPerdido + " de hp perdido");
                    System.out.print("Presione enter para continuar. ");
                    scanner.nextLine();
                    menuDeModificacion();
                
                } else{
                    controlador.limpiarPantalla();
                    System.out.println("La cantidad debe de ser mayor a 0.");
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
        
          while( puntosDefinidosMpPerdidos < 1 ){

            try{
                System.out.println("================================");
                    System.out.println("|| Ingrese la cantidad de Hp  ||");
                    System.out.println("|| que deseas perder.         ||");
                    System.out.println("================================");
                    System.out.print("Cantidad de Mp: ");
                     puntosDefinidosMpPerdidos = scanner.nextInt();
                    scanner.nextLine();
                
                if(puntosDefinidosHpPerdido > 0 ){
                    controlador.limpiarPantalla();
                    System.out.println("Ahora esta casilla te penalizara con:");
                    System.out.println( puntosDefinidosMpPerdidos + " de Mp perdido");
                    System.out.println("Presione enter para continuar.");
                    scanner.nextLine();
                
                } else{
                    controlador.limpiarPantalla();
                    System.out.println("La cantidad debe de ser mayor a 0.");
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
    public void aplicarEfecto() {
       
    }
    
}
