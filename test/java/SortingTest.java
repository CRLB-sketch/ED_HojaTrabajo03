import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;
class SortingTest {

    //array de ejemplo
    int[] data= {10, 20, 30, 40, 23, 14, 19, 90, 122};

    //GNOME*****************
    @org.junit.jupiter.api.Test
    void gnomeSort() {
        int index = 0;
        int n=data.length;
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
        System.out.println(data);
    }
    //GNOME*****************

    //RADIX****************
    @org.junit.jupiter.api.Test
    void radixSort(int data[]) {
        for (int i = 0; i < 6; i++){
            ordenRadix(data,i);
        }
    }

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

    private static int digit(int n, int d){
        if (d == 0) return n % 10;
        else return digit(n/10,d-1);
    }
    //RADIX****************


    //QUICK**********************
    @org.junit.jupiter.api.Test
    void quickSort(int data[]){
        quickSortRecursive(data, 0, data.length-1);
    }

    private static void quickSortRecursive(int data[], int left, int right){
        int pivot;
        if (left >= right) return;
        pivot = partition(data,left,right);
        quickSortRecursive(data,left,pivot-1);
        quickSortRecursive(data,pivot+1,right);
    }

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

    private static void swap(int data[], int i, int j) {
        int temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //QUICK**********************

    //BUBLE**************************
    @org.junit.jupiter.api.Test
    void bubleSort(int data[]) {
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
    //BUBLE**************************

    //MERGE************************
    @org.junit.jupiter.api.Test
    void mergeSort(int data[]){

        if(data.length <= 1) {

            System.out.println(data);

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

        mergeSort(left);
        mergeSort(right);

        result = merge(left, right);

        System.out.println(result);
    }

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
    //MERGE************************

}