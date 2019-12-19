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
public class RendimentoSerie {
    
    
     private Integer codRendimento;
    private Integer inep;
    private Integer codSerie;
    private Integer codDisciplina;
    private double rendimento;

    public RendimentoSerie(Integer codRendimento, Integer inep, Integer codSerie, Integer codDisciplina, double rendimento) {
        this.codRendimento = codRendimento;
        this.inep = inep;
        this.codSerie = codSerie;
        this.codDisciplina = codDisciplina;
        this.rendimento = rendimento;
    }

    public RendimentoSerie() {
    }

    public Integer getCodRendimento() {
        return codRendimento;
    }

    public void setCodRendimento(Integer codRendimento) {
        this.codRendimento = codRendimento;
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

    public Integer getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codRendimento);
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
        final RendimentoSerie other = (RendimentoSerie) obj;
        if (!Objects.equals(this.codRendimento, other.codRendimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RendimentoSerie{" + "codRendimento=" + codRendimento + ", inep=" + inep + ", codSerie=" + codSerie + ", codDisciplina=" + codDisciplina + ", rendimento=" + rendimento + '}';
    }

    
    
    
}
