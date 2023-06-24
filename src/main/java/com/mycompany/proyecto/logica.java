
package com.mycompany.proyecto;

import java.io.IOException;
import java.util.InputMismatchException; //Excepción de tipo de entrada incorrecta
import java.util.Scanner;

public class logica {
    //creamos un Sacnner para hacer ingresos desde el teclado
    Scanner sc= new Scanner(System.in);
    //Definimos las cantidad de registro que se podra ingresar
    private final int registrosMax =2;

    //Creamos objetos de cada clase para usar los datos de esas clases y los metodos
    //Creamos 4 clases para los productos
    Producto[] Producto = new Producto[registrosMax]; //Primero sirve para almacenarlos sin marca
    Samsung[] Samsung = new Samsung[registrosMax];
    RCA[] RCA = new RCA[registrosMax];
    Lg[] Lg = new Lg[registrosMax];

    //Creamos varibles para almacenar informacion de movimientos, entrada y salida de datos
    //contadores para los metodos
    private int contador=0;
    private int ingresos=0; //Sirve para estar al tanto de cuantos ingresos de datos se han hecho
    private int movimientos=0; //Sirve para saber si se a realizado algun movimiento de datos a otra clase

    private int movimientosSamsung=0; //Para saber si se ingreso aquí
    private int movimientosRCA=0;
    private int movimientosLg=0;


