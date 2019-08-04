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
public class Turma implements Serializable{
    
    
    private Integer idTurma;
    private Integer idSerie;
    private String nome;
    

    public Turma(Integer idTurma,Integer idSerie, String nome) {
        this.idTurma = idTurma;
        this.idSerie = idSerie;
        this.nome = nome;
       
    }

    public Turma() {
        
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.idTurma);
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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.idTurma, other.idTurma)) {
            return false;
        }
        return true;
    }

   
   

    

   
    
    @Override
    public String toString() {
        return "Serie{" + "idTurma=" + idTurma + "idSerie=" + idSerie + " , nome=" + nome + '}';
    } 
    
}
