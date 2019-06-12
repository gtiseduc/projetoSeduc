package com.br.seducpaudalho.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





import com.br.seducpaudalho.Entidade.Fornecedor;
import com.br.seducpaudalho.Dao.FornecedorDao;
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
public class FornecedorBean {

    private Fornecedor fornecedor = new Fornecedor();
    private List<Fornecedor> fornecedores = new ArrayList<>();
    
    private FornecedorDao fornecedorDao = new FornecedorDao();
    private List<SelectItem> selectFornecedores;
    private String parametro;
   
    
    
   
    public void salvar() {

       
         try {    
          
/*
           

            if (fornecedor.getNome().equals("")) {

                adicionarMensagem("O CAMPO NOME É OBRIGATÓRIO !","", FacesMessage.SEVERITY_WARN);
                return;

            }
            if (fornecedor.getCpf().equals("")) {

                adicionarMensagem("O CAMPO CPF É OBRIGATÓRIO !","", FacesMessage.SEVERITY_WARN);
                return;

            }

            if (fornecedor.getSenha().equals("")) {

                adicionarMensagem("O CAMPO SENHA É OBRIGATÓRIO !","", FacesMessage.SEVERITY_WARN);
                return;

            }
           
            if (fornecedor.getNivel().equals("")) {

                adicionarMensagem("O CAMPO ACESSO É OBRIGATÓRIO !","", FacesMessage.SEVERITY_WARN);
               
                
                return;

            }
            else{*/

            
        fornecedorDao.salvar(fornecedor);
        fornecedor = new Fornecedor();
         fornecedores = fornecedorDao.listarFornecedores();
            
        adicionarMensagem("SALVO!", "SALVO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
             adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
            
            
           // }
      
    }
    public void alterar() {
/*
        try {
            loginDao.salvar(fornecedor);
            fornecedor = new Login();
            adicionarMensagem("SALVO!", "SALVO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
*/
    }
    public void excluir(Fornecedor f) {
        System.out.println("com.br.seducpaudalho.Bean.FornecedorBean.excluir()" + f);
        try {
            fornecedorDao.deletar(f);
            fornecedor = new Fornecedor();
            adicionarMensagem("EXCLUIDO!", "EXCLUIDO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
 
    }

    
    

    
    
    
     public void editar(Fornecedor entidade) {
        this.fornecedor = entidade;
       // mudarParaAltera(); 
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

        
          
           fornecedor = loginDao.buscarLoginN(fornecedor);
           
           usuarioLogado = fornecedor.getNome();
           usuarioCpf = fornecedor.getCpf();

                   System.out.println("olha o nivel de acesso"+fornecedor.getNivel());
                   
                   
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

                session.setAttribute("nome", fornecedor.getNome());                          
                session.setAttribute("cpf", fornecedor.getCpf());               
                session.setAttribute("nivelAcesso", fornecedor.getNivel());               
                session.setAttribute("nivelAcesso", fornecedor.getUrl());              
                session.setAttribute("login", fornecedor);
                System.out.println("usuario logado" + fornecedor.getNome());
            }
            
            if(fornecedor.getNivel().equals("A")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/nutricao?faces-redirect=true";
            }
            if(fornecedor.getNivel().equals("B")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/admgeral?faces-redirect=true";
            }
            if(fornecedor.getNivel().equals("C")){
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
           
           fornecedor = new Login();
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<SelectItem> getSelectFornecedores() throws ErroSistema {
      
        System.out.println("----------------------------------------------");
        if(selectFornecedores == null){
            selectFornecedores = new ArrayList<SelectItem>();
            fornecedor = new Fornecedor();
            fornecedores = fornecedorDao.listarFornecedores();
            
            if(fornecedores != null && !fornecedores.isEmpty()){
                
                SelectItem item;
                for (Fornecedor fornecedorLista : fornecedores) {
                   
                    item = new SelectItem(fornecedorLista,fornecedorLista.getRzSocial());
                    selectFornecedores.add(item);
                }
            }
            
        }
       
       return selectFornecedores;
    }

   

      
    

    
}
