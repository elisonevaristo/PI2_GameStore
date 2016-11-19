/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.database;

import com.gamestore.exceptions.DataAccessException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author Roger
 */
public abstract class DaoBase<T> {
    private java.sql.Connection connection = null;
    private ConnectionUtils connUtil = null;
    
    protected DaoBase(ConnectionUtils connUtil) throws DataAccessException {
        
        if (connUtil == null)
        {
            System.out.println("ConnectionUtil é nulo.");
            throw new DataAccessException("Não foi possível conectar à base de dados.");
        }        
        
        this.connUtil = connUtil;
    }
    
    protected PreparedStatement obterStatement(String command) throws java.sql.SQLException, Exception {
        if (connection == null)
            this.connection = connUtil.getConnection();        
        
        return connection.prepareStatement(command);
    }    
    
    protected void fecharConexao() throws java.sql.SQLException {
        if (connection != null && !connection.isClosed())
            connection.close();
    }
    
    protected void saveOrUpdate(String command) throws java.sql.SQLException {
        
        if (connection == null)
            this.connection = connUtil.getConnection();        
        
        Statement statement = connection.createStatement();        
        statement.execute(command);
    }
    
    protected ResultSet getList(String query) throws java.sql.SQLException {        
        return connection.createStatement().executeQuery(query);
    }
    
    protected abstract void insert(T obj) throws DataAccessException;
    
    protected abstract void update(T obj) throws DataAccessException;
}
