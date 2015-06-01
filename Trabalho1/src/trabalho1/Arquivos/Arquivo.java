/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Arquivos;

import java.io.*;
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
    float[][] matriz;
    int[] classe;
    int linha;

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
    int coluna;

    /**
     * Contrutor de arquivo
     * Metodo resposavel por ler o arquivo e gerar a matriz contendo os dados,
     * e o vetor contendo as classes.
     */
    public Arquivo() {

        Scanner scanner;
        int cont = 0;
        linha = 0;
        coluna = 0;
        matriz = null;
        classe = null;
        int j = 0;
        try {
            scanner = new Scanner(new FileReader("C:\\Users\\Andre\\Documents\\NetBeansProjects\\Trabalho1\\src\\trabalho1\\Arquivos\\Input.txt"));

            while (scanner.hasNext()) {
                if (cont < 2) {
                    linha = Integer.parseInt(scanner.useDelimiter(" ").next().trim());
                    cont++;
                    coluna = Integer.parseInt(scanner.useDelimiter("\\r\\n").next().trim());
                    cont++;
                    matriz = new float[linha][coluna];
                    classe = new int[linha];
                } else {
                    scanner.useDelimiter(" ");
                    for (int i = 0; i < coluna; i++) {
                        matriz[j][i] = Float.parseFloat(scanner.next());
                    }
                    classe[j] = Integer.parseInt(scanner.useDelimiter("\\r\\n").next().trim());
                    j++;
                }

            }                    
        } catch (FileNotFoundException ex) {
            System.out.println("Erro, arquivo não encontrado");
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Metodo responsavel por retornar a matriz com os dados.
     * @return float [][]matriz
     */
    public float[][] getMatriz(){
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
                    System.out.println();
                    k = 0;
                }
            } 
    }

}
