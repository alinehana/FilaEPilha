/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.ecd_listatad;

/**
 *
 * @author aline
 */
public class Ex2_Fila {
    private Ex2_Cliente[] vetorDados; //um array de Clientes que armazena os elementos da fila.
    private int frente;
    private int fim;
    private int qtdItens;
    
    public Ex2_Fila (int tamanho){
        vetorDados = new Ex2_Cliente[tamanho];
        frente = 0;
        fim = -1;
        qtdItens = 0;
    }
    
    public void enqueue(Ex2_Cliente cliente){
        if(fim == vetorDados.length -1){
            fim = -1;
        }
        
        vetorDados[++fim] = cliente;
        qtdItens++;
    }
    
    public Ex2_Cliente dequeue(){
        Ex2_Cliente aux = vetorDados[frente++];
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
