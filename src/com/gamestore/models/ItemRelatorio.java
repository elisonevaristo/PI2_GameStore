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
public class ItemRelatorio {

    private String pedidoId;
    private String clienteNome;
    private String produtoNome;
    private String quantidade;
    private String data;
    private String valorUnitario;
    private String valorTotal;
    
    public ItemRelatorio(String pedidoId, String clienteNome, String produtoNome, String quantidade, String data, String valorUnitario, String valorTotal){
        setPedidoId(pedidoId);
        setClienteNome(clienteNome);
        setProdutoNome(produtoNome);
        setQuantidade(quantidade);
        setData(data);
        setValorUnitario(valorUnitario);
        setValorTotal(valorTotal);
    }

    /**
     * @return the pedidoId
     */
    public String getPedidoId() {
        return pedidoId;
    }

    /**
     * @param pedidoId the pedidoId to set
     */
    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    /**
     * @return the clienteNome
     */
    public String getClienteNome() {
        return clienteNome;
    }

    /**
     * @param clienteNome the clienteNome to set
     */
    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    /**
     * @return the produtoNome
     */
    public String getProdutoNome() {
        return produtoNome;
    }

    /**
     * @param produtoNome the produtoNome to set
     */
    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the valorUnitario
     */
    public String getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the valortotal
     */
    public String getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valortotal the valortotal to set
     */
    public void setValorTotal(String valortotal) {
        this.valorTotal = valortotal;
    }
}
