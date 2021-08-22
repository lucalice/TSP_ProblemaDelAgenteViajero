package proyecto1tsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carranza Escobar Luis Enrique
 */
public class Arbol {
    private Nodo raiz = new Nodo(); //Nodo raiz
    private Nodo hijo;
    private String [] ciudades; //Arreglo de todas las ciudades que están en el mapa.
    private double[][] matrizTran; //Matriz de trancision 
    private double[][] matrizHeu; //Matriz de heuristicas
    private String ciudadRaiz; //Nombre de la ciudad raiz, por ejemplo CDMX
    private int ciudadRaizInt; //Número de la ciudad en la columna, por ejemplo CDMX está en la columna 2 de la matriz de transicion
    private List<Nodo> rutaNodos;
    private int hijoaCrear = 0;
    private ArrayList<String> ciudadesVisitadas = new ArrayList<>();
    private float pesoTotal = 0;
    
    /**
     * Constructor Default
     */
    public Arbol(){
        
    }
    
    /**
     * Constructor sobre cargado
     * Este método recibe la matriz de trancision (la representación del grafo), la matriz heuritica, ciudad donde se
     * encuentra el "usuario" y una lista de ciudades que se obtiene mediante la lectura del archivo
     * Esta ciudad Raiz será la raiz del árbol.
     */
    
    public Arbol(double[][] matrizTran, double[][] matrizHeu, String ciudadRaiz, String[] ciudades){
        this.ciudadRaiz = ciudadRaiz;
        this.matrizHeu = matrizHeu;
        this.matrizTran = matrizTran;
        this.ciudades = ciudades; 
        //Encontramos en que posición de la matriz se encuentra la ciudad raiz
        ciudadRaizInt = encuentraCiudad(ciudades,ciudadRaiz);
        System.out.println("La ciudad de inicio es la número: "+ciudadRaizInt);
        System.out.println("La ciudad de inicio es: "+ciudadRaiz);
        System.out.println("");
        //Creamos el nodo raiz inicializaremos el nodo raiz con peso y heuristica igual a cero.
        raiz = new Nodo(0,0,getNumHijosNodo(ciudadRaizInt),null,ciudadRaiz);
        //raiz.mostrarNodo();
        hijo = generaHijos(ciudadRaizInt,null); //Regresa A
        ciudadesVisitadas.add(ciudadRaiz);
    }
    
    
    /**
     * Método que devuelve el número de columna que le corresponde a la ciudad
     */
    public int encuentraCiudad(String[] listaCiudades, String ciudad){
        for(int i = 0; i < listaCiudades.length;i++){
            if(listaCiudades[i].equals(ciudad)){
                ciudadRaizInt = i;
                return i;
            }
        }
        return 0;
    }
    
    
    /**
     * Método que devuelve el número de hijos de un nodo
     * Recibe la posición de la ciudad en la matriz de transición
     */
    public int getNumHijosNodo(int ciudadRaiz){
        int iNumHijos = 0;
        for(int i = 0; i < ciudades.length; i++){
            if(matrizTran[i][ciudadRaiz] != 0){
                iNumHijos++;
            }
        }
        return iNumHijos;
    }
    
    /**
     * Método que recibe El número de ciudad dónde se buscarán los hijos y el nodo papá.
     */
    public Nodo generaHijos(int iNumCiudad, Nodo nodoPapa){
        double suma = 0.0;
        double desicionNodo = 1000000.0;
        if(raiz == null){
            System.out.println("No hay una raíz");
            return null;
        }else{
            for(int i = 0; i < ciudades.length; i++){
                if(matrizTran[iNumCiudad][i] != 0.0){                  
                    System.out.println("Peso del hijo: "+matrizTran[iNumCiudad][i]);
                    System.out.println("Heu del hijo: "+matrizHeu[iNumCiudad][i]);
                    suma = matrizTran[iNumCiudad][i] + matrizHeu[iNumCiudad][i];
                    if((suma <= desicionNodo)){ //&& (ciudadesVisitadas.indexOf(ciudades[i]) != -1)
                        desicionNodo = suma;
                        hijoaCrear = i;
                        System.out.println("Ciudad hija: "+ciudades[i]);
                    }
                    System.out.println("\n");
                }
            }
            //System.out.println("Este es el valor de i: "+hijoaCrear);
            matrizTran[iNumCiudad][hijoaCrear] = 0.0;
            //matrizTran[hijoaCrear][iNumCiudad] = 0.0;
            matrizHeu[iNumCiudad][hijoaCrear] = 0.0;
            //matrizHeu[hijoaCrear][iNumCiudad] = 0.0;
        }
        ciudadesVisitadas.add(ciudades[hijoaCrear]);
        Nodo nodoHijo =  new Nodo(matrizTran[iNumCiudad][hijoaCrear],matrizHeu[iNumCiudad][hijoaCrear],getNumHijosNodo(hijoaCrear),nodoPapa,ciudades[hijoaCrear]);
        pesoTotal += desicionNodo;
        return nodoHijo;
    }
    
    
    
    
    public void muestraNodoRaiz(){  
        System.out.println("Ciudades en el mapa: "+ciudades);
        System.out.println("Matriz Trancision");
        for(int i = 0; i<ciudades.length;i++){
            for(int j = 0; j<ciudades.length;j++){
                System.out.print(matrizTran[i][j]+" ");
            }
            System.out.println("\n");
        }
        System.out.println("Matriz Heu");
        
        for(int i = 0; i<ciudades.length;i++){
            for(int j = 0; j<ciudades.length;j++){
                System.out.print(matrizHeu[i][j]+" ");
            }
            System.out.println("\n");
        }
        System.out.println("Ciudad raiz: "+ciudadRaiz);
        System.out.println("Coulmna Ciudad raiz: "+ciudadRaizInt);
        System.out.println("Número de hijos del nodo padre: "+ getNumHijosNodo(ciudadRaizInt));
    }
    
    
    public ArrayList<String> getCiudadesVisitadas(){
        return ciudadesVisitadas;
    } 
    public int getCiudadInt(){
        return hijoaCrear;
    }
    public Nodo getNodoRaiz(){
        return raiz;
    }
    public Nodo getHijoRaiz(){
        return hijo;
    }
    public float getPesoTotal(){
        return pesoTotal;
    }
}
