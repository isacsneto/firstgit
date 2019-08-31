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
public class Venda {
    private int idvenda;
    private String clientev;
    private int qtditens;
    private String datavenda;
    private double valort;
    private int qtd_compras;

    public int getQtd_compras() {
        return qtd_compras;
    }

    public void setQtd_compras(int qtd_compras) {
        this.qtd_compras = qtd_compras;
    }

  
    public double getValort() {
        return valort;
    }

    public void setValort(double valort) {
        this.valort = valort;
    }
    
    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public String getClientev() {
        return clientev;
    }

    public void setClientev(String clientev) {
        this.clientev = clientev;
    }

    public int getQtditens() {
        return qtditens;
    }

    public void setQtditens(int qtditens) {
        this.qtditens = qtditens;
    }

    public String getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(String datavenda) {
        this.datavenda = datavenda;
    }
}
