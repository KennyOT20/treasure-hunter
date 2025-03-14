/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Mapa;

import com.mycompany.treasurehunter.Personaje.Jugador;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author kenny
 */
public class Mapa implements Serializable {
    
    private Jugador jugador;
    
    private static final String FONDO_NEGRO = "\u001B[40m";
    private static final String FONDO_AMARILLO_BRILLANTE = "\u001B[103m";
    private static final String FONDO_ROJO = "\u001B[41m";
    private static final String FONDO_VERDE = "\u001B[42m";
    private static final String FONDO_AMARILLO = "\u001B[43m";
    private static final String FONDO_AZUL = "\u001B[44m";
    private static final String FONDO_CYAN = "\u001B[46m";
    private static final String FONDO_BLANCO = "\u001B[47m";
    private static final String TEXTO_NEGRO = "\u001B[30m";
    private static final String RESETEAR_FONDO = "\u001B[0m";
    private static final String[] SIMBOLOS_CASILLAS = {" ", "C","E","M","P", "T","R"};
    private static final String SIMBOLO_CASILLA_TESORO = "K";
    private int cantidadFilas;
    private int cantidadColumnas;
    private int coordenadaX;
    private int coordenadaY;
    private String [][] mapa;

    public Mapa(Jugador jugador) {
        this.jugador = jugador;
    }
    
    //Metodo encargado de generar un mapa por defecto de 27 *27 
    public void generarMapaPorDefecto(){
        cantidadFilas = 24;
        cantidadColumnas = 24;
        jugador.setPosicionX(4);
        jugador.setPosicionY(3);
        mapa = new String[cantidadFilas][cantidadColumnas];
        inicializarMapa();
        generarMapa();
        
    }
   
    //Metodo encargado de generar el indice de letrar horizonal(a,b,c,d,e,f,g....x,y,z)
    private void generarIndiceHorizontal(){
        System.out.print("    ");
        for (int j = 0; j < mapa[0].length - 1; j++) {
            System.out.print((char) ('A' + j) + "  ");
        }
        System.out.println();
    }
    
    //Metodo encargado de imprimir el mapa con los indices ya bien definido
    private void imprimirMapa(){
        for (int i = 0; i < cantidadFilas; i++) {
            System.out.printf("%2d ", (i + 1)); //.printf para darle 2 espacios definidos al indce
            for (int j = 0; j < cantidadColumnas - 1; j++) {
                agregarColores(i, j);
            }
            System.out.println();
        }
    }
    
