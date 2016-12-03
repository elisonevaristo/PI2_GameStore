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
public enum Genero {
    naoInformado(0, "Não Informado"),
    acao(1, "Ação"),
    aventura(2, "Aventura"),
    estrategia(3, "Estratégia"),
    esportes(4, "Esportes"),
    fps(5, "FPS"),
    mmo(6, "MMO"),
    plataforma(7, "Plataforma"),
    rpg(8, "RPG")
    ;
    
    private final int id;
    private final String descricao;

    Genero(int id, String descricao)
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
        return new String[] { "Ação", "Aventura", "Estratégia", "Esportes", "FPS", "MMO", "Plataforma", "RPG" } ;
    }
    
    public static Genero getById(int id)
    {
        switch (id) {
            case 1:
                return Genero.acao;
            case 2:
                return Genero.aventura;
            case 3:
                return Genero.estrategia;            
            case 4:
                return Genero.esportes;   
            case 5:
                return Genero.fps;   
            case 6:
                return Genero.mmo;   
            case 7:
                return Genero.plataforma;   
            case 8:
                return Genero.rpg;   
            default:
                return Genero.naoInformado;
        }
    }
    
    public static Genero getByDescricao(String descricao)
    {
        switch (descricao) {
            case "Ação":
                return Genero.acao;
            case "Aventura":
                return Genero.aventura;
            case "Estratégia":
                return Genero.estrategia;            
            case "Esportes":
                return Genero.esportes;   
            case "FPS":
                return Genero.fps;   
            case "MMO":
                return Genero.mmo;   
            case "Plataforma":
                return Genero.plataforma;   
            case "RPG":
                return Genero.rpg;   
                
            default:
                return Genero.naoInformado;
        }
    }
}
