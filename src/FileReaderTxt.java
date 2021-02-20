/**
 * <h1> Hoja de Trabajo 02 </h1>
 * <h2> FileReader (Leector de Archivos) </h2>
 * 
 * Algoritmos
 * 
 * Esta clase ejecutará se encargará de leer los
 * archivos txt.
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

import java.io.*;
 
public class FileReaderTxt {
    
    //------------------------------------------------------------------
    // --> Atributos
    private BufferedReader bf;
    private File f;
    private FileWriter w;
    private BufferedWriter bw;
    private PrintWriter wr;
    
    //------------------------------------------------------------------
    /** 
     * Read File: Método para leer el archivo ingresado
     * 
     * @param file      Para solicitar la dirección del archivo.
     * @return String   Para retornar el texto del archivo
     *                  o la información.
     */
    public String readFile(String file){

        String text = "";
        
        try {

            bf = new BufferedReader(new FileReader(file));
            String temp = "";
            String bfRead;

            while((bfRead = bf.readLine()) != null){
                temp = temp + bfRead;
            }

            text = temp;

        } catch (Exception e) {
            text = "error";
        }

        return text;
    }

    public String saveInformation(String file, String text){
        String information = "";
        
        try {

            f = new File(file);
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);
            
            // Se agregará la información
            wr.write(text);

            wr.close();
            bw.close();

            information = "success";

        } catch (Exception e) {
            information = "error";
        }
        
        return information;
    }
}
