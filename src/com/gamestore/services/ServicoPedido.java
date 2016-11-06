/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import com.gamestore.models.Cliente;
import com.gamestore.models.ItemPedido;
import com.gamestore.models.ItemRelatorio;
import com.gamestore.models.Pedido;
import com.gamestore.models.Produto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author roger
 */
public class ServicoPedido  extends ServicoBase<Pedido> {
        
    Pedido pedidoPendente;
    
    public List<Pedido> ObterPedidos(){
        return itens;
    }    
    
    public List<ItemRelatorio> ObterRelatorio(String dataInicial, String dataFinal, String plataforma, String categoria, String produto) throws Exception {
        
        List<ItemRelatorio> itensRelatorio = new ArrayList<>();
        
        if (dataInicial.trim().isEmpty() || dataFinal.trim().isEmpty())
            throw new Exception("A data é obrigatória para gerar o relatório.");
                
        for (Pedido p : itens) {
            for (ItemPedido i : p.getItens()) {
                                
                if (!p.getData().after(getDateFromString(dataInicial)) || !p.getData().before(getDateFromString(dataFinal)))
                    continue;
                
                if (!plataforma.trim().isEmpty())
                    if(!i.getProduto().getPlataforma().equalsIgnoreCase(plataforma))
                        continue;
                
                if (!categoria.trim().isEmpty())
                    if (!i.getProduto().getCategoria().equalsIgnoreCase(categoria))
                        continue;
                
                if (!produto.trim().isEmpty())
                    if(!i.getProduto().getNome().toUpperCase().contains(produto.toUpperCase()))
                        continue;
                
                itensRelatorio.add(new ItemRelatorio(String.valueOf(p.getId()), p.getCliente().getNome(), i.getProduto().getNome(), String.valueOf(i.getQuantidade()), p.getData().toString(), String.valueOf(i.getProduto().getPreco()), "100"));
            }
        }
                
        return itensRelatorio;        
    }    
    
    /*
        Valida se as informações obrigatórias foram preenchidas corretamente
    */
    public void novoPedido(Cliente cliente) throws Exception {                
        
        if (cliente == null)
            throw new Exception("É obrigatório informar o cliente ao iniciar um novo pedido.");
                                
        pedidoPendente = new Pedido(cliente);
    }
    
    public void adicionarItem(Produto produto, int quantidade) throws Exception {
        
        if (pedidoPendente == null)
            throw new Exception("É obrigatório informar o cliente ao iniciar um novo pedido.");
        
        if (produto == null)
            throw new Exception("Informe um produto válido.");
        
        if (quantidade <= 0)
            throw new Exception("Quantidade deve ser um valor maior que zero.");
        
        pedidoPendente.adicionarItem(new ItemPedido(pedidoPendente, produto, quantidade));
    }
    
    public void excluirItem(int produtoId){
        pedidoPendente.excluirItem(produtoId);
    }
    
    public void salvarPedido() throws Exception {
        
        if (pedidoPendente == null)
            throw new Exception("Pedido não iniciado!");
        
        if (pedidoPendente.getCliente() == null)
            throw new Exception("Um pedido sem cliente não pode ser salvo!");
        
        if (pedidoPendente.getItens().isEmpty())
            throw new Exception("Um pedido sem itens não pode ser salvo!");
        
        itens.add(pedidoPendente);
        
        pedidoPendente = null;
    }
    
    public void cancelarPedido(){
        pedidoPendente = null;
    }    
}
