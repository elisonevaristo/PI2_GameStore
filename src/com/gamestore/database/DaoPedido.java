/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.database;

import com.gamestore.exceptions.DataAccessException;
import com.gamestore.models.ItemPedido;
import com.gamestore.models.ItemRelatorio;
import com.gamestore.models.Pedido;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Roger
 */
public class DaoPedido extends DaoBase<Pedido> {
    
    DaoProduto daoProduto;
    
    public DaoPedido(ConnectionUtils connection) throws DataAccessException {
        super(connection);
        daoProduto = new DaoProduto(connection);        
    }
    
    @Override
    public void insert(Pedido obj) throws DataAccessException {
        
        PreparedStatement stt = null;
        
        try
        {
            String command = 
                    "insert into pedido (data, codigo_cliente) values (sysdate(), ?)";

            stt = obterStatement(command);
            
            stt.setInt(1, obj.getCliente().getId());
            
            stt.execute();
            
            for (ItemPedido item : obj.getItens())
                insertItem(item);
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            throw new DataAccessException("Não foi possível inserir o pedido.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível inserir o pedido.");
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
                throw new DataAccessException("Não foi possível inserir o pedido.");
            }
        }
    }

    private void insertItem(ItemPedido obj) throws DataAccessException {
        
        PreparedStatement stt = null;
        
        try
        {
            String command = 
                    "insert into produto_pedido (codigo_pedido, codigo_produto, valor_unitario, quantidade) values (?,?,?,?)";

            stt = obterStatement(command);
            
            stt.setInt(1, obj.getPedido().getId());
            stt.setInt(2, obj.getProduto().getId());
            stt.setFloat(3, obj.getProduto().getPreco());
            stt.setInt(4, obj.getQuantidade());
            
            stt.execute();            
            
            daoProduto.updateSaldo(obj.getProduto());
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            throw new DataAccessException("Não foi possível inserir o pedido.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível inserir o pedido.");
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
                throw new DataAccessException("Não foi possível inserir o pedido.");
            }
        }
    }
    
    @Override
    protected void update(Pedido obj) throws DataAccessException {
        throw new UnsupportedOperationException("Atualização de pedido não implementada."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ItemRelatorio> obterLista(String dataInicial, String dataFinal, String plataforma, String categoria, String produto) throws DataAccessException {        
        
        PreparedStatement stt = null;
        ResultSet result = null;
        
        try
        {            
            String command = 
                    "select "
                        + "pedido.codigo as pedido_id, "
                        + "cliente.nome_completo as cliente_nome, "
                        + "produto.nome as produto_nome, "
                        + "item_pedido.quantidade, "
                        + "pedido.data, "
                        + "item_pedido.valor_unitario "
                    + "from "
                        + "pedido "
                        + "inner join cliente on (cliente.codigo = pedido.codigo_cliente) "
                        + "inner join produto_pedido item_pedido on (item_pedido.codigo_pedido = pedido.codigo) "
                        + "inner join produto on (produto.codigo = item_pedido.codigo_produto) "
                    + "where "
                        + "pedido.data between " + dataInicial + " and " + dataFinal + " ";
                       
            if (!produto.isEmpty())            
                command += " and UPPER(produto.nome) like UPPER('%" + produto + "%') ";
                        
            if (!plataforma.isEmpty())            
                command += " and plataforma = " + plataforma;            
                        
            if (!categoria.isEmpty())            
                command += " and categoria = " + categoria;            
                        
            System.out.println(command);
            
            result  = getList(command);
            
            ArrayList lista = new ArrayList<>();
            
            while(result.next()){
                               
                ItemRelatorio item = new ItemRelatorio(
                        result.getString("pedido_id"),
                        result.getString("cliente_nome"),
                        result.getString("produto_nome"),
                        result.getInt("quantidade"),
                        result.getString("data"),
                        result.getFloat("valor_unitario")
                );
                
                lista.add(item);
            }
            
            return lista;
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            
            System.out.println(sqlex.getMessage());
            
            throw new DataAccessException("Não foi possível obter a lista de pedido.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new DataAccessException("Não foi possível obter a lista de pedido.");
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
                throw new DataAccessException("Não foi possível obter a lista de pedido.");
            }
        }
    }
}
