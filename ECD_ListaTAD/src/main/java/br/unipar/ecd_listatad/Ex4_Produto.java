/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.ecd_listatad;

/**
 *
 * @author aline
 */
public class Ex4_Produto {
    private String codProduto;
    private String descricao;
    private String dataEntrada;
    private String ufOrigem;
    private String ufDestino;
    
    public Ex4_Produto(String codProduto, String descricao, String dataEntrada, String ufOrigem, String ufDestino){
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.ufOrigem = ufOrigem;
        this.ufDestino = ufDestino;
    }

    @Override
    public String toString() {
        return "Ex4_Produto{" + "codProduto=" + codProduto + ", descricao=" + descricao + ", dataEntrada=" + dataEntrada + ", ufOrigem=" + ufOrigem + ", ufDestino=" + ufDestino + '}';
    }
}