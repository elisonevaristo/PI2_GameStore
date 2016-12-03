/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.database;

import com.gamestore.models.Cliente;
import com.gamestore.exceptions.DataAccessException;
import com.gamestore.models.Endereco;
import com.gamestore.models.EstadoCivil;
import com.gamestore.models.PreferenciaContato;
import com.gamestore.models.Sexo;
import com.gamestore.models.Telefone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


/**
 *
 * @author Roger
 */
public class DaoCliente extends DaoBase<Cliente> {
    
    public DaoCliente(ConnectionUtils connection) throws DataAccessException {
        super(connection);
    }

    @Override
    public void insert(Cliente obj) throws DataAccessException {
        
        PreparedStatement stt = null;
        
        try
        {
            String command = 
                    "insert into cliente "
                    + "("
                        + "apelido, "
                        + "nome, "
                        + "sobrenome, "
                        + "foto, "
                        + "cpf, "
                        + "rg, "
                        + "sexo, "
                        + "estado_civil, "
                        + "nascimento, "
                        + "email, "
                        + "preferencia_contato, "
                        + "ativo, "
                        + "nome_completo, "
                        + "cep, "
                        + "logradouro, "
                        + "numero, "
                        + "complemento, "
                        + "bairro, "
                        + "cidade, "
                        + "uf "
                    + ") "
                    + "values "
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            stt = obterStatement(command);
            
            stt.setString(1, obj.getApelido().isEmpty() ? obj.getNome() : obj.getApelido());
            stt.setString(2, obj.getNome());
            stt.setString(3, obj.getSobreNome());
            stt.setString(4, null);
            stt.setString(5, obj.getCpf());
            stt.setString(6, obj.getRg());
            stt.setString(7, String.valueOf(obj.getSexo().getId()));
            stt.setInt(8, obj.getEstadoCivil().getId());
            stt.setDate(9, new java.sql.Date(obj.getNascimento().getTimeInMillis()));  
            stt.setString(10, obj.getEmail());            
            stt.setInt(11, obj.getPreferencia().getId());  
            stt.setBoolean(12, true);  
            stt.setString(13, String.format("%s %s", obj.getNome(), obj.getSobreNome()));
            
            stt.setString(14, obj.getEndereco().getCep());
            stt.setString(15, obj.getEndereco().getLogradouro());
            stt.setString(16, obj.getEndereco().getNumero());
            stt.setString(17, obj.getEndereco().getComplemento());
            stt.setString(18, obj.getEndereco().getBairro());
            stt.setString(19, obj.getEndereco().getCidade());
            stt.setString(20, obj.getEndereco().getUf());            
                        
            stt.execute();
            
            //stt.executeUpdate(command, Statement.RETURN_GENERATED_KEYS);
            
//            ResultSet rs = stt.getGeneratedKeys();
//            
//            if (rs.next())
//            {
//                int id = rs.getInt(1);
//                obj.setId(id);
//                insertTelefones(obj);
//            }
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            throw new DataAccessException("Não foi possível inserir o cliente.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível inserir o cliente.");
        }
        finally
        {
            try
            {
                if (stt != null && !stt.isClosed())
                    stt.close();
                
                fecharConexao();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                throw new DataAccessException("Não foi possível inserir o cliente.");
            }
        }
    }
    
    private void insertTelefones(Cliente obj) throws DataAccessException {
        if (obj == null)
            return;
        
        if (obj.getTelefones() == null || obj.getTelefones().isEmpty())
            return;
        
        for (Telefone tel : obj.getTelefones()) {
            insertTelefone(tel);
        }
    }
    
    private void insertTelefone(Telefone obj) throws DataAccessException {
        
        PreparedStatement stt = null;
        
        try
        {
            String command = 
                    "insert into telefone (tipo, ddd, numero, codigo_cliente) values (?, ?, ?, ?);";

            stt = obterStatement(command);
            
            stt.setInt(1, obj.getTipo().getId());
            stt.setString(2, obj.getDdd());
            stt.setString(3, obj.getNumero());
            stt.setInt(4, obj.getCliente().getId());           
            
            stt.execute();
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            throw new DataAccessException("Não foi possível inserir o telefone do cliente.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível inserir o telefone do cliente.");
        }
        finally
        {
            try
            {
                if (stt != null && !stt.isClosed())
                    stt.close();
                
                fecharConexao();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                throw new DataAccessException("Não foi possível inserir o cliente.");
            }
        }
    }
    
    @Override
    public void update(Cliente obj) throws DataAccessException  {        
        PreparedStatement stt = null;
        
        try
        {
            String command = 
                    "update cliente set "
                        + "apelido = ?, "
                        + "nome = ?, "
                        + "sobrenome = ?, "
                        + "foto = ?, "
                        + "cpf = ?, "
                        + "rg = ?, "
                        + "sexo = ?, "
                        + "estado_civil = ?, "
                        + "nascimento = ?, "
                        + "email = ?, "
                        + "preferencia_contato = ?, "
                        + "ativo = ?, "
                        + "nome_completo = ?, "
                        + "cep = ?, "
                        + "logradouro = ?, "
                        + "numero = ?, "
                        + "complemento = ?, "
                        + "bairro = ?, "
                        + "cidade = ?, "
                        + "uf = ? "
                    + "where "
                    + "codigo = ?";

            stt = obterStatement(command);
            
            stt.setString(1, obj.getApelido().isEmpty() ? obj.getNome() : obj.getApelido());
            stt.setString(2, obj.getNome());
            stt.setString(3, obj.getSobreNome());
            stt.setString(4, null);
            stt.setString(5, obj.getCpf());
            stt.setString(6, obj.getRg());
            stt.setString(7, String.valueOf(obj.getSexo().getId()));
            stt.setInt(8, obj.getEstadoCivil().getId());
            stt.setDate(9, new java.sql.Date(obj.getNascimento().getTimeInMillis()));  
            stt.setString(10, obj.getEmail());            
            stt.setInt(11, obj.getPreferencia().getId());  
            stt.setBoolean(12, true);  
            stt.setString(13, String.format("%s %s", obj.getNome(), obj.getSobreNome()));
            
            stt.setString(14, obj.getEndereco().getCep());
            stt.setString(15, obj.getEndereco().getLogradouro());
            stt.setString(16, obj.getEndereco().getNumero());
            stt.setString(17, obj.getEndereco().getComplemento());
            stt.setString(18, obj.getEndereco().getBairro());
            stt.setString(19, obj.getEndereco().getCidade());
            stt.setString(20, obj.getEndereco().getUf());      
            
            stt.setInt(21, obj.getId());  
            
            stt.execute();
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            throw new DataAccessException("Não foi possível atualizar o cliente.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível atualizar o cliente.");
        }
        finally
        {
            try
            {
                if (stt != null && !stt.isClosed())
                    stt.close();
                
                fecharConexao();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                throw new DataAccessException("Não foi possível atualizar o cliente.");
            }
        }
    }
    
