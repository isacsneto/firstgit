/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Eduardo
 */
public class Produto {
    
    private int codigo;
    private String nome;
    private double preco;
    private int qtd;
    private String descricao;
    private String data_fabri;
    private String cnpj_fornec;
    private int nova_qtd;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_fabri() {
        return data_fabri;
    }

    public void setData_fabri(String data_fabri) {
        this.data_fabri = data_fabri;
    }

    public String getCnpj_fornec() {
        return cnpj_fornec;
    }

    public void setCnpj_fornec(String cod_fornec) {
        this.cnpj_fornec = cod_fornec;
    }

    public int getNova_qtd() {
        return nova_qtd;
    }

    public void setNova_qtd(int nova_qtd) {
        this.nova_qtd = nova_qtd;
    }

   
    
    
}
