/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Mapa;

/**
 *
 * @author kenny
 */
public class Mapa {
    
    
    private int cantidadFilas;
    private int cantidadColumnas;
    private String [][] mapa;
    
    //Metodo encargado de generar un mapa por defecto
    public void generarMapaPorDefecto(){
        cantidadFilas = 27;
        cantidadColumnas = 27;
        mapa = new String[cantidadFilas][cantidadColumnas];
        
        imprimirMapa();
    }
    
    //metodo encargado de hacer que el usuario pueda configurar los mapas.
    public void configurarMapa(){
        
    }
    
    //Metodo encargado de generar el indice vertical, (1,2,3,4... n)
    private void generarIndiceVertical(){
        
        for (int i = 0; i < mapa.length; i++) {
            i++;
            
        }
        
    }
    
    //Metodo encargado de generar el indice de letrar horizonal(a,b,c,d,e,f,g....x,y,z)
    private void generarIndiceHorizontal(){
        
    }
    
    //Metodo encargado de comprobrar los espacios para que el mapa se imprima de manera correcta sin importar el tamaño
    private void comprobarEspacio(){
        
    }
    
    //Metodo encargado de imprimir el mapa ya bien definido
    private void imprimirMapa(){
        
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.println("[     ]");
            }
        }
        System.out.println("");
    }
}
