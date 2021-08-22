package proyecto1tsp;

/**
 * @author Carranza Escobar Luis Enrique
 */
public class Nodo {
    
    private String nombreCiudad;
    private int iHijos;
    private double iPeso;
    private double iHeuristica;
    private Nodo nodoPadre = null;
    private Nodo [] hijos = new Nodo[iHijos]; //Guardaremos los hijos del nodo.
    
    /**
     * Constructor Default
     */
    public Nodo(){
        
    }
    
    /**
     * Constructor que recibe el peso del nodo, la heuristica y el número de hijos (El número de hijos lo obtenemos
     * de la matriz de trancision).
     */
    public Nodo(double iPeso,double iHeuristica,int iHijos,Nodo nodoPadre,String nombreCiudad){
        this.nodoPadre = nodoPadre;
        this.iHijos = iHijos;
        this.iPeso = iPeso;
        this.iHeuristica = iHeuristica;
        this.nombreCiudad = nombreCiudad;
    }
    
    /**
     * Vamos a ir introduciendo los nodos hijos.
     */
    public void setHijos(Nodo hijo,int numeroHijo){
        if (numeroHijo > iHijos){
            System.out.println("No tengo tantos hijos");
        }else{
            hijos[numeroHijo] = hijo;
        }
    }  
    
    public String getNombre(){
        return nombreCiudad;
    }
    
    public double getPeso(){
        return iPeso;
    }
    
    public double getHeuristica(){
        return iHeuristica;
    }
    
    public void mostrarNodo(){
        System.out.println("Ciudad Nodo: "+nombreCiudad);
        System.out.println("Peso Nodo: "+iPeso);
        System.out.println("Heuristica: "+iHeuristica);
        System.out.println("Número de hijos: "+iHijos);
    }
    
}
