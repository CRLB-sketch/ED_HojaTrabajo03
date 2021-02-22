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
        nameFile = "numbers.txt";
    }

    // --> Métodos
    public void main_menu(){

        boolean out = false;
        do {
            
            String option = view.menu();

            switch (option) {

                // Asignar archivo Txt
                case "1":
                    String changeFile = view.askFile(nameFile);

                    if(changeFile.equals("cancelar")){
                        view.dialogueText("--> Cancelado ;)");
                    }
                    else{
                        nameFile = changeFile;
                        view.dialogueText("--> Ruta del archivo cambiada ;)");
                    }
                    
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
                                                       
                    String before = fileR.readFile(nameFile);
                    
                    if(before.equals("error")){
                        // Mostrar mensaje de error
                        view.errorFile();
                    }
                    else{
                        try {
                            // Obtener los numeros
                            int[] finalNumbers = numberG.convertStringToInt(before);                            
                            
                            // Preguntar cual método desea usar
                            String opMethod = view.askMethod();

                            switch (opMethod) {
                                case "1":
                                    Sorting.gnomeSort(finalNumbers, finalNumbers.length);
                                                                        
                                    view.finalResults("Gnome Sort", before, after(finalNumbers));
                                    break;

                                case "2":
                                    int[] resultMS = Sorting.mergeSort(finalNumbers);

                                    view.finalResults("Merge Sort", before, after(resultMS));
                                    break;

                                case "3":
                                    Sorting.radixSort(finalNumbers);
                                    
                                    view.finalResults("Radix Sort", before, after(finalNumbers));
                                    break;

                                case "4":
                                    Sorting.quickSort(finalNumbers);

                                    view.finalResults("Quick Sort", before, after(finalNumbers));
                                    break;

                                case "5":
                                    Sorting.bubleSort(finalNumbers);
                                    
                                    view.finalResults("Buble Sort", before, after(finalNumbers));
                                    break;
                            
                                default:
                                    view.invalid(0);
                                    break;
                            }

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

    private String after(int[] finalNumbers){
        String after = "";
                                    
        for (int i : finalNumbers) {
            after += i + " ";
        }

        return after;
    }
}
