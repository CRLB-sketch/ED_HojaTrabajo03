/**
 * <h1> Hoja de Trabajo 02 </h1>
 * <h2> Controller (Clase tipo "Controlador") </h2>
 * 
 * Algoritmos
 * 
 * Esta clase se encargará de llevar a cabo la lógica
 * del programa en sí.
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

import java.lang.NumberFormatException;
 
public class Controller {
    
    // --> Atributos
    private NumberGenerator numberG;
    private FileReaderTxt fileR;
    private View view;
    private String nameFile;

    // --> Constructor
    public Controller(){
        numberG = new NumberGenerator();
        fileR = new FileReaderTxt();
        view = new View();
        nameFile = "docs//numbers.txt";
    }

    // --> Métodos
    public void main_menu(){

        boolean out = false;
        do {
            
            String option = view.menu();

            switch (option) {

                // Asignar archivo Txt
                case "1":
                    
                    break;
            
                // Ver estado del archivo Txt
                case "2":
                    
                    String info2 = fileR.readFile(nameFile);

                    if(info2.equals("error")){
                        view.errorFile();
                    }
                    else{
                        if(info2.equals("") && info2.equals(" ")){
                            view.fileState(0);
                        }
                        else{
                            view.fileState(1);                            
                        }
                    }
                
                    break;

                // Asignar numeros al archivo Txt
                case "3":
                    // Preguntar por la cantidad de numeros
                    int amount = view.askValue();
                
                    // Generar numeros aleatorios
                    String numbers = numberG.generateNums(amount);
                    
                    if(numbers.equals("")){
                        // Valor inválido
                        view.invalid(1);
                    }else{
                        // Asignar los numeros generados
                        view.dialogueText(fileR.saveInformation(nameFile, numbers));
                    }
                                    
                    break;

                // Ordenar los numeros del archivo
                case "4":
                                                       
                    String info4 = fileR.readFile(nameFile);
                    
                    if(info4.equals("error")){
                        // Mostrar mensaje de error
                        view.errorFile();
                    }
                    else{
                        try {
                            // Obtener los numeros
                            int[] finalNumbers = numberG.convertStringToInt(info4);
                            
                            // Utilizar métodos de ordenamiento
                            
                        } 
                        // Mostrar los posibles errores
                        catch (NumberFormatException e){
                            view.errorLetter();
                        }                        
                        catch (Exception e) {                                                       
                            view.errorUnknow();
                        }
                    }                    
                    break;

                // Salir
                case "5":
                    out = true;
                    view.finish();  
                    break;
                    
                // Opción inválida
                default:
                    view.invalid(0);
                    break;
            }
            
        } while (!out);
    }
}
