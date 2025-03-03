/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Jugador;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class Jugador {
    
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
    
    //Metodo para encargado de obtener y validar el nombre del jugador.
    public void obtenerNombre(){
        
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
     
        obtenerSimboloJugador();
    }
    
    //metodo encargado de obtener un simbolo del ujugador para representarlo en el mapa
    private void obtenerSimboloJugador(){
        char [] nombre = nombreJugador.toCharArray();
        simboloJugador = Character.toUpperCase(nombre[0]);      
    }
    
    //Metodo encargado de calcular la cura del personaje
    private int calcularCura(){
        int cura = numerosAleatorios(10, 25);
        return cura;
    }
    
    public void aplicarCura(){
      
        if(puntosDeMana > 0){
            puntosDeMana --;
            puntosDeVida += calcularCura();
        } else{
            System.out.println("Puntos de Mp insuficientes");
        }
    }
    
   
    
    //Metodo encargado de calcular la defensa del jugador (reducir el ataque del enemigo)
    private int calcularDefensa(){
        
        int defensa = numerosAleatorios (0,5);
        return defensa;
    }
    
    public void aplicarDefensa(){
        
        if(puntosDeMana > 0){
            puntosDeMana --;
        } else{
            System.out.println("Puntos de Mp insuficientes");
        }
       
    }
    
    /**
     * Metodo encargado de calcular el ataque que llega a tener el jugador
     * @return Un numero aleatorio entre 18 y 32 
     */
    private int calcularAtaque(){
        int ataque = numerosAleatorios(18, 32);
        return ataque;
    }
    
    public void aplicarAtaque(){
        
    }
    
    /**
     * Se encarga de retornar dos numeros aleatorios entre un intervalo de numeros
     * @param minimo Recibe un numero entre un intervalo minimo
     * @param maximo Recibe un numero entre un intervalo maximo
     * @return retorna un numero aleatorio entre los numeros obtenidos de <code> maximo <code> y  <code> minimo <code> 
     */
    private int numerosAleatorios(int minimo, int maximo){
        Random random = new Random();
        return random.nextInt(minimo, maximo) ;
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
