/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import com.gamestore.database.ConnectionUtils;
import com.gamestore.database.DaoProduto;
import com.gamestore.exceptions.DataAccessException;
import com.gamestore.exceptions.ProdutoException;
import com.gamestore.models.Categoria;
import com.gamestore.models.Genero;
import com.gamestore.models.Produto;
import java.util.List;

/**
 *
 * @author roger
 */
public class ServicoProduto extends ServicoBase<Produto> {
            
    DaoProduto dao = null;
    ConnectionUtils conn = null;
    Produto produto = null;
    
    public ServicoProduto(ConnectionUtils conn){
        this.conn = conn;
    }
    
    public void cadastrar(Produto produto) throws DataAccessException {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        dao.insert(produto);
    }
    
    public void atualizar(Produto produto) throws DataAccessException {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        dao.update(produto);
    }
    
    public void selecionar(int id) throws DataAccessException {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        produto = dao.obterPorId(id);
    }
        
    public Produto obterSelecionado(){
        return produto;
    }
    
    public Boolean validarExisteSelecionado(){        
        return produto != null && produto.getId() != 0;
    }
    
    public void cancelarSelecao(){        
        produto = null;
    }
    
    public void excluir(int id) throws DataAccessException  {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        dao.inativar(id);
    } 
    
    public Produto obterPorId(int id) throws DataAccessException {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        return dao.obterPorId(id);
    }
    
    public List<Produto> ObterProdutos(String nome) throws DataAccessException {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        return dao.obterLista(nome, null, null, 0, null);
    }
    
    public List<Produto> ObterProdutos(String nome, String plataforma, String fabricante, int categoria, String ean) throws DataAccessException {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        return dao.obterLista(nome, plataforma, fabricante, categoria, ean);
    }
}
