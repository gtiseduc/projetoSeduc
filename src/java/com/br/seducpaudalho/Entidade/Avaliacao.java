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
public class Avaliacao implements Serializable{
    
    private Integer idAvaliacao;
    private Integer codAluno;
    private Integer codTurma;
    private Integer codSerie;
    private Integer inepEscola;
    
    private String respPortugues;
    private String respMatematica;
    private String respCienciasHumanas;
    private String respCienciasNatureza;
    private String nomeAluno;
    private double numeroAcertos;
    
    private String disciplina;
    private String avDisciplina;

    public Avaliacao(Integer idAvaliacao, Integer codAluno, Integer codTurma, Integer codSerie, Integer inepEscola, String respPortugues, String respMatematica, String respCienciasHumanas, String respCienciasNatureza) {
        this.idAvaliacao = idAvaliacao;
        this.codAluno = codAluno;
        this.codTurma = codTurma;
        this.codSerie = codSerie;
        this.inepEscola = inepEscola;
        this.respPortugues = respPortugues;
        this.respMatematica = respMatematica;
        this.respCienciasHumanas = respCienciasHumanas;
        this.respCienciasNatureza = respCienciasNatureza;
    }

    public Avaliacao() {
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Integer getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(Integer codAluno) {
        this.codAluno = codAluno;
    }

    public Integer getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(Integer codTurma) {
        this.codTurma = codTurma;
    }

    public Integer getCodSerie() {
        return codSerie;
    }

    public void setCodSerie(Integer codSerie) {
        this.codSerie = codSerie;
    }

    public Integer getInepEscola() {
        return inepEscola;
    }

    public void setInepEscola(Integer inepEscola) {
        this.inepEscola = inepEscola;
    }

    public String getRespPortugues() {
        return respPortugues;
    }

    public void setRespPortugues(String respPortugues) {
        this.respPortugues = respPortugues;
    }

    public String getRespMatematica() {
        return respMatematica;
    }

    public void setRespMatematica(String respMatematica) {
        this.respMatematica = respMatematica;
    }

    public String getRespCienciasHumanas() {
        return respCienciasHumanas;
    }

    public void setRespCienciasHumanas(String respCienciasHumanas) {
        this.respCienciasHumanas = respCienciasHumanas;
    }

    public String getRespCienciasNatureza() {
        return respCienciasNatureza;
    }

    public void setRespCienciasNatureza(String respCienciasNatureza) {
        this.respCienciasNatureza = respCienciasNatureza;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public double getNumeroAcertos() {
        return numeroAcertos;
    }

    public void setNumeroAcertos(double numeroAcertos) {
        this.numeroAcertos = numeroAcertos;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getAvDisciplina() {
        return avDisciplina;
    }

    public void setAvDisciplina(String avDisciplina) {
        this.avDisciplina = avDisciplina;
    }

   
    
    
    
    
    
    
}
