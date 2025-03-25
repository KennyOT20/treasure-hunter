/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Mapa;

import com.mycompany.treasurehunter.Casillas.CasillaCombate;
import com.mycompany.treasurehunter.Casillas.CasillaEnergia;
import com.mycompany.treasurehunter.Casillas.CasillaMuro;
import com.mycompany.treasurehunter.Casillas.CasillaNormal;
import com.mycompany.treasurehunter.Casillas.CasillaPista;
import com.mycompany.treasurehunter.Casillas.CasillaTeletransporte;
import com.mycompany.treasurehunter.Casillas.CasillaTrampa;
import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Personaje.Jugador;
import java.io.Serializable;

/**
 *
 * @author kenny
 */
public class Mapa implements Serializable {
    
    private final Jugador jugador;
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
    private static final String[] SIMBOLOS_CASILLAS = {"N", "C","E","M","P", "T","R"};
    private static final String CASILLA ="   ";
    private static final String SIMBOLO_FONDO = "F";
    private static final String FONDO_TABLERO = "\u001B[45m";
    private String casillaAnteriorJugador = SIMBOLOS_CASILLAS[0];
    private int cantidadFilas;
    private int cantidadColumnas;
    private int jugadorCoordenadaX;
    private int jugadorCoordenadaY;
    private int movimientoArriba;
    private int movimientoAbajo;
    private int movimientoDerecha;
    private int movimientoIzquierdo;
    private String [][] mapa;

    public Mapa(Jugador jugador) {
        this.jugador = jugador;
        this.cantidadColumnas = 5;
        this.cantidadFilas = 5;
        this.mapa = new String[cantidadFilas][cantidadColumnas];
    }
    
    //Metodo encargado de generar un mapa por defecto de 27 *27 
    public void generarMapaPorDefecto(){
        cantidadFilas = 24;
        cantidadColumnas = 24;
        jugador.setPosicionX(1);
        jugador.setPosicionY(1);
        mapa = new String[cantidadFilas][cantidadColumnas];
        inicializarMapa(false);
        generarMapa();
        
    }
    
    public void mapaCreado(){
        mapa = new String[cantidadFilas][cantidadColumnas];
        inicializarMapa(true);
        generarMapa();
        
    }
   
    //Metodo encargado de generar el indice de letrar horizonal(a,b,c,d,e,f,g....x,y,z)
    private void generarIndiceHorizontal(){
        System.out.print("    ");
        for (int j = 0; j < mapa[0].length ; j++) {
            System.out.print((char) ('A' + j) + "  ");
        }
        System.out.println();
    }
    
    //Metodo encargado de imprimir el mapa con los indices ya bien definido
    private void imprimirMapa(){
        for (int i = 0; i < cantidadFilas; i++) {
            System.out.printf("%2d ", (i + 1)); //.printf para darle 2 espacios definidos al indce
            for (int j = 0; j < cantidadColumnas ; j++) {
                agregarColores(i, j);
            }
            System.out.println();
        }
    }
    
