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
public enum PreferenciaContato {
    email(1, "Email"),
    telefone(2, "Telefone");
    
    private int id;
    private String descricao;
    
    PreferenciaContato(int id, String descricao)
    {
        this.id = id;
        this.descricao = descricao;
    }
}
