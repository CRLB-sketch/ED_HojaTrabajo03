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

public class TestNumberG extends TestCase {
    
    // --> Atributos
    private NumberGenerator numG;

    // --> Constructor
    public TestNumberG(){
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
        
}
