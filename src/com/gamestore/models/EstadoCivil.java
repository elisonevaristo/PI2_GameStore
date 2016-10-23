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
public enum EstadoCivil {
    solteiro(1, "Solteiro"),
    casado(2, "Casado"),
    divorciado(3, "Divorciado"),
    viuvo(4, "Viúvo");
    
    private final int id;
    private final String descricao;

    EstadoCivil(int id, String descricao)
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
}
