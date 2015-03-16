/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author BELTRAN
 */
public class Puzzle {
    int[][] solucion={{1,2,3},
                      {4,5,6},
                      {7,8,0}};
    Scanner pause = new Scanner(System.in);
    String[][] Acciones = {{"Abajo","Derecha"},{"Abajo", "Izquierda","Derecha"},{"Abajo", "Izquierda"},
                           {"Abajo","Derecha", "Arriba"},{"Abajo", "Izquierda","Derecha", "Arriba"},{"Abajo", "Izquierda", "Arriba"},
                           {"Derecha", "Arriba"},{ "Izquierda","Derecha", "Arriba"},{"Izquierda", "Arriba"}};
    
    boolean limiteAlcanzado = false;
    boolean solucionEncontrada = false;
    
    
    public Puzzle(Nodo problema){
        problema.distManh(solucion);
        //busqueda_profundidad_limitada(problema);
        
    }
    
    public void busqueda_profundidad_limitada(Nodo problema){
        for (int limite = 1;; limite++) {
            if(BPL_recursivo(problema, limite)){
                System.out.println("Nodo no encontrado, (Se llego al LIMITE en el nivel "+limite+")");            
            }
            else
            {
                System.out.println("SOLUCION ENCONTRADA");
                break;
            }
        }

        


    }
    
    public boolean BPL_recursivo(Nodo problema,int limite){
        //Tenemos una bandera que verifica si se encontro la solucion
        if (!solucionEncontrada) {
            //Si el nodo es la meta entonces la iteratividad termina y se 
            //Imprime la solucion
            if (Arrays.deepEquals(problema.estado, solucion)) {
                imprimirSolucion(problema);
                solucionEncontrada = true;
                return false;
            } 
            /*Si se llega al limite entonces returnamos el valor de limite alcanzado*/
            else if (limite == 0) {
                return limiteAlcanzado;
            }
            /*Se obtiene el indice del numero 0 de la matriz*/
            problema.getIndicedelNodo();
            for (String accionPosible : Acciones[problema.indice]) {
                Nodo hijo = crearNodo(problema,(String)accionPosible);
                boolean Resultado = BPL_recursivo(hijo, limite - 1);
                if (Resultado == limiteAlcanzado) {
                    limiteAlcanzado = true;
                } 
                else {
                    return Resultado;
                }
            }
            return limiteAlcanzado;
        }
        return false;        

       
    }

   
    public Nodo crearNodo(Nodo nodoPadre,String accion){
        Nodo hijo=new Nodo();
        hijo.estado=resolverProblema(copiarArreglo(nodoPadre),accion);
        hijo.NodoPadre=nodoPadre;
        hijo.costo=nodoPadre.costo++;
        return hijo;
        
    }
    
    
    public int[][] resolverProblema(int [][] estado,String accion){
        int[][] estadoAux=estado.clone();
        boolean flag=false;
        int flagNumero=100;
        int aux,posC=0,posF=0;
        
        if(accion=="Abajo"){
            for (int i = 0; i < estadoAux.length; i++) {
                for (int j = 0; j < estadoAux[i].length; j++) {
                    if (estadoAux[i][j]==0) {
                        flag=true;
                        flagNumero=3;
                        posF=i;
                        posC=j;
                    }
                    if(flag){
                        if(flagNumero==0){
                            estadoAux[posF][posC]=estadoAux[i][j];
                            estadoAux[i][j]=0;
                            return estadoAux;
                        }
                        flagNumero--;
                    } 
                }    
            }            
        }
        if(accion=="Arriba"){
            for (int i = estadoAux.length-1; i >= 0; i--) {
                for (int j =estadoAux[i].length-1 ; j >=0 ; j--) {
                    
                    if (estadoAux[i][j]==0) {
                        flag=true;
                        flagNumero=3;
                        posF=i;
                        posC=j;
                    }
                    if(flag){
                        if(flagNumero==0){
                            estadoAux[posF][posC]=estadoAux[i][j];
                            estadoAux[i][j]=0;
                            return estadoAux;
                        }
                        flagNumero--;
                    }
                    
                }
                
            }
        }
        if(accion=="Derecha"){
            for (int i = 0; i < estadoAux.length; i++) {
                for (int j = 0; j < estadoAux[i].length; j++) {
                    if (estadoAux[i][j]==0) {
                        flag=true;
                        flagNumero=1;
                        posF=i;
                        posC=j;
                    }
                    if(flag){
                        if(flagNumero==0){
                            estadoAux[posF][posC]=estadoAux[i][j];
                            estadoAux[i][j]=0;
                            return estadoAux;
                        }
                        flagNumero--;
                    } 
                }    
            }                 
        }
        
        if(accion=="Izquierda"){
            for (int i = estadoAux.length-1; i >= 0; i--) {
                for (int j =estadoAux[i].length-1 ; j >=0 ; j--) {
                    
                    if (estadoAux[i][j]==0) {
                        flag=true;
                        flagNumero=1;
                        posF=i;
                        posC=j;
                    }
                    if(flag){
                        if(flagNumero==0){
                            estadoAux[posF][posC]=estadoAux[i][j];
                            estadoAux[i][j]=0;
                            return estadoAux;
                        }
                        flagNumero--;
                    }
                    
                }
                
            }
        }        
        return estadoAux;

        
    }
    

    public void imprimirSolucion(Nodo aux){
        int contador=1;
        //System.out.println("Costo del Algoritmo: "+aux.costo);
        while(aux.NodoPadre!=null){
        for (int i = 0; i < aux.estado.length; i++) {
            for (int j = 0; j < aux.estado[i].length; j++) {
                System.out.printf(aux.estado[i][j]+" "); 
            }
            System.out.println();  
        }
        System.out.println();
        aux=aux.NodoPadre;
        contador++;
        }
        System.out.println("Numero de Niveles: "+contador);
        System.out.println("El numero de nodos creados: "+aux.contador);
        
    }
    public void imprimir(Nodo aux){
            for (int i = 0; i < aux.estado.length; i++) {
            for (int j = 0; j < aux.estado[i].length; j++) {
                System.out.printf(aux.estado[i][j]+" "); 
            }
            System.out.println();  
        }
        System.out.println();    
    }
    
    public int[][] copiarArreglo(Nodo nodo){
        int[][] aux=new int[3][3];
        for(int i=0; i<nodo.estado.length; i++)
        for(int j=0; j<nodo.estado[i].length; j++)
            aux[i][j]=nodo.estado[i][j];
        return aux;
    }
    
    
    
}
