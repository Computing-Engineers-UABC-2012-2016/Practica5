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
    int disManh;
    int desacomodados;
    
    
    public Nodo(){
        NodoPadre=null;
        costo=0;
        contador++;
        disManh=0;
        desacomodados=0;
        
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
    
    public void distManh(int[][] solucion){
        for (int i = 0; i < this.estado.length; i++) {
            for (int j = 0; j < this.estado[i].length; j++) {
                if(this.estado[i][j]==solucion[i][j])
                    continue;
                else{
                    for (int k = 0; k < solucion.length; k++) {
                        for (int l = 0; l < solucion[k].length; l++) {
                            if(this.estado[i][j]==solucion[k][l])
                                this.disManh+=Math.abs(i-k) + Math.abs(j-l);
                        }
                    }
                }
            }
            
        }
        
    }

    public void CuantosDesacomodados(int[][] solucion){
        
        for (int i = 0; i < this.estado.length; i++) {
            for (int j = 0; j < this.estado[i].length; j++) {
                if(this.estado[i][j]!=solucion[i][j])
                    this.desacomodados++;    
            }
        }
        System.out.println("->"+this.desacomodados);
    }
    
}
