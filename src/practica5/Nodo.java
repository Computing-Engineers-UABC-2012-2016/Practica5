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
public class Nodo {
    Nodo NodoPadre;
    int indice;
    int costo;
    int[][] estado=new int[3][3];
    static int contador=0;
    
    
    public Nodo(){
        NodoPadre=null;
        costo=0;
        contador++;
        
    }
    public void getIndicedelNodo(){
        int indice=0;
        for (int i = 0; i < this.estado.length; i++) {
            for (int j = 0; j < this.estado[i].length; j++) {
                if(this.estado[i][j]==0){
                    this.indice=indice;
                    return;
                }
                    
                indice++;
            }
            
        }
        this.indice=indice;       
    }

    
}
