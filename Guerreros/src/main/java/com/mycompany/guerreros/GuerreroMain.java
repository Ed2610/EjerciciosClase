/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.guerreros;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;

/**
 *
 * @author Amb 302-2
 */
public class GuerreroMain {

    /**
     * @param args the command line arguments
     */
    
private static void eliminarMuertos(List<Guerrero> ejercito){    
    
    List<Guerrero> muertos = new ArrayList<>();
    
    for(Guerrero guerrero : ejercito){
    if (guerrero.isMuerto()){
        muertos.add(guerrero);
    }
    }
    ejercito.removeAll(muertos);
    

    }

    
    public static void main(String[] args) {
        int resp = 0;
        int opciones;
        do{
        Scanner sc = new Scanner(System.in);
        List<Guerrero> griegos = new ArrayList<>();
        List<Guerrero> troyanos = new ArrayList<>();
        String[] nombresG = {"Adem", "Ahmet", "Ayaz", "Emre", "Eymen", "Kaan", "Mehmet", "Mustafa", "Berat", "Dilara"};
        String[] nombresT = {"Anthea", "Prometeo", "Ícaro", "Hércules", "Hefesto", "Eurídice", "Alejandro", "Apolo", "Aphrodite", "Zeus"};
        
        /*for(int i=0;i<=nombre.length;i++){
            System.out.println("Digite el nombre: "+ (i+1));
            nombre[i] = sc.nextLine();
            
    }*/
        
        
        
        // Crear ejércitos aleatorios
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            griegos.add(new Griego(nombresG[random.nextInt(nombresG.length)]+" G"+(i+1), random.nextInt(46) + 15, random.nextInt(10) + 1));
            troyanos.add(new Troyano(nombresT[random.nextInt(nombresT.length)]+" T"+(i+1), random.nextInt(46) + 15, random.nextInt(10) + 1));
        }
        opciones = Integer.parseInt(JOptionPane.showInputDialog("1.Consultar posibles ejercitos\n2.Realizar enfrentamientos\n3.Salir"));
        switch(opciones){
            default:break;
        
        // Mostrar ejércitos
            case 1:    
        System.out.println("Ejército Griego:");
        for (Guerrero guerrero : griegos) {
            System.out.println(guerrero.getNombre() + " | Edad: " + guerrero.getEdad() + " | Fuerza: " + guerrero.getFuerza());
        }

        System.out.println("\nEjército Troyano:");
        for (Guerrero guerrero : troyanos) {
            System.out.println(guerrero.getNombre() + " | Edad: " + guerrero.getEdad() + " | Fuerza: " + guerrero.getFuerza());
        } 
        break;

        // Enfrentamiento
            case 2:
                
        System.out.println("Ejército Griego:");
        for (Guerrero guerrero : griegos) {
            System.out.println(guerrero.getNombre() + " | Edad: " + guerrero.getEdad() + " | Fuerza: " + guerrero.getFuerza());
        }

        System.out.println("\nEjército Troyano:");
        for (Guerrero guerrero : troyanos) {
            System.out.println(guerrero.getNombre() + " | Edad: " + guerrero.getEdad() + " | Fuerza: " + guerrero.getFuerza());
        } 
                
        int turno = 1;
        int listaTroyanos = 0;
        int listaGriegos = 0;
        while (getCantidadGuerrerosVivos(griegos) >0 && getCantidadGuerrerosVivos(troyanos)>0) {
            
            eliminarMuertos(griegos);
            eliminarMuertos(troyanos);

            // Guerrero aleatorios de cada ejército
             
            
            
            Guerrero atacante = griegos.get(random.nextInt(griegos.size()));
            Guerrero atacado = troyanos.get(random.nextInt(troyanos.size()));
            
            if (turno % 2 != 0) {
            if (listaTroyanos >= troyanos.size()) {
            listaTroyanos = 0;
            }
            atacado = troyanos.get(listaTroyanos);
            atacante = griegos.get(random.nextInt(griegos.size()));
            listaTroyanos++;
            }   else {
            if (listaGriegos >= griegos.size()) {
            listaGriegos = 0;
            }
            atacado = griegos.get(listaGriegos);
            atacante = troyanos.get(random.nextInt(troyanos.size()));
            listaGriegos++;
            }

            // Realizar el ataque y mostrar el resultado
            System.out.println("\nTurno " + turno + " - Enfrentamiento:");
            int ataque = random.nextInt(10) + 1;
            System.out.println(atacante.getNombre() + " ataca a " + atacado.getNombre() + " con un ataque de " + ataque);
            atacado.recibirAtaque(ataque);

            // Mostrar estado del guerrero atacado
            if (atacado.isMuerto()) {
                System.out.println(atacado.getNombre() + " ha sido derrotado.");
            } else if (atacado.isHerido() && atacado.retirarse()) {
                System.out.println(atacado.getNombre() + " está herido y se retira de la batalla.");
                griegos.remove(atacado);
            } else if (atacado.isHerido()) {
                System.out.println(atacado.getNombre() + " está herido.");
            } else {
                System.out.println(atacado.getNombre() + " sigue en pie.");
            }
            
            
            

            turno++;
        }

        // Determinar el bando ganador
        System.out.println("\nFin de la batalla.");
        if (getCantidadGuerrerosVivos(griegos)>0) {
            System.out.println("¡El ejército Griego ha ganado la batalla!");
            System.out.println("Quedaron en pie: "+ getCantidadGuerrerosVivos(griegos)+ " Griegos");
        } else if (getCantidadGuerrerosVivos(troyanos)>0) {
            System.out.println("¡El ejército Troyano ha ganado la batalla!");
            System.out.println("Quedaron en pie: "+ getCantidadGuerrerosVivos(troyanos)+ " Troyanos");
        } else {
            System.out.println("¡La batalla ha terminado en empate!");
        }
        break;
        }

        resp = Integer.parseInt(JOptionPane.showInputDialog("Desea continuar? 1.Si/2.No"));
        }while(resp==1);
        }
       
    
    
    private static int getCantidadGuerrerosVivos(List<Guerrero> ejercito) {
        int contadorVivos = 0;
        for (Guerrero guerrero : ejercito) {
            if (!guerrero.isMuerto()) {
                contadorVivos++;
            }
        }
        return contadorVivos;
    }
}