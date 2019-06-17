package com.br.seducpaudalho.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.seducpaudalho.Entidade.Fornecedor;
import com.br.seducpaudalho.Dao.FornecedorDao;
import com.br.seducpaudalho.Dao.ProdutoDao;
import com.br.seducpaudalho.Entidade.Produto;
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
public class ProdutoBean {

    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();
    private ProdutoDao produtoDao = new ProdutoDao();

    private List<SelectItem> selectFornecedores;
    private Fornecedor fornecedor;
    private List<Fornecedor> fornecedores = new ArrayList<>();
    private FornecedorDao fornecedorDao = new FornecedorDao();
    private String parametro;

    public void salvar() {

        try {

            System.out.println("olha aqui o fornecedor "+produto.getIdFornecedor()+ " kilo "+produto.getKiloProduto()+ "Un "+ produto.getUnidadeProduto());
            if (produto.getNomeProduto().equals("")) {

                adicionarMensagem("O CAMPO DESCRIÇÃO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }
            if (produto.getMarcaProduto().equals("")) {

                adicionarMensagem("O MARCA É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }

            if (produto.getIdFornecedor() == null) {

                adicionarMensagem("O CAMPO FORNECEDOR É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }

            if (produto.getUnidadeProduto().equals("")) {

                adicionarMensagem("O CAMPO UNIDADE É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
           
            if (produto.getKiloProduto() == 0.0) {

                adicionarMensagem("O CAMPO KILO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (produto.getValorUnitario() == 0.0) {

                adicionarMensagem("O CAMPO VALOR UNITÁRIO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (produto.getValorTotal() == 0.0) {

                adicionarMensagem("O CAMPO VALOR TOTAL É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (produto.getEspecificacaoProduto().equals("")) {

                adicionarMensagem("O CAMPO ESPECIFICAÇÃO DO PRODUTO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            } else {

                System.out.println("entrou no salvar----------");
                produtoDao.salvar(produto);
                produto = new Produto();
                produtos = produtoDao.listarProdutos();

                adicionarMensagem("SALVO COM SUCESSO!", "", FacesMessage.SEVERITY_INFO);
           }
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

    public void excluir(Produto p) {
        System.out.println("com.br.seducpaudalho.Bean.ProdutoBean.excluir()" + p);
        try {
            produtoDao.deletar(p);
            produto = new Produto();
            produtos = produtoDao.listarProdutos();
            adicionarMensagem("EXCLUIDO!", "EXCLUIDO COM SUCESSO", FacesMessage.SEVERITY_INFO);
            
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }

    public void editar(Produto entidade) {
        this.produto = entidade;
        // mudarParaAltera(); 
    }

    public void listarProdutos() {

        System.out.println("entrou no metodo listar");
        try {
            produtos = produtoDao.listarProdutos();
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void listarFornecedores() {

        System.out.println("entrou no metodo listar");
        try {
            fornecedores = fornecedorDao.listarFornecedores();
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<SelectItem> getSelectFornecedores() throws ErroSistema {

        System.out.println("----------------------------------------------");
        if (selectFornecedores == null) {
            selectFornecedores = new ArrayList<SelectItem>();
            fornecedor = new Fornecedor();
            fornecedores = fornecedorDao.listarFornecedores();

            if (fornecedores != null && !fornecedores.isEmpty()) {

                SelectItem item;
                for (Fornecedor fornecedorLista : fornecedores) {

                    item = new SelectItem(fornecedorLista, fornecedorLista.getRzSocial());
                    selectFornecedores.add(item);
                }
            }

        }

        return selectFornecedores;
    }

    public Fornecedor getFornecedor() {
        System.out.println("com.br.seducpaudalho.Bean.ProdutoBean.getFornecedor()");
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getFornecedores() throws ErroSistema {
        fornecedores = fornecedorDao.listarFornecedores();
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public ProdutoDao getProdutoDao() {
        return produtoDao;
    }

    public void setProdutoDao(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    public FornecedorDao getFornecedorDao() {
        return fornecedorDao;
    }

    public void setFornecedorDao(FornecedorDao fornecedorDao) {
        this.fornecedorDao = fornecedorDao;
    }

}
