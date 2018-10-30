/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.models;

/**
 *
 * @author Elison Evaristo
 */
public enum PreferenciaContato {
    email(1, "Email"),
    residencial(2, "Telefone Residencial"),
    celular(3, "Telefone Celular"),
    comercial(4, "Telefone Comercial"),
    nenhuma(0, "Nenhuma");
    
    private int id;
    private String descricao;
    
    PreferenciaContato(int id, String descricao)
    {
        this.id = id;
        this.descricao = descricao;
    }
    
    public static PreferenciaContato getById(int id)
    {
        switch (id) {
            case 1:
                return PreferenciaContato.email;
            case 2:
                return PreferenciaContato.residencial;
            case 3:
                return PreferenciaContato.celular;
            case 4:
                return PreferenciaContato.comercial;
            default:
                return PreferenciaContato.nenhuma;
        }
    }
    
    public int getId(){
        return this.id;
    }
}
