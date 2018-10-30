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
public class Telefone {
    private int id;
    private TipoTelefone tipo;
    private String ddd;
    private String numero;    
    
    public Telefone(TipoTelefone tipo, String numero)
    {
        this.tipo = tipo;
        this.numero = numero;
    }
    
    public Telefone(TipoTelefone tipo, String ddd, String numero)
    {
        this.tipo = tipo;
        this.ddd = ddd;
        this.numero = numero;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

    /**
     * @param ddd the ddd to set
     */
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the tipo
     */
    public TipoTelefone getTipo() {
        return tipo;
    }

    /**
     * @return the ddd
     */
    public String getDdd() {
        return ddd;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }
}
