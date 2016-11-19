/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.database;

import com.gamestore.models.Cliente;
import com.gamestore.exceptions.DataAccessException;
import com.gamestore.models.PreferenciaContato;
import com.gamestore.models.Sexo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                        + "nome, "
                        + "sobrenome, "
                        + "cpf, "
                        + "rg, "
                        + "sexo, "
                        + "estado_civil, "
                        + "nascimento, "
                        + "preferencia_contato, "
                        + "ativo"
                    + ") "
                    + "values "
                    + "(?,?,?,?,?,?,?,?,?)";

            stt = obterStatement(command);
            
            stt.setString(1, obj.getNome());
            stt.setString(2, obj.getSobreNome());
            stt.setString(3, obj.getCpf());
            stt.setString(4, obj.getRg());
            stt.setString(5, String.valueOf(obj.getSexo().getId()));
            stt.setInt(6, obj.getEstadoCivil().getId());
            stt.setDate(7, new java.sql.Date(obj.getNascimento().getTimeInMillis()));  
            stt.setInt(8, obj.getPreferencia().getId());  
            stt.setBoolean(9, true);  
            
            stt.execute();
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

    @Override
    public void update(Cliente obj) throws DataAccessException  {        
        PreparedStatement stt = null;
        
        try
        {
            String command = 
                    "update cliente set "
                        + "nome = ? "
                        + "sobrenome = ? "
                        + "cpf = ? "
                        + "rg = ? "
                        + "sexo = ? "
                        + "estado_civil = ? "
                        + "nascimento = ? "
                        + "preferencia_contato = ? "
                        + "ativo = ? "
                    + "where "
                    + "codigo = ?";

            stt = obterStatement(command);
            
            stt.setString(1, obj.getNome());
            stt.setString(2, obj.getSobreNome());
            stt.setString(3, obj.getCpf());
            stt.setString(4, obj.getRg());
            stt.setString(5, String.valueOf(obj.getSexo().getId()));
            stt.setInt(6, obj.getEstadoCivil().getId());
            stt.setDate(7, new java.sql.Date(obj.getNascimento().getTimeInMillis()));  
            stt.setInt(8, obj.getPreferencia().getId());  
            stt.setBoolean(9, obj.getAtivo());  
            stt.setInt(10, obj.getId());  
            
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
    
    public List<Cliente> obterLista(String nome, String cpf) throws DataAccessException {        
        
        PreparedStatement stt = null;
        ResultSet result = null;
        
        try
        {
            if (nome.isEmpty() && cpf.isEmpty())
                return new ArrayList<>();
            
            String command = 
                    "select codigo, apelido, nome, sobrenome, cpf, rg, sexo, estado_civil, nascimento from cliente where ativo = ? ";
            
            command += cpf.isEmpty() ? "?" : " and cpf = ? ";            
            command += nome.isEmpty() ? "?" : " and UPPER(nome) || UPPER(sobrenome) like UPPER(?) ";
            
            stt = obterStatement(command);
            
            stt.setBoolean(1, true);
            stt.setString(2, cpf);
            stt.setString(3, nome);
            
            result  = stt.executeQuery();
            
            ArrayList lista = new ArrayList<>();
            
            while(result.next()){
                
                Calendar cal = new GregorianCalendar();
                cal.setTime(result.getDate("nascimento"));
                
                Sexo sexo = Sexo.getById(result.getString("sexo").charAt(0));
                
                PreferenciaContato pref = PreferenciaContato.getById(result.getInt("preferencia_contato"));
                
                Cliente cliente = new Cliente(
                        result.getInt("cliente_id"),
                        null,
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
