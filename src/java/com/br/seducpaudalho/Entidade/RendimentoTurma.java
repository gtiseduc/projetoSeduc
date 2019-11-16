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
public class RendimentoTurma {
    
    
     private Integer codRendimento;
    private Integer codTurma;
    private Integer inep;
    private Integer codSerie;
    private Integer codDisciplina;
    private double rendimento;

    public RendimentoTurma(Integer codRendimento, Integer codTurma, Integer inep, Integer codSerie, Integer codDisciplina, double rendimento) {
        this.codRendimento = codRendimento;
        this.codTurma = codTurma;
        this.inep = inep;
        this.codSerie = codSerie;
        this.codDisciplina = codDisciplina;
        this.rendimento = rendimento;
    }

    public RendimentoTurma() {
    }

  
    
    
    
    
    
    
    public Integer getCodRendimento() {
        return codRendimento;
    }

    public void setCodRendimento(Integer codRendimento) {
        this.codRendimento = codRendimento;
    }

    public Integer getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(Integer codTurma) {
        this.codTurma = codTurma;
    }

    public Integer getInep() {
        return inep;
    }

    public void setInep(Integer inep) {
        this.inep = inep;
    }

    public Integer getCodSerie() {
        return codSerie;
    }

    public void setCodSerie(Integer codSerie) {
        this.codSerie = codSerie;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public Integer getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.inep);
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
        final RendimentoTurma other = (RendimentoTurma) obj;
        if (!Objects.equals(this.inep, other.inep)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RendimentoTurma{" + "codRendimento=" + codRendimento + ", codTurma=" + codTurma + ", inep=" + inep + ", codSerie=" + codSerie + ", codDisciplina=" + codDisciplina + ", rendimento=" + rendimento + '}';
    }

 
    
    
    
    
}
