/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.models;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Elison Evaristo
 */
public class Cliente implements ItemComId {
    
    private int id;    
    
    private String nome;
    private String sobreNome;
    private String apelido;
    
    private java.awt.Image foto;
    
    private String cpf;
    private String rg;    
    
    private Sexo sexo;        
    private EstadoCivil estadoCivil;
    private Calendar nascimento;
    private Endereco endereco;
    private List<Telefone> telefones;
    private String email;
    private PreferenciaContato preferencia;
    
    private Boolean ativo;
    
    public Cliente(int id, String apelido, String nome, String sobreNome, Sexo sexo, String cpf, Calendar nascimento, PreferenciaContato preferencia)
    {
        setId(id);
        setApelido(apelido);
        setNome(nome);
        setSobreNome(sobreNome);
        setSexo(sexo);
        setCpf(cpf);
        setNascimento(nascimento);
        setPreferencia(preferencia);
        setAtivo(true);
    }
    
    public Cliente(String apelido, String nome, String sobreNome, Sexo sexo, String cpf, Calendar nascimento, PreferenciaContato preferencia)
    {
        setApelido(apelido);
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
    @Override
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
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
    
    public String getNomeCompleto(){
        return nome + " " + sobreNome;
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
    
    public String getIdade(){
        
        int anoNascimento = nascimento.get(Calendar.YEAR);        
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        
        return String.format("%s anos", anoAtual - anoNascimento);
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
    public List<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    public String getTelefone(TipoTelefone tipo){
        if (telefones == null)
            return "";
        
        for (Telefone tel : this.telefones) {
            if (tel.getTipo().equals(tipo))
                return tel.getNumero();
        }
        
        return "";
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
    
    public int getNumeroPedidos(){
        return 0;
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

    /**
     * @return the foto
     */
    public java.awt.Image getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(java.awt.Image foto) {
        this.foto = foto;
    }    
}
