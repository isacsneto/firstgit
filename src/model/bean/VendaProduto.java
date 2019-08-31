/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author isac_
 */
public class VendaProduto {
    
    private int codvenda;
    private int codproduto;
    private int qtdproduto;
    private String nomeproduto;
    private double precoproduto;

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public double getPrecoproduto() {
        return precoproduto;
    }

    public void setPrecoproduto(double precoproduto) {
        this.precoproduto = precoproduto;
    }

    public int getCodvenda() {
        return codvenda;
    }

    public void setCodvenda(int codvenda) {
        this.codvenda = codvenda;
    }

    public int getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }

    public int getQtdproduto() {
        return qtdproduto;
    }

    public void setQtdproduto(int qtdproduto) {
        this.qtdproduto = qtdproduto;
    }

}
