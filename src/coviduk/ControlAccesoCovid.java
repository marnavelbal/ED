/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coviduk;

import java.util.Scanner;

/**
 *
 * @author Alberto
 */
public class ControlAccesoCovid {

    public ControlAccesoCovid() {
        
        char sintomas;
        Scanner respuesta;
        respuesta = new Scanner (System.in);
        System.out.println("¿Posee síntomas Covid?(S/N)");
        sintomas = Character.toUpperCase (respuesta.next().charAt(0));
                     
        while (!(sintomas=='N')){
            if (!(sintomas=='N'))
                System.out.println("Vuelva sin sintomas");
            else
                System.out.println("Lleve a cabo las medidas de prevención");
           
            System.out.println("¿Aún posee síntomas Covid?(S/N)");            
            sintomas = Character.toUpperCase (respuesta.next().charAt(0));
        }
       
        System.out.println("Puede acceder, muchas gracias");
    }
    
}
