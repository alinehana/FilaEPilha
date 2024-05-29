/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.ecd_listatad;

/**
 *
 * @author aline
 */
public class Ex1_Fila {
    private String[]vetorDados; //um array de inteiros que armazena os elementos da fila.
    private int frente;
    private int fim;
    private int qtdItens;
    
    public Ex1_Fila (int tamanho){
        vetorDados = new String[tamanho];
        frente = 0;
        fim = -1;
        qtdItens = 0;
    }
    
    public void enqueue(String nome){
        if(fim == vetorDados.length -1){
            fim = -1;
        }
        
        vetorDados[++fim] = nome;
        qtdItens++;
    }
    
    public String dequeue(){
        String aux = vetorDados[frente++];
        if(frente == vetorDados.length){
            frente = 0;
        }
        qtdItens--;
        return aux;
    }
    
    //Retorna verdadeiro se a fila estiver vazia
    public boolean isEmpty(){
        return qtdItens == 0;
    }
    
    public boolean isFull(){
        return qtdItens == vetorDados.length;
    }
}