package com.mycompany.semaforocovid;

import java.util.Scanner;

/**
 *
 * @author ED_CarlosIII
 */
public class SemaforoCovid {
    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        
        int numCasos, poblacion;
        float p1,p2,p3,p4;
        
        System.out.println("Introduce la población del municipio/ciudad");
        poblacion = teclado.nextInt();
        
        System.out.println("Introduce el número de casos en los últimos 14 días");
        numCasos = teclado.nextInt();
        
        p1 = numCasosPor100kHabitantes(numCasos, poblacion);
        
        System.out.println("Introduce la tasa de positividad (en tanto por 1)");
        p2 = teclado.nextFloat();
        
        System.out.println("Introduce el tanto por 1 de camas ocupadas por pacientes Covid");
        p3 = teclado.nextFloat();
        
        System.out.println("Introduce el tanto por 1 de camas UCI ocupadas por pacientes Covid");
        p4 = teclado.nextFloat();
        
        System.out.println("El nivel de riesgo del semáforo Covid es: " + nivelRiesgo(p1, p2, p3, p4));
        
    }
    
    public static int nivelRiesgo(float numCasos14dias, float tasaPositividad, float presionHospitalaria, float presionCamasUCI)
    {
        if ((numCasos14dias < 25) && (tasaPositividad < 0.07) && (presionHospitalaria < 0.05) && (presionCamasUCI < 0.1))
        {
            return 1;
        }    
        else if ((numCasos14dias < 150) && (tasaPositividad < 0.1) && (presionHospitalaria < 0.1) && (presionCamasUCI < 0.15))
        {
            return 2;
        }
        else if ((numCasos14dias < 250) && (presionCamasUCI < 0.25))
        {
            return 3;
        }    
        else
        {
            return 4;
        }    
    }    

    public static float numCasosPor100kHabitantes(int numCasos, int poblacion)
    {
        if (poblacion == 100000)
            return numCasos;
        else
            return numCasos * ((float) 100000/poblacion);
        
    }       
}
