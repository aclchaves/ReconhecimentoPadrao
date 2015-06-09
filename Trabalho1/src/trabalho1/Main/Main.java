/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Main;

import trabalho1.Arquivos.Arquivo;
import trabalho1.Arquivos.NavesBayes.NavesBayes;

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
      double[] media;
      double[] desvio;
  
      matriz = arq.getMatriz();
      classe = arq.getClasses();
      linha = arq.getLinha();
      coluna = arq.getColuna();
      arq.contaClasse();

      NavesBayes nv = new NavesBayes();
      media = nv.mediaAtributo(matriz, linha, coluna);
      nv.imprimeMediaAtributo(media, media.length);
      desvio = nv.desvioPadraoAtributo(matriz, linha, coluna, media);
      nv.imprimeDesvioAtributo(desvio, desvio.length);
      // arq.imprimeClasses(classe); 
      //arq.imprimeProb();
      
      //System.out.println();
      //arq.imprimeMatriz(matriz);                 
        
    }
    
}
