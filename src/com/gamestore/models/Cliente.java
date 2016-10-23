/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.models;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author roger
 */
public class Cliente {
    
    private int id;    
    
    private String nome;
    private String sobreNome;
    private String apelido;
    
    private String cpf;
    private String rg;    
    
    private Sexo sexo;        
    private EstadoCivil estadoCivil;
    private Calendar nascimento;
    private Endereco endereco;
    private ArrayList<Telefone> telefones;
    private String email;
    private PreferenciaContato preferencia;
    
    private Boolean ativo;
    
    public Cliente(int id, String nome, String sobreNome, Sexo sexo, String cpf, Calendar nascimento, PreferenciaContato preferencia)
    {
        setId(id);
        setNome(nome);
        setSobreNome(sobreNome);
        setSexo(sexo);
        setCpf(cpf);
        setNascimento(nascimento);
        setPreferencia(preferencia);
        setAtivo(true);
    }
    
    public Cliente(String nome, String sobreNome, Sexo sexo, String cpf, Calendar nascimento, PreferenciaContato preferencia)
    {
        setNome(nome);
        setSobreNome(sobreNome);
        setSexo(sexo);
        setCpf(cpf);
        setNascimento(nascimento);
        setPreferencia(preferencia);
        setAtivo(true);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobreNome
     */
    public String getSobreNome() {
        return sobreNome;
    }

    /**
     * @param sobreNome the sobreNome to set
     */
    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the estadoCivil
     */
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the nascimento
     */
    public Calendar getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefones
     */
    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the preferencia
     */
    public PreferenciaContato getPreferencia() {
        return preferencia;
    }

    /**
     * @param preferencia the preferencia to set
     */
    public void setPreferencia(PreferenciaContato preferencia) {
        this.preferencia = preferencia;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
