/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import com.gamestore.models.ItemComId;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author roger
 * @param <T> A classe filha que implementa as funções mais específicas do serviço.
 */
public class ServicoBase<T extends ItemComId> {
            
    protected Calendar getDateFromString(String stringDate) throws ParseException { 
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(stringDate);
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        
        return calendarDate;
    }
    
    protected String getStringFromDate(Calendar date){        
        return new SimpleDateFormat("dd/MM/yyyy").format(date.getTime());
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
