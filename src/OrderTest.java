/**
 * <h1> Hoja de Trabajo 02 </h1>
 * <h2> Test Number Generator </h2>
 * 
 * Algoritmos
 * 
 * En esta clase se llevarán a cabo pruebas unitarias
 * para revisar la clase Test Number Generator.
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

import junit.framework.TestCase;

public class OrderTest extends TestCase {
    
    // --> Atributos
    private NumberGenerator numG;
    private int[] data= {10, 20, 30, 40, 23, 14, 19, 90, 122};

    // --> Constructor
    public OrderTest(){
        numG = new NumberGenerator();
    }
    
    // --> Métodos
    public void testGenerator(){
        // Esto nunca dará un resultado bueno por los aleatorios Xd
        // Pero si da los valores solicitados :)
        String result = numG.generateNums(1000);
        String expected = "Correcto";

        assertEquals(expected, result);
    }

    public void testGnomeSort(){

        String result = "";
        String expected = "";
        
        // Ordenar
        Sorting.gnomeSort(data, data.length);

        for (int i : data) {
            result += i + " ";
        }

        // Verificar respuesta
        int[] order = {10, 14, 19, 20, 23, 30 , 40, 90, 122};

        for (int i : order) {
            expected += i + " ";
        }

        assertEquals(expected, result);
    }

    public void testMergeSort(){
        String result = "";
        String expected = "";
        
        // Ordenar
        int[] order = Sorting.mergeSort(data);
        
        for (int i : order) {
            result += i + " ";
        }

        // Verificar respuesta
        int[] orderExpected = {10, 14, 19, 20, 23, 30 , 40, 90, 122};

        for (int i : orderExpected) {
            expected += i + " ";
        }

        assertEquals(expected, result);
    }
        
    public void testRadixSort(){
        String result = "";
        String expected = "";
        
        // Ordenar
        Sorting.radixSort(data);

        for (int i : data) {
            result += i + " ";
        }

        // Verificar respuesta
        int[] order = {10, 14, 19, 20, 23, 30 , 40, 90, 122};

        for (int i : order) {
            expected += i + " ";
        }

        assertEquals(expected, result);
    }

    public void testQuickSort(){
        String result = "";
        String expected = "";
        
        // Ordenar
        Sorting.quickSort(data);

        for (int i : data) {
            result += i + " ";
        }

        // Verificar respuesta
        int[] order = {10, 14, 19, 20, 23, 30 , 40, 90, 122};

        for (int i : order) {
            expected += i + " ";
        }

        assertEquals(expected, result);
    }

    public void testBubleSort(){
        String result = "";
        String expected = "";
        
        // Ordenar
        Sorting.bubleSort(data);

        for (int i : data) {
            result += i + " ";
        }

        // Verificar respuesta
        int[] order = {10, 14, 19, 20, 23, 30 , 40, 90, 122};

        for (int i : order) {
            expected += i + " ";
        }

        assertEquals(expected, result);
    }
}
