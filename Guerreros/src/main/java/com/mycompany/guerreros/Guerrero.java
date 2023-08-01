/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.guerreros;

/**
 *
 * @author Amb 302-2
 */
public abstract class Guerrero {
    
    final String Nombre;
    protected int Edad;
    protected int Fuerza;
    protected boolean Herido;
    protected boolean Muerto;
    protected boolean Retirarse;

    public  Guerrero(String Nombre, int Edad, int Fuerza) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Fuerza = Fuerza;
        this.Herido = false;
        this.Muerto = false;
        this.Retirarse = false;
        
        

    }
    
    
    public Guerrero(){
        this("GuerreroX", 15, 1);
        this.Herido = false;
        this.Muerto = false;
        this.Retirarse = false;
    }
    
    public Guerrero(Guerrero guerrero, String nuevoNombre) {
        this.Nombre = nuevoNombre;
        this.Edad = guerrero.Edad;
        this.Fuerza = guerrero.Fuerza;
        this.Herido = guerrero.Herido;
        this.Muerto = guerrero.Muerto;
        this.Retirarse = guerrero.Retirarse;
    }
    
    
     public String getNombre() {
        return Nombre;
    }
    
    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    
    public int getFuerza() {
        return Fuerza;
    }

    public void setFuerza(int Fuerza) {
        this.Fuerza = Fuerza;
    }
    public boolean isRetirarse() {
        return Retirarse;
    }

    public void setRetirarse(boolean Retirarse) {
        this.Retirarse = Retirarse;
    }
    public boolean isHerido() {
        return Herido;
    }

    public void setHerido(boolean Herido) {
        this.Herido = Herido;
    }

    public boolean isMuerto() {
        return Muerto;
    }

    public void setMuerto(boolean Muerto) {
        this.Muerto = Muerto;
    }
    
    public void recibirAtaque(int ataque) {
        
         if (!isMuerto()){
        
        Fuerza -= ataque;
        
        if(Fuerza<=0){
            Muerto = true;
            Herido = true;
        }
        else if(Fuerza >=1 && Fuerza <=4){
            Herido = true;
        }
        }
    }
    
    protected boolean comprobarEdad(int Edad){
        boolean comprobarEdad;
        if(Edad <15 || Edad >60){
            comprobarEdad = false;
            
        }
        return false;
    }
    
    protected boolean comprobarFuerza(int Fuerza){
        boolean comprobarFuerza = true;
        if(Fuerza <1 || Fuerza >10){
            comprobarFuerza = false;
        } else if(Fuerza >1 ||Fuerza <10){
           comprobarFuerza = true;
       }
        return comprobarFuerza;
    }
    
    protected abstract boolean retirarse();

    }

