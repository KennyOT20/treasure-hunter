/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Personaje;

import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class Jugador extends Personaje{
    
    private String nombreJugador;
    private int puntosDeMana;
    private int puntosDeVida;
    private int puntosDeDefensa;
    private int vidaMax;
    private int manaMax;
    private int defensaMax;
    private int posicionX;
    private int posicionY;
    private char simboloJugador;

    public Jugador() {
        super("Sin nombre", 500, 0);
    }


    //Metodo para encargado de obtener y validar el nombre del jugador.
    public String obtenerNombre(){
        
        Scanner scanner = new Scanner(System.in);
        
        do{
            System.out.println("==============================");
            System.out.println("|| Ingrese el nombre de tu  ||");
            System.out.println("|| personaje                ||");
            System.out.println("==============================");
            System.out.print("Nombre: ");
                
            nombreJugador = scanner.nextLine().trim();
            
            if(nombreJugador.isEmpty()){
                System.out.println("¡Error!, el nombre no puede estar vacio");
            }
        } while(nombreJugador.isEmpty());
     
        obtenerSimboloJugador(nombreJugador);
        
        return nombreJugador;
    }
    
    //metodo encargado de obtener un simbolo del ujugador para representarlo en el mapa
    private void obtenerSimboloJugador(String nombreJugador){
        char [] nombre = nombreJugador.toCharArray();
        simboloJugador = Character.toUpperCase(nombre[0]);      
    }
    
    
    //Metodo abstracto para aplicar el ataque del jugador
      @Override
    public void aplicarAtaque(Personaje objetivo) {
    }
    
    //Getters y Setters mnecesarios para el jugador

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntosDeMana() {
        return puntosDeMana;
    }

    public void setPuntosDeMana(int puntosDeMana) {
        this.puntosDeMana = puntosDeMana;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    public int getPuntosDeDefensa() {
        return puntosDeDefensa;
    }

    public void setPuntosDeDefensa(int puntosDeDefensa) {
        this.puntosDeDefensa = puntosDeDefensa;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public int getManaMax() {
        return manaMax;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public int getDefensaMax() {
        return defensaMax;
    }

    public void setDefensaMax(int defensaMax) {
        this.defensaMax = defensaMax;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public char getSimboloJugador() {
        return simboloJugador;
    }

    public void setSimboloJugador(char simboloJugador) {
        this.simboloJugador = simboloJugador;
    }
 
}
