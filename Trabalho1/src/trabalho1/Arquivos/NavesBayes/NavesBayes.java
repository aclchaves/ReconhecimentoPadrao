/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.Arquivos.NavesBayes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class NavesBayes {
    
    Double[] valorAtributo;
    Double[][] matrizContingencia;
    int classeQtd;
    int atributosQtd;
    int atributosTotal;
    List<Double> atributoValor = new ArrayList<Double>();
    int cont = 0;
    
    /**
     * Metodo que calcula a media por atributo, e retorna um vetor onde cada
     * indice é referente a um atributo lido. O tamnho do vetor é de acordo
     * com o numero de atributos lidos no arquivo.
     * @param matriz
     * @param linha
     * @param coluna
     * @return double[] 
     */
    public double[] mediaAtributo(Double[][] matriz, int linha, int coluna){
        double[] media = new double[coluna];
        int total = linha;
        double soma = 0;
        for (int i = 0; i < coluna; i++) {           
            for (int j = 0; j < linha; j++) {                
                    soma = soma + matriz[j][i];                    
            }
            media[i] = soma/total;
            soma = 0;
        }
        return media;
    }
    
    /**
     * Metodo que calcula o desvido padrão por atributo, e retorna um vetor onde
     * cada indice é referente a um atributo lido. O tamanho do vetor é de acordo
     * com o numero de atributos lidos no arquivo.
     * @param matriz
     * @param linha
     * @param coluna
     * @param media
     * @return double[]
     */
    public double[] desvioPadraoAtributo(Double[][] matriz, int linha, int coluna, double[] media){
        double soma = 0;
        int total = linha;
        double aux = 0;        
        double[] desvio = new double[coluna];
        for (int i = 0; i < coluna; i++) {           
            for (int j = 0; j < linha; j++) {
                soma = soma +(matriz[j][i] - media[i])*(matriz[j][i] - media[i]);
            }
            aux = (((double)1/(total-1))* soma);
            desvio[i] = Math.sqrt(aux);
            soma = 0;
        }
        return desvio;
    }
    /**
     * Imprime o vetor que contem os desvios padrões de cada atributo.
     * @param desvio
     * @param tamanho 
     */
    public void imprimeDesvioAtributo(double[] desvio, int tamanho){
        for (int i = 0; i < tamanho; i++) {           
            System.out.println("Desvio[" + i +"]= " + desvio[i]);
            
        }
    }
    
    /**
     * Imprime o vetor que contem os desvios padrões de cada atributo.
     * @param media
     * @param tamanho 
     */
    public void imprimeMediaAtributo(double[] media, int tamanho){
         for (int i = 0; i < tamanho; i++) {           
            System.out.println("Media[" + i +"]= " + media[i]);
            
        }
    }    

    
    public Double[] getValorAtributo() {
        return valorAtributo;
    }

    public void setValorAtributo(Double[] valorAtributo) {
        this.valorAtributo = valorAtributo;
    }

    public Double[][] getMatrizContingencia() {
        return matrizContingencia;
    }

    public void setMatrizContingencia(Double[][] matrizContingencia) {
        this.matrizContingencia = matrizContingencia;
    }

    public int getClasseQtd() {
        return classeQtd;
    }

    public void setClasseQtd(int classeQtd) {
        this.classeQtd = classeQtd;
    }

    public int getAtributosQtd() {
        return atributosQtd;
    }

    public void setAtributosQtd(int atributosQtd) {
        this.atributosQtd = atributosQtd;
    }

    public int getAtributosTotal() {
        return atributosTotal;
    }

    public void setAtributosTotal(int atributosTotal) {
        this.atributosTotal = atributosTotal;
    }
    
    

    
    
    
}
