/**
 * <h1> Hoja de Trabajo 02 </h1>
 * <h2> ISorting (Clase tipo "Interface") </h2>
 * 
 * Algoritmos
 * 
 * Esta interface tendrá las bases principales para tener
 * una clase sorting completa.
 * 
 * Git del programa: *Enlace del GIT*
 * 
 * <p>
 * Algoritmos Estructuras de datos - Universidad del Valle de Guatemala
 * </p>
 * 
 * Creado por:
 * 
 * @author Cristian Fernando Laynez Bachez
 * @version 1.0
 * @since 2021 - Febrero - 19
 **/    

public interface ISorting {
    
    /**
     * Selection Sort Algorithm.
     * 
     * @param data  Solicitar los datos que se desean ordenar
     */
    void selectionSort(int data[]);

    /**
     * Insertion Sort Algorithm.
     * 
     * @param data  Solicitar los datos que se desean ordenar
     */
    void insertionSort(int data[]);

    /**
     * Buble Sort Algorithm.
     * 
     * @param data  Solicitar los datos que se desean ordenar
     */
    void bubleSort(int data[]);

    /**
     * Quick Sort Algorithm.
     * 
     * @param data  Solicitar los datos que se desean ordenar
     */
    void quickSort(int data[]);    
}
