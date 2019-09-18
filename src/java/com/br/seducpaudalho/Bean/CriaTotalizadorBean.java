/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Bean;

import com.br.seducpaudalho.Entidade.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author SEC-EDUC02
 */
@ManagedBean
@SessionScoped
public class CriaTotalizadorBean {

    private List<String> colunas = new ArrayList<String>();
    private List<String> operacoes = new ArrayList<String>();
    private List<Aluno> alunos = new ArrayList<>();

    public CriaTotalizadorBean() {

        Aluno a = new Aluno();
        a.setIdAluno(1);
        a.setNome("VICTOR");
        a.setNomeSerie("1º ANO");
        a.setIdSerie(20);
        alunos.add(a);
        Aluno aa = new Aluno();
        aa.setIdAluno(2);
        aa.setNome("MARCOS");
        aa.setNomeSerie("1º ANO");
         aa.setIdSerie(30);
        alunos.add(aa);
        Aluno aaa = new Aluno();
        aaa.setIdAluno(3);
        aaa.setNome("FERNANDO");
        aaa.setNomeSerie("1º ANO");
         aaa.setIdSerie(29);
        alunos.add(aaa);
        Aluno aaaa = new Aluno();
        aaaa.setIdAluno(4);
        aaaa.setNome("GABRIELA");
        aaaa.setNomeSerie("1º ANO");
         aaaa.setIdSerie(45);
        alunos.add(aaaa);

        /*colunas.add("coluna1");
        colunas.add("coluna2");
        colunas.add("coluna3");
        colunas.add("coluna4");

        operacoes.add("op1");
        operacoes.add("op2");
        operacoes.add("op3");
        operacoes.add("op4");
        operacoes.add("op5");
        operacoes.add("op6");*/
    }

    public List<String> getColunas() {
        return colunas;
    }

    public void setColunas(List<String> colunas) {
        this.colunas = colunas;
    }

    public List<String> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<String> operacoes) {
        this.operacoes = operacoes;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

}
