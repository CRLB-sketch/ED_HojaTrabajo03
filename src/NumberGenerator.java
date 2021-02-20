/**
 * <h1> Hoja de Trabajo 02 </h1>
 * <h2> NumberGenerator / Generador de Números </h2>
 * 
 * Algoritmos
 * 
 * Esta clase se encargará de dar valores numericos o al azar
 * depende de la necesidad o los deseos del usuario.
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

import java.util.Random;
 
public class NumberGenerator {
    
    //------------------------------------------------------------------
    // --> Atributos
    private Random rand;

    //------------------------------------------------------------------
    // --> Constantes
    private final static int MAX_NUMBERS = 3000;
    private final static int MIN_NUMBERS = 3;

    //------------------------------------------------------------------
    // --> Constructor
    public NumberGenerator(){
        rand = new Random();
    }
    
    //------------------------------------------------------------------
    // --> Métodos

    /**
     * Generar Numeros: Para generar numeros deseados
     * 
     * @param amount    Numeros deseados
     * @return          Los numeros aleatorios solicitados
     */
    public String generateNums(int amount) {
        // Para guardar todos los numeros
        String numbers = "";

        // Verificaremos si es el valor ideal
        if(amount >= MIN_NUMBERS && amount <= MAX_NUMBERS){
            // Empezaremos a unir todos los numeros
            for (int i = 0; i < amount; i++) {                
                numbers += rand.nextInt(MAX_NUMBERS) + " ";
            }
        }
        
        return numbers;
    }

    public int[] convertIntToString(String[] numbers) {
        return null;
    }
}
