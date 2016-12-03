/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import com.gamestore.database.ConnectionUtils;
import com.gamestore.database.DaoPedido;
import com.gamestore.exceptions.PedidoException;
import com.gamestore.exceptions.ProdutoException;
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
        
    DaoPedido dao = null;
    ConnectionUtils conn = null;
    Pedido pedidoPendente;
    List<Pedido> itens;
    
    public ServicoPedido(ConnectionUtils conn){
        this.conn = conn;
    }
        
    public List<ItemRelatorio> ObterRelatorio(String dataInicial, String dataFinal, String plataforma, String categoria, String produto) throws PedidoException, Exception {
        
        List<ItemRelatorio> itensRelatorio = new ArrayList<>();
        
        if (dataInicial.trim().isEmpty() || dataFinal.trim().isEmpty())
            throw new PedidoException("A data é obrigatória para gerar o relatório.");
                
        Calendar inicio = getDateFromString(dataInicial);
        Calendar fim = getDateFromString(dataFinal);
        fim.add(Calendar.DATE, 1);
        
        if (dao == null)
            dao = new DaoPedido(conn);
                        
        return dao.obterLista(inicio, fim, plataforma, categoria, produto);  
    }    
    
    /*
        Valida se as informações obrigatórias foram preenchidas corretamente
    */
    public void novoPedido(Cliente cliente) throws Exception {                
        
        if (cliente == null)
            throw new Exception("É obrigatório informar o cliente ao iniciar um novo pedido.");
                                
        pedidoPendente = new Pedido(cliente);
    }
    
    /**
     * 
     * @param produto O produto a ser incluído.
     * @return True quando o produto já tiver sido incluído anteriormente. Falso quando for a primeira vez.
     * @throws Exception 
     */
    public Boolean adicionarItem(Produto produto) throws Exception {
        
        if (pedidoPendente == null)
            throw new ProdutoException("É obrigatório informar o cliente ao iniciar um novo pedido.");
        
        if (produto == null)
            throw new ProdutoException("Informe um produto válido.");
        
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
        
        if (dao == null)
            dao = new DaoPedido(conn);
        
        dao.insert(pedidoPendente);
    }
    
    public void cancelarPedido(){
        pedidoPendente = null;
    }    
}
