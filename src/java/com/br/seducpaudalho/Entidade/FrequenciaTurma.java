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
public class FrequenciaTurma {
    
    
    private Integer codFrequencia;
    private Integer codTurma;
    private Integer inep;
    private Integer codSerie;
    private double resultevasaoTurma;

    
    
    
    public FrequenciaTurma(Integer codFrequencia,Integer codTurma, Integer inep, Integer codSerie, double resultevasaoTurma) {
        this.codFrequencia = codFrequencia;
        this.codTurma = codTurma;
        this.inep = inep;
        this.codSerie = codSerie;
        this.resultevasaoTurma = resultevasaoTurma;
    }

    public FrequenciaTurma() {
    }

    public Integer getCodFrequencia() {
        return codFrequencia;
    }

    public void setCodFrequencia(Integer codFrequencia) {
        this.codFrequencia = codFrequencia;
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

    public double getResultevasaoTurma() {
        return resultevasaoTurma;
    }

    public void setResultevasaoTurma(double resultevasaoTurma) {
        this.resultevasaoTurma = resultevasaoTurma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final FrequenciaTurma other = (FrequenciaTurma) obj;
        if (!Objects.equals(this.inep, other.inep)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FrequenciaTurma{" + "codFrequencia=" + codFrequencia + ", codTurma=" + codTurma + ", inep=" + inep + ", codSerie=" + codSerie + ", resultevasaoTurma=" + resultevasaoTurma + '}';
    }

    
    
    
    
    
    
    
    
    
    
    
}
