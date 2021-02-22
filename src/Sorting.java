/**
 * <h1> Hoja de Trabajo 02 </h1>
 * <h2> Sorting </h2>
 * 
 * Algoritmos
 * 
 * Esta clase se encargará de ordenar todos los numeros del archivo,
 * contaremos con varios tipos de algoritmos (Solo habrán métodos).
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


import java.util.*;
import java.io.*;

public class Sorting {
    

    //------------------------------------------------------------------------------
    // Métodos con los algoritmos correspondientes
    //------------------------------------------------------------------------------

    /***
     * Gnome Sort Algoritm (Stupid Sort Algoritm)
     * @param data: los numeros a ordenar
     * @param n: cantidad de datos en el array
     */
    public static void gnomeSort(int data[], int n)
    {
        int index = 0;

        while (index < n) {
            if (index == 0)
                index++;
            if (data[index] >= data[index - 1])
                index++;
            else {
                int temp = 0;
                temp = data[index];
                data[index] = data[index - 1];
                data[index - 1] = temp;
                index--;
            }
        }
        return;
    }

    /***
     * algoritmo Merge Sort
     * @param data array con todos los números a ordenar
     * @return
     */
    public static int[] mergeSort(int data[]) {


        if(data.length <= 1) {

            return data;

        }

        int midpoint = data.length / 2;


        int[] left = new int[midpoint];
        int[] right;

        if(data.length % 2 == 0) { // el array es impar

            right = new int[midpoint];

        } else {

            right = new int[midpoint + 1];

        }

        for(int i=0; i < midpoint; i++) {

            left[i] = data[i];

        }

        for(int j=0; j < right.length; j++) {

            right[j] = data[midpoint+j];

        }

        int[] result = new int[data.length];

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);

        return result;

    }


    /***
     * Radix Sort
     * 
     * @param data el array que contiene los números a ordenar
     */
    public static void radixSort(int data[]){
        // pre: data is array of values; each is less than 1,000,000
        // post: data in the array are sorted into increasing order
        for (int i = 0; i < 6; i++){
            ordenRadix(data,i);
        }
    }

    /**
     * Quick Sort Algorithm.
     *
     * @param data  Solicitar los datos que se desean ordenar
     */
    public static void quickSort(int data[]){
        quickSortRecursive(data, 0, data.length-1);
    }

    /**
     * Buble Sort Algorithm.
     * 
     * @param data  Solicitar los datos que se desean ordenar
     */
    public static void bubleSort(int data[]){
        int numSorted = 0; // number of values in order
        int index; // general index
        while (numSorted < data.length)
        {
            // bubble a large element to higher array index
            for (index = 1; index < data.length-numSorted; index++)
            {
                if (data[index-1] > data[index])
                    swap(data,index-1,index);
            }
            // at least one more value in place
            numSorted++;
        }
    }

    //------------------------------------------------------------------------------
    // Métodos que auxiliaran a los métodos anteriores
    //------------------------------------------------------------------------------

    /**
     * Swap: Para intercambiar los valores.
     * 
     * @param data  Solicitar los datos que se desean modificar
     * @param i     Obtener el valor izquierdo
     * @param j     Obtener el valor derecho
     */
    private static void swap(int data[], int i, int j) {
        int temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    
    /**
     * Quick Sort Recuersive: Este metodo se llevará a cabo recursivamente.
     * 
     * @param data  Solicitar los datos que se desean modificar
     * @param left  Obtener el valor izquierdo
     * @param right Obtener el valor derecho
     */
    private static void quickSortRecursive(int data[], int left, int right){
        int pivot;
        if (left >= right) return;
        pivot = partition(data,left,right);
        quickSortRecursive(data,left,pivot-1);
        quickSortRecursive(data,pivot+1,right);
    }

    /**
     * Partition: Para hacer las particiones correspondientes
     * 
     * @param data  Solicitar los datos que se desean modificar
     * @param left  Obtener el valor izquierdo
     * @param right Obtener el valor derecho
     * @return      Se devolverá el valor derecho o izquierda
     *              depende del resultado final del algoritmo
     */
    private static int partition(int data[], int left, int right)
    {
        while (true)
        {
        // Mover el puntero derecho hacia la izquierda
        while (left < right && data[left] < data[right]) right--;
        if (left < right) swap(data,left++,right);
        else return left;
        // Mover el puntero izquierod hacia la derecha
        while (left < right && data[left] < data[right]) left++;
        if (left < right) swap(data,left,right--);
        else return right;
        }
    }

    /***
     * Método para definir el orden para Radix
     * @param data datos del array
     * @param d los datos se ordenan por el dígito que se encuentra en la ubicación d
     */
    private static void ordenRadix(int data[], int d){

        int i;
        int j;
        int value;
        // alojar el orden que se usará, en esta caso de 0-9
        Vector<Vector<Integer>> orden = new Vector<Vector<Integer>>(10);
        orden.setSize(10);
        for (j = 0; j < 10; j++) orden.set(j,new Vector<Integer>());
        int n = data.length;
        for (i = 0; i < n; i++){
            value = data[i];
            j = digit(value,d);
            orden.get(j).add(value);
        }
        i = n;
        for (j = 9; j >= 0; j--){
            while (!orden.get(j).isEmpty()){
                i--;
                value = orden.get(j).remove(j);
                data[i] = value;
            }
        }
    }

    /**
     * el método que denota la base
     * @param n numero usado para referencia y sacar los residuos
     * @param d numero al cual será evaluado el módulo
     * @return retorna la base del número
     */
    private static int digit(int n, int d){
        if (d == 0) return n % 10;
        else return digit(n/10,d-1);
    }


    /***
     *
     * @param left es el arreglo izquierdo, que guarda la primera mitad de datos
     * @param right es el arreglo derecho, que guarda la primera mitad de datos
     * @return
     */
    private static int[] merge(int[] left, int[] right) {

        // Array unido
        int[] result = new int[left.length + right.length];

        // punteros
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while(leftPointer < left.length || rightPointer < right.length) {

            if(leftPointer < left.length && rightPointer < right.length) {

                if(left[leftPointer] < right[rightPointer]) {

                    result[resultPointer++] = left[leftPointer++];

                } else {

                    result[resultPointer++] = right[rightPointer++];

                }

            }

            else if(leftPointer < left.length) {

                result[resultPointer++] = left[leftPointer++];

            }

            else if(rightPointer < right.length) {

                result[resultPointer++] = right[rightPointer++];

            }

        }

        return result;

    }

}

//Referencias de geek's for geek's
//References JavaStructures, Duane A. Bailey, 2007