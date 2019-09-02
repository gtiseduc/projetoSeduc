/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Entidade;

import java.io.Serializable;

/**
 *
 * @author VICTOR HUGO
 */
public class Correcao implements Serializable{
    
    private Integer idCorrecao;
    private String gabarito;
    private String descritores;

    public Correcao(Integer idCorrecao, String gabarito, String descritores) {
        this.idCorrecao = idCorrecao;
        this.gabarito = gabarito;
        this.descritores = descritores;
    }

    public Correcao() {
    }

    public Integer getIdCorrecao() {
        return idCorrecao;
    }

    public void setIdCorrecao(Integer idCorrecao) {
        this.idCorrecao = idCorrecao;
    }

    public String getGabarito() {
        return gabarito;
    }

    public void setGabarito(String gabarito) {
        this.gabarito = gabarito;
    }

    public String getDescritores() {
        return descritores;
    }

    public void setDescritores(String descritores) {
        this.descritores = descritores;
    }
    
    
    
}
