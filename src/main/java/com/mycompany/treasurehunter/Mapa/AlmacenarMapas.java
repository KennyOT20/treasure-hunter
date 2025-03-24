/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.Mapa;

import java.io.Serializable;

/**
 *
 * @author kenny
 */
public class AlmacenarMapas implements Serializable {
    
    private final String CARPETA_DE_MAPAS_PREDEFINIDOS = "ArchivosDelJuego/MapasPredefinidos/";
    private final String CARPETA_DE_MAPAS_USUARIO =  "ArchivosDelJuego/MapasCreadosPorElUsuario/";
    
    private CrearMapa mapaCreado;

    public AlmacenarMapas(CrearMapa mapaCreado) {
        this.mapaCreado = mapaCreado;
    }
    
    
    
    //Metodo encargado de guardar los mapas predefinidos o creados por el ususario
    public void guardarMapa(){
        
        
    }
    
}
