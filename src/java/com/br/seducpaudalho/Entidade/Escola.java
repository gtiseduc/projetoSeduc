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
public class Escola implements Serializable{
    
    private Integer inepEscola;
    private String nome;
    private Integer cp;
    private Integer ca;

    public Escola(Integer inepEscola, String nome) {
        this.inepEscola = inepEscola;
        this.nome = nome;
       
    }

    public Escola() {
        
    }
   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.inepEscola);
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
        final Escola other = (Escola) obj;
        if (!Objects.equals(this.inepEscola, other.inepEscola)) {
            return false;
        }
        return true;
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

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public Integer getCa() {
        return ca;
    }

    public void setCa(Integer ca) {
        this.ca = ca;
    }

   
    
    @Override
    public String toString() {
        return "Escola{" + "inepEscola=" + inepEscola + ", nome=" + nome + '}';
    } 
    
}
