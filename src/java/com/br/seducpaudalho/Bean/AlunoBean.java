package com.br.seducpaudalho.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.seducpaudalho.Dao.AlunoDao;
import com.br.seducpaudalho.Dao.EscolaDao;
import com.br.seducpaudalho.Entidade.Fornecedor;
import com.br.seducpaudalho.Dao.FornecedorDao;
import com.br.seducpaudalho.Dao.ProdutoDao;
import com.br.seducpaudalho.Dao.SerieDao;
import com.br.seducpaudalho.Dao.TurmaDao;
import com.br.seducpaudalho.Entidade.Aluno;
import com.br.seducpaudalho.Entidade.Escola;
import com.br.seducpaudalho.Entidade.Serie;
import com.br.seducpaudalho.Entidade.Turma;

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
public class AlunoBean {

    private Aluno aluno = new Aluno();
    private List<Aluno> alunos = new ArrayList<>();
    private AlunoDao alunoDao = new AlunoDao();

    private List<SelectItem> selectEscolas;
    private Escola escola;
    private List<Escola> escolas = new ArrayList<>();
    private EscolaDao escolaDao = new EscolaDao();
    
    private List<SelectItem> selectSerie;
    private Serie serie;
    private List<Serie> series = new ArrayList<>();
    private SerieDao serieDao = new SerieDao();
    
    private List<SelectItem> selectTurma;
    private Turma turma;
    private List<Turma> turmas = new ArrayList<>();
    private TurmaDao turmaDao = new TurmaDao();
   
    private String parametro;
    

    public void salvar() {
/*
        try {

            System.out.println("olha aqui o escola " + aluno.getIdFornecedor() + " kilo " + aluno.getKiloProduto() + "Un " + aluno.getUnidadeProduto() + " olha o preço " + aluno.getValorTotal());

            if (aluno.getNomeProduto().equals("")) {

                adicionarMensagem("O CAMPO DESCRIÇÃO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }
            if (aluno.getMarcaProduto().equals("")) {

                adicionarMensagem("O MARCA É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }

            if (aluno.getIdFornecedor() == null) {

                adicionarMensagem("O CAMPO FORNECEDOR É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }

            if (aluno.getUnidadeProduto().equals("")) {

                adicionarMensagem("O CAMPO UNIDADE É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }

            if (aluno.getKiloProduto() == 0.0) {

                adicionarMensagem("O CAMPO KILO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (aluno.getValorUnitario() == 0.0) {

                adicionarMensagem("O CAMPO VALOR UNITÁRIO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (aluno.getValorTotal() == 0.0) {

                adicionarMensagem("O CAMPO VALOR TOTAL É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (aluno.getEspecificacaoProduto().equals("")) {

                adicionarMensagem("O CAMPO ESPECIFICAÇÃO DO PRODUTO É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            } else {

                System.out.println("entrou no salvar----------");
                alunoDao.salvar(aluno);
                aluno = new Produto();
                alunos = alunoDao.listarProdutos();

                adicionarMensagem("SALVO COM SUCESSO!", "", FacesMessage.SEVERITY_INFO);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }*/

        // }
    }

    public void alterar() {
        /*
        try {
            loginDao.salvar(aluno);
            aluno = new Login();
            adicionarMensagem("SALVO!", "SALVO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
         */
    }

    public void excluir(Aluno p) {
       /* System.out.println("com.br.seducpaudalho.Bean.ProdutoBean.excluir()" + p);
        try {
            alunoDao.deletar(p);
            aluno = new Produto();
            alunos = alunoDao.listarProdutos();
            adicionarMensagem("EXCLUIDO!", "EXCLUIDO COM SUCESSO", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }*/

    }

    public void editar(Aluno entidade) {
        this.aluno = entidade;
        // mudarParaAltera(); 
    }

