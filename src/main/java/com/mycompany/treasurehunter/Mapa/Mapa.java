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
    private int cantidadFilas;
    private int cantidadColumnas;
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
                System.out.print("[" + mapa[i][j] +  "]");
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
        
        jugador.setPosicionY(jugador.getPosicionY() + 1);
        
            if(jugador.getPosicionY() > mapa[0].length ){
                System.out.println("Has alcanzado el limite del mapa "); 
                jugador.setPosicionY(jugador.getPosicionY() - 1);
            } else{
                generarMapa();
               // actualizarMapa();
            }
    }
    
    public void movimientoIzquierda(){
       
        jugador.setPosicionY(jugador.getPosicionY() - 1);
        
            if(jugador.getPosicionY() < 0){
                System.out.println("Has alcanzado el limite del mapa");
                jugador.setPosicionY(jugador.getPosicionY() + 1); 
            } else{
                generarMapa();
            }
        
            
    }
    
    public void movimientoArriba(){
        
        jugador.setPosicionX(jugador.getPosicionX() - 1 );
        
            if(jugador.getPosicionX() < 0){
                System.out.println("Has alcanzado el limite del mapa");
                jugador.setPosicionX(jugador.getPosicionX() + 1 );
            } else{
                generarMapa();
            //    actualizarMapa();
            }
    }
    
    public void movimientoAbajo(){
        
        jugador.setPosicionX(jugador.getPosicionX() + 1);
        
            if(jugador.getPosicionX() > mapa.length){
                System.out.println("Has alcanzado el limite del mapa");
            }else{
                generarMapa();
                //actualizarMapa();
            }
    }
    
 
    
    //Metodo encargado de generar el mapa ya con todas las validaciones posibles
    public void generarMapa(){
        
        generarIndiceHorizontal();
        colocarJugadorEnMapa();
        imprimirMapa();
        
    }
    
   
}
