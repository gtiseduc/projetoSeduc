/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Util.Excepition;

/**
 *
 * @author VICTOR HUGO
 */
public class ErroSistema extends Exception{

    
    public ErroSistema(String message){
    super(message);
    }
    public ErroSistema(String message, Throwable cause){
    super(message,cause);
    }
}
