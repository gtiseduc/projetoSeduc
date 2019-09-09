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
public class Associacao {
    
    
    private Integer codAssociacao;
    private Integer codSerie;
    private Integer codDisciplina;
    private Integer numeroQuestoes;
    
    
    private String descritor;
    private String questao;
    private String alternativa;

    public Associacao(Integer codAssociacao, Integer codSerie, Integer codDisciplina, String descritor, String questao, String alternativa) {
        this.codAssociacao = codAssociacao;
        this.codSerie = codSerie;
        this.codDisciplina = codDisciplina;
        this.descritor = descritor;
        this.questao = questao;
        this.alternativa = alternativa;
    }

    public Associacao() {
    }

    public Integer getCodAssociacao() {
        return codAssociacao;
    }

    public void setCodAssociacao(Integer codAssociacao) {
        this.codAssociacao = codAssociacao;
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

    public String getDescritor() {
        return descritor;
    }

    public void setDescritor(String descritor) {
        this.descritor = descritor;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public Integer getNumeroQuestoes() {
        return numeroQuestoes;
    }

    public void setNumeroQuestoes(Integer numeroQuestoes) {
        this.numeroQuestoes = numeroQuestoes;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.codAssociacao);
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
        final Associacao other = (Associacao) obj;
        if (!Objects.equals(this.codAssociacao, other.codAssociacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Associacao{" + "codAssociacao=" + codAssociacao + ", codSerie=" + codSerie + ", codDisciplina=" + codDisciplina + ", descritor=" + descritor + ", questao=" + questao + ", alternativa=" + alternativa + '}';
    }
    
    
    
    
    
}
