/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Mapa;

import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class Mapa {
    
    private static Scanner scanner = new Scanner(System.in); 
    private int cantidadFilas;
    private int cantidadColumnas;
    private String [][] mapa;
    
    //Metodo encargado de generar un mapa por defecto
    public void generarMapaPorDefecto(){
        cantidadFilas = 27;
        cantidadColumnas = 27;
        mapa = new String[cantidadFilas][cantidadColumnas];
        generarMapa();
        
    }
    
    //metodo encargado de hacer que el usuario pueda configurar los mapas.
    public void configurarMapa(){
        
    }
    
    
    //Metodo encargado de generar el indice de letrar horizonal(a,b,c,d,e,f,g....x,y,z)
    private void generarIndiceHorizontal(){
        
        System.out.println("    ");
        for (int j = 0; j < mapa[0].length; j++) {
            System.out.print((char) ('A' + j) + "  ");
        }
        System.out.println();
    }
    
    //Metodo encargado de comprobrar los espacios para que el mapa se imprima de manera correcta sin importar el tamaño
    private void comprobarEspacios(){
        
    }
    
    //Metodo encargado de imprimir el mapa con los indices ya bien definido
    private void imprimirMapa(){
        
        for (int i = 0; i < mapa.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print("[ ]");
            }
            System.out.println();
        }
    }
    
    //Metodo encargado de generar el mapa ya con todas las validaciones posibles
    public void generarMapa(){

        generarIndiceHorizontal();
        comprobarEspacios();
        imprimirMapa();
        
    }
    
}
