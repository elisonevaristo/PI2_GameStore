/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.models;

/**
 *
 * @author roger
 */
public class Produto implements IProduto {
    private int id;
    private String nome;
    private String descricao;
    //private java.awt.Image foto;
    private float preco;
    private float valor;
    private int quantidade;
    private String codigoEan;    
    
    private Boolean ativo;
    
    public Produto(String nome, String descricao, float preco, float valor, int quantidade, String codigoEan){
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
        setValor(valor);
        setQuantidade(quantidade);
        setCodigoEan(codigoEan);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the codigoEan
     */
    public String getCodigoEan() {
        return codigoEan;
    }

    /**
     * @param codigoEan the codigoEan to set
     */
    public void setCodigoEan(String codigoEan) {
        this.codigoEan = codigoEan;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
