/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Menus;

import com.mycompany.treasurehunter.Controladores.ControladorMenu;
import com.mycompany.treasurehunter.Controladores.ControladorMetodos;

/**
 *Clase que hereda los metodos del menuBase para mostrar un menu inicial del juego que se
 * encarga de mostrar las opciones iniciales
 * @author kenny
 */
public class MenuInicial extends MenuBase {
    
    private ControladorMenu controlador;

    public MenuInicial() {
        this.controlador = new ControladorMenu();
    }
    
    @Override
    public void mostrarMenu() {
        
        System.out.println("====================================");
        System.out.println("||          Bienvenido            ||");
        System.out.println("||              a                 ||");
        System.out.println("||        Treasure Hunter         ||");
        System.out.println("====================================");
        System.out.println("||      ¿Que deseas realizar?     ||");
        System.out.println("||                                ||");
        System.out.println("|| 1. Iniciar partida.            ||");
        System.out.println("|| 2. Cargar partida              ||");
        System.out.println("|| 3. Editar mapa.                ||");
        System.out.println("|| 4. Crear mapa.                 ||");
        System.out.println("|| 5. Eliminar mapa               ||");
        System.out.println("|| 6. Reportes                    ||");
        System.out.println("|| 7. Salir del programa.         ||");
        System.out.println("====================================");
        System.out.print("Selecciona una opcion: ");
        validarOpcion();
    }

    
    
    @Override
    public void ejecutarOpcion(int opcionMenu) {

        
        
            switch(opcionMenu){
                case 1 -> {
                   controlador.iniciarPartida();
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> {
                }
                case 5 -> {
                }
                case 6 -> {
                }
                case 7 -> {
                }
                default -> {
                    ControladorMetodos.limpiarPantalla();
                    System.out.println("Opcion no valida, intente de nuevo");
                    mostrarMenu();
                }

            }
        }
    
}
