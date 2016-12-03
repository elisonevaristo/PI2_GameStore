/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.models;

/**
 *
 * @author Roger
 */
public enum ClassificacaoIndicativa {
    naoInformado(0, "Não Informada"),
    console(1, "Console"),
    acessorio(2, "Acessorio"),
    jogo(3, "Jogo")
    ;
    
    private final int id;
    private final String descricao;

    ClassificacaoIndicativa(int id, String descricao)
    {
        this.id = id;
        this.descricao = descricao;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getDescricao()
    {
        return this.descricao;
    }
    
    public static String[] getDescricoes(){
        return new String[] { "Não informada", "Console", "Acessório", "Jogo" } ;
    }
    
    public static Categoria getById(int id)
    {
        switch (id) {
            case 1:
                return Categoria.console;
            case 2:
                return Categoria.acessorio;
            case 3:
                return Categoria.jogo;
            default:
                return Categoria.naoInformado;
        }
    }
    
    public static Categoria getByDescricao(String descricao)
    {
        switch (descricao) {
            case "Console":
                return Categoria.console;
            case "Acessorio":
                return Categoria.acessorio;
            case "Jogo":
                return Categoria.jogo;            
            default:
                return Categoria.naoInformado;
        }
    }
}
