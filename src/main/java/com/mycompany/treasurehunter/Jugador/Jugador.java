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
            calcularMana();
            puntosDeVida += calcularCura();
        } else{
            System.out.println("Puntos de mana insuficiente, intente de nuevo");
        }
    }
    
    //metodo encargado de evaluar la cantidad de  puntos de mana y que no sea menor de 0
    private void calcularMana(){
        
        puntosDeMana --;
        
            if(puntosDeMana <= 0){
                puntosDeMana = 0;
            }
    }
    
    //Metodo encargado de calcular la defensa del jugador (reducir el ataque del enemigo)
    private int calcularDefensa(){
        
        int defensa = 15;
        return defensa;
    }
    
    public void aplicarDefensa(){
        
    }
    
    private int calcularAtaque(){
        
        int ataque = numerosAleatorios(18, 32);
        
        return ataque;
    }
    
    public void aplicarAtaque(){
        
    }
    
    //Metodo encargado de obtener numeros aleatorios para calcular la defensa,cura o ataque del jugador
    private int numerosAleatorios(int minimo, int maximo){
        Random random = new Random();
        return random.nextInt((maximo - minimo) + 1) + minimo ;
    }
    
}
