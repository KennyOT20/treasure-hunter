 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Personaje;

/**
 *
 * @author kenny
 */
public class Enemigo extends Personaje{
    
    private Jugador jugador;
    private int hpEnemigo;
    private int hpMaximo;
    private int ataqueEnemigo;
    private static final String[] NOMBRE_ENEMIGO = {"Calavera Negra", "Barba Roja", "Jack", "Adrian" }; 
    private String nombreEnemigo;

    public Enemigo() {
        super("Sin enemigo", 0, 0);
    }

    //Metodo encargado de generar los enemigos 
    public void generarEnemigos(){
       int hpMinimo = jugador.getPuntosDeVida() - (jugador.getPuntosDeVida()/2);
       hpMaximo = jugador.getPuntosDeVida() + (jugador.getPuntosDeVida()/2);
       hpEnemigo = calcularNumerosRandom(hpMinimo, hpMaximo);
       int indice = calcularNumerosRandom(0, NOMBRE_ENEMIGO.length);
       ataqueEnemigo = calcularNumerosRandom(25,53);
       nombreEnemigo = NOMBRE_ENEMIGO[indice];
    }
    
    //metodo abstracto para aplicar el ataque
    
     @Override
    public void aplicarAtaque(Personaje objetivo) {
       
    }
    
    //Getters y setters necesarios 

    public int getHpEnemigo() {
        return hpEnemigo;
    }

    public void setHpEnemigo(int hpEnemigo) {
        this.hpEnemigo = hpEnemigo;
    }

    public int getAtaqueEnemigo() {
        return ataqueEnemigo;
    }

    public void setAtaqueEnemigo(int ataqueEnemigo) {
        this.ataqueEnemigo = ataqueEnemigo;
    }

    public String getNombreEnemigo() {
        return nombreEnemigo;
    }

    public void setNombreEnemigo(String nombreEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
    }

    public int getHpMaximo() {
        return hpMaximo;
    }  
}
