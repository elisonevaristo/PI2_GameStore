/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import com.gamestore.models.Cliente;
import java.text.ParseException;
import java.util.List;
import com.gamestore.database.DaoCliente;
import com.gamestore.database.ConnectionUtils;
import com.gamestore.exceptions.DataAccessException;

/**
 *
 * @author roger
 */
public class ServicoCliente extends ServicoBase<Cliente> {
        
    DaoCliente dao = null;
    ConnectionUtils conn = null;
    Cliente cliente = null;
            
    public ServicoCliente(ConnectionUtils conn){
        this.conn = conn;
    }
    
    public void cadastrar(Cliente cliente) throws DataAccessException {
        if (dao == null)
            dao = new DaoCliente(conn);
        
        dao.insert(cliente);
    }
    
    public void atualizar(Cliente produto) throws DataAccessException {
        if (dao == null)
            dao = new DaoCliente(conn);
        
        dao.update(produto);
    }
    
    public void selecionar(int id) throws DataAccessException {
        if (dao == null)
            dao = new DaoCliente(conn);
        
        cliente = dao.obterPorId(id);
    }
        
    public Cliente obterSelecionado(){
        return cliente;
    }
    
    public Boolean validarExisteSelecionado(){        
        return cliente != null && cliente.getId() != 0;
    }
    
    public void cancelarSelecao(){        
        cliente = null;
    }
    
    public void excluir(int id) throws DataAccessException  {
        if (dao == null)
            dao = new DaoCliente(conn);
        
        dao.inativar(id);
    } 
    
    public List<Cliente> obterClientes(String nome) throws DataAccessException {        
        if (dao == null)
            dao = new DaoCliente(conn);
        
        return dao.obterLista(nome, null);
    }
    
    public Cliente obterPorId(int id) throws DataAccessException {
        if (dao == null)
            dao = new DaoCliente(conn);
        
        return dao.obterPorId(id);
    }
    
    public List<Cliente> ObterClientes(String nome, String cpf) throws DataAccessException {
        if (dao == null)
            dao = new DaoCliente(conn);
        
        return dao.obterLista(nome, cpf);
    }    
                
    public static Boolean validarSexo(String sexo) {
        char id = sexo.toUpperCase().charAt(0);
        
        switch (id) {
            case 'M':
            case 'F':
            case 'I':
                return true;
            default:
                return false;
        }
    }
    
    public static Boolean validarCpf(String cpf){                
        return cpf.length() == 11;
    }
    
    public Boolean validarNascimento(String nascimento){
        
        try
        {
            getDateFromString(nascimento);
        }
        catch(ParseException pe)
        {
            return false;
        }
        
        return true;
    }
    
    public static Boolean validarPreferencia(String preferencia){
        
        try
        {
            int numero = Integer.parseInt(preferencia);
            
            return numero > 0 && numero < 5;                
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }    
}
