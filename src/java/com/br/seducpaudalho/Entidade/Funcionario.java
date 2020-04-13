/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Entidade;

import java.util.Date;

/**
 *
 * @author SEC-EDUC02
 */
public class Funcionario {
    
    
    private int codFuncionario;
    private int codInep;
    
    private String nomeFuncionario;
    private String endereco;
    private String cidade;
    private String telefone;
    private String cpf;
    private String rg;
    private String email;
    private String cargo;
    private String funcao;
    private Date dataNascimento;
    private Date dataAdmissao;

    public Funcionario(int codFuncionario, int codInep, String nomeFuncionario, String endereco, String cidade, String telefone, String cpf, String rg, String email, String cargo, String funcao, Date dataNascimento, Date dataAdmissao) {
        this.codFuncionario = codFuncionario;
        this.codInep = codInep;
        this.nomeFuncionario = nomeFuncionario;
        this.endereco = endereco;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.cargo = cargo;
        this.funcao = funcao;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
    }

    public Funcionario() {
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getCodInep() {
        return codInep;
    }

    public void setCodInep(int codInep) {
        this.codInep = codInep;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codFuncionario;
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
        final Funcionario other = (Funcionario) obj;
        if (this.codFuncionario != other.codFuncionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "codFuncionario=" + codFuncionario + ", codInep=" + codInep + ", nomeFuncionario=" + nomeFuncionario + ", endereco=" + endereco + ", cidade=" + cidade + ", telefone=" + telefone + ", cpf=" + cpf + ", rg=" + rg + ", email=" + email + ", cargo=" + cargo + ", funcao=" + funcao + ", dataNascimento=" + dataNascimento + ", dataAdmissao=" + dataAdmissao + '}';
    }
    
    
    
    
}
