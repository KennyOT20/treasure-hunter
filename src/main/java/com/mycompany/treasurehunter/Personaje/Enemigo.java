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
       ControladorMetodos controlador = new ControladorMetodos();
       
       int hpMinimo = jugador.getVidaMaxPersonaje() - (jugador.getVidaMaxPersonaje()/2);
       int hpMaximo = jugador.getVidaMaxPersonaje() + (jugador.getVidaMaxPersonaje()/2);
       int hpEnemigo = controlador.calcularNumerosAleatorios(hpMinimo, hpMaximo);
       int hpMaxEnemigo = hpEnemigo;
       
       setVidaPersonaje(hpEnemigo);
       setVidaMaxPersonaje(hpMaxEnemigo);
       
       int indice = controlador.calcularNumerosAleatorios(0, NOMBRE_ENEMIGO.length);
       setAtaquePersonaje(controlador.calcularNumerosAleatorios(10, 22));
       setNombrePersonaje(NOMBRE_ENEMIGO[indice]);
       
    }    
      
    //metodo abstracto para aplicar el ataque
    
     @Override
    public void aplicarAtaque(Personaje objetivo) {      
        System.out.println("El pirata " + getNombrePersonaje() + " te ataco con "  + getAtaquePersonaje() + " de daño." );
        objetivo.recibirAtaque(getAtaquePersonaje());
        System.out.println("");
    }

    @Override
    public void mostrarEstadoPersonaje() {
        System.out.println("");
        System.out.print("Hp de pirata " + getNombrePersonaje());
        System.out.print(" " + getVidaPersonaje() + " / " + getVidaMaxPersonaje() );
        System.out.println("");
        
    }
    
}
