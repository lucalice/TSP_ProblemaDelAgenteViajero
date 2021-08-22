package proyecto1tsp; 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Carranza Escobar Luis Enrique
 */
public class Lector {
    
    int    iNumCiudades = 0;
    int    iNumLineasArchivo = 0;
    String fileName = null;
    String cadena = null;
    String subCadena[];
    String totalCiudadesMapa[];
    String ruta[];
    List<String> listaCiudadesVisita = new ArrayList<String>();
    List<String> listaPeso = new ArrayList<String>();
    List<String> listaHeuristica = new ArrayList<String>();
    
    
    /**
     * Constructor default
     */
    public Lector (){
        
    }
    
    /**
     * Constructor sobrecargado
    */
    public Lector(String fileName) throws FileNotFoundException, IOException {
        this.fileName = fileName;
        this.iNumCiudades = 0;
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        while(b.readLine() != null){
            iNumLineasArchivo++;
        }
        System.out.println("El archivo tiene "+iNumLineasArchivo+" líneas.");
        b.close();
    } 
    
    /**
     * Método que lee el archivo línea por línea
     */
    public void leerNumCiudades() throws FileNotFoundException, IOException {
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();
        subCadena = cadena.split(" ");
        b.close();
        iNumCiudades = subCadena.length;
        System.out.println("El número de ciudades es de: "+iNumCiudades);
    }
    
    /**
     * Método que genera las listas necesarias para poder crear las matrices de transición
     * 
     */
    public void matriz() throws FileNotFoundException, IOException {
        int aux = 0;
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        b.readLine();
        while(((cadena = b.readLine())!=null)  && aux < iNumLineasArchivo){
            //Leemos las lineas restantes
            subCadena = cadena.split(" ");
            for (int i = 1; i<subCadena.length;i+=3){
                listaPeso.add(subCadena[i]);                                
            }
          
            for (int i = 2; i<subCadena.length;i+=3){
                listaHeuristica.add(subCadena[i]);
            }
            aux++;
        }
    }
    /**
     *Método que muestra el contenido de las listas
     */
    
    public void muestralista(){
        System.out.println("Lista Peso:\n");
        for (String listaPeso1 : listaPeso) {
            System.out.println(listaPeso1);
        }
        System.out.println("\nLista Heuristica: \n");
        for (String listaPeso2: listaHeuristica){
            System.out.println(listaPeso2);
        }
        
    }
    /**
     *Método que regresa un arreglo con los nombres de las ciudades
     */
    public String[] getNombreCiudades()throws FileNotFoundException, IOException {
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        totalCiudadesMapa = b.readLine().split(" ");
        return totalCiudadesMapa;
    }
    
    /**
     *Método que regresa la lista con los datos para crear la matriz de pesos o matriz de trancision
     */
    public List<String> getListaPeso(){        
        return listaPeso;
    }
    
    /**
     *Método que regresa la lista con los datos para crear la matriz de heuristica
     */
    public List<String> getListaHeuristica(){        
        return listaHeuristica;
    }
    
    /**
     *Método que regresa el número total de ciudades
     */
    public int getNumCiudades(){
        return iNumCiudades;
    }
    
    
    public String[] getRuta() throws FileNotFoundException, IOException {        

        LineNumberReader lnr;
        int numLinea=0;//Número de línea leido
        String valLinea="";//Valor de la línea leido
        try{
            lnr=new LineNumberReader(new FileReader(fileName));//Acceso al archivo
            while(true){//ciclo infinito
                String linea=lnr.readLine();//lee otra línea y almacena temporalmente su valor
                if(numLinea==lnr.getLineNumber()){
                //cuando llega a la última linea, el valor de getLineNumber, no cambia
                //System.out.println(valLinea);//Imprime la última línea del archivo
                //System.out.println(numLinea);//Imprime el número de la última línea del archivo
                break;
            }
            valLinea=linea;
            numLinea=lnr.getLineNumber();//Almacena el número de línea
            }
        }catch(IOException ioe){
            System.out.println("No hay ruta de paseo.");    
        }            
        return ruta = valLinea.split(" ");
    }
    
}
