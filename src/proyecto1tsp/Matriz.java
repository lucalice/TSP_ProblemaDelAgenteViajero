package proyecto1tsp; 

import java.util.List;

/**
 * @author Carranza Escobar Luis Enrique
 */
public class Matriz {
    
    private int iNumCiudades;
    private int aux = 0;
    private double[][] iMatrizTran;
    private double[][] iHeuristica;
    private List<String> listaHeuristica;
    private List<String> listaPeso;
    
    public Matriz(){
        
    }
    
    public Matriz(List<String> listaPeso,List<String> listaHeuristica,int iNumCiudades){
        this.iNumCiudades = iNumCiudades;
        this.listaPeso = listaPeso;
        this.listaHeuristica = listaHeuristica;
    }
    
    public void creaMatrices(){
        iMatrizTran = new double[iNumCiudades][iNumCiudades];
        iHeuristica = new double[iNumCiudades][iNumCiudades];
        if(listaPeso.size() == listaHeuristica.size()){
            for(int i = 0; i < iNumCiudades; i++){
                for(int j = 0; j < iNumCiudades; j++){
                    iMatrizTran[i][j] = Double.parseDouble(listaPeso.get(aux));
                    iHeuristica[i][j] = Double.parseDouble(listaHeuristica.get(aux));
                    aux ++;
                }
            }
        }else{
            listaHeuristica.add("A");
            for(int i = 0; i < iNumCiudades; i++){
                for(int j = 0; j < iNumCiudades; j++){
                    iMatrizTran[i][j] = Double.parseDouble(listaPeso.get(aux));
                    iHeuristica[i][j] = Double.parseDouble(listaHeuristica.get(aux));
                    aux ++;
                }
            }
        }
        
    }
    
    public void muestraMatrices(){
        System.out.println("Matriz de pesos");
        for(int i = 0; i < iNumCiudades; i++){
            for(int j = 0; j < iNumCiudades; j++){
                System.out.print(iMatrizTran[i][j]+" ");
            }
            System.out.println("\n");
        }
        System.out.println("Matriz heuristica.");
        for(int i = 0; i < iNumCiudades; i++){
            for(int j = 0; j < iNumCiudades; j++){
                System.out.print(iHeuristica[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
    
    public double[][] getMatrizTran(){
        return iMatrizTran;
    }
    public double[][] getMatrizHeu(){
        return iHeuristica;
    }
}
