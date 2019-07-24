package com.br.seducpaudalho.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.br.seducpaudalho.Entidade.Login;
import com.br.seducpaudalho.Dao.LoginDao;

import com.br.seducpaudalho.Util.Excepition.ErroSistema;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VICTOR HUGO
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private Login login = new Login();
    private List<Login> logins = new ArrayList<>();
    //private Auditoria auditoria = new Auditoria();
    //private List<Auditoria> auditorias = new ArrayList<>();
    private String usuarioLogado;
    private String usuarioCpf;
    private String usuarioLocalidade;
    private LoginDao loginDao = new LoginDao();
    private String estadoTela = "usuario";
    private String estadoLocalidade = "local";
    private String parametro;
   
    
    
    public void adicionar() {

      /*  try {
            
          

           

            if (login.getNome().equals("")) {

                adicionarMensagem("O CAMPO NOME É OBRIGATÓRIO !","", FacesMessage.SEVERITY_WARN);
                return;

            }
            if (login.getCpf().equals("")) {

                adicionarMensagem("O CAMPO CPF É OBRIGATÓRIO !","", FacesMessage.SEVERITY_WARN);
                return;

            }

            if (login.getSenha().equals("")) {

                adicionarMensagem("O CAMPO SENHA É OBRIGATÓRIO !","", FacesMessage.SEVERITY_WARN);
                return;

            }
           
            if (login.getNivel().equals("")) {

                adicionarMensagem("O CAMPO ACESSO É OBRIGATÓRIO !","", FacesMessage.SEVERITY_WARN);
               
                
                return;

            }
            else{
            loginDao.salvar(login);
            login = new Login();
            adicionarMensagem("SALVO!", "SALVO COM SUCESSO", FacesMessage.SEVERITY_INFO);
            
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
*/
    }
    public void alterar() {
/*
        try {
            loginDao.salvar(login);
            login = new Login();
            adicionarMensagem("SALVO!", "SALVO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
*/
    }
    public void excluir(Login l) {
/*
        try {
            loginDao.deletar(l);
            login = new Login();
            adicionarMensagem("EXCLUIDO!", "EXCLUIDO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
 */
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

  /*  public List<Auditoria> getAuditorias() {
        return auditorias;
    }

    public void setAuditorias(List<Auditoria> auditorias) {
        this.auditorias = auditorias;
    }*/

    
    
    
     public void editar(Login entidade) {
        this.login = entidade;
       // mudarParaAltera(); 
    }
    public void listar() {
       
        /* System.out.println("entrou no metodo listar");
        try {
            logins = loginDao.buscar();
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }*/
    }
    public void listarF(String parametro) {
       /* try {
            logins = loginDao.buscarF(parametro);
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }*/
    }
   /* public void listarA(String parametro) {
        try {
            auditorias = loginDao.buscarAuditoria(parametro);
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }*/

    public String buscarLogin() {

       
       String retorno = "";
        System.out.println("entrou no buscar login");
        try {

        
          
           login = loginDao.buscarLoginN(login);
           
           usuarioLogado = login.getNome();
           usuarioCpf = login.getCpf();

                   System.out.println("olha o nivel de acesso"+login.getNivel());
                   
                   
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
       

        if (usuarioLogado == null) {
            System.out.println("usuario nulo");
            adicionarMensagem("ACESSO NÃO AUTORIZADO TENTE NOVAMENTE!", "USUARIO OU SENHA INVALIDA", FacesMessage.SEVERITY_INFO);
             
            return null;
        } else {
          
           
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
           
            if (session != null) {

                session.setAttribute("nome", login.getNome());                          
                session.setAttribute("cpf", login.getCpf());               
                session.setAttribute("nivelAcesso", login.getNivel());               
                session.setAttribute("url", login.getUrl());              
                session.setAttribute("instituicao", login.getInstituicao());              
                session.setAttribute("login", login);
                System.out.println("usuario logado" + login.getNome());
            }
            
            if(login.getNivel().equals("A")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/nutricao?faces-redirect=true";
            }
            if(login.getNivel().equals("B")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/admgeral?faces-redirect=true";
            }
            if(login.getNivel().equals("C")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/gNecessidades?faces-redirect=true";
            }
            if(login.getNivel().equals("D")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/monitoramento?faces-redirect=true";
            }
              if(login.getNivel().equals("E")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/nEscola?faces-redirect=true";
            }
            
            else{
                //System.out.println("entrou na pagina index");
                mudarParaUsuario();
           // retorno = "/index?faces-redirect=true";
            }
           
           login = new Login();
           return retorno; 
          // return retorno; 
          
        }
    
    
    }

    public String logOff() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "/login?faces-redirect=true";
    }

    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    
    
    
    

    
    
    public boolean isAdmin() {
        return "admin".equals(estadoTela);
       
    }

    public void mudarParaAdmin() {
        estadoTela = "admin";
      System.out.println("entrou no mudar para admin");
    }
    public boolean isUse() {
        return "usuario".equals(estadoTela);
       
    }

    public void mudarParaUsuario() {
        estadoTela = "usuario";
      System.out.println("entrou no mudar para usuario");
    }
    
    
     public boolean isInseri() {
        return "inserir".equals(estadoTela);
    }

    public boolean isEdita() {
        return "editar".equals(estadoTela);
    }

    public boolean isBusca() {
        return "buscar".equals(estadoTela);
    }

    public boolean isSalve() {
        return "salve".equals(estadoTela);
    }

    public void mudarParaSalve() {
        estadoTela = "salve";
    }

    public boolean isAltera() {
        return "altera".equals(estadoTela);
    }

    public void mudarParaAltera() {
        estadoTela = "altera";
    }

    public void mudarParaInseri() {
        estadoTela = "inserir";
    }

    public void mudarParaEdita() {
        estadoTela = "editar";
    }

    public void mudarParaBusca() {
        estadoTela = "buscar";
    }
    
     public boolean isLocalidade() {
        return "localidade".equals(estadoLocalidade);
    }
    
     public void mudarParaLocalidade() {
        estadoLocalidade = "localidade";
    }
}
