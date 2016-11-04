/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamestore.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author roger
 */
public class ServicoBase {
        
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
            Float.parseFloat(numero);
            
            return true;
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
    }
}
