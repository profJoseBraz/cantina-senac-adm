/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.helpers.formatters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author caetano.8918
 */
public class MyDateFormatter {
    public static String format(String dateToFormat, String _inputFormatter, String _outputFormatter){
        try{
            String prodDate = dateToFormat;
                    
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(_inputFormatter);

            LocalDate date = LocalDate.parse(prodDate, inputFormatter);

            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(_outputFormatter);

            String formatteDate = date.format(outputFormatter);

            return formatteDate;
        }catch(Exception e){
            System.err.println("Classe: MyDateFormatter | Método: format" + e.getMessage());
            return "";
        }
    }
}
