/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guerreros;

/**
 *
 * @author Amb 302-2
 */
public class Troyano extends Guerrero{
    public Troyano(String Nombre, int Edad, int Fuerza) {
        super(Nombre, Edad, Fuerza);
    }
    

   



    

    @Override
    protected boolean retirarse() {
        return false;
    }

}
