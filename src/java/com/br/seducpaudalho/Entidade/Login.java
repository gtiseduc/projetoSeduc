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
    private String novaSenha;
    private String mensagem;
    private String nivel;
    private String url;
    private String instituicao;
    private String email;
    
    private static final Logger LOG = Logger.getLogger(Login.class.getName());

    public Login() {
    }

    public Login(Integer idLogin, String nome, String cpf, String senha, String novaSenha, String mensagem, String nivel, String url, String instituicao, String email) {
        this.idLogin = idLogin;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.novaSenha = novaSenha;
        this.mensagem = mensagem;
        this.nivel = nivel;
        this.url = url;
        this.instituicao = instituicao;
        this.email = email;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cpf);
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
        return "Login{" + "idLogin=" + idLogin + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", novaSenha=" + novaSenha + ", mensagem=" + mensagem + ", nivel=" + nivel + ", url=" + url + ", instituicao=" + instituicao + ", email=" + email + '}';
    }

    

    
   
}
