package com.br.seducpaudalho.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.seducpaudalho.Dao.AbastecimentoDao;

import com.br.seducpaudalho.Entidade.Abastecimento;

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
public class abastecimentoBean {

    private Abastecimento abastecimento = new Abastecimento();
    private List<Abastecimento> abastecimentos = new ArrayList<>();
    private AbastecimentoDao abastecimentoDao = new AbastecimentoDao();
    private List<SelectItem> selectAbastecimento;
    private String parametro;

    public void salvar() {

     
           try {
         
          if (abastecimento.getNumeroCartao().equals("")) {

                adicionarMensagem("O CAMPO NÚMERO DO CARTÃO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }

            if (abastecimento.getPlaca().equals("")) {

                adicionarMensagem("O CAMPO PLACA É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }
            

         

          
            if (abastecimento.getCombustivel().equals("")) {

                adicionarMensagem("O CAMPO TIPO DE COMBUSTIVEL É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            } 
            
              if (abastecimento.getData().equals("")) {

                adicionarMensagem("O CAMPO DATA É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }
               
              
                if (abastecimento.getLitro() == 0.0) {

                adicionarMensagem("O CAMPO LITRO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }
                if (abastecimento.getValorAbastecido() == 0.0) {

                adicionarMensagem("O CAMPO VALOR ABASTECIDO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }
            
               
            else {

                System.out.println("com.br.seducpaudalho.Bean.VeiculoBean.salvar()");
                abastecimentoDao.salvar(abastecimento);
                abastecimento = new Abastecimento();
               // abastecimentos = abastecimentoDao.listarAbastecimentos();

                adicionarMensagem("SALVO!", "SALVO COM SUCESSO", FacesMessage.SEVERITY_INFO);
           }
       } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

         
    }
    
    public void soma(){
    
        abastecimento.setPrecoLitro( abastecimento.getValorAbastecido() /abastecimento.getLitro() );
        
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

   /* public void excluir(Veiculo v) {
        System.out.println("com.br.seducpaudalho.Bean.FornecedorBean.excluir()" + v);
        try {
            abastecimentoDao.deletar(v);
            abastecimento = new Veiculo();
            abastecimentos = abastecimentoDao.listarVeiculos();
            adicionarMensagem("EXCLUIDO!", "EXCLUIDO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }*/

    public void editar(Abastecimento entidade) {
        this.abastecimento = entidade;
        // mudarParaAltera(); 
    }

    public void listarVeiculos() {

        System.out.println("entrou no metodo listar");
        try {
            abastecimentos = abastecimentoDao.listarAbastecimentos();
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

    public List<SelectItem> getSelectFornecedores() throws ErroSistema {
/*
        System.out.println("----------------------------------------------");
        if (selectVeiculos == null) {
            selectVeiculos = new ArrayList<SelectItem>();
            abastecimento = new Veiculo();
            abastecimentos = abastecimentoDao.listarVeiculos();

            if (abastecimentos != null && !abastecimentos.isEmpty()) {

                SelectItem item;
                for (Veiculo veiculoLista : abastecimentos) {

                    item = new SelectItem(veiculoLista, veiculoLista.getPlaca());
                    selectVeiculos.add(item);
                }
            }

        }
*/
       // return selectVeiculos;
        return null;
    }

    

   /* public List<SelectItem> getSelectVeiculos() throws ErroSistema {

        System.out.println("----------------------------------------------");
        if (selectVeiculos == null) {
            selectVeiculos = new ArrayList<SelectItem>();
            abastecimento = new Veiculo();
            abastecimentos = abastecimentoDao.listarVeiculos();

            if (abastecimentos != null && !abastecimentos.isEmpty()) {

                SelectItem item;
                for (Veiculo veiculoLista : abastecimentos) {

                    item = new SelectItem(veiculoLista, veiculoLista.getPlaca());
                    selectVeiculos.add(item);
                }
            }

        }

        return selectVeiculos;

    }

    public void setSelectVeiculos(List<SelectItem> selectVeiculos) {
        this.selectVeiculos = selectVeiculos;
    }*/

    public Abastecimento getAbastecimento() {
        return abastecimento;
    }

    public void setAbastecimento(Abastecimento abastecimento) {
        this.abastecimento = abastecimento;
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public void setAbastecimentos(List<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }

    public AbastecimentoDao getAbastecimentoDao() {
        return abastecimentoDao;
    }

    public void setAbastecimentoDao(AbastecimentoDao abastecimentoDao) {
        this.abastecimentoDao = abastecimentoDao;
    }

    public List<SelectItem> getSelectAbastecimento() {
        return selectAbastecimento;
    }

    public void setSelectAbastecimento(List<SelectItem> selectAbastecimento) {
        this.selectAbastecimento = selectAbastecimento;
    }
    
    
    

}