 private void IngresarDatos() throws InterruptedException { //Metodo para ingresar datos con una condicional
     if(contador < registrosMax) {
     System.out.println("Ingresa el modelo del producto: ");
     String modelo = sc.next();


     //Iniciamos con los try catch en bucle hasta que se ingresen bien el dato de unidades
     int unidades;
     while (true) {
        try {
        System.out.println("Ingresa las unidades: ");
     unidades = sc.nextInt();
     break;
     } catch (InputMismatchException e) {
        System.out.println("Dato incorrecto. Solo se acepta numeros enteros");
        sc.nextLine(); // Descartar token inválido
        }
    }
    //Iniciamos con los try catch en bucle hasta que se ingresen bien el dato de peso
     double peso;
     while (true) {
        try {
        System.out.println("Ingresa el peso del pruducto(kg): ");
     peso = sc.nextDouble();
     break;
     } catch (InputMismatchException e) {
        System.out.println("Dato incorrecto. Solo se acepta numeros enteros o decimales");
        sc.nextLine(); // Descartar token inválido
        }
    }

     System.out.println("Ingresa la fecha de Ingreso:");
     int dia, mes, anio;
     //Iniciamos con los try catch en bucle hasta que se ingresen bien el dato de dia, mes y a?o
     while (true) {
        try {
            //Iniciamos un bucle para que ingrese un numero del dia correcto
        do{
        System.out.print("Dia:");
        dia = sc.nextInt();
            if (dia>=1 && dia<=31 ) {
                System.out.println("Dato ingresado correctamente");
            }else{
                System.out.println("Ese dia no existe, vuelve a ingresar un numero del dia");
            }
        }while( dia<=0 || dia>=32 );
     //Aqui se acaba el bucle
     break;
     } catch (InputMismatchException e) {
        System.out.println("Dato incorrecto. Solo se acepta numeros enteros");
        sc.nextLine(); // Descartar token inválido
        }
    }

     while (true) {
        try {
         do{
     System.out.print("Mes:");
     mes = sc.nextInt();
        if (mes>=1 && mes<=12) {
          System.out.println("Dato ingresado correctamente");
        }else{
        System.out.println("Ese mes no existe, vuelve a ingresar un numero del mes");
        }
     }while(mes<=0 || mes>=13);

     break;
     } catch (InputMismatchException e) {
        System.out.println("Dato incorrecto. Solo se acepta numeros enteros");
        sc.nextLine(); // Descartar token inválido
        }
    }

     while (true) {
        try {
            do{

     System.out.print("A?o:");
     anio= sc.nextInt();
          if (anio>=2022 && anio<=2024) {
          System.out.println("Dato ingresado correctamente");
        }else{
        System.out.println("Solo se puede ingresar desde el a?o 2022 al 2024");
        }
     }while(anio<=2021 || anio>=2025);
     break;
     } catch (InputMismatchException e) {
        System.out.println("Dato incorrecto. Solo se acepta numeros enteros");
        sc.nextLine(); // Descartar token inválido
        }
    }
     //Usamos el objeto para almacenar los datos y enviarlos atravez del objeto constructor
     Producto[contador] = new Producto(modelo, unidades, peso, dia, mes, anio);
         System.out.println("-----------------------------------------");
         promptEnterKey();
    //Sumamos los ingresos y el contador
     contador++;
     ingresos++;
         try
         {
             // Limpiar la ventana
             limpiarventana();
         }
         catch (IOException ioe)
         {
             ioe.printStackTrace();
         }
     }else{
         System.out.println("Limite alcanzado");
         System.out.println("-----------------------------------------");
         promptEnterKey();
         try
         {
             // Limpiar la ventana
             limpiarventana();
         }
         catch (IOException ioe)
         {
             ioe.printStackTrace();
         }
     }
 }
  private void ClasificarDatos() throws InterruptedException { //Metodo para clasificar los datos almacenados en la clase Producto y moverlos a otra clase
      //Verificamos si hay datos ingresados
      if (Producto[0]== null) {
        System.out.println("No hay datos Ingresados");
        System.out.println("-----------------------------------------");
          promptEnterKey();
          try
          {
              // Limpiar la ventana
              limpiarventana();
          }
          catch (IOException ioe)
          {
              ioe.printStackTrace();
          }
    }else{
          //Mostramos todos los registros que haya en mi clase producto
          //Y lo comparamos con ingresos para que solo recorra los espacios llenos y no vacios porque da error de espacios nulos
      for (int i = 0; i < ingresos ; i++) {
        System.out.println((i + 1) + ") Modelo: " + Producto[i].getModelo());
         }

      //Creamos un while usando un booleno para salir, el bucle sirve para que el usuario ingrese una
      //Opcion correcta y no otra porque luego eligira un espacio vacio y dará un error
      boolean salir=false;
      //Primero al momento de elegir la una opcion de la lista creamos un try catch para que no ingresen texto
      while (!salir) {
        int opcion;
        while (true) try {
            System.out.println("Selecciona una opcion del modelo que vas a elegir(1- 4");
            opcion = sc.nextInt();
            break;
        } catch (InputMismatchException e) {
            System.out.println("Dato incorrecto. Solo se acepta numeros enteros indicados");
            sc.nextLine(); // Descartar token inválido
        }

      //Verificamos que aya ingresado una opcion correcta entre el rango de ingresos
      //Y verificamos que solo se pueda guardar la cantidad max de dato permitido en cada clase
      if (opcion<=ingresos && opcion>=1) {
          salir=true;
      System.out.println("Ingresa la Marca del producto(Samsung-RCA-Lg): ");
      //Guardamos la marca que el usuario eligio y lo convertimos en con toLowerCase en minuscula
      //Por si el usuario apresuradamente ingreso una palabra en mayuscula y otra en minuscula
      String opcionMarca = sc.next().toLowerCase();

          switch (opcionMarca) {
              case "samsung" -> {
                  //Verificamos ya que solo se puede guardar los productos max que estan establecidos
                  if (movimientosSamsung < registrosMax) {
                      //Ingresamos los datos faltantes al clasificarlo
                      System.out.println("Ingrese el estado del producto(Perfecto-Da?ado-Vacio):");
                      String estado = sc.next();
                      int garantia;
                      while (true) try {
                          System.out.println("Ingrese cuantos a?os de garantia tendra el Producto: ");
                          garantia = sc.nextInt();
                          break;
                      } catch (InputMismatchException e) {
                          System.out.println("Dato incorrecto. Solo se acepta numeros enteros");
                          sc.nextLine(); // Descartar token inválido
                      }

                      //Hacemos paso por valor indicando que lo guarde en la posicion que este el movimientosSamsung
                      //Luego guardamos esos datos almacenamos pero como el usuario no sabe que inicia con 0 y piensa que inicia con 1
                      //restamo la opcion -1 para obtener los datos de esa posicion

                      Samsung[movimientosSamsung] = new Samsung(estado, garantia, opcionMarca, Producto[opcion - 1].getModelo()
                              , Producto[opcion - 1].getUnidades(), Producto[opcion - 1].getPeso(), Producto[opcion - 1].getDia(), Producto[opcion - 1].getMes(), Producto[opcion - 1].getAnio());
                      System.out.println("Se a realizado con exitó el cambio");
                      System.out.println("-----------------------------------------");
                      //Va sumando los movimientos para usarlo en trasacciones o movimientos realizados
                      movimientos++;
                      movimientosSamsung++;
                      promptEnterKey();
                      try
                      {
                          // Limpiar la ventana
                          limpiarventana();
                      }
                      catch (IOException ioe)
                      {
                          ioe.printStackTrace();
                      }
                  } else {
                      System.out.println("Limite alcanzado (" + movimientosSamsung + ")");
                      promptEnterKey();
                      try
                      {
                          // Limpiar la ventana
                          limpiarventana();
                      }
                      catch (IOException ioe)
                      {
                          ioe.printStackTrace();
                      }
                  }
              }
              case "rca" -> {
                  //Verificamos ya que solo se puede guardar los productos max que estan establecidos
                  if (movimientosRCA < registrosMax) {
                      System.out.println("Ingrese el estado del producto(Perfecto-Da?ado-Vacio):");
                      String estado = sc.next();
                      int garantia;
                      while (true) try {
                          System.out.println("Ingrese cuantos a?os de garantia tendra el Producto: ");
                          garantia = sc.nextInt();
                          break;
                      } catch (InputMismatchException e) {
                          System.out.println("Dato incorrecto. Solo se acepta numeros enteros");
                          sc.nextLine(); // Descartar token inválido
                      }
                      RCA[movimientosRCA] = new RCA(estado, garantia, opcionMarca, Producto[opcion - 1].getModelo(), Producto[opcion - 1].getUnidades()
                              , Producto[opcion - 1].getPeso(), Producto[opcion - 1].getDia(), Producto[opcion - 1].getMes(), Producto[opcion - 1].getAnio());
                      System.out.println("Se a realizado con exitó el cambio");
                      System.out.println("-----------------------------------------");
                      //Va sumando los movimientos para usarlo en trasacciones o movimientos realizados
                      movimientos++;
                      movimientosRCA++;
                      promptEnterKey();
                      try
                      {
                          // Limpiar la ventana
                          limpiarventana();
                      }
                      catch (IOException ioe)
                      {
                          ioe.printStackTrace();
                      }
                  } else {
                      System.out.println("Limite alcanzado (" + movimientosRCA + ")");
                      promptEnterKey();
                      try
                      {
                          // Limpiar la ventana
                          limpiarventana();
                      }
                      catch (IOException ioe)
                      {
                          ioe.printStackTrace();
                      }
                  }
              }
              case "lg" -> {
                  //Verificamos ya que solo se puede guardar los productos max que estan establecidos
                  if (movimientosLg < registrosMax) {
                      System.out.println("Ingrese el estado del producto(Perfecto-Da?ado-Vacio):");
                      String estado = sc.next();
                      int garantia;
                      while (true) try {
                          System.out.println("Ingrese cuantos a?os de garantia tendra el Producto: ");
                          garantia = sc.nextInt();
                          break;
                      } catch (InputMismatchException e) {
                          System.out.println("Dato incorrecto. Solo se acepta numeros enteros");
                          sc.nextLine(); // Descartar token inválido
                      }
                      Lg[movimientosLg] = new Lg(estado, garantia, opcionMarca, Producto[opcion - 1].getModelo(), Producto[opcion - 1].getUnidades()
                              , Producto[opcion - 1].getPeso(), Producto[opcion - 1].getDia(), Producto[opcion - 1].getMes(), Producto[opcion - 1].getAnio());
                      System.out.println("Se a realizado con exitó el cambio");
                      System.out.println("-----------------------------------------");
                      promptEnterKey();
                      try
                      {
                          // Limpiar la ventana
                          limpiarventana();
                      }
                      catch (IOException ioe)
                      {
                          ioe.printStackTrace();
                      }
                      //Va sumando los movimientos para usarlo en trasacciones o movimientos realizados
                      movimientos++;
                      movimientosLg++;

                  } else {
                      System.out.println("Limite alcanzado (" + movimientosLg + ")");
                      promptEnterKey();
                      try
                      {
                          // Limpiar la ventana
                          limpiarventana();
                      }
                      catch (IOException ioe)
                      {
                          ioe.printStackTrace();
                      }
                  }
              }
              default -> {
                  //Si el usuario ingresa otra opcion que no es entonces mostrara esto
                  System.out.println("Opcion incorrecta-No existe ese registro");
                  System.out.println("-----------------------------------------");
                  promptEnterKey();
                  try
                  {
                      // Limpiar la ventana
                      limpiarventana();
                  }
                  catch (IOException ioe)
                  {
                      ioe.printStackTrace();
                  }
              }
          }
      }else{
          System.out.println("Opcion incorrecta vuelva a elegir");
          promptEnterKey();
          try
          {
              // Limpiar la ventana
              limpiarventana();
          }
          catch (IOException ioe)
          {
              ioe.printStackTrace();
          }
      }
      }
      }
  }
private void Movimientos() throws InterruptedException { //Metodo de movimientos que me indica cuantos se han clasificado, cuantos se han ingresado
    //Y a que marca se a movido
       if (Producto[0]== null) {
        System.out.println("No hay datos Ingresados(movimientos)");
        System.out.println("-----------------------------------------");
           promptEnterKey();
           try
           {
               // Limpiar la ventana
               limpiarventana();
           }
           catch (IOException ioe)
           {
               ioe.printStackTrace();
           }
    }else{
           System.out.println("Se han ingresado: ("+ingresos+") registros");
           System.out.println("Se han realizado ("+movimientos+") clasificaciones");
           System.out.println("Se han realizado ("+movimientosSamsung+") clasificaciones de registros a Samsung");
           System.out.println("Se han realizado ("+movimientosRCA+") clasificaciones de registros a RCA");
           System.out.println("Se han realizado ("+movimientosLg+") clasificaciones de registros a Lg");
           System.out.println("-----------------------------------------");
           promptEnterKey();
           try
           {
               // Limpiar la ventana
               limpiarventana();
           }
           catch (IOException ioe)
           {
               ioe.printStackTrace();
           }
       }

}
private void ConsultasModelo() throws InterruptedException { //Void para hacer consultas por el nombre del modeo
    //Verificamos que este lleno o no el arreglo
    if (Producto[0]== null) {
        System.out.println("No hay datos Ingresados");
        System.out.println("-----------------------------------------");
        promptEnterKey();
        try
        {
            // Limpiar la ventana
            limpiarventana();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }else{
        //Si tiene algun dato entonces mostrar lo siguiente
    System.out.println("Ingresa el nombre del modelo: ");
    String consulta = sc.next();
        System.out.println("Ingresa la marca del producto: ");
        String consultaM = sc.next();
        System.out.println("Ingresa el estado del producto: ");
        String consultaE = sc.next();

    System.out.println("-----------------------------------------");

    //Creamos un metodo booleano para ver si se encontró o no el modelo
    boolean encontrado1 =false;
    //Primero usamos un for para encontrar el producto con las caracteristicas que ingrese el usuario
    //Ejecutamos un for con Producto.length para que solo verifique los espacios llenos
    for (int i = 0; i < Producto.length; i++) {
        //Si el elemento en la posición "i" del arreglo no es nulo y el modelo igual se encuentra,
        //sin importar las mayúsculas o minúsculas, Entonces imprimira sus datos
            if(Samsung[i]!= null && Samsung[i].getModelo().equalsIgnoreCase(consulta) &&
                    Samsung[i].getMarca().equalsIgnoreCase(consultaM) && Samsung[i].getEstado().equalsIgnoreCase(consultaE)){
                System.out.println("Producto marca Samsung:");
                Samsung[i].MostrarDatos();
                System.out.println("-----------------------------------------S");
                encontrado1=true;
            }
            if(RCA[i]!= null && RCA[i].getModelo().equalsIgnoreCase(consulta) &&
                    RCA[i].getMarca().equalsIgnoreCase(consultaM) && RCA[i].getEstado().equalsIgnoreCase(consultaE)){
                System.out.println("Producto marca RCA:");
                RCA[i].MostrarDatos();
                System.out.println("-----------------------------------------R");
                encontrado1=true;
            }
            if(Lg[i]!= null && Lg[i].getModelo().equalsIgnoreCase(consulta) &&
                    Lg[i].getMarca().equalsIgnoreCase(consultaM) && Lg[i].getEstado().equalsIgnoreCase(consultaE)){
                System.out.println("Producto marca Lg:");
                Lg[i].MostrarDatos();
                System.out.println("-----------------------------------------L");
                encontrado1=true;
            }
    }
    //Si no se pudo encontrar con las caracteristicas introducidas por el usuario encontonces buscaremos en el producto base
    boolean encontrado2 = false;
        if (!encontrado1) {
            System.out.println("Tu producto no se encuentra clasificado o no ingresaste bien los datos");
            System.out.println("A continuacion se mostrara un resultado similar en los productos base: ");
            for(int i = 0; i < Producto.length; i++){
                if (Producto[i] != null && Producto[i].getModelo().equalsIgnoreCase(consulta)) {
                    Producto[i].MostrarDatos();
                    System.out.println("-----------------------------------------P");
                    //Si el producto se encontró aqui o en otro if entonces el valor booleano sera verdad
                    encontrado2 = true;
                }
            }
            promptEnterKey();
            try
            {
                // Limpiar la ventana
                limpiarventana();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }


    //En el caso de que en ningun momento la condicion se cumplio y no se encontro el valor permanecera falso
    //Y el condicional indica si es diferente a falso pero como se mantiene en falso mostrara su mensaje
    if (!encontrado1 && !encontrado2) {
    System.out.println("Dato no encontrado");
    System.out.println("-----------------------------------------");
        promptEnterKey();
        try
        {
            // Limpiar la ventana
            limpiarventana();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    }
    }
private void ConsultasMarcas() throws InterruptedException {//Metodo para consultar por lista de marcas
    //Creamos una variable local primero para inicializar el while y para usarlo en el switch
    int opcion=0;
    //Sera un bucle hasta que el usuario ingrese el 5
    if (Producto[0]== null) {
        System.out.println("No hay datos Ingresados");
        System.out.println("-----------------------------------------");
        promptEnterKey();
        try
        {
            // Limpiar la ventana
            limpiarventana();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }else while (opcion != 5) {
        System.out.println("1) Mostrar todos los registros base (" + ingresos + ")");
        if (Samsung[0] == null) {
            //Ahorramos el tiempo al usuario para indicarle de una que no hay datos guardado aqui si es el caso
            System.out.println("2) No hay datos Ingresados en Samsung (0)");
        } else {
            System.out.println("2) Mostrar todos los registros de Samsung (" + movimientosSamsung + ")");
        }
        if (RCA[0] == null) {
            System.out.println("3) No hay datos Ingresados en RCA (0)");
        } else {
            System.out.println("3) Mostrar todos los registros de RCA (" + movimientosRCA + ")");
        }
        if (Lg[0] == null) System.out.println("4) No hay datos Ingresados en Lg (0)");
        else {
            System.out.println("4) Mostrar todos los registros de Lg (" + movimientosLg + ")");
        }
        System.out.println("5) Salir");
        while (true) try {
            opcion = sc.nextInt();
            break;
        } catch (InputMismatchException e) {
            System.out.println("Dato incorrecto. Solo se acepta numeros enteros indicados");
            sc.nextLine(); // Descartar token inválido
        }
        //Iniciamos el switch segun la opcion
        switch (opcion) {
            case 1 -> {
                //Lo comparamos con ingresos que es donde esta guardado cuantos se han registrado y no ingrese a espacios vacios
                System.out.println("-----------------------------------------");
                System.out.println("Lista de Productos Base:");
                for (int i = 0; i < ingresos; i++) {
                    System.out.println("-----------------------------------------");
                    //Depende de la posicion mostrara los datos de esa posicion
                    //El metodo MostrarDatos() esta alojado en mi clase Producto
                    Producto[i].MostrarDatos();
                    System.out.println("-----------------------------------------");
                }
                promptEnterKey();
                try
                {
                    // Limpiar la ventana
                    limpiarventana();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            case 2 -> {
                System.out.println("-----------------------------------------");
                System.out.println("Lista de Productos Samsung:");
                for (int i = 0; i < movimientosSamsung; i++) {
                    System.out.println("-----------------------------------------");
                    Samsung[i].MostrarDatos();
                    System.out.println("-----------------------------------------");
                }
                promptEnterKey();
                try
                {
                    // Limpiar la ventana
                    limpiarventana();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            case 3 -> {
                System.out.println("-----------------------------------------");
                System.out.println("Lista de Productos RCA:");
                for (int i = 0; i < movimientosRCA; i++) {
                    System.out.println("-----------------------------------------");
                    RCA[i].MostrarDatos();
                    System.out.println("-----------------------------------------");
                }
                promptEnterKey();
                try
                {
                    // Limpiar la ventana
                    limpiarventana();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            case 4 -> {
                System.out.println("-----------------------------------------");
                System.out.println("Lista de Productos Lg:");
                for (int i = 0; i < movimientosLg; i++) {
                    System.out.println("-----------------------------------------");
                    Lg[i].MostrarDatos();
                    System.out.println("-----------------------------------------");

                }
                promptEnterKey();
                try
                {
                    // Limpiar la ventana
                    limpiarventana();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            case 5 -> {
                System.out.println("-----------------------------------------");
                System.out.println("Saliendo.............");
                System.out.println("-----------------------------------------");
                promptEnterKey();
                try
                {
                    // Limpiar la ventana
                    limpiarventana();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            default -> {
                System.out.println("-----------------------------------------");
                System.out.println("Opcion incorrecta");
                System.out.println("-----------------------------------------");
            }
        }
    }
}

private void MostrarEstado() throws InterruptedException { //Metodo para Mostrar todos los productos que que este en estado da?ado, perfecto y vacio
     //Primero verificamos que esten llenos
if ((Samsung[0] == null) && (RCA[0] == null) && (Lg[0] == null)){
    System.out.println("No hay datos datos clasificados");
    promptEnterKey();
    try
    {
        // Limpiar la ventana
        limpiarventana();
    }
    catch (IOException ioe)
    {
        ioe.printStackTrace();
    }
}else{
    //Si estan llenos se ejecutara esta seccion
    int opcion=0;
    do {
        //Mostramos el menu de opciones
    System.out.println("1) Mostrar los productos en perfecto estado");
    System.out.println("2) Mostrar los productos que esten da?ados");
    System.out.println("3) Mostrar los productos que esten Vacio");
    System.out.println("4) Salir");
        while (true) {
            try {
                opcion = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto. Solo se acepta numeros enteros indicados");
                sc.nextLine(); // Descartar token inválido
            }
        }
    //Segun la opcion mostra el estado del producto
        switch (opcion) {
            case 1 -> {
                //Un boleano para comprobar si existe algun producto en tal estado
                boolean encontradoP = false;
                System.out.println("-----------------------------------------");
                //For para recorrer todos los espacios
                for (int i = 0; i < Producto.length; i++) {
                    //Verificaciones atravez del equalsIgnoreCase
                    if (Samsung[i] != null && Samsung[i].getEstado().equalsIgnoreCase("Perfecto")) {
                        Samsung[i].MostrarDatos();
                        encontradoP = true;
                        System.out.println("-----------------------------------------");
                    }
                    if (RCA[i] != null && RCA[i].getEstado().equalsIgnoreCase("Perfecto")) {
                        RCA[i].MostrarDatos();
                        encontradoP = true;
                        System.out.println("-----------------------------------------");
                    }
                    if (Lg[i] != null && Lg[i].getEstado().equalsIgnoreCase("Perfecto")) {
                        Lg[i].MostrarDatos();
                        encontradoP = true;
                        System.out.println("-----------------------------------------");
                    }
                }
                //SI no se encontro entonces mostrara un mensaje indicando que no hay tal estado del producto
                if (!encontradoP) {
                    System.out.println("No hay productos en estado Perfecto");
                    System.out.println("-----------------------------------------");
                    promptEnterKey();
                    try
                    {
                        // Limpiar la ventana
                        limpiarventana();
                    }
                    catch (IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                }else {
                    promptEnterKey();
                    try {
                        // Limpiar la ventana
                        limpiarventana();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
            case 2 -> {
                boolean encontradoD = false;
                System.out.println("-----------------------------------------");
                for (int i = 0; i < Producto.length; i++) {
                    if (Samsung[i] != null && Samsung[i].getEstado().equalsIgnoreCase("Da?ado")) {
                        Samsung[i].MostrarDatos();
                        encontradoD = true;
                        System.out.println("-----------------------------------------");
                    }
                    if (RCA[i] != null && RCA[i].getEstado().equalsIgnoreCase("Da?ado")) {
                        RCA[i].MostrarDatos();
                        encontradoD = true;
                        System.out.println("-----------------------------------------");
                    }
                    if (Lg[i] != null && Lg[i].getEstado().equalsIgnoreCase("Da?ado")) {
                        Lg[i].MostrarDatos();
                        encontradoD = true;
                        System.out.println("-----------------------------------------");
                    }
                }
                if (!encontradoD) {
                    System.out.println("No hay productos da?ados");
                    System.out.println("-----------------------------------------");
                    promptEnterKey();
                    try
                    {
                        // Limpiar la ventana
                        limpiarventana();
                    }
                    catch (IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                }else{
                    promptEnterKey();
                    try
                    {
                        // Limpiar la ventana
                        limpiarventana();
                    }
                    catch (IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                }
            }
            case 3 -> {
                boolean encontradoV = false;
                System.out.println("-----------------------------------------");
                for (int i = 0; i < Producto.length; i++) {
                    if (Samsung[i] != null && Samsung[i].getEstado().equalsIgnoreCase("Vacio")) {
                        Samsung[i].MostrarDatos();
                        encontradoV = true;
                        System.out.println("-----------------------------------------");
                    }
                    if (RCA[i] != null && RCA[i].getEstado().equalsIgnoreCase("Vacio")) {
                        RCA[i].MostrarDatos();
                        encontradoV = true;
                        System.out.println("-----------------------------------------");
                    }
                    if (Lg[i] != null && Lg[i].getEstado().equalsIgnoreCase("Vacio")) {
                        Lg[i].MostrarDatos();
                        encontradoV = true;
                        System.out.println("-----------------------------------------");
                    }
                }
                if (!encontradoV) {
                    System.out.println("No hay productos vacios");
                    System.out.println("-----------------------------------------");
                    promptEnterKey();
                    try
                    {
                        // Limpiar la ventana
                        limpiarventana();
                    }
                    catch (IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                }else{
                    promptEnterKey();
                    try
                    {
                        // Limpiar la ventana
                        limpiarventana();
                    }
                    catch (IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                }
            }
            case 4 -> {
                System.out.println("Saliendo........");
                promptEnterKey();
                try
                {
                    // Limpiar la ventana
                    limpiarventana();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            default -> System.out.println("Opcion incorrecta");
        }
    }while(opcion != 4);
}
}



public void  Final (int opcion) throws InterruptedException {
    //Y en este ultimo metodo se quedara en publico para que el programador solo pueda usar este metodo
    //Y aqui inicializara todos los metodos y si faltara uno daria error ya que algunos datos solo estan guardado en un metodo
    switch (opcion) {
        case 1 -> {
            System.out.println("-----------------------------------------");
            //Llamamos el metodo que esta en esta clase
            IngresarDatos();
        }
        case 2 -> {
            System.out.println("-----------------------------------------");
            ClasificarDatos();
        }
        case 3 -> {
            System.out.println("-----------------------------------------");
            Movimientos();
        }
        case 4 -> {
            int opcionConsulta;
            System.out.println("-----------------------------------------");
            System.out.println("Deseas hacer una consultas por: ");
            System.out.println("1) Modelo:");
            System.out.println("2) Por marcas:");
            System.out.println("3) Por estado del producto");
            while (true) {
                try {
                    opcionConsulta = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Dato incorrecto. Solo se acepta numeros enteros indicados");
                    sc.nextLine(); // Descartar token inválido
                }
            }
            switch (opcionConsulta) {
                case 1 -> {
                    System.out.println("-----------------------------------------");
                    ConsultasModelo();
                }
                case 2 -> {
                    System.out.println("-----------------------------------------");
                    ConsultasMarcas();
                }
                case 3 -> {
                    System.out.println("-----------------------------------------");
                    MostrarEstado();
                }
                default -> System.out.println("Opcion incorrecta");
            }
        }
        case 5 -> System.out.println("Saliendo...");
        default -> System.out.println("Opcion incorrecta");
    }
}
    public static void limpiarventana() throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}