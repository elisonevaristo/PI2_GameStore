/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import com.gamestore.models.Cliente;
import com.gamestore.models.Endereco;
import com.gamestore.models.EstadoCivil;
import com.gamestore.models.PreferenciaContato;
import com.gamestore.models.Sexo;
import com.gamestore.models.Telefone;
import com.gamestore.models.TipoTelefone;
import java.text.ParseException;
import java.util.ArrayList;
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
            
    public ServicoCliente(ConnectionUtils conn){
        this.conn = conn;
    }
    
    public void cadastrar(Cliente cliente) throws DataAccessException {
        if (dao == null)
            dao = new DaoCliente(conn);
        
        dao.insert(cliente);
    }
    
    public List<Cliente> obterClientes(String nome) throws DataAccessException {        
        if (dao == null)
            dao = new DaoCliente(conn);
        
        return dao.obterLista(nome, null);
    }
    
    public List<Cliente> ObterClientes(String nome, String cpf) throws DataAccessException {
        if (dao == null)
            dao = new DaoCliente(conn);
        
        return dao.obterLista(nome, cpf);
    }    
    
    /*
        Valida se as informações obrigatórias foram preenchidas corretamente
    */
    public Cliente validarCliente(String apelido, String nome, String sobreNome, String sexo, String cpf, String nascimento, String preferencia, String cep, String logradouro, String numero, String complemento, String bairro, 
            String cidade, String uf, String email, String foneResidencial, String foneCelular, String foneComercial, String estadoCivil) throws Exception {                
        
        if (nome.isEmpty())
            throw new Exception("É obrigatório informar o nome do cliente.");
        
        if (sobreNome.isEmpty())
            throw new Exception("É obrigatório informar o sobrenome do cliente.");
                        
        if (sexo.isEmpty() || !validarSexo(sexo))
            throw new Exception("É obrigatório informar o sexo do cliente.");
        
        String cpfFormatado = cpf.replaceAll("[^\\d]", "");
        System.out.println(cpfFormatado);
        
        if (cpfFormatado.isEmpty() || !validarCpf(cpfFormatado))
            throw new Exception("É obrigatório informar o CPF do cliente.");
        
        if (nascimento.isEmpty() || !validarNascimento(nascimento))
            throw new Exception("É obrigatório informar a data de nascimento do cliente.");
        
        if (preferencia.isEmpty() || !validarPreferencia(preferencia))
            throw new Exception("É obrigatório informar a preferencia de contato do cliente.");                
        
        Cliente novoCliente = new Cliente(apelido, nome, sobreNome, Sexo.getById(sexo.toUpperCase().charAt(0)), cpfFormatado, getDateFromString(nascimento), PreferenciaContato.getById(Integer.parseInt(preferencia)));
        
        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setUf(uf);        
        
        novoCliente.setEndereco(endereco);
        
        novoCliente.setEmail(email);
        
        List<Telefone> telefones = new ArrayList<>();
        
        if (!foneResidencial.isEmpty())
            telefones.add(new Telefone(TipoTelefone.residencial, foneResidencial));
        if (!foneCelular.isEmpty())
            telefones.add(new Telefone(TipoTelefone.celular, foneCelular));
        if (!foneComercial.isEmpty())
            telefones.add(new Telefone(TipoTelefone.comercial, foneComercial));
            
        novoCliente.setTelefones(telefones);        
        
        novoCliente.setEstadoCivil(EstadoCivil.getByDescricao(estadoCivil));
                
        return novoCliente;        
    }
            
    private static Boolean validarSexo(String sexo) {
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
    
    private static Boolean validarCpf(String cpf){                
        return cpf.length() == 11;
    }
    
    private Boolean validarNascimento(String nascimento){
        
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
    
    private static Boolean validarPreferencia(String preferencia){
        
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
