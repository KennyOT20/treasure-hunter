/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Casillas;

import com.mycompany.treasurehunter.Controladores.ControladorMetodos;
import com.mycompany.treasurehunter.Personaje.Jugador;

/**
 *
 * @author kenny
 */
public class CasillaPista extends Casilla {
    
    private String[] pistas ={ "El tesoro se encuentra arriba por la izquierda o por la derecha...",
        "Estas casi cerca, solo te falta regresar por donde estabas",
        "Casi lo encuentras...",
        "Estas muy lejos, la proxima agarra otro camino"
    };

    public CasillaPista(Jugador jugador) {
        super(jugador, "Casilla pista");
    }

    

    @Override
    public void efectoDeCasillaNormal() {
        ControladorMetodos controlador = new ControladorMetodos();
        
        int indicePistas = controlador.calcularNumerosAleatorios(0, pistas.length);
        String pistaObtenida = pistas[indicePistas];
        controlador.limpiarPantalla();
        System.out.println("Pista:");
        System.out.println(pistaObtenida);
        
    }


    @Override
    public void modificarCasilla() {

    }

    @Override
    public void menuDeModificacion() {

    }

    @Override
    public void efectoDeCasillaModificado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
