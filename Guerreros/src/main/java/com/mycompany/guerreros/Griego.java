/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guerreros;

/**
 *
 * @author Amb 302-2
 */
public class Griego extends Guerrero {
    public Griego(String Nombre, int Edad, int Fuerza) {
        super(Nombre, Edad, Fuerza);
    }
    
    @Override
    protected boolean retirarse(){
        boolean retirarse = false;
        if(Herido = true){
            retirarse = true;
    }
        else if(Muerto = true){
        retirarse = false;
    }
        return retirarse;
}
}
