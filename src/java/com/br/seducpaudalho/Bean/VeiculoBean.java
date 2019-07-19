package com.br.seducpaudalho.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.seducpaudalho.Dao.VeiculoDao;
import com.br.seducpaudalho.Entidade.Veiculo;
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
public class VeiculoBean {

    private Veiculo veiculo = new Veiculo();
    private List<Veiculo> veiculos = new ArrayList<>();
    private VeiculoDao veiculoDao = new VeiculoDao();
    private List<SelectItem> selectVeiculos;
    private String parametro;

    public void salvar() {

        try {

            if (veiculo.getPlaca().equals("")) {

                adicionarMensagem("O CAMPO PLACA É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }
            if (veiculo.getDescricao().equals("")) {

                adicionarMensagem("O CAMPO DESCRIÇÃO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }

            if (veiculo.getResponsavel().equals("")) {

                adicionarMensagem("O CAMPO RESPONSÁVEL É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }

            if (veiculo.getTelefone1().equals("") && veiculo.getTelefone2().equals("")) {

                adicionarMensagem("VOCÊ TEM QUE CADASTRAR UM TELEFONE!", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (veiculo.getSecretaria().equals("")) {

                adicionarMensagem("O CAMPO SECRETARIA É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            } else {

                System.out.println("com.br.seducpaudalho.Bean.VeiculoBean.salvar()");
                veiculoDao.salvar(veiculo);
                veiculo = new Veiculo();
                veiculos = veiculoDao.listarVeiculos();

                adicionarMensagem("SALVO!", "SALVO COM SUCESSO", FacesMessage.SEVERITY_INFO);
            }
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

    public void excluir(Veiculo v) {
        System.out.println("com.br.seducpaudalho.Bean.FornecedorBean.excluir()" + v);
        try {
            veiculoDao.deletar(v);
            veiculo = new Veiculo();
            veiculos = veiculoDao.listarVeiculos();
            adicionarMensagem("EXCLUIDO!", "EXCLUIDO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }

    public void editar(Veiculo entidade) {
        this.veiculo = entidade;
        // mudarParaAltera(); 
    }

    public void listarVeiculos() {

        System.out.println("entrou no metodo listar");
        try {
            veiculos = veiculoDao.listarVeiculos();
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

        System.out.println("----------------------------------------------");
        if (selectVeiculos == null) {
            selectVeiculos = new ArrayList<SelectItem>();
            veiculo = new Veiculo();
            veiculos = veiculoDao.listarVeiculos();

            if (veiculos != null && !veiculos.isEmpty()) {

                SelectItem item;
                for (Veiculo veiculoLista : veiculos) {

                    item = new SelectItem(veiculoLista, veiculoLista.getPlaca());
                    selectVeiculos.add(item);
                }
            }

        }

        return selectVeiculos;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Veiculo> getVeiculos() throws ErroSistema {
        veiculos =  veiculoDao.listarVeiculos();
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public VeiculoDao getVeiculoDao() {
        return veiculoDao;
    }

    public void setVeiculoDao(VeiculoDao veiculoDao) {
        this.veiculoDao = veiculoDao;
    }

    public List<SelectItem> getSelectVeiculos() throws ErroSistema {
        
         System.out.println("----------------------------------------------");
        if (selectVeiculos == null) {
            selectVeiculos = new ArrayList<SelectItem>();
            veiculo = new Veiculo();
            veiculos = veiculoDao.listarVeiculos();

            if (veiculos != null && !veiculos.isEmpty()) {

                SelectItem item;
                for (Veiculo veiculoLista : veiculos) {

                    item = new SelectItem(veiculoLista, veiculoLista.getPlaca());
                    selectVeiculos.add(item);
                }
            }

        }

        return selectVeiculos;
        
       
    }

    public void setSelectVeiculos(List<SelectItem> selectVeiculos) {
        this.selectVeiculos = selectVeiculos;
    }

}
