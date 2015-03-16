/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.*;

/**
 *
 * @author BELTRAN
 */
public class Menu {
    
    public Menu(){
        int[][] problema={  {1,2,3},
                            {4,5,6},
                            {7,0,8}};
        if(Evaluacion(problema)){
            Nodo nodoProblema=new Nodo();
            nodoProblema.estado=problema;
            Puzzle puzzle=new Puzzle(nodoProblema);            
        }
        else{
            System.out.println("Sistema no Tiene Solucion");
        }

   
    }
    protected boolean Evaluacion(int [][] problema){
        int[] vectorAux = new int[9];
        int bandera = 0;
        int contador=0;
        
        for (int i = 0; i < problema.length; i++) {
            for (int j = 0; j < problema[i].length; j++) {
                if (problema[i][j]==0) {
                    bandera=i;
                }
    
                vectorAux[contador]=problema[i][j];
                contador++;        
            }
        }
        
        contador=0;
        
        for (int i = 0; i < vectorAux.length; i++) {
            for (int j = i+1; j < vectorAux.length; j++) {
                if(vectorAux[i]>vectorAux[j]&&vectorAux[i]!=0&&vectorAux[j]!=0)
                    contador++;
            }
        }
        if((contador%2==0)&& (bandera%2==0) )
            return true;
        return false;

            
    }
    
}