    public Cliente obterClientePorId(int id) throws DataAccessException {        
        
        PreparedStatement stt = null;
        ResultSet result = null;
        
        try
        {               
            String command = "select * from cliente where codigo = ?";
                      
            stt = obterStatement(command);
            
            stt.setInt(1, id);
            
            result  = stt.executeQuery(command);
            
            ArrayList lista = new ArrayList<>();
            
            while(result.next()){
                
                Calendar cal = new GregorianCalendar();
                cal.setTime(result.getDate("nascimento"));
                
                Sexo sexo = Sexo.getById(result.getString("sexo").charAt(0));
                
                PreferenciaContato pref = PreferenciaContato.getById(result.getInt("preferencia_contato"));
                                
                Cliente cliente = new Cliente(
                        result.getInt("codigo"),
                        result.getString("apelido"),
                        result.getString("nome"),
                        result.getString("sobrenome"),
                        sexo,
                        result.getString("cpf"),
                        cal,
                        pref                        
                );
                
                cliente.setRg(result.getString("rg"));
                cliente.setEstadoCivil(EstadoCivil.getById(result.getInt("estado_civil")));
                cliente.setEmail(result.getString("email"));
                
                Endereco endereco = new Endereco();
                
                endereco.setCep(result.getString("cep"));
                endereco.setCep(result.getString("logradouro"));
                endereco.setCep(result.getString("numero"));
                endereco.setCep(result.getString("complemento"));
                endereco.setCep(result.getString("bairro"));
                endereco.setCep(result.getString("cidade"));
                endereco.setCep(result.getString("uf"));
                
                cliente.setEndereco(endereco);
                
                lista.add(cliente);
            }
            
            return lista.size() == 0 ? null : (Cliente)lista.get(0);
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            
            System.out.println(sqlex.getMessage());
            
            throw new DataAccessException("Não foi possível obter a lista de clientes.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível obter a lista de clientes.");
        }
        finally
        {
            try
            {
                if (stt != null && !stt.isClosed())
                    stt.close();
                
                fecharConexao();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                throw new DataAccessException("Não foi possível obter a lista de clientes.");
            }
        }
    }
    
    public List<Cliente> obterLista(String nome, String cpf) throws DataAccessException {        
        
        PreparedStatement stt = null;
        ResultSet result = null;
        
        int indexParam = 0;
        
        try
        {            
            if (nome == null && cpf == null)
                return new ArrayList<>();
            
            String command = 
                    "select "
                    + "codigo, "
                    + "apelido, "
                    + "nome, "
                    + "sobrenome, "
                    + "cpf, "
                    + "rg, "
                    + "sexo, "
                    + "estado_civil, "
                    + "nascimento, "
                    + "preferencia_contato "
                    + "from "
                    + "cliente "
                    + "where ativo = 1 ";
            
            if (cpf != null && !cpf.isEmpty())            
                command += " and cpf = ? " + cpf;            
            
            if (nome != null && !nome.isEmpty())            
            command += " and UPPER(nome_completo) like UPPER('%?%') ";
                      
            stt = obterStatement(command);
            
            if (cpf != null && !cpf.isEmpty()) {
                stt.setString(indexParam, cpf);
                indexParam++;
            }
            
            if (nome != null && !nome.isEmpty()){            
                stt.setString(indexParam, nome);
                indexParam++;
            }
            
            result  = stt.executeQuery(command);
            
            ArrayList lista = new ArrayList<>();
            
            while(result.next()){
                
                Calendar cal = new GregorianCalendar();
                cal.setTime(result.getDate("nascimento"));
                
                Sexo sexo = Sexo.getById(result.getString("sexo").charAt(0));
                
                PreferenciaContato pref = PreferenciaContato.getById(result.getInt("preferencia_contato"));
                
                Cliente cliente = new Cliente(
                        result.getInt("codigo"),
                        result.getString("apelido"),
                        result.getString("nome"),
                        result.getString("sobrenome"),
                        sexo,
                        result.getString("cpf"),
                        cal,
                        pref                        
                );
                
                lista.add(cliente);
            }
            
            return lista;
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            
            System.out.println(sqlex.getMessage());
            
            throw new DataAccessException("Não foi possível obter a lista de clientes.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível obter a lista de clientes.");
        }
        finally
        {
            try
            {
                if (stt != null && !stt.isClosed())
                    stt.close();
                
                fecharConexao();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                throw new DataAccessException("Não foi possível obter a lista de clientes.");
            }
        }
    }
}
