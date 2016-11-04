/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

//import com.gamestore.models.Acessorio;
//import com.gamestore.models.Console;
//import com.gamestore.models.IProduto;
//import com.gamestore.models.Jogo;
import com.gamestore.models.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roger
 */
public class ServicoProduto extends ServicoBase {
    
    List<Produto> produtos = new ArrayList<>();
    
    Produto produtoEmManutencao;
        
    public List<Produto> ObterProdutos(String nome, String plataforma, String fabricante, String categoria, String ean){
        return produtos;
    }
    
    public Produto getClienteSelecionado(){
        return produtoEmManutencao;
    }
    
    public void CadastrarProduto(Produto novoProduto) throws Exception
    {        
        int size = produtos.size();
        int id = size == 0 ? size : produtos.get(produtos.size() - 1).getId();
        
        novoProduto.setId(id + 1);
        produtos.add(novoProduto);
    }
    
    public void AtualizarCadastroProduto(Produto produto) throws Exception
    {                
        Produto antigoProduto = obterProdutoPorId(produto.getId());
        
        produtos.remove(antigoProduto);
        produtos.add(produto);
    }
    
    public void InativarCadastroProduto(int id) throws Exception
    {
        Produto produto = obterProdutoPorId(id);
        produto.setAtivo(false);
    }    
    
    private Produto obterProdutoPorId(int id)
    {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id)
                return produtos.get(i);                
        }
        
        return null;
    }
    
    /*
        Valida se as informações obrigatórias foram preenchidas corretamente
    */
    public Produto validarProduto(String nome, String descricao, String preco, String valor, String quantidade, String codigoEan) throws Exception {                
        
        if (nome.isEmpty())
            throw new Exception("É obrigatório informar a nome do produto.");
        
        if (descricao.isEmpty())
            throw new Exception("É obrigatório informar a descrição do produto.");
                       
        if (preco.isEmpty() || !validarFloat(preco))
            throw new Exception("É obrigatório informar um preço para o produto.");
        
        if (valor.isEmpty() || !validarFloat(valor))
            throw new Exception("É obrigatório informar o valor de venda do produto.");
        
        if (quantidade.isEmpty() || !validarInteger(quantidade))
            throw new Exception("É obrigatório informar a quantidade em estoque do produto.");                
        
        Produto novoProduto = new Produto(nome, descricao, Float.parseFloat(preco), Float.parseFloat(preco), Integer.parseInt(quantidade), codigoEan);
                        
        return novoProduto;        
    }
    
   
    public void excluirItens(int[] ids){
        
    }
    
    public void iniciarEdicao(int id){
        produtoEmManutencao = obterProdutoPorId(id);
    }
    
    public Boolean verificarEdicao(){        
        return produtoEmManutencao != null && produtoEmManutencao.getId() != 0;
    }
    
    public void cancelarManutencao(){        
        produtoEmManutencao = null;
    }
}
