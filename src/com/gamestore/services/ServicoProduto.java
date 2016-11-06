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
public class ServicoProduto extends ServicoBase<Produto> {
            
    public List<Produto> ObterProdutos(String nome){
        
        List<Produto> listaResultado = new ArrayList<>();        
        if (itens != null && nome != null) {
            for (Produto pro : itens) {
                if (pro != null && pro.getNome().toUpperCase().contains(nome.toUpperCase())) {
                    listaResultado.add(pro);
                }
            }
        }        
        return listaResultado;
    }
    
    public List<Produto> ObterProdutos(String nome, String plataforma, String fabricante, String categoria, String ean){
        return itens;
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
        
        Produto novoProduto = new Produto(nome, fabricante, Float.parseFloat(custo.replace(",", ".")), Float.parseFloat(preco.replace(",", ".")), Integer.parseInt(quantidade), categoria, genero, plataforma, classificacao, garantia, codigoEan, descricao);
                        
        return novoProduto;        
    }    
}
