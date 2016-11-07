/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author roger
 */
public class Pedido implements ItemComId {

    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Calendar data;
    private Boolean ativo;

    public Pedido(Cliente cliente){
        setCliente(cliente);
        setData(Calendar.getInstance());
        itens = new ArrayList<>();
    }
    
    public Pedido(Cliente cliente, List<ItemPedido> itens) {        
        this(cliente);
        setItens(itens);        
    }
    
    public void adicionarItem(ItemPedido item){
        if (itens == null || itens.isEmpty())
            itens = new ArrayList<>();
        
        itens.add(item);        
    }
    
    public void excluirItem(int produtoId){
        
        ItemPedido item = null;
        
        for (ItemPedido i : itens) {
            if (i.getProduto().getId() == produtoId)
                item = i;
        }
                
        if (item == null)
            return;
        
        itens.remove(item);
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the itens
     */
    public List<ItemPedido> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
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
    
    public float obterValorTotal(){
        float total = 0;
        
        for (ItemPedido i : itens) {
            total += i.getQuantidade() * i.getProduto().getPreco();
        }
        
        return total;
    }
}
