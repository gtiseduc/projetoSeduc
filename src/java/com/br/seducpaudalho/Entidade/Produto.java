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
public class Produto implements Serializable {
    
    private Integer idProduto;
    private Integer idFornecedor;
    private String nomeProduto;
    private String marcaProduto;
    private String especificacaoProduto;
    private String unidadeProduto;
    private double kiloProduto;
    private double valorUnitario;
    private double valorTotal;

    public Produto(Integer idProduto, Integer idFornecedor, String nomeProduto, String marcaProduto, String especificacaoProduto, String unidadeProduto, double kiloProduto, double valorUnitario, double valorTotal) {
        this.idProduto = idProduto;
        this.idFornecedor = idFornecedor;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.especificacaoProduto = especificacaoProduto;
        this.unidadeProduto = unidadeProduto;
        this.kiloProduto = kiloProduto;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    
    
    public Produto() {
    }

    
    
    
    
    
    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getEspecificacaoProduto() {
        return especificacaoProduto;
    }

    public void setEspecificacaoProduto(String especificacaoProduto) {
        this.especificacaoProduto = especificacaoProduto;
    }

   

    public String getUnidadeProduto() {
        return unidadeProduto;
    }

    public void setUnidadeProduto(String unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    public double getKiloProduto() {
        return kiloProduto;
    }

    public void setKiloProduto(double kiloProduto) {
        this.kiloProduto = kiloProduto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.idProduto);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.idProduto, other.idProduto)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Produto{" + "idProduto=" + idProduto + ", idFornecedor=" + idFornecedor + ", nomeProduto=" + nomeProduto + ", marcaProduto=" + marcaProduto + ", especificacaoProduto=" + especificacaoProduto + ", unidadeProduto=" + unidadeProduto + ", kiloProduto=" + kiloProduto + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + '}';
    }

   

    
    
    
    
}
