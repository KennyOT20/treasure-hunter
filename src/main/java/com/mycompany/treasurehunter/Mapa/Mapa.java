/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Mapa;

import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class Mapa {
    
    private Jugador jugador;
    private static final String FONDO_BLANCO = "\u001B[47m";
    private static final String RESETEAR_FONDO = "\u001B[0m";
    private static final String FONDO_NEGRO = "\u001B[40m";
    private static final String TEXTO_NEGRO = "\u001B[30m";
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
        cantidadFilas = 27;
        cantidadColumnas = 27;
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
                mapa[i][j] = " ";
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
        if(mapa[i][j].equals(" ")){
            System.out.print("[" + FONDO_NEGRO + " "+ RESETEAR_FONDO + "]");
        }else if(i == jugador.getPosicionX() && j == jugador.getPosicionY()){
            System.out.print("[" + FONDO_BLANCO + TEXTO_NEGRO + jugador.getSimboloJugador() + RESETEAR_FONDO + "]");
        }
    }
    
    //Metodo encargado de generar el mapa ya con todas las validaciones posibles
    public void generarMapa(){
        generarIndiceHorizontal();
        generarCasillas();
        colocarJugadorEnMapa();
        imprimirMapa();
    }
    
    private void generarCasillas(){
        
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