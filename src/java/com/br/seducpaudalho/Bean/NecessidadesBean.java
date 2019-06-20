package com.br.seducpaudalho.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.br.seducpaudalho.Dao.NecessidadeDao;
import com.br.seducpaudalho.Entidade.Necessidade;
import com.br.seducpaudalho.Util.Excepition.ErroSistema;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VICTOR HUGO
 */
@ManagedBean
@SessionScoped
public class NecessidadesBean {

    private Necessidade necessidade = new Necessidade();
    private List<Necessidade> necessidades = new ArrayList<>();
    private NecessidadeDao necessidadeDao = new NecessidadeDao();

   
    private String parametro;

    public void salvar() {

        try {

           

                System.out.println("entrou no salvar----------");
                necessidadeDao.salvar(necessidade);
                necessidade = new Necessidade();
                //necessidades = necessidadeDao.listarProdutos();

                adicionarMensagem("SALVO COM SUCESSO!", "", FacesMessage.SEVERITY_INFO);
           
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

        // }
    }

    public void alterar() {
        /*
        try {
            loginDao.salvar(produto);
            produto = new Login();
            adicionarMensagem("SALVO!", "SALVO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
         */
    }

    public void excluir(NecessidadeDao n) {
        /*System.out.println("com.br.seducpaudalho.Bean.ProdutoBean.excluir()" + p);
        try {
            //necessidadeDao.deletar(n);
            necessidade = new Necessidade();
          //  necessidades = necessidadeDao.listarProdutos();
            adicionarMensagem("EXCLUIDO!", "EXCLUIDO COM SUCESSO", FacesMessage.SEVERITY_INFO);
            
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
*/
    }

    public void editar(NecessidadeDao entidade) {
       // this.necessidade = entidade;
        // mudarParaAltera(); 
    }

    public void listarProdutos() {

      /*  System.out.println("entrou no metodo listar");
        try {
            produtos = produtoDao.listarProdutos();
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }*/
    }

    public void listarFornecedores() {

      /*  System.out.println("entrou no metodo listar");
        try {
            fornecedores = fornecedorDao.listarFornecedores();
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }*/
    }

    public String buscarLogin() {
        /*
       
       String retorno = "";
        System.out.println("entrou no buscar login");
        try {

        
          
           produto = loginDao.buscarLoginN(produto);
           
           usuarioLogado = produto.getNome();
           usuarioCpf = produto.getCpf();

                   System.out.println("olha o nivel de acesso"+produto.getNivel());
                   
                   
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

                session.setAttribute("nome", produto.getNome());                          
                session.setAttribute("cpf", produto.getCpf());               
                session.setAttribute("nivelAcesso", produto.getNivel());               
                session.setAttribute("nivelAcesso", produto.getUrl());              
                session.setAttribute("login", produto);
                System.out.println("usuario logado" + produto.getNome());
            }
            
            if(produto.getNivel().equals("A")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/nutricao?faces-redirect=true";
            }
            if(produto.getNivel().equals("B")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/admgeral?faces-redirect=true";
            }
            if(produto.getNivel().equals("C")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/materiais?faces-redirect=true";
            }
            
            else{
                //System.out.println("entrou na pagina index");
                mudarParaUsuario();
           // retorno = "/index?faces-redirect=true";
            }
           
           produto = new Login();
           return retorno; 
          // return retorno; 
          
        }*/

        return null;
    }

    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    
}
