/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.ecd_listatad;

/**
 *
 * @author aline
 */
public class Ex3_Pilha<String> {
    private String[]pilha;  
    private int posicaoTopo; //identifica quem ta no topo
    
    public Ex3_Pilha(int tamanho){ //construtor
        pilha = (String[]) new Object[tamanho]; //tipos abstratos de dados, para objetos abstratos
        posicaoTopo = -1;//comeca com -1 pois vai adicionar 1 no push e comecar a partir do 0
    }
    
    //adiciona elemento da pilha
    public void push(String elemento){
        pilha[++posicaoTopo] = elemento; //soma a posicaoTopo e depois utiliza. Se fosse posicaoTopo++ seria ao contrario
    }
    
    //remove elemento da pilha
    public String pop(){
        return pilha[posicaoTopo--];//utiliza a posicaoTopo e depois remove o elemento
    }
    
    //retorna o elemento que esta no topo da pilha
    public String top(){
        return pilha[posicaoTopo];
    }
    
    //returna true se esta vazio
    public boolean isEmpty(){
        return posicaoTopo == -1;
    }
    
    //retorna true se estiver cheio
    public boolean isFull(){
        return posicaoTopo == pilha.length-1;
    }
}
