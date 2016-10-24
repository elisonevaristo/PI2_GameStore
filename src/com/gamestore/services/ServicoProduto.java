/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import com.gamestore.models.Acessorio;
import com.gamestore.models.Console;
import com.gamestore.models.IProduto;
import com.gamestore.models.Jogo;
import java.util.ArrayList;

/**
 *
 * @author roger
 */
public class ServicoProduto {
    
    ArrayList<IProduto> produtos = new ArrayList<>();
    
    public void CadastrarJogo(Jogo jogo)
    {
        produtos.add(jogo);
    }
    
    public void CadastrarConsole(Console console)
    {
        produtos.add(console);
    }
    
    public void CadastrarAcessorio(Acessorio acessorio)
    {
        produtos.add(acessorio);
    }
}
