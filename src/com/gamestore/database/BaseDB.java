/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.database;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Roger
 */
public abstract class BaseDB<T> {
    private static java.sql.Connection connection = null;
    
    protected BaseDB(ConnectionUtils connUtil) throws Exception {
        
        if (connUtil == null)
        {
            System.out.println("ConnectionUtil é nulo.");
            throw new Exception("Connection Utils não disponível");
        }
        
        this.connection = connUtil.getConnection();
    }
    
    protected void saveOrUpdate(String command) throws java.sql.SQLException {
        Statement statement = connection.createStatement();        
        statement.execute(command);
    }
    
    protected static ResultSet getList(String query) throws java.sql.SQLException {        
        return connection.createStatement().executeQuery(query);
    }
    
    protected abstract void insert(T obj);
    
    protected abstract void update(T obj);
}
