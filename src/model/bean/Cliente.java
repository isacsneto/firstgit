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
public class Cliente {
    
    private String nome;
    private String cpf;
    private String email;
    private String celular;
    private String cep;
    private String rua;
    private String numero;

    //public Cliente(String nome, String cpf, String email, String celular, String cep, String rua, String numero) {
    //    this.nome = nome;
    //    this.cpf = cpf;
    //    this.celular = celular;
    //    this.email = email;
    //    this.rua = rua;
    //    this.cep = cep;
    //    this.numero = numero;
    //}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
