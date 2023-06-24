
package com.mycompany.proyecto;

import java.io.IOException;
import java.util.InputMismatchException; //Excepción de tipo de entrada incorrecta
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        //Se crea un objeto de la clase logica ya que hay esta guardado el metodo para usarlo aqui
        logica iniciar = new logica();
        //Menu de opciones en bucle hasta que se ingrese 5

        int opcion=0;
        while (opcion!=5) {
        System.out.println("Control de calidad de productos: ");
        System.out.println("1)Ingreso de datos: ");
        System.out.println("2)Clasificacion de datos: ");
        System.out.println("3)Movimientos o historial: ");
        System.out.println("4)Consultas: ");
        System.out.println("5)Salir: ");
        while (true){
           try {
        opcion = sc.nextInt();
            break;
            } catch (InputMismatchException e) {
            System.out.println("Dato incorrecto. Solo se acepta numeros enteros indicados");
            sc.nextLine(); // Descartar token inválido
            }
        }
            try
            {
                // Limpiar la ventana
                logica.limpiarventana();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        //Llamo al metodo para que ejecute todo
            iniciar.Final(opcion);

        }    
        
        
    }
}    