    //metodo encargado de iniciar el mapa con espacios vacios
    private void inicializarMapa(){
        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j <cantidadColumnas - 1; j++) {
                mapa[i][j] = generarCasillas();
            }
        }
    }
    
    //Metodo encargado de colocar el simbolo del jugador en el mapa
    private void colocarJugadorEnMapa(){
        mapa[jugador.getPosicionX()][jugador.getPosicionY()] = String.valueOf(jugador.getSimboloJugador());
    }
    
    //Metodos encargados de realizar los movimientos del jugador: Arriba, abajo, izquierda o Derecha.
    public void movimientoDerecha(){
        coordenadaX = jugador.getPosicionX();
        coordenadaY = jugador.getPosicionY();
        
        jugador.setPosicionY(jugador.getPosicionY() + 1);
        
            if(jugador.getPosicionY() == mapa[0].length - 1 ){
                System.out.println("Has alcanzado el limite del mapa "); 
                jugador.setPosicionY(jugador.getPosicionY() - 1);
                actualizarMapa();
                generarMapa();
            } else{
                actualizarMapa();
                generarMapa();
            }
    }
    
    public void movimientoIzquierda(){
        coordenadaX = jugador.getPosicionX();
        coordenadaY = jugador.getPosicionY();
       
        jugador.setPosicionY(jugador.getPosicionY() - 1);
        
            if(jugador.getPosicionY() == -1){
                System.out.println("Has alcanzado el limite del mapa");
                jugador.setPosicionY(jugador.getPosicionY() + 1);
                actualizarMapa();
                generarMapa();
            } else{
                actualizarMapa();
                generarMapa();
            }
        
            
    }
    
    public void movimientoArriba(){
        coordenadaX = jugador.getPosicionX();
        coordenadaY = jugador.getPosicionY();
        
        jugador.setPosicionX(jugador.getPosicionX() - 1 );
        
            if(jugador.getPosicionX() == -1 ){
                System.out.println("Has alcanzado el limite del mapa");
                jugador.setPosicionX(jugador.getPosicionX() + 1 );
                actualizarMapa();
                generarMapa();
            } else{
                actualizarMapa();
                generarMapa();
            }
    }
    
    public void movimientoAbajo(){
        coordenadaX = jugador.getPosicionX();
        coordenadaY = jugador.getPosicionY();
        
        jugador.setPosicionX(jugador.getPosicionX() + 1);
                
            if(jugador.getPosicionX() == mapa[0].length ){
                System.out.println("Has alcanzado el limite del mapa");
                jugador.setPosicionX(jugador.getPosicionX() - 1);
                actualizarMapa();
                generarMapa();
            }else{
                actualizarMapa();
                generarMapa();
            }
    }
    
    //Metodo encargado de ir actualizando el mapa cada vez que el jugador pase por encima de una casilla
    private void actualizarMapa(){
        
        mapa[coordenadaX][coordenadaY] = " ";
        colocarJugadorEnMapa();
    }
    
    /**
     * Metodo encargado de pintar las casillas segun el tipo que sea
     * @param i es encargado de recibir desde el metodo imprimirMapa la cantidad de filas
     * @param j es encargado de recibir desde el metodo imprimirMapa la cantidad de columnas
     */
    private void agregarColores(int i, int j){
        if(mapa[i][j].equals(SIMBOLOS_CASILLAS[0])){
            System.out.print(FONDO_NEGRO + "   "+ RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[1])){
            System.out.print(FONDO_ROJO + "   " + RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[2])){
            System.out.print(FONDO_VERDE + "   " + RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[3])){
            System.out.print(FONDO_AMARILLO_BRILLANTE + "   " + RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[4])){
            System.out.print(FONDO_AZUL + "   " + RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[5])){
            System.out.print(FONDO_AMARILLO + "   " + RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[6])){
            System.out.print(FONDO_CYAN + "   " + RESETEAR_FONDO);
        }else if(i == jugador.getPosicionX() && j == jugador.getPosicionY()){
            System.out.print(FONDO_BLANCO + TEXTO_NEGRO + " " + jugador.getSimboloJugador() + " " + RESETEAR_FONDO);
        }
    }
    
    //Metodo encargado de generar el mapa ya con todas las validaciones posibles
    public void generarMapa(){
        simbologiaDeMapa();
        generarIndiceHorizontal();
        colocarJugadorEnMapa();
        imprimirMapa();
    }
    
    /**
     * Metodo encargado de generar las casillas aleatorias mediante el simbolo de las casillas
     * @return un simbolo y lo coloca en el mapa en el metodo inicializar mapa
     */
    private String generarCasillas(){
        Random random = new Random();
        int indiceCasillas = random.nextInt(SIMBOLOS_CASILLAS.length);
        String letraAletoria = SIMBOLOS_CASILLAS[indiceCasillas];
        return letraAletoria;
    }
    
    private void comprobarCasillas(){
        
    }
    
    private void simbologiaDeMapa(){
        
        System.out.println("Partida de: " + jugador.getNombrePersonaje());
        System.out.print("Jugador: " + FONDO_BLANCO + TEXTO_NEGRO + " " + jugador.getSimboloJugador() + " " + RESETEAR_FONDO + " Casillas--> " );
        System.out.print(" |Normal: " + FONDO_NEGRO + "   "+ RESETEAR_FONDO);
        System.out.print(" |Energia: " + FONDO_VERDE + "   " + RESETEAR_FONDO );
        System.out.print(" |Combate: " + FONDO_ROJO + "   " + RESETEAR_FONDO);
        System.out.print(" |Pista: " + FONDO_AMARILLO_BRILLANTE + "   " + RESETEAR_FONDO);
        System.out.print(" |Teletransporte: " + FONDO_CYAN + "   " + RESETEAR_FONDO );
        System.out.print(" |Muro: " + FONDO_AMARILLO + "   " + RESETEAR_FONDO);
        System.out.print(" |Trampa: " + FONDO_AZUL + "   " + RESETEAR_FONDO );
        System.out.println();
        System.out.println();
    }
    
    //Getters y Setters necesarios
    public int getCantidadFilas() {
        return cantidadFilas;
    }

    public void setCantidadFilas(int cantidadFilas) {
        this.cantidadFilas = cantidadFilas;
    }

    public int getCantidadColumnas() {
        return cantidadColumnas;
    }

    public void setCantidadColumnas(int cantidadColumnas) {
        this.cantidadColumnas = cantidadColumnas;
    }
    
   
}