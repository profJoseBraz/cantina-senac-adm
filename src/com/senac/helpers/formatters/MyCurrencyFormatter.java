/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.helpers.formatters;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author caetano.8918
 */
public class MyCurrencyFormatter {
    public static String format(Double valueToFormat, Locale locale){
        try{
            Double value = valueToFormat;

            NumberFormat monetaryFormat = NumberFormat.getCurrencyInstance(locale);

            String formattedValue = monetaryFormat.format(value);

            return formattedValue;
        }catch(Exception e){
            System.err.println("Classe: MyCurrencyFormatter | Método: format" + e.getMessage());
            return "";
        }
    }
}
