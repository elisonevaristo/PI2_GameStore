/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.models;

/**
 *
 * @author roger
 */
public enum TipoTelefone {
    residencial(1, "Residencial", "Res."),
    celular(2, "Celular", "Cel."),
    comercial(3, "Comercial", "Com.");
    
    private int id;
    private String descricao;
    private String abreviatura;
    
    TipoTelefone(int id, String descricao, String abreviatura)
    {
        this.id = id;
        this.descricao = descricao;
        this.abreviatura = abreviatura;
    }
    
    public int getId(){
        return this.id;
    }
}
