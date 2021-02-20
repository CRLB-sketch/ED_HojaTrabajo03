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

public class Sorting {
    

    //------------------------------------------------------------------------------
    // Métodos con los algoritmos correspondientes
    //------------------------------------------------------------------------------
    
    /**
     * Selection Sort Algorithm.
     * 
     * @param data  Solicitar los datos que se desean ordenar
     */
    public static void selectionSort(int data[]){
        int numUnsorted = data.length;
        int index; // general index
        int max; // index of largest value
        while (numUnsorted > 0)
        {
            // determine maximum value in array
            max = 0;
            for (index = 1; index < numUnsorted; index++)
            {
                if (data[max] < data[index]) max = index;
            }
            swap(data,max,numUnsorted-1);
            numUnsorted--;
        }
    }
    
    /**
     * Insertion Sort Algorithm.
     * 
     * @param data  Solicitar los datos que se desean ordenar
     */
    public static void insertionSort(int data[]){
        int numSorted = 1; // number of values in place
        int index; // general index
        while (numSorted < data.length)
        {
            // take the first unsorted value
            int temp = data[numSorted];
            // ...and insert it among the sorted:
            for (index = numSorted; index > 0; index--)
            {
                if (temp < data[index-1])
                {
                    data[index] = data[index-1];
                } else {
                    break;
                }
            }
            // reinsert value
            data[index] = temp;
            numSorted++;
        }
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

    /**
     * Quick Sort Algorithm.
     * 
     * @param data  Solicitar los datos que se desean ordenar
     */
    public static void quickSort(int data[]){
        quickSortRecursive(data, 0, data.length-1);
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

}
