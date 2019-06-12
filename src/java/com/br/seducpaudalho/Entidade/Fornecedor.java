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
public class Fornecedor implements Serializable{
    
    private Integer idFornecedor;
    private String tPessoa;
    private String rzSocial;
    private String cnpj;
    private String cep;
    private String endereco;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String telefone1;
    private String telefone2;
    private String email;
    private String estadual;
    private String municipal;
    private String fantasia;
    private String pessoa;

    public Fornecedor(Integer idFornecedor, String tPessoa, String rzSocial, String cnpj, String cep, String endereco, String complemento, String numero, String bairro, String cidade, String estado, String pais, String telefone1, String telefone2, String email, String estadual, String municipal, String fantasia, String pessoa) {
        this.idFornecedor = idFornecedor;
        this.tPessoa = tPessoa;
        this.rzSocial = rzSocial;
        this.cnpj = cnpj;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.email = email;
        this.estadual = estadual;
        this.municipal = municipal;
        this.fantasia = fantasia;
        this.pessoa = pessoa;
    }

    public Fornecedor() {
        
    }
    
    
    
    

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String gettPessoa() {
        return tPessoa;
    }

    public void settPessoa(String tPessoa) {
        this.tPessoa = tPessoa;
    }

    public String getRzSocial() {
        return rzSocial;
    }

    public void setRzSocial(String rzSocial) {
        this.rzSocial = rzSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

  
  
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadual() {
        return estadual;
    }

    public void setEstadual(String estadual) {
        this.estadual = estadual;
    }

    public String getMunicipal() {
        return municipal;
    }

    public void setMunicipal(String municipal) {
        this.municipal = municipal;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idFornecedor);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.idFornecedor, other.idFornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "idFornecedor=" + idFornecedor + ", tPessoa=" + tPessoa + ", rzSocial=" + rzSocial + ", cnpj=" + cnpj + ", cep=" + cep + ", endereco=" + endereco + ", complemento=" + complemento + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", email=" + email + ", estadual=" + estadual + ", municipal=" + municipal + ", fantasia=" + fantasia + ", pessoa=" + pessoa + '}';
    }

   
    
    
    
}
