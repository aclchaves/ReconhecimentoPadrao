/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Main;

import trabalho1.Arquivos.Arquivo;

/**
 *
 * @author Andre
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static void main(String[] args) {
      Arquivo arq = new Arquivo();
      Double[][] matriz;
      int[] classe;
      int linha = 0;
      int coluna = 0;
  
      matriz = arq.getMatriz();
      classe = arq.getClasses();
      linha = arq.getLinha();
      coluna = arq.getColuna();
      arq.contaClasse();
     // arq.imprimeClasses(classe); 
      arq.imprimeProb();
      
      //System.out.println();
      //arq.imprimeMatriz(matriz);                 
        
    }
    
}
