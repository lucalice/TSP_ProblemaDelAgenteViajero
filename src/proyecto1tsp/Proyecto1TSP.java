package proyecto1tsp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;

/**
 * @author Carranza Escobar Luis Enrique
 */
public class Proyecto1TSP {

    public static void main(String[] args)throws FileNotFoundException, IOException {
        
        String[] ruta;
        int verificacion = 1; //Debe ser igual a uno, porque partimos de la ciudad de origen 
        List<Nodo> nodosCreados =  null;
        
        /*
        *Leemos los datos 
        */
        String h = "/Users/luiscarranza/Documents/IA/Proyecto1TSP/src/proyecto1tsp/ABDC.txt"; //Leemos la mariz de incidencia del grafo
        Lector l = new Lector(h);
        l.leerNumCiudades();
        l.matriz();
        ruta = l.getRuta();
        List<String> rutaListas = asList(ruta);
        
        /*
        *Creamos las matrices que representan el grafo
        */
        Matriz mat = new Matriz(l.getListaPeso(),l.getListaHeuristica(),l.getNumCiudades());
        mat.creaMatrices();
        mat.muestraMatrices();
       
        //mat.muestraMatrices();
        
        
        /*
        * Creamos el árbol
        */
        //l.getRuta[0] es igual a la ciudad dónde nos encontramos actualmente
        
        Arbol mapa = new Arbol(mat.getMatrizTran(),mat.getMatrizHeu(),l.getRuta()[0],l.getNombreCiudades());
        //verificacion++;
        //mapa.muestraNodoRaiz();
        //System.out.println("Hola bro");
         
        /**
         * 0 0 0
        */
        Nodo papa =  new Nodo();
        papa = mapa.getNodoRaiz();
        //nodosCreados.add(papa);
        //System.out.println("Mostrando el noto raiz: ");
        //papa.mostrarNodo();
        ruta[0] = "0";
        
        for(int i  = 0; i < ruta.length; i++){
            if(ruta[i].equals(mapa.getHijoRaiz().getNombre())){
                verificacion++;
                //System.out.println("Hola man"+ruta[i]);
            }
            
        }
        
        //mapa.getCiudadesVisitadas().retainAll(Arrays.asList(ruta))
        while(ruta.length != verificacion){
            
            System.out.println("--------------------------------------------------------------");
            //papa = mapa.generaHijos(mapa.encuentraCiudad(l.getNombreCiudades(),l.getRuta()[0]),papa); 
            System.out.println("Ciudad: "+mapa.getCiudadInt());
            papa = mapa.generaHijos(mapa.getCiudadInt(),papa);  
            //nodosCreados.add(papa);
            papa.mostrarNodo();
            for(int i = 0; i<ruta.length;i++){
                if(ruta[i].equals(papa.getNombre())){
                    verificacion++;
                    ruta[i] = "0";
                }
            }
            System.out.println("--------------------------------------------------------------");
            
        }
        
        System.out.println("Ciudades visitadas: ");
        String cambio = mapa.getCiudadesVisitadas().remove(0);
        mapa.getCiudadesVisitadas().add(1, cambio);
        for (String elemento: mapa.getCiudadesVisitadas())
            System.out.print(elemento+" ");
        
        System.out.println(" ");
        System.out.println("El peso total es de: "+mapa.getPesoTotal());
        
    }
    
}
