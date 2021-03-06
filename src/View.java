/**
 * <h1> Hoja de Trabajo 02 </h1>
 * <h2> View (Clase tipo "Vista") </h2>
 * 
 * Algoritmos
 * 
 * Esta clase ejecutará se encargará con todo lo relacionado
 * con la interacción con el usuario.
 * 
 * Git del programa: *Enlace del GIT*
 * 
 * <p>
 * Algoritmos Estructuras de datos - Universidad del Valle de Guatemala
 * </p>
 * 
 * Creado por:
 * 
 * @author Cristian Fernando Laynez Bachez, Elean Rivas
 * @version 1.0
 * @since 2021 - Febrero - 19
 **/    

import java.util.Scanner;
 
public class View {
    
    //------------------------------------------------------------------
    // --> Atributos
    private Scanner scan;

    //------------------------------------------------------------------
    // --> Constructor
    public View(){
        scan = new Scanner(System.in);
    }

    //------------------------------------------------------------------
    // --> Métodos

    public String menu(){
        System.out.println("Menu:");
        System.out.println("1. Asignar archivo Txt");
        System.out.println("2. Ver estado del archivo Txt");
        System.out.println("3. Asignar numeros al archivo Txt");
        System.out.println("4. Ordenar los numeros del archivo");
        System.out.println("5. Salir");

        String option = scan.nextLine();
        return option;
    }

    public void state(int estado){
        if (estado == 0)
            System.out.println("Esta vacio");
        if (estado == 1)
            System.out.println("Tiene contenido");
    }

    public int askValue(){
        System.out.println("¿Cuantos numeros deseas?");

        int op = scan.nextInt();
        return op;
    }

    public String askFile(String actualFile){
        System.out.println("Ruta actual: " + actualFile);
        System.out.println("Escribe el nombre del archivo: ");
        System.out.println("Ejemplo 1: [docs//nombreEjemplo.txt]");
        System.out.println("Ejemplo 2: [nombreEjemplo.txt]");
        System.out.println("Escriba 'cancelar' por si ya no quiere poner otro doc");

        String op = scan.nextLine();
        return op;
    }    
    
    public String askMethod(){
        System.out.println("¿Cual de estos métodos deseas usar?");
        System.out.println("1. GnomeSort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Radix Sort");
        System.out.println("4. Quick Sort");
        System.out.println("5. Buble Sort");

        String op = scan.nextLine();
        return op;
    }

    public void finalResults(String method, String before, String after){
        System.out.println("- Metodo Utilizado: " + method);        
        System.out.println("\nAntes:\n" + before);
        System.out.println("\nDespues:\n" + after);
    }

    public void invalid(int op){
        if(op == 0)
            System.out.println("--> Opción invalida");
        if(op == 1)
            System.out.println("--> Valor invalido");
    }

    public void finish(){
        System.out.println("--> Saliendo...");
    }

    public void dialogueText(String information){
        System.out.println(information);
    }
    
    public void errorFile(){
        System.out.println("--> ERROR: No se encontro el archivo");
    }

    public void errorLetter(){
        System.out.println("--> ERROR: Tu documento tiene letras, aquí solo ordenaremos numeros.");
    }

    public void errorUnknow(){
        System.out.println("--> ERROR: Ocurrio un inconveniente desconocido :(");
    }

    public void fileState(int op){
        if(op == 0)
            System.out.println("--> Este archivo esta vacio");
        if(op == 1)
            System.out.println("--> Este archivo tiene contenido");
    }
}
