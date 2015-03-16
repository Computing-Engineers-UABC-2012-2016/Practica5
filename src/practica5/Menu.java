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
        int[][] problema={{1,2,0},
                          {4,5,3},
                          {7,8,6}};
        Nodo nodoProblema=new Nodo();
        nodoProblema.estado=problema;
        Puzzle puzzle=new Puzzle(nodoProblema);
        
        
   
        
    }
    
}
