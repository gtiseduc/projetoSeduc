package com.br.seducpaudalho.Entidade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.seducpaudalho.Util.LoginUtil;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author VICTOR HUGO
 */
@ManagedBean
public class Login {

    private Integer idLogin;
    private String nome;
    private String cpf;
    private String senha;
    private String mensagem;
    private String nivel;
    private String url;
    private static final Logger LOG = Logger.getLogger(Login.class.getName());

    public Login() {

    }

    public Login(String nome, String cpf, String senha, String localidade, String mensagem, String nivel) {

        this.nome = nome;
        this.cpf = cpf;
        this.senha = new LoginUtil().MD5(senha);

        this.mensagem = mensagem;
    }

    public void exibir() {

        mensagem = cpf + "" + senha;

    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.cpf);
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
        final Login other = (Login) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {

        return "Login{" + "nome=" + nome + '}';
    }

}