    //metodo encargado de iniciar el mapa con espacios vacios
    public void inicializarMapa(boolean mapaCreado){
        
        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j < cantidadColumnas ; j++) {
                if(mapaCreado == false){
                    mapa[i][j] = generarCasillas();
                    //mapa[0][0] = "K";
                } else{
                   mapa[i][j] = SIMBOLO_FONDO; 
                }
                
            }
        }
    }
    
    //Metodo encargado de colocar el simbolo del jugador en el mapa
    private void colocarJugadorEnMapa(){
        mapa[jugador.getPosicionX()][jugador.getPosicionY()] = String.valueOf(jugador.getSimboloJugador());
    }
    
    //Metodos encargados de realizar los movimientos del jugador: Arriba, abajo, izquierda o Derecha.
    public void movimientoDerecha(){
        movimientoDerecha ++;
        jugadorCoordenadaX = jugador.getPosicionX();
        jugadorCoordenadaY = jugador.getPosicionY();
        
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
        movimientoIzquierdo ++;
        jugadorCoordenadaX = jugador.getPosicionX();
        jugadorCoordenadaY = jugador.getPosicionY();
       
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
        movimientoArriba ++;
        jugadorCoordenadaX = jugador.getPosicionX();
        jugadorCoordenadaY = jugador.getPosicionY();
        
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
        movimientoAbajo ++;
        jugadorCoordenadaX = jugador.getPosicionX();
        jugadorCoordenadaY = jugador.getPosicionY();
        
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
    
    /*
    Metodo encargado de ir acutalizando el mapa luego de un movimiento del jugador
    se encarga de ir guardando los simbolos de la antigua casilla y la nueva casilla 
    del jugador para poder evitar que las casillas se borren o se sobreescriban con colores.
    */
   public void actualizarMapa(){
      mapa[jugadorCoordenadaX][jugadorCoordenadaY] = casillaAnteriorJugador;
      
      String casillaNuevaJugador = mapa[jugador.getPosicionX()][jugador.getPosicionY()];
      
      if(!verificarCasilla(casillaNuevaJugador)){
          casillaAnteriorJugador = casillaNuevaJugador;
      }
    
      llamarCasilla(casillaNuevaJugador);
      colocarJugadorEnMapa();
      
    }
   
   
   /**
    * Metodo encargado de verificar si es una casilla teletransporte o una casillaMuro
    * para poder evitar que cuando se pise una casilla de estas, no pinte o sobreescriba el fondo
    * de la otra casilla que pisa el jugador.
    * @param comprobarCasilla recibe el simbolo y el fondo de la nueva casilla del jugador como parametro
    * enviado desde el metodo actualizar mapa
    * @return una verificacion si la casilla del jugador es igual al simbolo de la casilla muro o de la casilla
    * teletransporte para evitar sobreescribir casillas
    */
   private boolean verificarCasilla(String comprobarCasilla){
       return comprobarCasilla.equals("M") || comprobarCasilla.equals("T");
   }
    
    /**
     * Metodo encargado de pintar las casillas segun el tipo que sea
     * @param i es encargado de recibir desde el metodo imprimirMapa la cantidad de filas
     * @param j es encargado de recibir desde el metodo imprimirMapa la cantidad de columnas
     */
    private void agregarColores(int i, int j){
        
        if(i == jugador.getPosicionX() && j == jugador.getPosicionY()){
            System.out.print(FONDO_BLANCO + TEXTO_NEGRO + " " + jugador.getSimboloJugador() + " " + RESETEAR_FONDO);
        } else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[0])){
            System.out.print(FONDO_NEGRO + CASILLA+ RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[1])){
            System.out.print(FONDO_ROJO + CASILLA + RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[2])){
            System.out.print(FONDO_VERDE + CASILLA + RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[3])){
            System.out.print(FONDO_AMARILLO + CASILLA + RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[4])){
            System.out.print(FONDO_AMARILLO_BRILLANTE + CASILLA + RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[5])){
            System.out.print(FONDO_CYAN + CASILLA + RESETEAR_FONDO);
        }else if(mapa[i][j].equals(SIMBOLOS_CASILLAS[6])){
            System.out.print(FONDO_AZUL + CASILLA + RESETEAR_FONDO);
        } else if(mapa[i][j].equals("K")){
            System.out.print(FONDO_NEGRO + CASILLA + RESETEAR_FONDO);  
        } else if(mapa[i][j].equals(SIMBOLO_FONDO)){
            System.out.print(FONDO_TABLERO + CASILLA + RESETEAR_FONDO);
        }
        
    }
   
    /**
     * Metodo encargado de la edicion de las casillas, este metodo se encarga de 
     * de ir validando si el usuario coloca una casilla fuera de los limites
     * @param fila recibe la coordenada en que fila colocara el usuario la casilla
     * @param columna recible la coordenada en que columna colocara el usuario su casilla
     * @param simboloCasilla coloca el simbolo correspondiente en el mapa 
     */
    public void editarCasillas(int fila, int columna, String simboloCasilla){
       // System.out.println("Simbolo puesto:" + simboloCasilla);
        if(fila >= 0 && fila < cantidadFilas && columna >= 0 && columna < cantidadColumnas){
             mapa[fila][columna] = simboloCasilla;
             actualizarMapa();
        } else{
            System.out.println("Posicion fuera de los limites");
        }
    }
    
    //Metodo encargado de generar el mapa ya con todas las validaciones posibles
    public void generarMapa(){
    //    jugador.mostrarEstadoPersonaje();
        simbologiaDeMapa();
        generarIndiceHorizontal();
        colocarJugadorEnMapa();
        imprimirMapa();
    }
    
    /**
     * Metodo encargado de generar las casillas aleatorias mediante una letra que representa a una casilla en
     * especifico.
     * @return un simbolo y lo coloca en el mapa en el metodo inicializar mapa
     */
    private String generarCasillas(){
        ControladorMetodos controlador = new ControladorMetodos();
        int indiceCasillas = controlador.calcularNumerosAleatorios(0, SIMBOLOS_CASILLAS.length);
        String letraAletoria = SIMBOLOS_CASILLAS[indiceCasillas];
        return letraAletoria;
    }
    
    /*
    Metodo encargado de mostrar que significa cada color que lleva el mapa, como las casillas combates
    , simbolo del jugador entre otros.
    */
    private void simbologiaDeMapa(){
        System.out.println("");
        System.out.print("Jugador: " + FONDO_BLANCO + TEXTO_NEGRO + " " + jugador.getSimboloJugador() + " " + RESETEAR_FONDO + " Casillas--> " );
        System.out.print(" |Normal: " + FONDO_NEGRO + "   "+ RESETEAR_FONDO);
        System.out.print(" |Energia: " + FONDO_VERDE + "   " + RESETEAR_FONDO );
        System.out.print(" |Combate: " + FONDO_ROJO + "   " + RESETEAR_FONDO);
        System.out.print(" |Pista: " + FONDO_AMARILLO_BRILLANTE + "   " + RESETEAR_FONDO);
        System.out.print(" |Teletransporte: " + FONDO_CYAN + "   " + RESETEAR_FONDO );
        System.out.print(" |Muro: " + FONDO_AMARILLO + "   " + RESETEAR_FONDO);
        System.out.print(" |Trampa: " + FONDO_AZUL + "   " + RESETEAR_FONDO + "|");
        System.out.println();
        System.out.println();
    }
    
    //Metodo encargado de ir llamando el efecto de la casilla correspondiente dependiendo de la posicion del jugador.
    private void llamarCasilla(String casillaActual){
     boolean tesoroEncontrado = false;
        if(casillaActual.equals(SIMBOLOS_CASILLAS[0])){
            new CasillaNormal(jugador, this).efectoDeCasillaNormal();
        } else if(casillaActual.equals(SIMBOLOS_CASILLAS[1])){
            new CasillaCombate(jugador, this).efectoDeCasillaNormal();
        } else if(casillaActual.equals(SIMBOLOS_CASILLAS[2])){
            new CasillaEnergia(jugador, this).efectoDeCasillaNormal();
        } else if(casillaActual.equals(SIMBOLOS_CASILLAS[3])){
            new CasillaMuro(jugador, this).efectoDeCasillaNormal();
        } else if(casillaActual.equals(SIMBOLOS_CASILLAS[4])){
            new CasillaPista(jugador, this).efectoDeCasillaNormal();
        } else if(casillaActual.equals(SIMBOLOS_CASILLAS[5])){
            new CasillaTeletransporte(jugador, this).efectoDeCasillaNormal();
        } else if(casillaActual.equals(SIMBOLOS_CASILLAS[6])){
            new CasillaTrampa(jugador, this).efectoDeCasillaNormal();
        } else{
            tesoroEncontrado = true;
           jugador.setTesoroEncontrado(tesoroEncontrado);
        }
            
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

    public int getJugadorCoordenadaX() {
        return jugadorCoordenadaX;
    }

    public int getJugadorCoordenadaY() {
        return jugadorCoordenadaY;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public static String[] getSIMBOLOS_CASILLAS() {
        return SIMBOLOS_CASILLAS;
    }



}