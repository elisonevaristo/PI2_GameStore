/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.database;

import com.gamestore.models.Cliente;

/**
 *
 * @author Roger
 */
public class ClienteDB extends BaseDB<Cliente> {
    
    public ClienteDB(ConnectionUtils connection) throws Exception {
        super(connection);
    }
    
    public void Inserir(){
    
    }

    @Override
    protected void insert(Cliente obj) {
        
        String command = "insert into cliente (id, nome, sobrenome, cpf, rg, )";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void update(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
