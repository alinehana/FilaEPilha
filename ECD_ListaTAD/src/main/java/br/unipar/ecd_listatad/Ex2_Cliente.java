/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.ecd_listatad;

/**
 *
 * @author aline
 */
public class Ex2_Cliente {
    private int senha;
    private String nome;
    private int anoNascimento;
    
    public Ex2_Cliente (int senha, String nome, int anoNascimento){
        this.senha = senha;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }
    
    public int getIdade(int anoAtual){
        return anoAtual - this.anoNascimento;
    }

    @Override
    public String toString() {
        return "Ex2_Cliente{" + "senha=" + senha + ", nome=" + nome + ", anoNascimento=" + anoNascimento + '}';
    }
}
