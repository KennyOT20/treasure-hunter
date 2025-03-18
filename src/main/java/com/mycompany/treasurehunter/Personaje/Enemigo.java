 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Personaje;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;

/**
 *
 * @author kenny
 */
public class Enemigo extends Personaje{
    
    private static final String[] NOMBRE_ENEMIGO = {"Calavera Negra", "Barba Roja", "Jack", "Adrian" }; 

    public Enemigo() {
        super("", 0, 0, 0);
    }

    //Metodo encargado de generar los enemigos 
    public void generarEnemigos(Jugador jugador){
       int hpMinimo = jugador.getVidaMaxPersonaje() - (jugador.getVidaMaxPersonaje()/2);
       int hpMaximo = jugador.getVidaMaxPersonaje() + (jugador.getVidaMaxPersonaje()/2);
       int hpEnemigo = ControladorMetodos.calcularNumerosAleatorios(hpMinimo, hpMaximo);
       int hpMaxEnemigo = hpEnemigo;
       setVidaPersonaje(hpEnemigo);
       setVidaMaxPersonaje(hpMaxEnemigo);
       int indice = ControladorMetodos.calcularNumerosAleatorios(0, NOMBRE_ENEMIGO.length);
       setAtaquePersonaje(ControladorMetodos.calcularNumerosAleatorios(30, 42));
       setNombrePersonaje(NOMBRE_ENEMIGO[indice]);
    }
    
  
    
    //metodo abstracto para aplicar el ataque
    
     @Override
    public void aplicarAtaque(Personaje objetivo) {
        
        System.out.println("El pirata " + getNombrePersonaje() + " te ataco con " );
        System.out.print(getAtaquePersonaje() + " de daño.");
         recibirAtaque(getAtaquePersonaje());
    }

    @Override
    public void mostrarEstadoPersonaje() {
        System.out.println("");
        System.out.println("Hp de pirata " + getNombrePersonaje());
        System.out.print(" " + getVidaPersonaje() + " / " + getVidaMaxPersonaje() );
        
    }
    
}
