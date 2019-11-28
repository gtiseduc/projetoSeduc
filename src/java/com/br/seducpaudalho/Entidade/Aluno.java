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
public class Aluno {
    
    private Integer idAluno;
    private Integer codInep;
    private Integer inepEscola;
    private Integer idSerie;
    private Integer idTurma;
    
    private String nome;
    private String nomeEscola;
    private String nomeSerie;
    private String nomeTurma;
    private String turno;
    private String portugues;
    private String matematica;
    private String cienciasHumanas;
    private String cienciasNatureza;
    private String dataNascimento;
    private String nomePai;
    private String nomeMae;
    private String nomeResponsavel;
    private String anoCadastro;
    private String instituicao;

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getInepEscola() {
        return inepEscola;
    }

    public void setInepEscola(Integer inepEscola) {
        this.inepEscola = inepEscola;
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getNomeSerie() {
        return nomeSerie;
    }

    public void setNomeSerie(String nomeSerie) {
        this.nomeSerie = nomeSerie;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getPortugues() {
        return portugues;
    }

    public void setPortugues(String portugues) {
        this.portugues = portugues;
    }

    public String getMatematica() {
        return matematica;
    }

    public void setMatematica(String matematica) {
        this.matematica = matematica;
    }

    public String getCienciasHumanas() {
        return cienciasHumanas;
    }

    public void setCienciasHumanas(String cienciasHumanas) {
        this.cienciasHumanas = cienciasHumanas;
    }

    public String getCienciasNatureza() {
        return cienciasNatureza;
    }

    public void setCienciasNatureza(String cienciasNatureza) {
        this.cienciasNatureza = cienciasNatureza;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Integer getCodInep() {
        return codInep;
    }

    public void setCodInep(Integer codInep) {
        this.codInep = codInep;
    }

    public String getAnoCadastro() {
        return anoCadastro;
    }

    public void setAnoCadastro(String anoCadastro) {
        this.anoCadastro = anoCadastro;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.idAluno);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.idAluno, other.idAluno)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
