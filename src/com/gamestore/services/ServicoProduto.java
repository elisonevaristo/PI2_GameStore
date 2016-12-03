/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import com.gamestore.database.ConnectionUtils;
import com.gamestore.database.DaoProduto;
import com.gamestore.exceptions.DataAccessException;
import com.gamestore.models.Categoria;
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
    
    @Override
    public void selecionar(int id) throws DataAccessException {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        produto = dao.obterPorId(id);
    }
        
    @Override
    public Produto obterSelecionado(){
        return produto;
    }
    
    @Override
    public Boolean validarExisteSelecionado(){        
        return produto != null && produto.getId() != 0;
    }
    
    @Override
    public void cancelarSelecao(){        
        produto = null;
    }
    
    @Override
    public void excluir(int id) throws DataAccessException  {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        dao.inativar(id);
    } 
    
    public List<Produto> ObterProdutos(String nome) throws DataAccessException {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        return dao.obterLista(nome, null, null, null, null);
    }
    
    public List<Produto> ObterProdutos(String nome, String plataforma, String fabricante, String categoria, String ean) throws DataAccessException {
        if (dao == null)
            dao = new DaoProduto(conn);
        
        return dao.obterLista(nome, plataforma, fabricante, categoria, ean);
    }
    
    /*
        Valida se as informações obrigatórias foram preenchidas corretamente
    */
    public Produto validarProduto(String nome, String fabricante, String custo, String preco, String quantidade, String categoria, String genero, String plataforma, String classificacao, String garantia, 
                                  String codigoEan, String descricao) throws Exception {                
        
        if (nome.isEmpty())
            throw new Exception("É obrigatório informar a nome do produto.");
        
        if (descricao.isEmpty())
            throw new Exception("É obrigatório informar a descrição do produto.");
        
        if (custo.isEmpty() || !validarFloat(custo))
            throw new Exception("É obrigatório informar o custo de compra do produto.");
        
        if (preco.isEmpty() || !validarFloat(preco))
            throw new Exception("É obrigatório informar um preço para o produto.");
                
        if (quantidade.isEmpty() || !validarInteger(quantidade))
            throw new Exception("É obrigatório informar a quantidade em estoque do produto.");     
        
        if (categoria.isEmpty())
            throw new Exception("É obrigatório informar a categoria do produto.");
        
        if (genero.isEmpty())
            throw new Exception("É obrigatório informar o genêro do produto.");
        
        if (plataforma.isEmpty())
            throw new Exception("É obrigatório informar a plataforma do produto.");
        
        if (classificacao.isEmpty())
            throw new Exception("É obrigatório informar a classificação indicativa do produto.");
        
        if (garantia.isEmpty())
            throw new Exception("É obrigatório informar a garantia do produto.");
        
        if (codigoEan.isEmpty())
            throw new Exception("É obrigatório informar o código EAN do produto.");
        
        if (fabricante.isEmpty())
            throw new Exception("É obrigatório informar o fabricante do produto.");
        
        Produto novoProduto = new Produto(nome, fabricante, 
                Float.parseFloat(custo.replace(",", ".")), 
                Float.parseFloat(preco.replace(",", ".")), 
                Integer.parseInt(quantidade), 
                Categoria.getByDescricao(categoria), 
                genero, 
                plataforma, 
                classificacao, 
                garantia, 
                codigoEan, 
                descricao);
                        
        return novoProduto;        
    }    
}
