/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.models;

import com.gamestore.exceptions.ProdutoException;

/**
 *
 * @author roger
 */
public class Produto implements ItemComId {
    private int id;
    private String nome;
    private String fabricante;
    private float custo;
    private float preco;    
    private String descricao;
    private String codigoEan;        
    private Boolean ativo;
    private Categoria categoria;
    private int quantidade;//em estoque
    private Genero genero;
    private String plataforma;
    private String classificacao;
    private String garantiaFornecedor;
    //private java.awt.Image foto;    
    
    public Produto(int id, String nome, String fabricante, float custo, float preco, int quantidade, Categoria categoria, Genero genero, String plataforma, String classificacao, String garantia, String codigoEan, String descricao){        
        this(nome, fabricante, custo, preco, quantidade, categoria, genero, plataforma, classificacao, garantia, codigoEan, descricao);
        setId(id);
    }
    
    public Produto(String nome, String fabricante, float custo, float preco, int quantidade, Categoria categoria, Genero genero, String plataforma, String classificacao, String garantia, String codigoEan, String descricao){
        setNome(nome);
        setFabricante(fabricante);
        setCusto(custo);
        setPreco(preco);
        setQuantidade(quantidade);
        setCategoria(categoria);
        setGenero(genero);
        setPlataforma(plataforma);
        setClassificacao(classificacao);
        setGarantiaFornecedor(garantia);
        setCodigoEan(codigoEan);
        setDescricao(descricao);
    }

    /**
     * @return the id
     */
    @Override
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

    /**
     * @return the plataforma
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * @param plataforma the plataforma to set
     */
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the custo
     */
    public float getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(float custo) {
        this.custo = custo;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the genero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * @return the classificacao
     */
    public String getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * @return the garantiaFornecedor
     */
    public String getGarantiaFornecedor() {
        return garantiaFornecedor;
    }

    /**
     * @param garantiaFornecedor the garantiaFornecedor to set
     */
    public void setGarantiaFornecedor(String garantiaFornecedor) {
        this.garantiaFornecedor = garantiaFornecedor;
    }
    
    public void validarEstoque(int quantidade) throws ProdutoException {
        if (quantidade > this.quantidade){
            throw new ProdutoException(
                String.format("O saldo em estoque do produto %s "
                    + "é inferior à quantidade solicitada. "
                    + "\n Solicitado: %s "
                    + "\n Disponível: %s", this.nome, quantidade, this.quantidade));
        }
    }
}
