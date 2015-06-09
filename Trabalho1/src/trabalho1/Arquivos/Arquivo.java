/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Arquivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre
 */
public class Arquivo {

    FileInputStream stream;
    InputStreamReader reader;
    BufferedReader br;
    Double[][] matriz;
    int[] classe;
    int linha;
    List<Integer> listaClasses = new ArrayList<Integer>();
    List<Integer> listaAmostrasC = new ArrayList<Integer>(); 
    int coluna;

    /**
     * Contrutor de arquivo
     * Metodo resposavel por ler o arquivo e gerar a matriz contendo os dados,
     * e o vetor contendo as classes.
     */
    public Arquivo() {

        Scanner scanner;
        int cont = 0;
        int cont2 = 0;
        linha = 0;
        coluna = 0;
        matriz = null;
        classe = null;
        int j = 0;
        
        //System.out.printf("Informe o nome de arquivo texto:\n");
        //String nome = ler.nextLine();
        //System.out.printf("\nConteúdo do arquivo texto:\n");
        // try {
        FileReader arq;
        try {
            //arq = new FileReader("C:\\Users\\Andre\\Documents\\GitHub\\ReconhecimentoPadrao\\Trabalho1\\src\\trabalho1\\Arquivos\\teste.txt");
            //arq = new FileReader("C:\\Users\\Andre\\Documents\\GitHub\\ReconhecimentoPadrao\\Trabalho1\\src\\trabalho1\\Arquivos\\Input.txt");
            arq = new FileReader("C:\\Users\\Andre\\Documents\\GitHub\\ReconhecimentoPadrao\\Trabalho1\\src\\trabalho1\\Arquivos\\Input2.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String l = lerArq.readLine();            
            while (l != null && cont2 <= linha) {
                String[] l2 = l.split(" ");
                if(cont == 0){
                    linha = Integer.parseInt(l2[0]);
                    coluna = Integer.parseInt(l2[1]);
                    System.out.printf(" %s\n", linha);
                    System.out.printf(" %s\n", coluna);
                    matriz = new Double[linha][coluna];
                    classe = new int[linha];
                    cont++;
                }else{
                    for (int i = 0; i < l2.length-1; i++) {
                        matriz[j][i] =  Double.parseDouble(l2[i]);
                    }
                    int size = l2.length;
                    classe[j] = Integer.parseInt(l2[size-1]);
                    j++;
                }
                
                l = lerArq.readLine();
                cont2++;
            }
            arq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        /*try {
        scanner = new Scanner(new FileReader("C:\\Users\\Andre\\Documents\\GitHub\\ReconhecimentoPadrao\\Trabalho1\\src\\trabalho1\\Arquivos\\teste.txt"));
        
        while (scanner.hasNext()) {
        if (cont < 2) {
        linha = Integer.parseInt(scanner.useDelimiter(" ").next().trim());
        cont++;
        coluna = Integer.parseInt(scanner.useDelimiter("\\n").next().trim());
        cont++;
        matriz = new Double[linha][coluna];
        classe = new int[linha];
        } else {
        
        for (int i = 0; i < coluna; i++) {
        if( coluna-1 == i){
        scanner.useDelimiter("\\n\\r");
        }else{
        scanner.useDelimiter(" ");
        }
        matriz[j][i] = Double.parseDouble(scanner.next());
        }
        classe[j] = Integer.parseInt(scanner.useDelimiter("\\n").next().trim());
        j++;
        }
        
        }                    
        } catch (FileNotFoundException ex) {
        System.out.println("Erro, arquivo não encontrado");
        Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
    /**
     * Metodo responsavel por retornar a matriz com os dados.
     * @return float [][]matriz
     */
    public Double[][] getMatriz(){
        return this.matriz;
    }
    
    /**
     * Metodo responsavel por retornar um vetor contendo as classe
     * de cada linha da matriz.
     * @return int[] vetor 
     */
    public int[] getClasses(){
        return this.classe;
    }
    /**
     * Metodo resposavel por receber uma matriz e imprimi-la
     * @param matriz 
     */
    public void imprimeMatriz(float[][] matriz){
        for (int i = 0; i < linha; i++) {
                for (int j = 0; j < coluna; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }           
            System.out.println();
    }
    
    /**
     * Metodo responsavel por receber um vetor contendo as classes e imprimi-lo
     * @param classe 
     */
    public void imprimeClasses(int[] classe){
        int k = 0;
            for (int j = 0; j < linha; j++) {
                System.out.print(classe[j] + ",");
                k++;
                if (k == 4) {
                    //System.out.println();
                    k = 0;
                }
            } 
    }
    //verificar se precisa estar ondernado as classes
    public void contaClasse(){
        int cont = 0;
        //int[] arraySort = new int[linha];
         //arraySort = Arrays.sort(classe);
        //List<String> listaClasses = new ArrayList<String>();
        //List<Integer> listaAmostrasC = new ArrayList<Integer>();
        //listaClasses.add(classe[0]);
        //listaAmostrasC.add(1);
        for(int i = 0; i < classe.length; i++ ){
            if(listaClasses.contains(classe[i])){
                cont++;
            }else if(listaClasses.size() == 0){
            cont++;
            listaClasses.add(classe[i]);
        }else{
                //listaAmostrasC.add(cont);
               /*if(listaClasses.contains(classe[i])){               
                    listaAmostrasC.add(cont);   
                    cont = 0;
                }else{*/
                   listaClasses.add(classe[i]);
                    listaAmostrasC.add(cont);                   
                    cont = 1;
                //}
                    
            }
        
        }
        listaAmostrasC.add(cont);                  
        cont = 0;
   }
    
    public void  imprimeProb(){
        for(int i = 0; i < listaClasses.size(); i++){
         System.out.print(" Classes = " + listaClasses.get(i));
         System.out.print(", Total = " + listaAmostrasC.get(i));
         System.out.println(", Probabilidade: "  +listaAmostrasC.get(i).doubleValue()/linha);
      }
    }

    public List<Integer> getListaClasses() {
        return listaClasses;
    }

    public void setListaClasses(List<Integer> listaClasses) {
        this.listaClasses = listaClasses;
    }

    public List<Integer> getListaAmostrasC() {
        return listaAmostrasC;
    }

    public void setListaAmostrasC(List<Integer> listaAmostrasC) {
        this.listaAmostrasC = listaAmostrasC;
    }
    
   

}
