/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import com.gamestore.models.ItemComId;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author roger
 * @param <T> A classe filha que implementa as funções mais específicas do serviço.
 */
public class ServicoBase<T extends ItemComId> {
    
    List<T> itens = new ArrayList<>();
    
    T selecionado;
        
    public void selecionar(int id){
        selecionado = obterItemPorId(id);
    }
    
    public Boolean validarExisteSelecionado(){        
        return selecionado != null && selecionado.getId() != 0;
    }
    
    public T obterSelecionado(){
        return selecionado;
    }
    
    public void cancelarSelecao(){        
        selecionado = null;
    }
    
    public void CadastrarItem(T item) throws Exception {
        int size = itens.size();
        int id = size == 0 ? size : itens.get(itens.size() - 1).getId();
        
        item.setId(id + 1);
        itens.add(item);
    }    
    
    public void AtualizarCadastroItem(T item) throws Exception
    {                
        T antigoItem = obterItemPorId(item.getId());
        
        itens.remove(antigoItem);
        itens.add(item);
    }
    
    public void InativarCadastroItem(int id) throws Exception
    {
        T item = obterItemPorId(id);
        item.setAtivo(false);
    }
    
    public void excluir(int[] ids){
        
    }        
    
    protected T obterItemPorId(int id)
    {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getId() == id)
                return itens.get(i);                
        }
        
        return null;
    }
    
    protected Calendar getDateFromString(String stringDate) throws ParseException { 
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(stringDate);
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        
        return calendarDate;
    }
    
    protected Boolean validarInteger(String numero){
        try
        {
            Integer.parseInt(numero);
            
            return true;
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
    }
    
    protected Boolean validarFloat(String numero){
        try
        {
            Float.parseFloat(numero.replace(",", "."));
            
            return true;
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
    }
}
