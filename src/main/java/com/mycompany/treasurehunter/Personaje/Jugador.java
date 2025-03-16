/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Personaje;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class Jugador extends Personaje{
    
    private int puntosDeMana;
    private int puntosDeDefensa;
    private int manaMax;
    private int defensaMax;
    private int posicionX;
    private int posicionY;
    private char simboloJugador;
    
    //Constructor con valores iniciales
    public Jugador() {
        super("", 500, 500, 0);
    }

    //Metodo para encargado de obtener y validar el nombre del jugador.
    public void obtenerNombre(){
        
        Scanner scanner = new Scanner(System.in);
        String nombreJugador;
        
        do{
            System.out.println("==============================");
            System.out.println("|| Ingrese el nombre de tu  ||");
            System.out.println("|| personaje                ||");
            System.out.println("==============================");
            System.out.print("Nombre: ");
                
            nombreJugador = scanner.nextLine().trim();
            
            if(nombreJugador.isEmpty()){
                ControladorMetodos.limpiarPantalla();
                System.out.println("¡Error!, el nombre no puede estar vacio");
            }
        } while(nombreJugador.isEmpty());
        
        setNombrePersonaje(nombreJugador);
        obtenerSimboloJugador(nombreJugador);
    }
    
    //metodo encargado de obtener un simbolo del ujugador para representarlo en el mapa
    private void obtenerSimboloJugador(String nombreJugador){
        char [] nombre = nombreJugador.toCharArray();
        simboloJugador = Character.toUpperCase(nombre[0]);      
    }
    
    public void verificarAtributosMax(boolean verificacion){
        if(verificacion == true){
            setVidaPersonaje(getVidaMaxPersonaje());
        } else{
            puntosDeMana = manaMax;
        }
    }
   
    public void verifivarAtributosMin(boolean verificacion){
        if(verificacion == true){
            setVidaPersonaje(0);
        } else{
            puntosDeMana = 0;
        }
    }
    
    //Metodo abstracto para aplicar el ataque del jugador
      @Override
    public void aplicarAtaque(Personaje objetivo) {
        
        int ataque = ControladorMetodos.calcularNumerosAleatorios(50,55);
        setAtaquePersonaje(ataque);
        System.out.println("Has atacado con " + getAtaquePersonaje());
        recibirAtaque(getAtaquePersonaje());
    }
    
    
    
    //Getters y Setters mnecesarios para el jugador

    public int getPuntosDeMana() {
        return puntosDeMana;
    }

    public void setPuntosDeMana(int puntosDeMana) {
        this.puntosDeMana = puntosDeMana;
    }

    public int getPuntosDeDefensa() {
        return puntosDeDefensa;
    }

    public void setPuntosDeDefensa(int puntosDeDefensa) {
        this.puntosDeDefensa = puntosDeDefensa;
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