    public void listarAlunos() {

        System.out.println("entrou no metodo listar");
        try {
            alunos = alunoDao.listarAlunos();
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    public void listarSerieParametro(Integer codigo) {

        System.out.println("--------****----***----***------- " + codigo);
        try {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx " );
            series = serieDao.listarSerieParametro(codigo);
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    public void listarTurmasParametro(Integer codigo) {

        System.out.println("olha o codigo --------****----***----***------- " + codigo);
        try {
            turmas = turmaDao.listarTurmaParametro(codigo);
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    public void imprimirAlunos(Integer codTurma,Integer inep,Integer codSerie) {

        System.out.println("olha o codigo --------"+codTurma+"****----***"+inep+"----***------- " + codSerie);
        try {
            alunos = alunoDao.imprimirAlunos(codTurma, inep,codSerie);
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void listarFornecedores() {

      /*  System.out.println("entrou no metodo listar");
        try {
            escolas = escolaDao.listarFornecedores();
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

        
          
           aluno = loginDao.buscarLoginN(aluno);
           
           usuarioLogado = aluno.getNome();
           usuarioCpf = aluno.getCpf();

                   System.out.println("olha o nivel de acesso"+aluno.getNivel());
                   
                   
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

                session.setAttribute("nome", aluno.getNome());                          
                session.setAttribute("cpf", aluno.getCpf());               
                session.setAttribute("nivelAcesso", aluno.getNivel());               
                session.setAttribute("nivelAcesso", aluno.getUrl());              
                session.setAttribute("login", aluno);
                System.out.println("usuario logado" + aluno.getNome());
            }
            
            if(aluno.getNivel().equals("A")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/nutricao?faces-redirect=true";
            }
            if(aluno.getNivel().equals("B")){
           // System.out.println("entrou na pagina de administrador");
            //mudarParaAdmin();
           // mudarParaLocalidade();
            retorno = "/admgeral?faces-redirect=true";
            }
            if(aluno.getNivel().equals("C")){
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
           
           aluno = new Login();
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

       

        return selectEscolas;
    }

    public List<SelectItem> getSelectEscolas() throws ErroSistema {
       
        
        System.out.println("----------------------------------------------");
        if (selectEscolas == null) {
            selectEscolas = new ArrayList<SelectItem>();
            escola = new Escola();
            escolas = escolaDao.listarEscolas();

            if (escolas != null && !escolas.isEmpty()) {

                SelectItem item;
                for (Escola escolaLista : escolas) {

                    item = new SelectItem(escolaLista, escolaLista.getNome());
                    selectEscolas.add(item);
                }
            }

        }
        
        return selectEscolas;
    }

    public void setSelectEscolas(List<SelectItem> selectEscolas) {
        this.selectEscolas = selectEscolas;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public List<Escola> getEscolas() throws ErroSistema {
       escolas = escolaDao.listarEscolas();
        
        return escolas;
    }

    public void setEscolas(List<Escola> escolas) {
        this.escolas = escolas;
    }

    public EscolaDao getEscolaDao() {
        return escolaDao;
    }

    public void setEscolaDao(EscolaDao escolaDao) {
        this.escolaDao = escolaDao;
    }

   

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public AlunoDao getAlunoDao() {
        return alunoDao;
    }

    public void setAlunoDao(AlunoDao alunoDao) {
        this.alunoDao = alunoDao;
    }

    public List<SelectItem> getSelectSerie() throws ErroSistema {
        
     /* System.out.println("----------------------------------------------");
        if (selectSerie == null) {
            selectSerie = new ArrayList<SelectItem>();
            serie = new Serie();
            series = serieDao.listarSerieParametro(aluno.getInepEscola());

            if (series != null && !series.isEmpty()) {

                SelectItem item;
                for (Serie serieLista : series) {

                    item = new SelectItem(serieLista, serieLista.getNome());
                    selectSerie.add(item);
                }
            }

        }*/
        
        return selectSerie;
    }

    public void setSelectSerie(List<SelectItem> selectSerie) {
        this.selectSerie = selectSerie;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<Serie> getSeries() throws ErroSistema {
       // series = serieDao.listarSerieParametro(Integer.SIZE);
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public SerieDao getSerieDao() {
        return serieDao;
    }

    public void setSerieDao(SerieDao serieDao) {
        this.serieDao = serieDao;
    }

    public List<SelectItem> getSelectTurma() throws ErroSistema {
       
        /*  System.out.println("----------------------------------------------");
        if (selectTurma == null) {
            selectTurma = new ArrayList<SelectItem>();
            turma = new Turma();
            turmas = turmaDao.listarTurmaParametro(aluno.getInepEscola());

            if (turmas != null && !turmas.isEmpty()) {

                SelectItem item;
                for (Turma turmaLista : turmas) {

                    item = new SelectItem(turmaLista, turmaLista.getNome());
                    selectTurma.add(item);
                }
            }

        }*/
        
        return selectTurma;
    }

    public void setSelectTurma(List<SelectItem> selectTurma) {
        this.selectTurma = selectTurma;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public TurmaDao getTurmaDao() {
        return turmaDao;
    }

    public void setTurmaDao(TurmaDao turmaDao) {
        this.turmaDao = turmaDao;
    }

   

}
