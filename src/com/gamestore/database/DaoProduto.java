/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.database;

import com.gamestore.exceptions.DataAccessException;
import com.gamestore.models.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roger
 */
public class DaoProduto extends DaoBase<Produto> {
    public DaoProduto(ConnectionUtils connection) throws DataAccessException {
        super(connection);
    }

    @Override
    public void insert(Produto obj) throws DataAccessException {
        
        PreparedStatement stt = null;
        
        try
        {
            String command = 
                    "insert into produto "
                    + "("
                        + "nome, "
                        + "fabricante, "
                        + "custo, "
                        + "preco, "
                        + "descricao, "
                        + "codigo_ean, "
                        + "ativo, "
                        + "categoria, "
                        + "quantidade,"
                        + "genero, "
                        + "plataforma, "
                        + "classificacao, "
                        + "garantia_fornecedor"
                    + ") "
                    + "values "
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            stt = obterStatement(command);
            
            stt.setString(1, obj.getNome());
            stt.setString(2, obj.getFabricante());
            stt.setFloat(3, obj.getCusto());
            stt.setFloat(4, obj.getPreco());
            stt.setString(5, obj.getDescricao());
            stt.setString(6, obj.getCodigoEan());
            stt.setBoolean(7, true);  
            stt.setString(8, obj.getCategoria());  
            stt.setInt(9, obj.getQuantidade());  
            stt.setString(10, obj.getGenero());  
            stt.setString(11, obj.getPlataforma());  
            stt.setString(12, obj.getClassificacao());  
            stt.setString(13, obj.getGarantiaFornecedor());              
            
            stt.execute();
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            throw new DataAccessException("Não foi possível inserir o produto.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível inserir o produto.");
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
                throw new DataAccessException("Não foi possível inserir o produto.");
            }
        }
    }

    @Override
    public void update(Produto obj) throws DataAccessException  {        
        PreparedStatement stt = null;
        
        try
        {
            String command = 
                    "update "
                    + "produto "
                    + "set "
                        + "nome = ?, "
                        + "fabricante = ?, "
                        + "custo = ?, "
                        + "preco = ?, "
                        + "descricao = ?, "
                        + "codigo_ean = ?, "
                        + "ativo = ?, "
                        + "categoria = ?, "
                        + "quantidade = ?, "
                        + "genero = ?, "
                        + "plataforma = ?, "
                        + "classificacao = ?, "
                        + "garantia_fornecedor = ? "
                    + "where "
                    + "codigo = ?";

            stt = obterStatement(command);
            
            stt.setString(1, obj.getNome());
            stt.setString(2, obj.getFabricante());
            stt.setFloat(3, obj.getCusto());
            stt.setFloat(4, obj.getPreco());
            stt.setString(5, obj.getDescricao());
            stt.setString(6, obj.getCodigoEan());
            stt.setBoolean(7, true);  
            stt.setString(8, obj.getCategoria());  
            stt.setInt(9, obj.getQuantidade());  
            stt.setString(10, obj.getGenero());  
            stt.setString(11, obj.getPlataforma());  
            stt.setString(12, obj.getClassificacao());  
            stt.setString(13, obj.getGarantiaFornecedor());    
            
            stt.setInt(14, obj.getId());  
            
            stt.execute();
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            throw new DataAccessException("Não foi possível atualizar o produto.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível atualizar o produto.");
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
                throw new DataAccessException("Não foi possível atualizar o produto.");
            }
        }
    }
    
    public void updateSaldo(Produto obj) throws DataAccessException  {        
        PreparedStatement stt = null;
        
        try
        {            
            String command = 
                    "update "
                    + "produto "
                    + "set "
                        + "quantidade = ? "
                    + "where "
                    + "codigo = ?";

            stt = obterStatement(command);
             
            stt.setInt(1, obj.getQuantidade());            
            stt.setInt(14, obj.getId());  
            
            stt.execute();
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            throw new DataAccessException("Não foi possível atualizar a quantidade do produto.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível atualizar a quantidade do produto.");
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
                throw new DataAccessException("Não foi possível atualizar o produto.");
            }
        }
    }
    
    public Produto obterPorCodigo(int codigo) throws DataAccessException {        
        
        PreparedStatement stt = null;
        ResultSet result = null;
        
        try
        {            
            String command = 
                    "select * from produto where codigo = " + codigo;
            
            result  = getList(command);
                        
            while(result.next()){
                               
                Produto produto = new Produto(
                        result.getString("nome"),
                        result.getString("fabricante"),
                        result.getFloat("custo"),
                        result.getFloat("preco"),
                        result.getInt("quantidade"),
                        result.getString("categoria"),
                        result.getString("genero"),
                        result.getString("plataforma"),
                        result.getString("classificacao"),
                        result.getString("garantia"),
                        result.getString("codigoEan"),
                        result.getString("descricao")
                );
                
                return produto;
            }
            
            return null;
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            
            System.out.println(sqlex.getMessage());
            
            throw new DataAccessException("Não foi possível obter o produto.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível obter o produto.");
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
                throw new DataAccessException("Não foi possível obter o produto.");
            }
        }
    }
    
    public List<Produto> obterLista(String nome, String plataforma, String fabricante, String categoria, String ean) throws DataAccessException {        
        
        PreparedStatement stt = null;
        ResultSet result = null;
        
        try
        {            
            String command = 
                    "select * from produto where ativo = 1 ";
                       
            if (!nome.isEmpty())            
                command += " and UPPER(nome) like UPPER('%" + nome + "%') ";
                        
            if (!plataforma.trim().isEmpty())            
                command += " and plataforma = " + plataforma;            
            
            if (!fabricante.isEmpty())            
                command += " and fabricante = " + fabricante;            
            
            if (!categoria.trim().isEmpty())            
                command += " and categoria = " + categoria;            
            
            if (!ean.isEmpty())            
                command += " and ean = " + ean;            
            
            System.out.println(command);
            
            result  = getList(command);
            
            ArrayList lista = new ArrayList<>();
            
            while(result.next()){
                               
                Produto produto = new Produto(
                        result.getInt("codigo"),
                        result.getString("nome"),
                        result.getString("fabricante"),
                        result.getFloat("custo"),
                        result.getFloat("preco"),
                        result.getInt("quantidade"),
                        result.getString("categoria"),
                        result.getString("genero"),
                        result.getString("plataforma"),
                        result.getString("classificacao"),
                        result.getString("garantia_fornecedor"),
                        result.getString("codigo_ean"),
                        result.getString("descricao")
                );
                
                lista.add(produto);
            }
            
            return lista;
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            
            System.out.println(sqlex.getMessage());
            
            throw new DataAccessException("Não foi possível obter a lista de produtos.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível obter a lista de produtos.");
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
                throw new DataAccessException("Não foi possível obter a lista de produtos.");
            }
        }
    }
}
