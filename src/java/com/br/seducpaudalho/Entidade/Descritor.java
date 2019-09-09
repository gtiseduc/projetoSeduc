/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Entidade;

import java.util.Objects;

/**
 *
 * @author VICTOR HUGO
 */
public class Descritor {
   
    private Integer codDescritor;
    private Integer codDisciplina;
    private Integer codSerie;
    
    private String siglaDescritor; 
    private String especiDescritor; 
    private String nomeMatriz; 

    public Descritor(Integer codDescritor, Integer codDisciplina, Integer codSerie, String siglaDescritor, String especiDescritor, String nomeMatriz) {
        this.codDescritor = codDescritor;
        this.codDisciplina = codDisciplina;
        this.codSerie = codSerie;
        this.siglaDescritor = siglaDescritor;
        this.especiDescritor = especiDescritor;
        this.nomeMatriz = nomeMatriz;
    }

    public Descritor() {
    }

    public Integer getCodDescritor() {
        return codDescritor;
    }

    public void setCodDescritor(Integer codDescritor) {
        this.codDescritor = codDescritor;
    }

    public Integer getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public Integer getCodSerie() {
        return codSerie;
    }

    public void setCodSerie(Integer codSerie) {
        this.codSerie = codSerie;
    }

    public String getSiglaDescritor() {
        return siglaDescritor;
    }

    public void setSiglaDescritor(String siglaDescritor) {
        this.siglaDescritor = siglaDescritor;
    }

    public String getEspeciDescritor() {
        return especiDescritor;
    }

    public void setEspeciDescritor(String especiDescritor) {
        this.especiDescritor = especiDescritor;
    }

    public String getNomeMatriz() {
        return nomeMatriz;
    }

    public void setNomeMatriz(String nomeMatriz) {
        this.nomeMatriz = nomeMatriz;
    }

   
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.codDescritor);
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
        final Descritor other = (Descritor) obj;
        if (!Objects.equals(this.codDescritor, other.codDescritor)) {
            return false;
        }
        return true;
    }
    
    
}
