/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Entidade;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author VICTOR HUGO
 */
public class Serie implements Serializable{
    
    
    private Integer idSerie;
    private Integer inepEscola;
    private String nome;
    

    public Serie(Integer idSerie,Integer inepEscola, String nome) {
        this.idSerie = idSerie;
        this.inepEscola = inepEscola;
        this.nome = nome;
       
    }

    public Serie() {
        
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public Integer getInepEscola() {
        return inepEscola;
    }

    public void setInepEscola(Integer inepEscola) {
        this.inepEscola = inepEscola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idSerie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Serie other = (Serie) obj;
        if (!Objects.equals(this.idSerie, other.idSerie)) {
            return false;
        }
        return true;
    }
   

    

   
    
    @Override
    public String toString() {
        return "Serie{" + "inepEscola=" + inepEscola + "idSerie=" + idSerie + " , nome=" + nome + '}';
    } 
    
}
