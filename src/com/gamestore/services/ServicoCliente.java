/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import com.gamestore.models.Cliente;
import java.util.ArrayList;

/**
 *
 * @author roger
 */
public class ServicoCliente {
    
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    public void CadastrarCliente(Cliente novoCliente) throws Exception
    {
        validarCliente(novoCliente);        
        clientes.add(novoCliente);
    }
    
    public void AtualizarCadastroCliente(Cliente cliente) throws Exception
    {        
        validarCliente(cliente);
        
        Cliente antigoCadastro = obterClientePorId(cliente.getId());
        
        antigoCadastro.setApelido(cliente.getApelido());
        //... todos os outros campos faltantes
    }
    
    public void InativarCadastroCliente(int id) throws Exception
    {
        Cliente cliente = obterClientePorId(id);
        cliente.setAtivo(false);
    }    
    
    private Cliente obterClientePorId(int id)
    {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id)
                return clientes.get(i);                
        }
        
        return null;
    }
    
    /*
        Valida se as informações obrigatórias foram preenchidas corretamente
    */
    private void validarCliente(Cliente cliente) throws Exception
    {
        if (cliente == null)
            throw new Exception("Não há cliente para incluir.");
        
        if (cliente.getNome().isEmpty())
            throw new Exception("É obrigatório informar o nome do cliente.");
        
        if (cliente.getSobreNome().isEmpty())
            throw new Exception("É obrigatório informar o sobrenome do cliente.");
        
        if (cliente.getSexo() == null)
            throw new Exception("É obrigatório informar o sexo do cliente.");
        
        if (cliente.getCpf().isEmpty())
            throw new Exception("É obrigatório informar o CPF do cliente.");
        
        if (cliente.getNascimento() == null)
            throw new Exception("É obrigatório informar a data de nascimento do cliente.");
        
        if (cliente.getPreferencia() == null)
            throw new Exception("É obrigatório informar a preferencia de contato do cliente.");
    }
}
