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
                
        Calendar dataFim = getDateFromString(dataFinal);
        dataFim.add(Calendar.DATE, 1);
        
        
        for (Pedido p : itens) {
            for (ItemPedido i : p.getItens()) {
                                
                if (!p.getData().after(getDateFromString(dataInicial)) || !p.getData().before(dataFim))
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
                
                itensRelatorio.add(new ItemRelatorio(String.valueOf(p.getId()), p.getCliente().getNome(), i.getProduto().getNome(), i.getQuantidade(), getStringFromDate(p.getData()), i.getProduto().getPreco()));
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
        cadastrarItem(pedidoPendente);
    }
    
    /**
     * 
     * @param produto O produto a ser incluído.
     * @return True quando o produto já tiver sido incluído anteriormente. Falso quando for a primeira vez.
     * @throws Exception 
     */
    public Boolean adicionarItem(Produto produto) throws Exception {
        
        if (pedidoPendente == null)
            throw new Exception("É obrigatório informar o cliente ao iniciar um novo pedido.");
        
        if (produto == null)
            throw new Exception("Informe um produto válido.");
        
        for (ItemPedido i : pedidoPendente.getItens()) {
            if (i.getProduto().getId() == produto.getId())
            {                
                i.setQuantidade(i.getQuantidade() + 1);
                return true;
            }
        }
        
        pedidoPendente.adicionarItem(new ItemPedido(pedidoPendente, produto, 1));
        
        return false;
    }
        
    public float obterTotalPedido(){
        if (pedidoPendente == null)
            return 0;
        
        return pedidoPendente.obterValorTotal();
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
        
        pedidoPendente = null;
    }
    
    public void cancelarPedido(){
        pedidoPendente = null;
    }    
}
