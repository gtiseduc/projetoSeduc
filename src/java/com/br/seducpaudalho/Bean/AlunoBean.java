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
import com.br.seducpaudalho.Entidade.Associacao;
import com.br.seducpaudalho.Entidade.Avaliacao;
import com.br.seducpaudalho.Entidade.Correcao;
import com.br.seducpaudalho.Entidade.Descritor;
import com.br.seducpaudalho.Entidade.Disciplina;
import com.br.seducpaudalho.Entidade.Escola;
import com.br.seducpaudalho.Entidade.Serie;
import com.br.seducpaudalho.Entidade.Turma;

import com.br.seducpaudalho.Util.Excepition.ErroSistema;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;

import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author VICTOR HUGO
 */
@ManagedBean
@SessionScoped
public class AlunoBean {

    private Aluno aluno = new Aluno();
    private List<Aluno> alunos = new ArrayList<>();
    private Correcao correcao = new Correcao();
    private List<Correcao> correcoes = new ArrayList<>();
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

    private List<SelectItem> selectDisciplina;
    private Disciplina disciplina = new Disciplina();
    private List<Disciplina> disciplinas = new ArrayList<>();
    //private DisciplinaDao disciplinaDao = new DisciplinaDao();

    private Avaliacao avaliacao = new Avaliacao();
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    //private DisciplinaDao disciplinaDao = new DisciplinaDao();
    List<Avaliacao> resul = new ArrayList<>();
    List<String> descri = new ArrayList<>();
    private String parametro;

    private List<SelectItem> selectDescritor;
    private Descritor descritor = new Descritor();
    private Descritor resultDescritor = new Descritor();
    List<Descritor> descritores = new ArrayList<>();

    private Associacao associacao = new Associacao();
    List<Associacao> questoes = new ArrayList<>();

    private BarChartModel barra;
    private HorizontalBarChartModel barraHorizontal;
    private HorizontalBarChartModel horizontalBarAluno;
    private LineChartModel barraLinha;
    private String concatDescritor = "";
    private List<String> colunas = new ArrayList<String>();

    String[][] dados;
    private List<String> resultdescritores = new ArrayList<String>();
    private List<String> resulAlunos = new ArrayList<String>();

    private Integer quantlunos = 0;
    private Integer quantDescritores = 0;
    private Integer quantQuest = 0;
    private Integer quantAcerto = 0;
    private Integer quantPresentes = 0;
    private Integer ca = 0;
    private Integer cp = 0;
    private double resultevasaoTurma = 0;
    private double resulPreseTurma = 0;
    private double quantFaltosos = 0;
    private BarChartModel barChartModel;
    private HorizontalBarChartModel horizontalBarModel;
    private HorizontalBarChartModel horizontalEvasao;
    private HorizontalBarChartModel horizontalRendimento;

    private LineChartModel lineModel;

    private boolean visivel = false;

    public void limpar() {

        System.out.println("############## - entrou no metodo limpar()");
        aluno = new Aluno();
        alunos = new ArrayList<>();
        correcao = new Correcao();
        correcoes = new ArrayList<>();
        alunoDao = new AlunoDao();
        escolas = new ArrayList<>();
        escolaDao = new EscolaDao();
        series = new ArrayList<>();
        serieDao = new SerieDao();
        turmas = new ArrayList<>();
        turmaDao = new TurmaDao();
        disciplina = new Disciplina();
        disciplinas = new ArrayList<>();
        avaliacao = new Avaliacao();
        avaliacoes = new ArrayList<>();
        resul = new ArrayList<>();
        descri = new ArrayList<>();
        descritor = new Descritor();
        descritores = new ArrayList<>();
        associacao = new Associacao();
        questoes = new ArrayList<>();
        colunas = new ArrayList<String>();
        resultdescritores = new ArrayList<String>();
        resulAlunos = new ArrayList<String>();
        quantlunos = 0;
        quantDescritores = 0;
        quantQuest = 0;
        quantAcerto = 0;
        quantPresentes = 0;
        ca = 0;
        cp = 0;
        resultevasaoTurma = 0;
        resulPreseTurma = 0;
        quantFaltosos = 0;
        visivel = false;

        horizontalBarAluno = null;
        horizontalBarModel = null;
        horizontalEvasao = null;
        horizontalRendimento = null;
    }

    public void salvarAluno() throws ErroSistema {

        adicionarMensagem("VOCÊ NÃO TEM PERMISSÃO PARA REALIZAR O CADASTRAMENTO DE ALUNOS !", "", FacesMessage.SEVERITY_INFO);

        /*  try {

            if (aluno.getNome().equals("")) {

                adicionarMensagem("O CAMPO NOME É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }

            System.out.println("com.br.seducpaudalho.Bean.AlunoBean.salvarAluno() " + aluno.getIdSerie());

            if (aluno.getDataNascimento().equals("")) {

                adicionarMensagem("O CAMPO DATA É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);
                return;

            }

            if (aluno.getNomePai().equals("")) {

                adicionarMensagem("O NOME DO PAI É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (aluno.getNomeMae().equals("")) {

                adicionarMensagem("O NOME DA MÃE É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (aluno.getNomeResponsavel().equals("")) {

                adicionarMensagem("O NOME DO RESPONSÁVEL É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (aluno.getInepEscola() == null) {

                adicionarMensagem("A SÉRIE É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (aluno.getIdSerie() == null) {

                adicionarMensagem("A SÉRIE É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            }
            if (aluno.getIdTurma() == null) {

                adicionarMensagem("A SÉRIE É OBRIGATÓRIO !", "", FacesMessage.SEVERITY_INFO);

                return;

            } else {

                alunoDao.salvarAluno(aluno);

                adicionarMensagem("SALVO COM SUCESSO!", "", FacesMessage.SEVERITY_INFO);

                aluno = new Aluno();
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }*/
    }

    public void salvarDescritor() throws ErroSistema {

      //  adicionarMensagem("VOCÊ NÃO TEM PERMISSÃO PARA SALVAR DESCRITORES!", "", FacesMessage.SEVERITY_INFO);
        alunoDao.salvarDescritor(descritor);
        adicionarMensagem("SALVO COM SUCESSO!", "", FacesMessage.SEVERITY_INFO);

        descritor = new Descritor();
    }

    public void salvarGabarito(Aluno a) throws ErroSistema {
        adicionarMensagem("VOCÊ NÃO TEM PERMISSÃO PARA SALVAR GABARITO!", "", FacesMessage.SEVERITY_INFO);
        /*
        alunoDao.salvarGabarito(a);
        adicionarMensagem("SALVO COM SUCESSO!", "", FacesMessage.SEVERITY_INFO);
         */

    }

    public void salvarQuestoes() throws ErroSistema {
       // adicionarMensagem("VOCÊ NÃO TEM PERMISSÃO PARA SALVAR QUESTÕES!", "", FacesMessage.SEVERITY_INFO);
          System.out.println("XXXXXXXXX " + associacao.getCodSerie() + " - " + associacao.getCodDisciplina() + " - " + associacao.getNumeroQuestoes());

        alunoDao.salvarQuestao(associacao);
        adicionarMensagem("SALVO COM SUCESSO!", "", FacesMessage.SEVERITY_INFO);

        associacao = new Associacao();
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

    public void excluir(Aluno p) throws ErroSistema {
        System.out.println("com.br.seducpaudalho.Bean.ProdutoBean.excluir()" + p.getIdAluno());
        alunoDao.deletar(p);
        alunos = alunoDao.imprimirAlunos(p.getIdTurma(), p.getInepEscola(), p.getIdSerie());
        adicionarMensagem("EXCLUIDO!", "ALUNO EXCLUIDO COM SUCESSO", FacesMessage.SEVERITY_INFO);

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

    public void listarSeries() {

        System.out.println("--------****----***----***------- ");
        try {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ");
            series = serieDao.listarSerie();
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void teste() {

        colunas.add("coluna1");
        colunas.add("coluna2");
        colunas.add("coluna3");
        colunas.add("coluna4");
    }

    public void listarDescritores(Integer codSerie, Integer codDisciplina) {

        System.out.println("--------****----***----***------- " + codSerie + codDisciplina);
        try {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ");

            descritores = serieDao.listarDescritores(codSerie, codDisciplina);
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }

    public void listarDescritoresMatriz(Integer codSerie, Integer codDisciplina) {

        System.out.println("--------****----***----***------- " + codSerie + codDisciplina);
        try {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ");

            descritores = serieDao.listarDescritorMatriz(codSerie, codDisciplina);
            // adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }

    public void listarSerieParametro(Integer codigo) {

        System.out.println("--------****----***----***------- " + codigo);
        try {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ");
            series = serieDao.listarSerieParametro(codigo);
            disciplinas.clear();
            disciplinas = new ArrayList<>();
            turmas.clear();
            turmas = new ArrayList<>();
            // adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void listarSeries(Integer codigo) {

        series = new ArrayList<>();

        System.out.println("--------****----***----***------- " + codigo);
        try {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ");
            series = serieDao.listarSerieParametro(codigo);

            disciplinas = new ArrayList<>();
            // adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void listarTodasSerie() {

        series = new ArrayList<>();

        try {

            series = serieDao.listarTodasSerie();
            // adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void listarDisciplinasSerie(Integer codigo) {

        System.out.println("--------****----***----***------- " + codigo);
        try {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ");
            disciplinas = serieDao.listarDisciplinasSerie(codigo);
            // adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void listarTurmasParametro(Integer codigo, Integer inep) {

        System.out.println("olha o codigo da turma--------****----***----***------- " + codigo);
         turmas.clear();
        turmas = new ArrayList<>();
        try {
            turmas = turmaDao.listarTurmaParametro(codigo, inep);
            //adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
            disciplinas.clear();
            disciplinas = new ArrayList<>();

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
       
        disciplinas = new ArrayList<>();
    }

    public void listarAssociacao() {

        System.out.println("olha a lista--------****----***----***------- ");
        try {
            questoes = turmaDao.listarAssociacao(associacao);
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void listarAlunos(Integer codTurma, Integer inep, Integer codSerie) throws ErroSistema {

        System.out.println("olha o codigo --------" + codTurma + "****----***" + inep + "----***------- " + codSerie);

        try {
            alunos = alunoDao.imprimirAlunos(codTurma, inep, codSerie);
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }

    public void grafico() {

        /*  barra = new BarChartModel();

        for (int i = 0; i < resul.size(); i++) {
            ChartSeries serie = new ChartSeries();
            serie.setLabel(resul.get(i).getNomeAluno());

            if (resul.get(i).getNumeroAcertos() < 2) {
                barra.setSeriesColors("DC143C");
                serie.set("olha", resul.get(i).getNumeroAcertos());
                barra.addSeries(serie);
                System.out.println("******************************************* 1");
            }
            if (resul.get(i).getNumeroAcertos() >= 2) {
                barra.setSeriesColors("00FFFF");
                serie.set("olha", resul.get(i).getNumeroAcertos());
                barra.addSeries(serie);
                System.out.println("******************************************* 2");
            }
            if (resul.get(i).getNumeroAcertos() > 7) {
                barra.setSeriesColors("FF1493");
                serie.set("olha", resul.get(i).getNumeroAcertos());
                barra.addSeries(serie);
                System.out.println("******************************************* 3");
            }

        }

        barra.setTitle("titulo do grafico");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);

        Axis xAxis = barra.getAxis(AxisType.X);
        xAxis.setLabel("eventos 1");
        Axis yAxis = barra.getAxis(AxisType.Y);
        yAxis.setLabel("eventos 2");

        yAxis.setMin(0);
        yAxis.setMax(10);*/
    }

    public void graficoEvasaoTurma() {

        /*barChartModel = new BarChartModel();
        barChartModel.setAspectRatio(AspectRatio.GOLDEN_SECTION);
        barChartModel.addLabel("Measure1");
        barChartModel.addLabel("Measure2");
        barChartModel.addLabel("Measure3");
        barChartModel.addLabel("Measure4");
        barChartModel.addLabel("Measure5");
        
        BarChartSeries series1 = new BarChartSeries();
        series1.setLabel("zxsd");
       
      
        
        Axis xAxis = barChartModel.getAxis(AxisType.);
        xAxis.setShowGrid(false);
        barChartModel.addSeries(series1);
      
        barChartModel.setShowTooltip(true);
        barChartModel.setSeriesBarDistance(15);
        barChartModel.setAnimateAdvanced(true);


        barChartModel = new BarChartModel();
       // barChartModel.setAspectRatio(AspectRatio.GOLDEN_SECTION);
       // barChartModel
       // barChartModel.addLabel("Measure2");
       // barChartModel.addLabel("Measure3");
       // barChartModel.addLabel("Measure4");
       // barChartModel.addLabel("Measure5");
         */
        barra = new BarChartModel();

        ChartSeries serie = new ChartSeries();

        serie.setLabel("PRESENTES");
        serie.set("olha", 100);
        barra.setSeriesColors("");
        barra.setExtender("chartExtender");
        barra.addSeries(serie);

        if (resultevasaoTurma <= 50) {
            ChartSeries serie2 = new ChartSeries();
            serie2.setLabel("EVASÃO");
            serie2.set("olha", resultevasaoTurma);
            barra.setSeriesColors("");
            barra.setExtender("chartExtender");
            barra.addSeries(serie2);
            System.out.println("****************grafico de evasao*************************** 1");
        } else {

            ChartSeries serie2 = new ChartSeries();
            serie2.setLabel("EVASÃO");
            barra.setSeriesColors("");
            serie2.set("olha", resultevasaoTurma);
            barra.addSeries(serie2);

        }

        ChartSeries serie3 = new ChartSeries();
        serie3.setLabel("EVASÃO");
        barra.setSeriesColors("");
        barra.setExtender("chartExtende");
        serie3.set("olha", 20);
        barra.addSeries(serie3);

        ChartSeries serie4 = new ChartSeries();
        serie4.setLabel("EVASÃO");
        barra.setSeriesColors("");
        barra.setExtender("chartExtende");
        serie4.set("olha", 25);
        barra.addSeries(serie4);

        //else {
        //  barra.setSeriesColors("FF1493");
        //  serie.set("olha", resultevasaoTurma);
        //  barra.addSeries(serie);
        //  System.out.println("******************************************* 3");
        //  }
        barra.setTitle("GRAFICO DE EVASÃO DA TURMA");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);

        Axis xAxis = barra.getAxis(AxisType.X);
        xAxis.setLabel("eventos 1");
        Axis yAxis = barra.getAxis(AxisType.Y);
        yAxis.setLabel("ASASAS");

        yAxis.setMin(0);
        yAxis.setMax(100);
    }

    public void graficoHorizontal() {

        /*  barraHorizontal = new HorizontalBarChartModel();

        for (int i = 0; i < resul.size(); i++) {
            ChartSeries serie = new ChartSeries();
            serie.setLabel(resul.get(i).getNomeAluno());

            if (resul.get(i).getNumeroAcertos() < 2) {
                barraHorizontal.setSeriesColors("DC143C");
                barraHorizontal.setExtender("chartColor");
                serie.set("olha", resul.get(i).getNumeroAcertos());
                barraHorizontal.addSeries(serie);
                System.out.println("******************************************* 1");
            }
            if (resul.get(i).getNumeroAcertos() >= 2) {
                barraHorizontal.setSeriesColors("00FFFF");
                barraHorizontal.setExtender("chartExtender");
                serie.set("olha", resul.get(i).getNumeroAcertos());
                barraHorizontal.addSeries(serie);
                System.out.println("******************************************* 2");
            }
            if (resul.get(i).getNumeroAcertos() > 7) {
                barraHorizontal.setSeriesColors("FF1493");
                barraHorizontal.setExtender("chartColorc");
                serie.set("olha", resul.get(i).getNumeroAcertos());
                barraHorizontal.addSeries(serie);
                System.out.println("******************************************* 3");
            }

        }

        barraHorizontal.setTitle("titulo do grafico");
        barraHorizontal.setLegendPosition("ne");
        barraHorizontal.setAnimate(true);

        Axis xAxis = barraHorizontal.getAxis(AxisType.X);
        xAxis.setLabel("eventos 1");
        Axis yAxis = barraHorizontal.getAxis(AxisType.Y);
        yAxis.setLabel("eventos 2");

        yAxis.setMin(0);
        yAxis.setMax(10);*/
    }

    public void graficoLinha() {

        barraLinha = new LineChartModel();

        for (int i = 0; i < resul.size(); i++) {
            ChartSeries serie = new ChartSeries();
            serie.setLabel(resul.get(i).getNomeAluno());
            serie.set("olha", resul.get(i).getNumeroAcertos());
            barraLinha.addSeries(serie);

        }

        barraLinha.setTitle("GRAFICO DE LINHA");
        barraLinha.setLegendPosition("e");
        barraLinha.setAnimate(true);

        Axis xAxis = barraLinha.getAxis(AxisType.X);
        xAxis.setLabel("eventos 1");
        Axis yAxis = barraLinha.getAxis(AxisType.Y);
        yAxis.setLabel("eventos 2");

        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    public void listarGabaritosAlunos(Integer codTurma, Integer inep, Integer codSerie) throws ErroSistema {

        /*  System.out.println("olha o codigo --------"+codTurma+"****----***"+inep+"----***------- " + codSerie);
        
      
        
        try {
          //  alunos = alunoDao.listarGabaritosAlunos(codTurma, inep,codSerie);
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
            
            
            
            
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        
         */
    }

    public void listarGabaritosDisciplina(Integer codTurma, Integer inep, Integer codSerie, Integer codDisciplina) throws ErroSistema {

        System.out.println("olha o codigo --------" + inep + "****----***" + codDisciplina + "----***------- " + codSerie);

        try {

            visivel = true;
            descritores = serieDao.listarDescritores(codSerie, codDisciplina);
            System.out.println("TAMANHO DESCRITORES ------ " + descritores.size());
            avaliacoes = alunoDao.listarGabaritosAlunos(codTurma, inep, codSerie);
            System.out.println("TAMANHO AVALIAÇÕES ------ " + avaliacoes.size());
            alunos = alunoDao.imprimirAlunos(codTurma, inep, codSerie);
            System.out.println("TAMANHO ALUNOS ------ " + alunos.size());

            quantPresentes = avaliacoes.size();
            quantlunos = alunos.size();
            quantDescritores = descritores.size();

            quantFaltosos = quantlunos - quantPresentes;

            resultevasaoTurma = 100 * quantPresentes / quantlunos;

            alunoDao.insertFrequeciaTurma(codTurma, inep, codSerie, resultevasaoTurma);

            //resulPreseTurma = 100 * quantFaltosos / quantlunos;
            resulPreseTurma = 100 - resultevasaoTurma;
            System.out.println("RESULT RESULTEVASAOTURMA " + resultevasaoTurma);
            System.out.println("RESULT PRESENTES " + resulPreseTurma);

            resultdescritores = new ArrayList<String>();
            resulAlunos = new ArrayList<String>();

            if (avaliacoes.size() == 0) {
                adicionarMensagem("LISTADO!", "NÃO TEM AVALIAÇÂO CADASTRADA NESSA TURMA", FacesMessage.SEVERITY_INFO);

                return;
            }

            if (descritores.size() == 0) {
                adicionarMensagem("LISTADO!", "NÃO TEM DESCRITOR NEM GABARITO CADASTRADO", FacesMessage.SEVERITY_INFO);
                return;
            }

            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

        dados = new String[quantlunos + descritores.size() + 2][quantlunos + descritores.size() + 2];
        String gaba = "";

        int nulo = 0;
        for (int co = 0; co < descritores.size(); co++) {

            Descritor gabarito = descritores.get(co);
            gaba += gabarito.getEspeciDescritor();
            if (gabarito.getEspeciDescritor().equals("N")) {
                nulo++;
            }
        }
        System.out.println("ALTERNATIVAS ANULADAS " + nulo);
        int re = quantDescritores - nulo;
        quantQuest = quantPresentes * re;
       
        List<String> listaDeGabarito = new ArrayList<String>();

        String resp = "";
        char tes = 0;

        for (int av = 0; av < avaliacoes.size(); av++) {

            Avaliacao ava = avaliacoes.get(av);

            if (codDisciplina == 1) {
                listaDeGabarito.add(ava.getRespPortugues());
                resp = ava.getRespPortugues();
            }
            if (codDisciplina == 2) {
                listaDeGabarito.add(ava.getRespMatematica());
                resp = ava.getRespMatematica();
            }
            if (codDisciplina == 3) {
                listaDeGabarito.add(ava.getRespCienciasHumanas());
                resp = ava.getRespCienciasHumanas();
            }
            if (codDisciplina == 4) {
                listaDeGabarito.add(ava.getRespCienciasNatureza());
                resp = ava.getRespCienciasNatureza();
            }
        }

        String gabarito = gaba;

        String compara = "";
        Integer resultado = 0;

        List<String> listaDeResultado = new ArrayList<String>();

        int[][] data = new int[listaDeGabarito.size()][gabarito.length()];

        List<Integer> meuGabarito = new ArrayList<Integer>();

        System.out.println("tamano1 " + listaDeGabarito.size() + "tamanho2 " + gabarito.length());

        for (int b = 0; b < listaDeGabarito.size(); b++) {

            String a = listaDeGabarito.get(b);

            for (int i = 0; i < a.length(); i++) {

                if (a.charAt(i) == gabarito.charAt(i)) {

                    compara = compara + "1";
                    //resultado = resultado + Integer.parseInt(compara);

                } else {
                    compara = compara + "0";
                }
            }

            listaDeResultado.add(compara);
            System.out.println("lista de resultado " + compara);
            compara = "";
            resultado = 0;
        }

        String var = "";
        String nome = "";

        int s = 0;
        for (int i = 0; i < listaDeResultado.size(); i++) {

            System.out.println("***** -#######- ****" + listaDeResultado.size());
            Avaliacao aa = new Avaliacao();
            var = listaDeResultado.get(i);

            System.out.println("***** - - ****" + i);
            // System.out.println("***** - - ****" + avaliacoes.get(i).getNomeAluno());
            //Avaliacao ava = avaliacoes.get(i);
            // nome = ava.getNomeAluno();
            for (int j = 0; j < var.length(); j++) {

                //  int a =  var.charAt(j
                int v = Character.getNumericValue(var.charAt(j));
                s = s + v;
                // System.out.println("***** - - ****" + s);
                //  System.out.println( "yyyyyy"+v + "uuuuu"+var.charAt(j));
                //data[i][j] = var.charAt(j);
                data[i][j] = v;
                // System.out.println("olha ****" + v++);

            }

            System.out.println("A SOMA DAS LINHAS É " + s);
            //Integer ra = 100 * s / descritores.size();
            Integer ra = s;
            quantAcerto += s;
            System.out.println("A QUANTIDADE DE ACERTOS É " + quantAcerto);
            resulAlunos.add(Integer.toString(ra));

            s = 0;
        }

        int size = data.length, largestRow = 0, sum = 0, col = 0;

        for (int check = 0; check <= (size - 1); check++) {
            if (largestRow < data[check].length) {
                largestRow = data[check].length;
            }
        }

        resultdescritores.add("RESULTADO DESCRITORES");

        do {
            for (int row = 0; row < data.length; row++) {
                //System.out.println("row(long): "+data[row].length+", col: "+col);
                //System.out.println(col>=(data[row].length-1));

                if (col >= (data[row].length)) {
                } else {
                    sum += data[row][col];
                }
            }
            col += 1;

            System.out.println("A SOMA DA COLUNA " + col + " É: " + (sum));//made the row +1, to make it understandable
            //Integer dp = 100 * sum / quantPresentes;
            Integer dp = sum;

            descri.add(Integer.toString(dp));

            resultdescritores.add(Integer.toString(dp));

            // System.out.println(sum + "%");
            sum = 0;
        } while (col != largestRow);

        for (int av = 0; av < avaliacoes.size(); av++) {

            Avaliacao ava = avaliacoes.get(av);

            if (codDisciplina == 1) {
                listaDeGabarito.add(ava.getRespPortugues());
                resp = ava.getRespPortugues();
            }
            if (codDisciplina == 2) {
                listaDeGabarito.add(ava.getRespMatematica());
                resp = ava.getRespMatematica();
            }
            if (codDisciplina == 3) {
                listaDeGabarito.add(ava.getRespCienciasHumanas());
                resp = ava.getRespCienciasHumanas();
            }
            if (codDisciplina == 4) {
                listaDeGabarito.add(ava.getRespCienciasNatureza());
                resp = ava.getRespCienciasNatureza();
            }

            System.out.println("LISTA DE QUESTÕES POR ALUNO " + resp);
            dados[av][0] = avaliacoes.get(av).getNomeAluno();

            //RETIRADO O + 1
            for (int j = 1; j <= descritores.size() + 1; j++) {

                if (j > descritores.size()) {
                    dados[av][j] = resulAlunos.get(av);
                } else {
                    if (codDisciplina == 1) {
                        tes = avaliacoes.get(av).getRespPortugues().charAt(j - 1);
                    }
                    if (codDisciplina == 2) {
                        tes = avaliacoes.get(av).getRespMatematica().charAt(j - 1);
                    }
                    if (codDisciplina == 3) {
                        tes = avaliacoes.get(av).getRespCienciasHumanas().charAt(j - 1);
                    }
                    if (codDisciplina == 4) {
                        tes = avaliacoes.get(av).getRespCienciasNatureza().charAt(j - 1);
                    }

                    String b = String.valueOf(tes);
                    System.out.println("############ " + b);

                    dados[av][j] = b;
                }

            }

        }

        // -----------------------------------------------------------\\
        //**********************************************************************************\\
        /* ArrayList<Descritor> teste = new ArrayList<>();
        int cd = 0;
        for (int i = 0; i < descritores.size(); i++) {

            int cont = 0;
            Descritor rd = new Descritor();

            int a = Integer.parseInt(resultdescritores.get(i + 1));
            double so = 0;

            for (int j = 0; j < descritores.size(); j++) {
                System.out.println("descritor 1 " + descritores.get(i).getSiglaDescritor());
                System.out.println("descritor 2 " + descritores.get(j).getSiglaDescritor());
                int aa = Integer.parseInt(resultdescritores.get(j + 1));
                if (descritores.get(i).getSiglaDescritor().equals(descritores.get(j).getSiglaDescritor())) {

                    so += aa;
                    cont++;
                    cd = cont;
                }

            }
            double t = 0;

            System.out.println("quantidade de repetição " + descritores.get(i).getSiglaDescritor() + " - " + cont);

            if (cont >= 2) {
                t = so;
            } else {
                t = a;
            }

            System.out.println("olha o teste " + teste.size());
            cont = 0;

            if (teste.size() == 0) {
                rd.setSiglaDescritor(descritores.get(i).getSiglaDescritor());
                System.out.println("************* " + rd.getSiglaDescritor());

                System.out.println("************* porcentagem descritor" + a);

                rd.setResultDescritor(t);

                teste.add(rd);
            } else {

                for (int d = 0; d < teste.size(); d++) {

                    System.out.println("************* descritor 1 " + descritores.get(i).getSiglaDescritor());
                    System.out.println("*************  descritor 2 " + teste.get(d).getSiglaDescritor());

                    if (descritores.get(i).getSiglaDescritor().equals(teste.get(d).getSiglaDescritor())) {
                        cont++;
                        /*rd.setSiglaDescritor(descritores.get(i).getSiglaDescritor());

                        System.out.println("************* " + rd.getSiglaDescritor());

                        System.out.println("************* porcentagem descritor" + a);

                        rd.setResultDescritor(i);

                        teste.add(rd);

                    }

                }
                if (cont < 1) {
                    rd.setSiglaDescritor(descritores.get(i).getSiglaDescritor());

                    System.out.println("************* " + rd.getSiglaDescritor());

                    System.out.println("************* porcentagem descritor" + a);

                    rd.setResultDescritor(t);

                    teste.add(rd);
                }

                cont = 0;
            }
            System.out.println("************* tamanho da lista teste ##**##" + teste.size());

            for (int j = 0; j < teste.size(); j++) {
                System.out.println("*************" + teste.get(j).getSiglaDescritor());
                System.out.println("*************" + teste.get(j).getResultDescritor());
            }

        }*/
//*****************************************************************************************\\
        horizontalBarModel = new HorizontalBarChartModel();

        ChartSeries vermelho = new ChartSeries();
        ChartSeries amarelo = new ChartSeries();
        ChartSeries azul = new ChartSeries();
        ChartSeries verde = new ChartSeries();

        vermelho.setLabel("25%");
        amarelo.setLabel("25% - 50%");
        azul.setLabel("50% - 75%");
        verde.setLabel("75% - 100%");

        //String a = "A";
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + resultdescritores.size());
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + descritores.size());

        double ve = 0;
        double ama = 0;
        double az = 0;
        double ver = 0;

        for (int i = 0; i < descritores.size(); i++) {
            int b = i + 1;
            int dec = descritores.size() - i;
            String g = "";
            int a = Integer.parseInt(resultdescritores.get(b));

            a = a * 100 / quantPresentes;
            /*
            double a = teste.get(i).getResultDescritor();
            double cda = teste.get(i).getResultDescritor();
     
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ****** " + a);
            a = a * 100 / quantPresentes;
           
            if (a > 100) {
               
                a = cda * 100 / quantPresentes * cd;
                
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ****** " + a);
                
            } 
             */
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX " + a);

            if (a <= 25) {
                ve = a;
                ama = 0;
                az = 0;
                ver = 0;
            }
            if (a > 24 && a <= 50) {
                ve = 0;
                ama = a;
                az = 0;
                ver = 0;
            }
            if (a > 49 && a <= 75) {
                ve = 0;
                ama = 0;
                az = a;
                ver = 0;
            }
            if (a > 74) {
                ve = 0;
                ama = 0;
                az = 0;
                ver = a;
            }

            System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + a);

            System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + descritores.get(i).getSiglaDescritor());
            //if (a > 0) {
            vermelho.set(dec + " - " + descritores.get(i).getSiglaDescritor(), ve);
            amarelo.set(dec + " - " + descritores.get(i).getSiglaDescritor(), ama);
            azul.set(dec + " - " + descritores.get(i).getSiglaDescritor(), az);
            verde.set(dec + " - " + descritores.get(i).getSiglaDescritor(), ver);
            // }

        }

        //}
        horizontalBarModel.addSeries(vermelho);
        horizontalBarModel.addSeries(amarelo);
        horizontalBarModel.addSeries(azul);
        horizontalBarModel.addSeries(verde);

        horizontalBarModel.setTitle("GRAFICO DE DESCRITORES ");
        horizontalBarModel.setSeriesColors("ff0000,ffff00,0000ff,66ff33");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
        horizontalBarModel.setShowPointLabels(true);

        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("");
        xAxis.setMin(0);
        xAxis.setMax(150);
        xAxis.setTickFormat("%1$.0f");
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("DESCRITORES");

        // -----------------------------------------------------------\\
        //------------------------------------------------------------\\
        horizontalBarAluno = new HorizontalBarChartModel();

        ChartSeries verm = new ChartSeries();
        ChartSeries am = new ChartSeries();
        ChartSeries azu = new ChartSeries();
        ChartSeries verd = new ChartSeries();

        verm.setLabel("25%");
        am.setLabel("25% - 50%");
        azu.setLabel("50% - 75%");
        verd.setLabel("75% - 100%");

        //String a = "A";
        //  System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + resultdescritores.size());
        //System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + descritores.size());
        int vermelho1 = 0;
        int amamarelo1 = 0;
        int azul1 = 0;
        int verde1 = 0;

        for (int i = 0; i < avaliacoes.size(); i++) {
            int b = i + 1;
            int rec = avaliacoes.size() - i;
            //System.out.println("quantidade de alunos "+resulAlunos.size());
            //  int a = Integer.parseInt(resulAlunos.get(i));
            int a = Integer.parseInt(resulAlunos.get(i));
            a = a * 100 / quantDescritores;

            //int a = Integer.parseInt("10");
            if (a <= 25) {
                vermelho1 = a;
                amamarelo1 = 0;
                azul1 = 0;
                verde1 = 0;
            }
            if (a > 24 && a <= 50) {
                vermelho1 = 0;
                amamarelo1 = a;
                azul1 = 0;
                verde1 = 0;
            }
            if (a > 49 && a <= 75) {
                vermelho1 = 0;
                amamarelo1 = 0;
                azul1 = a;
                verde1 = 0;
            }
            if (a > 74) {
                vermelho1 = 0;
                amamarelo1 = 0;
                azul1 = 0;
                verde1 = a;
            }

            // System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + a);
            // System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + descritores.get(i).getSiglaDescritor());
            verm.set(rec + " - " + avaliacoes.get(i).getNomeAluno(), vermelho1);
            am.set(rec + " - " + avaliacoes.get(i).getNomeAluno(), amamarelo1);
            azu.set(rec + " - " + avaliacoes.get(i).getNomeAluno(), azul1);
            verd.set(rec + " - " + avaliacoes.get(i).getNomeAluno(), verde1);

        }

        //}
        horizontalBarAluno.addSeries(verm);
        horizontalBarAluno.addSeries(am);
        horizontalBarAluno.addSeries(azu);
        horizontalBarAluno.addSeries(verd);

        horizontalBarAluno.setTitle("GRAFICO DE ALUNOS ");
        horizontalBarAluno.setSeriesColors("ff0000,ffff00,0000ff,66ff33");
        horizontalBarAluno.setLegendPosition("e");
        horizontalBarAluno.setStacked(true);
        horizontalBarAluno.setShowPointLabels(true);

        Axis xAAxis = horizontalBarAluno.getAxis(AxisType.X);
        xAAxis.setLabel("");
        xAAxis.setMin(0);
        xAAxis.setMax(150);
        xAAxis.setTickFormat("%1$.0f");
        Axis yAAxis = horizontalBarAluno.getAxis(AxisType.Y);
        yAAxis.setLabel("ALUNOS");

        //------------------------------------\\
        horizontalEvasao = new HorizontalBarChartModel();
        ChartSeries evasao = new ChartSeries();
        ChartSeries presentes = new ChartSeries();

        evasao.setLabel("PRESENTES");
        evasao.set("", resultevasaoTurma);
        horizontalEvasao.addSeries(evasao);

        presentes.setLabel("EVASÃO");
        presentes.set("", resulPreseTurma);
        horizontalEvasao.addSeries(presentes);

        horizontalEvasao.setTitle("GRAFICO DE EVASÃO ");
        horizontalEvasao.setSeriesColors("66ff33,ff0000");
        horizontalEvasao.setLegendPosition("e");
        horizontalEvasao.setStacked(true);
        horizontalEvasao.setShowPointLabels(true);

        Axis xAxi = horizontalEvasao.getAxis(AxisType.X);
        xAxi.setLabel("");
        xAxi.setMin(0);
        xAxi.setMax(150);
        xAxi.setTickFormat("%1$.0f");
        Axis yAxi = horizontalEvasao.getAxis(AxisType.Y);
        yAxi.setLabel("");

        double rendN = quantQuest;

        horizontalRendimento = new HorizontalBarChartModel();
        ChartSeries rendimentoP = new ChartSeries();
        ChartSeries rendimentoN = new ChartSeries();

        rendimentoP.setLabel("RENDIMENTO POSITIVO");

        double rend = quantAcerto * 100 / quantQuest;

        rendimentoP.set("", rend);

        alunoDao.insertRendimentoTurma(codTurma, inep, codSerie, codDisciplina, rend);

        horizontalRendimento.addSeries(rendimentoP);

        rendimentoN.setLabel("RENDIMENTO NEGATIVO");
        rendimentoN.set("", 100 - rend);

        horizontalRendimento.addSeries(rendimentoN);
        horizontalRendimento.setTitle("GRAFICO DE RENDIMENTO DA TURMA ");
        horizontalRendimento.setSeriesColors("66ff33,ff0000");
        horizontalRendimento.setLegendPosition("e");
        horizontalRendimento.setStacked(true);
        horizontalRendimento.setShowPointLabels(true);

        Axis rAxi = horizontalRendimento.getAxis(AxisType.X);
        rAxi.setLabel("");
        rAxi.setMin(0);
        rAxi.setMax(150);
        rAxi.setTickFormat("%1$.0f");
        Axis yrAxi = horizontalRendimento.getAxis(AxisType.Y);
        yrAxi.setLabel("");
        rend = 0;
        quantAcerto = 0;
        quantQuest = 0;

    }

    public void pesquisarFrequenciaPorMunicipio() throws ErroSistema {

        Integer c = 0;
        Integer b = 0;
        double p = 0;
        ca = alunoDao.contarAlunosMunicipio();
        cp = alunoDao.contarPresentesAvaliacao();
        escolas = escolaDao.listarEscolas();

        List<Escola> freEscola = new ArrayList<>();

        for (int i = 0; i < escolas.size(); i++) {

            Escola e = new Escola();
            e.setInepEscola(escolas.get(i).getInepEscola());
            e.setNome(escolas.get(i).getNome());
            c = alunoDao.contarPresentesEscola(escolas.get(i).getInepEscola());
            b = alunoDao.contarAlunosEscola(escolas.get(i).getInepEscola());

            e.setCp(c);
            e.setCa(b);

            freEscola.add(e);
        }

        horizontalEvasao = new HorizontalBarChartModel();
        ChartSeries evasao = new ChartSeries();
        ChartSeries presentes = new ChartSeries();

        presentes.setLabel("FREQUÊNCIA");
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + cp * 100 / ca);
        presentes.set("", cp * 100 / ca);
        horizontalEvasao.addSeries(presentes);

        horizontalEvasao.setTitle("GRAFICO DE FREQUÊNCIA ");
        horizontalEvasao.setSeriesColors("66ff33,ff0000");
        horizontalEvasao.setLegendPosition("e");
        horizontalEvasao.setStacked(true);
        horizontalEvasao.setShowPointLabels(true);

        Axis xAxi = horizontalEvasao.getAxis(AxisType.X);
        xAxi.setLabel("");
        xAxi.setMin(0);
        xAxi.setMax(150);
        xAxi.setTickFormat("%1$.0f");
        Axis yAxi = horizontalEvasao.getAxis(AxisType.Y);
        yAxi.setLabel("");

        horizontalBarModel = new HorizontalBarChartModel();

        ChartSeries g = new ChartSeries();
        g.setLabel("FREQUÊNCIA");
        //String a = "A";
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + resultdescritores.size());
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + descritores.size());

        for (int i = 0; i < freEscola.size(); i++) {

            System.out.println("xxxxxxxxxxxxxxxxxx--NOMES ESCOLAS--xxxxxxxxxxxxxxx " + freEscola.get(i).getCp());

            g.set(freEscola.get(i).getNome() + "     ", freEscola.get(i).getCp() * 100 / freEscola.get(i).getCa());

        }

        //}
        horizontalBarModel.addSeries(g);

        horizontalBarModel.setTitle("GRAFICO DE FREQUÊNCIA DAS ESCOLAS MUNICIPAIS ");
        horizontalBarModel.setSeriesColors("33ffbb");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
        horizontalBarModel.setShowPointLabels(true);

        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("FREQUÊNCIA DAS ESCOLAS");
        xAxis.setMin(0);
        xAxis.setMax(150);
        xAxis.setTickFormat("%1$.0f");
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("ESCOLAS");

        System.out.println("NUMERO DE ALUNOS PRESENTES  ------ " + ca + " -- " + cp);
        c = 0;
        b = 0;
    }

    public void listarFrequenciaturma(Integer inep, Integer serie) throws ErroSistema {

        List<Turma> t = new ArrayList<>();

        t = alunoDao.listarFrequenciaTurma(inep, serie);

        horizontalBarModel = new HorizontalBarChartModel();

        ChartSeries g = new ChartSeries();
        g.setLabel("FREQUÊNCIA");

        for (int i = 0; i < t.size(); i++) {

            g.set(t.get(i).getNome() + "     ", t.get(i).getEv());

        }

        //}
        horizontalBarModel.addSeries(g);

        horizontalBarModel.setTitle("GRAFICO DE FREQUÊNCIA POR TURMAS");
        horizontalBarModel.setSeriesColors("33ffbb");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
        horizontalBarModel.setShowPointLabels(true);

        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("");
        xAxis.setMin(0);
        xAxis.setMax(150);
        xAxis.setTickFormat("%1$.0f");
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("");

        System.out.println("NUMERO DE ALUNOS PRESENTES  ------ " + ca + " -- " + cp);

    }

    public void listarRendimentoSerie(Integer serie, Integer disciplina) throws ErroSistema {

        List<Serie> t = new ArrayList<>();

        t = alunoDao.listarRendimentoSerie(serie, disciplina);

        horizontalBarModel = new HorizontalBarChartModel();

        ChartSeries vermelho = new ChartSeries();
        ChartSeries amarelo = new ChartSeries();
        ChartSeries azul = new ChartSeries();
        ChartSeries verde = new ChartSeries();

        vermelho.setLabel("25%");
        amarelo.setLabel("25% - 50%");
        azul.setLabel("50% - 75%");
        verde.setLabel("75% - 100%");

        //String a = "A";
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + t.size());
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + t.get(0).getNome());

        double ve = 0;
        double ama = 0;
        double az = 0;
        double ver = 0;

        for (int i = 0; i < t.size(); i++) {
            int b = i + 1;
            int rec = t.size() - i;
            double a = t.get(i).getEv();

            if (a <= 25) {
                ve = a;
                ama = 0;
                az = 0;
                ver = 0;
            }
            if (a > 24 && a <= 50) {
                ve = 0;
                ama = a;
                az = 0;
                ver = 0;
            }
            if (a > 49 && a <= 75) {
                ve = 0;
                ama = 0;
                az = a;
                ver = 0;
            }
            if (a > 74) {
                ve = 0;
                ama = 0;
                az = 0;
                ver = a;
            }

            System.out.println("xxxxxxxxxxxxxxxxxx--serie--xxxxxxxxxxxxxxx " + a);

            vermelho.set(rec + " - " + t.get(i).getNome(), ve);
            amarelo.set(rec + " - " + t.get(i).getNome(), ama);
            azul.set(rec + " - " + t.get(i).getNome(), az);
            verde.set(rec + " - " + t.get(i).getNome(), ver);

        }

        //}
        horizontalBarModel.addSeries(vermelho);
        horizontalBarModel.addSeries(amarelo);
        horizontalBarModel.addSeries(azul);
        horizontalBarModel.addSeries(verde);

        horizontalBarModel.setTitle("GRAFICO DE RENDIMENTO SÉRIE ");
        horizontalBarModel.setSeriesColors("ff0000,ffff00,0000ff,66ff33");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
        horizontalBarModel.setShowPointLabels(true);

        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("");
        xAxis.setMin(0);
        xAxis.setMax(150);
        xAxis.setTickFormat("%1$.0f");
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("");

    }

    public void listarRendimentoturma(Integer inep, Integer serie, Integer disciplina) throws ErroSistema {

        List<Turma> t = new ArrayList<>();

        t = alunoDao.listarRendimentoTurma(inep, serie, disciplina);

        horizontalEvasao = new HorizontalBarChartModel();

        ChartSeries g = new ChartSeries();
        g.setLabel("RENDIMENTO");

        double rendSerie = 0;

        for (int i = 0; i < t.size(); i++) {
            g.set(t.get(i).getNome() + "     ", t.get(i).getEv());
            rendSerie = rendSerie + t.get(i).getEv();
        }

        System.out.println("OLHA O RENDIMENTO" + rendSerie / t.size());

        alunoDao.inserirRendimentoSerie(inep, serie, disciplina, rendSerie / t.size());

        //}
        horizontalEvasao.addSeries(g);

        horizontalEvasao.setTitle("GRAFICO DE RENDIMENTO POR TURMAS");
        horizontalEvasao.setSeriesColors("33ffbb");
        horizontalEvasao.setLegendPosition("e");
        horizontalEvasao.setStacked(true);
        horizontalEvasao.setShowPointLabels(true);

        Axis xAxis = horizontalEvasao.getAxis(AxisType.X);
        xAxis.setLabel("");
        xAxis.setMin(0);
        xAxis.setMax(150);
        xAxis.setTickFormat("%1$.0f");
        Axis yAxis = horizontalEvasao.getAxis(AxisType.Y);
        yAxis.setLabel("");

        System.out.println("NUMERO DE ALUNOS PRESENTES  ------ " + ca + " -- " + cp);

        try {

            visivel = true;
            descritores = serieDao.listarDescritores(serie, disciplina);
            System.out.println("TAMANHO DESCRITORES ------ " + descritores.size());

            avaliacoes = alunoDao.listarGabaritosSerie(inep, serie);
            System.out.println("TAMANHO AVALIAÇÕES ------ " + avaliacoes.size());
            alunos = alunoDao.imprimirAlunosSerie(inep, serie);
            // System.out.println("TAMANHO ALUNOS ------ " + alunos.size());

            quantPresentes = avaliacoes.size();
            quantlunos = alunos.size();
            quantDescritores = descritores.size();

            quantQuest = quantlunos * quantDescritores;

            // quantFaltosos = quantlunos - quantPresentes;
            // resultevasaoTurma = 100 * quantPresentes / quantlunos;
            // alunoDao.insertFrequeciaTurma( inep, codSerie, resultevasaoTurma);
            // resulPreseTurma = 100 * quantFaltosos / quantlunos;
            //System.out.println("@@@@@@@@@@@@@@@@@@@@@ " + resultevasaoTurma);
            resultdescritores = new ArrayList<String>();
            resulAlunos = new ArrayList<String>();

            if (avaliacoes.size() == 0) {
                adicionarMensagem("LISTADO!", "NÃO TEM AVALIAÇÂO CADASTRADA NESSA TURMA", FacesMessage.SEVERITY_INFO);

                return;
            }

            if (descritores.size() == 0) {
                adicionarMensagem("LISTADO!", "NÃO TEM DESCRITOR NEM GABARITO CADASTRADO", FacesMessage.SEVERITY_INFO);
                return;
            }

            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

        dados = new String[quantlunos + descritores.size()][quantlunos + descritores.size()];
        String gaba = "";

        for (int co = 0; co < descritores.size(); co++) {

            Descritor gabarito = descritores.get(co);
            gaba += gabarito.getEspeciDescritor();
            System.out.println("ALTERNATIVAS DOS GABARITOS " + gabarito.getEspeciDescritor());
        }

        List<String> listaDeGabarito = new ArrayList<String>();

        String resp = "";
        char tes = 0;

        for (int av = 0; av < avaliacoes.size(); av++) {

            Avaliacao ava = avaliacoes.get(av);

            if (disciplina == 1) {
                listaDeGabarito.add(ava.getRespPortugues());
                resp = ava.getRespPortugues();
            }
            if (disciplina == 2) {
                listaDeGabarito.add(ava.getRespMatematica());
                resp = ava.getRespMatematica();
            }
            if (disciplina == 3) {
                listaDeGabarito.add(ava.getRespCienciasHumanas());
                resp = ava.getRespCienciasHumanas();
            }
            if (disciplina == 4) {
                listaDeGabarito.add(ava.getRespCienciasNatureza());
                resp = ava.getRespCienciasNatureza();
            }
        }

        String gabarito = gaba;

        String compara = "";
        Integer resultado = 0;

        List<String> listaDeResultado = new ArrayList<String>();

        int[][] data = new int[listaDeGabarito.size()][gabarito.length()];

        List<Integer> meuGabarito = new ArrayList<Integer>();

        System.out.println("tamano1 " + listaDeGabarito.size() + "tamanho2 " + gabarito.length());

        for (int b = 0; b < listaDeGabarito.size(); b++) {

            String a = listaDeGabarito.get(b);

            for (int i = 0; i < a.length(); i++) {

                if (a.charAt(i) == gabarito.charAt(i)) {

                    compara = compara + "1";
                    //resultado = resultado + Integer.parseInt(compara);

                } else {
                    compara = compara + "0";
                }
            }

            listaDeResultado.add(compara);
            System.out.println("lista de resultado " + compara);
            compara = "";
            resultado = 0;
        }

        String var = "";
        String nome = "";

        int s = 0;
        for (int i = 0; i < listaDeResultado.size(); i++) {

            System.out.println("***** -#######- ****" + listaDeResultado.size());
            Avaliacao aa = new Avaliacao();
            var = listaDeResultado.get(i);

            System.out.println("***** - - ****" + i);
            // System.out.println("***** - - ****" + avaliacoes.get(i).getNomeAluno());
            //Avaliacao ava = avaliacoes.get(i);
            // nome = ava.getNomeAluno();
            for (int j = 0; j < var.length(); j++) {

                //  int a =  var.charAt(j
                int v = Character.getNumericValue(var.charAt(j));
                s = s + v;
                // System.out.println("***** - - ****" + s);
                //  System.out.println( "yyyyyy"+v + "uuuuu"+var.charAt(j));
                //data[i][j] = var.charAt(j);
                data[i][j] = v;
                // System.out.println("olha ****" + v++);

            }

            System.out.println("A SOMA DAS LINHAS É " + s);
            Integer ra = s;
            // Integer ra = 100 * s / quantPresentes;
            quantAcerto += s;
            System.out.println("A QUANTIDADE DE ACERTOS É " + quantAcerto);
            resulAlunos.add(Integer.toString(ra));

            s = 0;
        }

        int size = data.length, largestRow = 0, sum = 0, col = 0;

        for (int check = 0; check <= (size - 1); check++) {
            if (largestRow < data[check].length) {
                largestRow = data[check].length;
            }
        }

        resultdescritores.add("RESULTADO DESCRITORES");

        do {
            for (int row = 0; row < data.length; row++) {
                //System.out.println("row(long): "+data[row].length+", col: "+col);
                //System.out.println(col>=(data[row].length-1));

                if (col >= (data[row].length)) {
                } else {
                    sum += data[row][col];
                }
            }
            col += 1;

            System.out.println("A SOMA DA COLUNA " + col + " É: " + (sum));//made the row +1, to make it understandable
            Integer dp = sum;
            // Integer dp = 100 * sum / descritores.size();

            descri.add(Integer.toString(dp));

            resultdescritores.add(Integer.toString(dp));

            // System.out.println(sum + "%");
            sum = 0;
        } while (col != largestRow);

        for (int av = 0; av < avaliacoes.size(); av++) {

            Avaliacao ava = avaliacoes.get(av);

            if (disciplina == 1) {
                listaDeGabarito.add(ava.getRespPortugues());
                resp = ava.getRespPortugues();
            }
            if (disciplina == 2) {
                listaDeGabarito.add(ava.getRespMatematica());
                resp = ava.getRespMatematica();
            }
            if (disciplina == 3) {
                listaDeGabarito.add(ava.getRespCienciasHumanas());
                resp = ava.getRespCienciasHumanas();
            }
            if (disciplina == 4) {
                listaDeGabarito.add(ava.getRespCienciasNatureza());
                resp = ava.getRespCienciasNatureza();
            }

            System.out.println("LISTA DE QUESTÕES POR ALUNO " + resp);
            System.out.println("NOME DOS ALUNO " + avaliacoes.get(av).getNomeAluno());

            dados[av][0] = avaliacoes.get(av).getNomeAluno();
            //RETIRADO O + 1
            for (int j = 1; j <= descritores.size(); j++) {

                if (j > descritores.size()) {
                    dados[av][j] = resulAlunos.get(av);
                } else {
                    if (disciplina == 1) {
                        tes = avaliacoes.get(av).getRespPortugues().charAt(j - 1);
                    }
                    if (disciplina == 2) {
                        tes = avaliacoes.get(av).getRespMatematica().charAt(j - 1);
                    }
                    if (disciplina == 3) {
                        tes = avaliacoes.get(av).getRespCienciasHumanas().charAt(j - 1);
                    }
                    if (disciplina == 4) {
                        tes = avaliacoes.get(av).getRespCienciasNatureza().charAt(j - 1);
                    }

                    String b = String.valueOf(tes);
                    System.out.println("############ " + b);

                    dados[av][j] = b;
                }

            }

        }

        // -----------------------------------------------------------\\
        horizontalBarModel = new HorizontalBarChartModel();

        ChartSeries vermelho = new ChartSeries();
        ChartSeries amarelo = new ChartSeries();
        ChartSeries azul = new ChartSeries();
        ChartSeries verde = new ChartSeries();

        vermelho.setLabel("25%");
        amarelo.setLabel("25% - 50%");
        azul.setLabel("50% - 75%");
        verde.setLabel("75% - 100%");

        //String a = "A";
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + resultdescritores.size());
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + descritores.size());

        int ve = 0;
        int ama = 0;
        int az = 0;
        int ver = 0;

        for (int i = 0; i < descritores.size(); i++) {
            int b = i + 1;
            int rec = descritores.size() - i;
            int a = Integer.parseInt(resultdescritores.get(b));

            a = a * 100 / quantPresentes;

            if (a <= 25) {
                ve = a;
                ama = 0;
                az = 0;
                ver = 0;
            }
            if (a > 24 && a <= 50) {
                ve = 0;
                ama = a;
                az = 0;
                ver = 0;
            }
            if (a > 49 && a <= 75) {
                ve = 0;
                ama = 0;
                az = a;
                ver = 0;
            }
            if (a > 74) {
                ve = 0;
                ama = 0;
                az = 0;
                ver = a;
            }

            System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + a);

            System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + descritores.get(i).getSiglaDescritor());

            vermelho.set(rec + " - " + descritores.get(i).getSiglaDescritor(), ve);
            amarelo.set(rec + " - " + descritores.get(i).getSiglaDescritor(), ama);
            azul.set(rec + " - " + descritores.get(i).getSiglaDescritor(), az);
            verde.set(rec + " - " + descritores.get(i).getSiglaDescritor(), ver);

        }

        //}
        horizontalBarModel.addSeries(vermelho);
        horizontalBarModel.addSeries(amarelo);
        horizontalBarModel.addSeries(azul);
        horizontalBarModel.addSeries(verde);

        horizontalBarModel.setTitle("GRAFICO DE DESCRITORES ");
        horizontalBarModel.setSeriesColors("ff0000,ffff00,0000ff,66ff33");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
        horizontalBarModel.setShowPointLabels(true);

        Axis xAAxis = horizontalBarModel.getAxis(AxisType.X);
        xAAxis.setLabel("");
        xAAxis.setMin(0);
        xAAxis.setMax(150);
        xAAxis.setTickFormat("%1$.0f");
        Axis yAAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAAxis.setLabel("DESCRITORES");

        // -----------------------------------------------------------\\
        //------------------------------------------------------------\\
        horizontalBarAluno = new HorizontalBarChartModel();

        ChartSeries verm = new ChartSeries();
        ChartSeries am = new ChartSeries();
        ChartSeries azu = new ChartSeries();
        ChartSeries verd = new ChartSeries();

        verm.setLabel("25%");
        am.setLabel("25% - 50%");
        azu.setLabel("50% - 75%");
        verd.setLabel("75% - 100%");

        //String a = "A";
        //  System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + resultdescritores.size());
        //System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + descritores.size());
        int vermelho1 = 0;
        int amamarelo1 = 0;
        int azul1 = 0;
        int verde1 = 0;

        for (int i = 0; i < avaliacoes.size(); i++) {
            int b = i + 1;
            int rec = avaliacoes.size() - i;
            //System.out.println("quantidade de alunos "+resulAlunos.size());
            //int a = Integer.parseInt(resulAlunos.get(i)) * 100 / quantDescritores;
            int a = Integer.parseInt(resulAlunos.get(i));
            a = a * 100 / quantDescritores;

            //int a = Integer.parseInt("10");
            if (a <= 25) {
                vermelho1 = a;
                amamarelo1 = 0;
                azul1 = 0;
                verde1 = 0;
            }
            if (a > 24 && a <= 50) {
                vermelho1 = 0;
                amamarelo1 = a;
                azul1 = 0;
                verde1 = 0;
            }
            if (a > 49 && a <= 75) {
                vermelho1 = 0;
                amamarelo1 = 0;
                azul1 = a;
                verde1 = 0;
            }
            if (a > 74) {
                vermelho1 = 0;
                amamarelo1 = 0;
                azul1 = 0;
                verde1 = a;
            }

            // System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + a);
            // System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + descritores.get(i).getSiglaDescritor());
            verm.set(rec + " - " + avaliacoes.get(i).getNomeAluno(), vermelho1);
            am.set(rec + " - " + avaliacoes.get(i).getNomeAluno(), amamarelo1);
            azu.set(rec + " - " + avaliacoes.get(i).getNomeAluno(), azul1);
            verd.set(rec + " - " + avaliacoes.get(i).getNomeAluno(), verde1);

        }

        //}
        horizontalBarAluno.addSeries(verm);
        horizontalBarAluno.addSeries(am);
        horizontalBarAluno.addSeries(azu);
        horizontalBarAluno.addSeries(verd);

        horizontalBarAluno.setTitle("GRAFICO DE ALUNOS ");
        horizontalBarAluno.setSeriesColors("ff0000,ffff00,0000ff,66ff33");
        horizontalBarAluno.setLegendPosition("e");
        horizontalBarAluno.setStacked(true);
        horizontalBarAluno.setShowPointLabels(true);

        Axis xAxxis = horizontalBarAluno.getAxis(AxisType.X);
        xAxxis.setLabel("");
        xAxxis.setMin(0);
        xAxxis.setMax(150);
        xAxxis.setTickFormat("%1$.0f");
        Axis yAxxis = horizontalBarAluno.getAxis(AxisType.Y);
        yAxxis.setLabel("ALUNOS");

        //------------------------------------\\
    }

    public void mediaEscolarDescritor(Integer inep, Integer codSerie, Integer codDisciplina) throws ErroSistema {

        System.out.println("olha o codigo --------" + inep + "****----***" + codDisciplina + "----***------- " + codSerie);

        try {

            visivel = true;
            descritores = serieDao.listarDescritores(codSerie, codDisciplina);
            System.out.println("TAMANHO DESCRITORES ------ " + descritores.size());
            avaliacoes = alunoDao.listarGabaritoMediaEscolar(inep, codSerie);
            System.out.println("TAMANHO AVALIAÇÕES ------ " + avaliacoes.size());
            alunos = alunoDao.listarAlunos(inep, codSerie);
            System.out.println("TAMANHO ALUNOS ------ " + alunos.size());

            quantPresentes = avaliacoes.size();
            quantlunos = alunos.size();
            quantDescritores = descritores.size();

            quantQuest = quantlunos * quantDescritores;

            quantFaltosos = quantlunos - quantPresentes;

            resultevasaoTurma = 100 * quantPresentes / quantlunos;

            //------------alunoDao.insertFrequeciaTurma(codTurma, inep, codSerie, resultevasaoTurma);----//
            resulPreseTurma = 100 * quantFaltosos / quantlunos;

            System.out.println("@@@@@@@@@@@@@@@@@@@@@ " + resultevasaoTurma);

            resultdescritores = new ArrayList<String>();
            resulAlunos = new ArrayList<String>();

            if (avaliacoes.size() == 0) {
                adicionarMensagem("LISTADO!", "NÃO TEM AVALIAÇÂO CADASTRADA NESSA TURMA", FacesMessage.SEVERITY_INFO);

                return;
            }
            if (descritores.size() == 0) {
                adicionarMensagem("LISTADO!", "NÃO TEM DESCRITOR NEM GABARITO CADASTRADO", FacesMessage.SEVERITY_INFO);
                return;
            }
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

        dados = new String[quantPresentes][quantPresentes];
        String gaba = "";

        for (int co = 0; co < descritores.size(); co++) {

            Descritor gabarito = descritores.get(co);
            gaba += gabarito.getEspeciDescritor();
            System.out.println("ALTERNATIVAS DOS GABARITOS " + gabarito.getEspeciDescritor());
        }

        List<String> listaDeGabarito = new ArrayList<String>();

        String resp = "";
        char tes = 0;

        for (int av = 0; av < avaliacoes.size(); av++) {

            Avaliacao ava = avaliacoes.get(av);

            if (codDisciplina == 1) {
                listaDeGabarito.add(ava.getRespPortugues());
                resp = ava.getRespPortugues();
            }
            if (codDisciplina == 2) {
                listaDeGabarito.add(ava.getRespMatematica());
                resp = ava.getRespMatematica();
            }
            if (codDisciplina == 3) {
                listaDeGabarito.add(ava.getRespCienciasHumanas());
                resp = ava.getRespCienciasHumanas();
            }
            if (codDisciplina == 4) {
                listaDeGabarito.add(ava.getRespCienciasNatureza());
                resp = ava.getRespCienciasNatureza();
            }
        }

        String gabarito = gaba;

        String compara = "";
        Integer resultado = 0;

        List<String> listaDeResultado = new ArrayList<String>();

        int[][] data = new int[listaDeGabarito.size()][gabarito.length()];

        List<Integer> meuGabarito = new ArrayList<Integer>();

        System.out.println("tamano1 " + listaDeGabarito.size() + "tamanho2 " + gabarito.length());

        for (int b = 0; b < listaDeGabarito.size(); b++) {

            String a = listaDeGabarito.get(b);

            for (int i = 0; i < a.length(); i++) {

                if (a.charAt(i) == gabarito.charAt(i)) {

                    compara = compara + "1";
                    //resultado = resultado + Integer.parseInt(compara);

                } else {
                    compara = compara + "0";
                }
            }

            listaDeResultado.add(compara);
            System.out.println("lista de resultado " + compara);
            compara = "";
            resultado = 0;
        }

        String var = "";
        String nome = "";

        int s = 0;
        for (int i = 0; i < listaDeResultado.size(); i++) {

            System.out.println("***** -#######- ****" + listaDeResultado.size());
            Avaliacao aa = new Avaliacao();
            var = listaDeResultado.get(i);

            System.out.println("***** - - ****" + i);

            for (int j = 0; j < var.length(); j++) {

                int v = Character.getNumericValue(var.charAt(j));
                s = s + v;

                data[i][j] = v;

            }

            System.out.println("A SOMA DAS LINHAS É " + s);

            quantAcerto += s;
            System.out.println("A QUANTIDADE DE ACERTOS É " + quantAcerto);
            resulAlunos.add(Integer.toString(s));

            s = 0;
        }

        int size = data.length, largestRow = 0, sum = 0, col = 0;

        for (int check = 0; check <= (size - 1); check++) {
            if (largestRow < data[check].length) {
                largestRow = data[check].length;
            }
        }

        resultdescritores.add("RESULTADO DESCRITORES");

        do {
            for (int row = 0; row < data.length; row++) {
                //System.out.println("row(long): "+data[row].length+", col: "+col);
                //System.out.println(col>=(data[row].length-1));

                if (col >= (data[row].length)) {
                } else {
                    sum += data[row][col];
                }
            }
            col += 1;

            System.out.println("A SOMA DA COLUNA " + col + " É: " + (sum));//made the row +1, to make it understandable
            Integer dp = 100 * sum / descritores.size();

            descri.add(Integer.toString(dp));

            resultdescritores.add(Integer.toString(dp));

            // System.out.println(sum + "%");
            sum = 0;
        } while (col != largestRow);

        for (int av = 0; av < avaliacoes.size(); av++) {

            Avaliacao ava = avaliacoes.get(av);

            if (codDisciplina == 1) {
                listaDeGabarito.add(ava.getRespPortugues());
                resp = ava.getRespPortugues();
            }
            if (codDisciplina == 2) {
                listaDeGabarito.add(ava.getRespMatematica());
                resp = ava.getRespMatematica();
            }
            if (codDisciplina == 3) {
                listaDeGabarito.add(ava.getRespCienciasHumanas());
                resp = ava.getRespCienciasHumanas();
            }
            if (codDisciplina == 4) {
                listaDeGabarito.add(ava.getRespCienciasNatureza());
                resp = ava.getRespCienciasNatureza();
            }

            System.out.println("LISTA DE QUESTÕES POR ALUNO " + resp);
            dados[av][0] = avaliacoes.get(av).getNomeAluno();

            for (int j = 1; j <= descritores.size() + 1; j++) {

                if (j > descritores.size()) {
                    dados[av][j] = resulAlunos.get(av);
                } else {
                    if (codDisciplina == 1) {
                        tes = avaliacoes.get(av).getRespPortugues().charAt(j - 1);
                    }
                    if (codDisciplina == 2) {
                        tes = avaliacoes.get(av).getRespMatematica().charAt(j - 1);
                    }
                    if (codDisciplina == 3) {
                        tes = avaliacoes.get(av).getRespCienciasHumanas().charAt(j - 1);
                    }
                    if (codDisciplina == 4) {
                        tes = avaliacoes.get(av).getRespCienciasNatureza().charAt(j - 1);
                    }

                    String b = String.valueOf(tes);
                    System.out.println("############ " + b);

                    dados[av][j] = b;
                }

            }

        }

        horizontalBarModel = new HorizontalBarChartModel();

        ChartSeries vermelho = new ChartSeries();
        ChartSeries amarelo = new ChartSeries();
        ChartSeries azul = new ChartSeries();
        ChartSeries verde = new ChartSeries();

        vermelho.setLabel("25%");
        amarelo.setLabel("25% - 50%");
        azul.setLabel("50% - 75%");
        verde.setLabel("75% - 100%");

        //String a = "A";
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + resultdescritores.size());
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + descritores.size());

        int ve = 0;
        int ama = 0;
        int az = 0;
        int ver = 0;

        for (int i = 0; i < descritores.size(); i++) {
            int b = i + 1;

            int a = Integer.parseInt(resultdescritores.get(b));

            if (a <= 25) {
                ve = a;
                ama = 0;
                az = 0;
                ver = 0;
            }
            if (a > 24 && a <= 50) {
                ve = 0;
                ama = a;
                az = 0;
                ver = 0;
            }
            if (a > 49 && a <= 75) {
                ve = 0;
                ama = 0;
                az = a;
                ver = 0;
            }
            if (a > 74) {
                ve = 0;
                ama = 0;
                az = 0;
                ver = a;
            }

            System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + a);

            System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + descritores.get(i).getSiglaDescritor());

            vermelho.set(b + " - " + descritores.get(i).getSiglaDescritor(), ve);
            amarelo.set(b + " - " + descritores.get(i).getSiglaDescritor(), ama);
            azul.set(b + " - " + descritores.get(i).getSiglaDescritor(), az);
            verde.set(b + " - " + descritores.get(i).getSiglaDescritor(), ver);

        }

        //}
        horizontalBarModel.addSeries(vermelho);
        horizontalBarModel.addSeries(amarelo);
        horizontalBarModel.addSeries(azul);
        horizontalBarModel.addSeries(verde);

        horizontalBarModel.setTitle("GRAFICO DE DESCRITORES ");
        horizontalBarModel.setSeriesColors("ff0000,ffff00,0000ff,66ff33");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
        horizontalBarModel.setShowPointLabels(true);

        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("");
        xAxis.setMin(0);
        xAxis.setMax(110);
        xAxis.setTickFormat("%1$.0f");
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("DESCRITORES");

        horizontalEvasao = new HorizontalBarChartModel();
        ChartSeries evasao = new ChartSeries();
        ChartSeries presentes = new ChartSeries();

        evasao.setLabel("PRESENTES");
        evasao.set("PRESENTES", resultevasaoTurma);
        horizontalEvasao.addSeries(evasao);

        presentes.setLabel("EVASÃO");
        presentes.set("EVASÃO", resulPreseTurma);
        horizontalEvasao.addSeries(presentes);

        horizontalEvasao.setTitle("GRAFICO DE EVASÃO ");
        horizontalEvasao.setSeriesColors("66ff33,ff0000");
        horizontalEvasao.setLegendPosition("e");
        horizontalEvasao.setStacked(true);
        horizontalEvasao.setShowPointLabels(true);

        Axis xAxi = horizontalEvasao.getAxis(AxisType.X);
        xAxi.setLabel("");
        xAxi.setMin(0);
        xAxi.setMax(110);
        xAxi.setTickFormat("%1$.0f");
        Axis yAxi = horizontalEvasao.getAxis(AxisType.Y);
        yAxi.setLabel("EVASÃO");

        double rendN = quantQuest - quantAcerto;

        horizontalRendimento = new HorizontalBarChartModel();
        ChartSeries rendimentoP = new ChartSeries();
        ChartSeries rendimentoN = new ChartSeries();

        rendimentoP.setLabel("RENDIMENTO POSITIVO");

        double rend = quantAcerto * 100 / quantQuest;

        rendimentoP.set("", rend);

        // alunoDao.insertRendimentoTurma(codTurma, inep, codSerie, codDisciplina, rend);
        horizontalRendimento.addSeries(rendimentoP);

        rendimentoN.setLabel("RENDIMENTO NEGATIVO");
        rendimentoN.set("", rendN * 100 / quantQuest);
        horizontalRendimento.addSeries(rendimentoN);
        horizontalRendimento.setTitle("GRAFICO DE RENDIMENTO DA SÉRIE ");
        horizontalRendimento.setSeriesColors("66ff33,ff0000");
        horizontalRendimento.setLegendPosition("e");
        horizontalRendimento.setStacked(true);
        horizontalRendimento.setShowPointLabels(true);

        Axis rAxi = horizontalRendimento.getAxis(AxisType.X);
        rAxi.setLabel("");
        rAxi.setMin(0);
        rAxi.setMax(110);
        rAxi.setTickFormat("%1$.0f");
        Axis yrAxi = horizontalRendimento.getAxis(AxisType.Y);
        yrAxi.setLabel("");
        rend = 0;
    }

    public void mediaGeralDescritor(Integer codSerie, Integer codDisciplina) throws ErroSistema {

        try {

            visivel = true;
            descritores = serieDao.listarDescritores(codSerie, codDisciplina);
            System.out.println("TAMANHO DESCRITORES ------ " + descritores.size());
            avaliacoes = alunoDao.listarGabaritoGeral(codSerie);
            System.out.println("TAMANHO AVALIAÇÕES ------ " + avaliacoes.size());
            alunos = alunoDao.listarTodosAlunos(codSerie);
            System.out.println("TAMANHO ALUNOS ------ " + alunos.size());

            quantPresentes = avaliacoes.size();
            quantlunos = alunos.size();
            quantDescritores = descritores.size();

            quantQuest = quantlunos * quantDescritores;

            quantFaltosos = quantlunos - quantPresentes;

            resultevasaoTurma = 100 * quantPresentes / quantlunos;

            //------------alunoDao.insertFrequeciaTurma(codTurma, inep, codSerie, resultevasaoTurma);----//
            resulPreseTurma = 100 * quantFaltosos / quantlunos;

            System.out.println("@@@@@@@@@@@@@@@@@@@@@ " + resultevasaoTurma);

            resultdescritores = new ArrayList<String>();
            resulAlunos = new ArrayList<String>();

            if (avaliacoes.size() == 0) {
                adicionarMensagem("LISTADO!", "NÃO TEM AVALIAÇÂO CADASTRADA NESSA TURMA", FacesMessage.SEVERITY_INFO);

                return;
            }
            if (descritores.size() == 0) {
                adicionarMensagem("LISTADO!", "NÃO TEM DESCRITOR NEM GABARITO CADASTRADO", FacesMessage.SEVERITY_INFO);
                return;
            }
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

        dados = new String[quantPresentes + descritores.size()][quantPresentes + descritores.size()];
        String gaba = "";

        for (int co = 0; co < descritores.size(); co++) {

            Descritor gabarito = descritores.get(co);
            gaba += gabarito.getEspeciDescritor();
            System.out.println("ALTERNATIVAS DOS GABARITOS " + gabarito.getEspeciDescritor());
        }

        List<String> listaDeGabarito = new ArrayList<String>();

        String resp = "";
        char tes = 0;

        for (int av = 0; av < avaliacoes.size(); av++) {

            Avaliacao ava = avaliacoes.get(av);

            if (codDisciplina == 1) {
                listaDeGabarito.add(ava.getRespPortugues());
                resp = ava.getRespPortugues();
            }
            if (codDisciplina == 2) {
                listaDeGabarito.add(ava.getRespMatematica());
                resp = ava.getRespMatematica();
            }
            if (codDisciplina == 3) {
                listaDeGabarito.add(ava.getRespCienciasHumanas());
                resp = ava.getRespCienciasHumanas();
            }
            if (codDisciplina == 4) {
                listaDeGabarito.add(ava.getRespCienciasNatureza());
                resp = ava.getRespCienciasNatureza();
            }
        }

        String gabarito = gaba;

        String compara = "";
        Integer resultado = 0;

        List<String> listaDeResultado = new ArrayList<String>();

        int[][] data = new int[listaDeGabarito.size()][gabarito.length()];

        List<Integer> meuGabarito = new ArrayList<Integer>();

        System.out.println("tamano1 " + listaDeGabarito.size() + "tamanho2 " + gabarito.length());

        for (int b = 0; b < listaDeGabarito.size(); b++) {

            String a = listaDeGabarito.get(b);

            for (int i = 0; i < a.length(); i++) {

                if (a.charAt(i) == gabarito.charAt(i)) {

                    compara = compara + "1";
                    //resultado = resultado + Integer.parseInt(compara);

                } else {
                    compara = compara + "0";
                }
            }

            listaDeResultado.add(compara);
            System.out.println("lista de resultado " + compara);
            compara = "";
            resultado = 0;
        }

        String var = "";
        String nome = "";

        int s = 0;
        for (int i = 0; i < listaDeResultado.size(); i++) {

            System.out.println("***** -#######- ****" + listaDeResultado.size());
            Avaliacao aa = new Avaliacao();
            var = listaDeResultado.get(i);

            System.out.println("***** - - ****" + i);
            // System.out.println("***** - - ****" + avaliacoes.get(i).getNomeAluno());
            //Avaliacao ava = avaliacoes.get(i);
            // nome = ava.getNomeAluno();
            for (int j = 0; j < var.length(); j++) {

                //  int a =  var.charAt(j
                int v = Character.getNumericValue(var.charAt(j));
                s = s + v;
                // System.out.println("***** - - ****" + s);
                //  System.out.println( "yyyyyy"+v + "uuuuu"+var.charAt(j));
                //data[i][j] = var.charAt(j);
                data[i][j] = v;
                // System.out.println("olha ****" + v++);

            }

            System.out.println("A SOMA DAS LINHAS É " + s);
            //Integer ra = 100 * s / descritores.size();
            Integer ra = s;
            quantAcerto += s;
            System.out.println("A QUANTIDADE DE ACERTOS É " + quantAcerto);
            resulAlunos.add(Integer.toString(ra));

            s = 0;
        }

        int size = data.length, largestRow = 0, sum = 0, col = 0;

        for (int check = 0; check <= (size - 1); check++) {
            if (largestRow < data[check].length) {
                largestRow = data[check].length;
            }
        }

        resultdescritores.add("RESULTADO DESCRITORES");

        do {
            for (int row = 0; row < data.length; row++) {
                //System.out.println("row(long): "+data[row].length+", col: "+col);
                //System.out.println(col>=(data[row].length-1));

                if (col >= (data[row].length)) {
                } else {
                    sum += data[row][col];
                }
            }
            col += 1;

            System.out.println("A SOMA DA COLUNA " + col + " É: " + (sum));//made the row +1, to make it understandable
            //Integer dp = 100 * sum / quantPresentes;
            Integer dp = sum;

            descri.add(Integer.toString(dp));

            resultdescritores.add(Integer.toString(dp));

            // System.out.println(sum + "%");
            sum = 0;
        } while (col != largestRow);

        for (int av = 0; av < avaliacoes.size(); av++) {

            Avaliacao ava = avaliacoes.get(av);

            if (codDisciplina == 1) {
                listaDeGabarito.add(ava.getRespPortugues());
                resp = ava.getRespPortugues();
            }
            if (codDisciplina == 2) {
                listaDeGabarito.add(ava.getRespMatematica());
                resp = ava.getRespMatematica();
            }
            if (codDisciplina == 3) {
                listaDeGabarito.add(ava.getRespCienciasHumanas());
                resp = ava.getRespCienciasHumanas();
            }
            if (codDisciplina == 4) {
                listaDeGabarito.add(ava.getRespCienciasNatureza());
                resp = ava.getRespCienciasNatureza();
            }

            System.out.println("LISTA DE QUESTÕES POR ALUNO " + resp);
            dados[av][0] = avaliacoes.get(av).getNomeAluno();

            for (int j = 1; j <= descritores.size() + 1; j++) {

                if (j > descritores.size()) {
                    dados[av][j] = resulAlunos.get(av);
                } else {
                    if (codDisciplina == 1) {
                        tes = avaliacoes.get(av).getRespPortugues().charAt(j - 1);
                    }
                    if (codDisciplina == 2) {
                        tes = avaliacoes.get(av).getRespMatematica().charAt(j - 1);
                    }
                    if (codDisciplina == 3) {
                        tes = avaliacoes.get(av).getRespCienciasHumanas().charAt(j - 1);
                    }
                    if (codDisciplina == 4) {
                        tes = avaliacoes.get(av).getRespCienciasNatureza().charAt(j - 1);
                    }

                    String b = String.valueOf(tes);
                    System.out.println("############ " + b);

                    dados[av][j] = b;
                }

            }

        }

        // -----------------------------------------------------------\\
        //**********************************************************************************\\
        /* ArrayList<Descritor> teste = new ArrayList<>();

        for (int i = 0; i < descritores.size(); i++) {

            int cont = 0;
            Descritor rd = new Descritor();

            int a = Integer.parseInt(resultdescritores.get(i + 1));
            double so = 0;

            for (int j = 0; j < descritores.size(); j++) {
                System.out.println("descritor 1 " + descritores.get(i).getSiglaDescritor());
                System.out.println("descritor 2 " + descritores.get(j).getSiglaDescritor());
                int aa = Integer.parseInt(resultdescritores.get(j + 1));
                if (descritores.get(i).getSiglaDescritor().equals(descritores.get(j).getSiglaDescritor())) {

                    so += aa;
                    cont++;
                }

            }
            double t = 0;
            System.out.println("quantidade de repetição " + descritores.get(i).getSiglaDescritor() + " - " + cont);

            if (cont >= 2) {
                t = so;
            } else {
                t = a;
            }

            System.out.println("olha o teste " + teste.size());
            cont = 0;

            if (teste.size() == 0) {
                rd.setSiglaDescritor(descritores.get(i).getSiglaDescritor());
                System.out.println("************* " + rd.getSiglaDescritor());

                System.out.println("************* porcentagem descritor" + a);

                rd.setResultDescritor(t);

                teste.add(rd);
            } else {

                for (int d = 0; d < teste.size(); d++) {

                    System.out.println("************* descritor 1 " + descritores.get(i).getSiglaDescritor());
                    System.out.println("*************  descritor 2 " + teste.get(d).getSiglaDescritor());

                    if (descritores.get(i).getSiglaDescritor().equals(teste.get(d).getSiglaDescritor())) {
                        cont++;
                        /*rd.setSiglaDescritor(descritores.get(i).getSiglaDescritor());

                        System.out.println("************* " + rd.getSiglaDescritor());

                        System.out.println("************* porcentagem descritor" + a);

                        rd.setResultDescritor(i);

                        teste.add(rd);
                    }

                }
                if (cont < 1) {
                    rd.setSiglaDescritor(descritores.get(i).getSiglaDescritor());

                    System.out.println("************* " + rd.getSiglaDescritor());

                    System.out.println("************* porcentagem descritor" + a);

                    rd.setResultDescritor(t);

                    teste.add(rd);
                }

                cont = 0;
            }
            System.out.println("************* tamanho da lista teste ##**##" + teste.size());

            for (int j = 0; j < teste.size(); j++) {
                System.out.println("*************" + teste.get(j).getSiglaDescritor());
                System.out.println("*************" + teste.get(j).getResultDescritor());
            }
         */
 /*  
            resultDescritor.setSiglaDescritor(descritores.get(i).getSiglaDescritor());
            System.out.println("************* " + resultDescritor.getSiglaDescritor());
            int a = Integer.parseInt(resultdescritores.get(i + 1));
            System.out.println("************* porcentagem descritor" + a);

            resultDescritor.setResultDescritor(a);
            teste.add(resultDescritor);*/
        // }
//*****************************************************************************************\\
        horizontalBarModel = new HorizontalBarChartModel();

        ChartSeries vermelho = new ChartSeries();
        ChartSeries amarelo = new ChartSeries();
        ChartSeries azul = new ChartSeries();
        ChartSeries verde = new ChartSeries();

        vermelho.setLabel("25%");
        amarelo.setLabel("25% - 50%");
        azul.setLabel("50% - 75%");
        verde.setLabel("75% - 100%");

        //String a = "A";
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + resultdescritores.size());
        System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + descritores.size());

        double ve = 0;
        double ama = 0;
        double az = 0;
        double ver = 0;

        for (int i = 0; i < descritores.size(); i++) {
            int b = i + 1;
            int dec = descritores.size() - i;
            int a = Integer.parseInt(resultdescritores.get(b));

            a = a * 100 / quantPresentes;

            System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb ****** " + a);
            System.out.println("de tras para frente ****** " + dec);

            if (a <= 25) {
                ve = a;
                ama = 0;
                az = 0;
                ver = 0;
            }
            if (a > 24 && a <= 50) {
                ve = 0;
                ama = a;
                az = 0;
                ver = 0;
            }
            if (a > 49 && a <= 75) {
                ve = 0;
                ama = 0;
                az = a;
                ver = 0;
            }
            if (a > 74) {
                ve = 0;
                ama = 0;
                az = 0;
                ver = a;
            }

            System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + a);

            System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + descritores.get(i).getSiglaDescritor());

            vermelho.set(dec + " - " + descritores.get(i).getSiglaDescritor(), ve);
            amarelo.set(dec + " - " + descritores.get(i).getSiglaDescritor(), ama);
            azul.set(dec + " - " + descritores.get(i).getSiglaDescritor(), az);
            verde.set(dec + " - " + descritores.get(i).getSiglaDescritor(), ver);

        }

        //}
        horizontalBarModel.addSeries(vermelho);
        horizontalBarModel.addSeries(amarelo);
        horizontalBarModel.addSeries(azul);
        horizontalBarModel.addSeries(verde);

        horizontalBarModel.setTitle("GRAFICO DE DESCRITORES ");
        horizontalBarModel.setSeriesColors("ff0000,ffff00,0000ff,66ff33");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
        horizontalBarModel.setShowPointLabels(true);

        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("");
        xAxis.setMin(0);
        xAxis.setMax(150);
        xAxis.setTickFormat("%1$.0f");
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("DESCRITORES");

        // -----------------------------------------------------------\\
        //------------------------------------------------------------\\
         horizontalBarAluno = new HorizontalBarChartModel();

        ChartSeries verm = new ChartSeries();
        ChartSeries am = new ChartSeries();
        ChartSeries azu = new ChartSeries();
        ChartSeries verd = new ChartSeries();

        verm.setLabel("25%");
        am.setLabel("25% - 50%");
        azu.setLabel("50% - 75%");
        verd.setLabel("75% - 100%");

        //String a = "A";
        //  System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + resultdescritores.size());
        //System.out.println("xxxxxxxxxxxxxxxxxx----xxxxxxxxxxxxxxx " + descritores.size());
        int vermelho1 = 0;
        int amamarelo1 = 0;
        int azul1 = 0;
        int verde1 = 0;

        for (int i = 0; i < avaliacoes.size(); i++) {
            int b = i + 1;

            //System.out.println("quantidade de alunos "+resulAlunos.size());
            //  int a = Integer.parseInt(resulAlunos.get(i));
            int a = Integer.parseInt(resulAlunos.get(i));
            a = a * 100 / quantDescritores;

            //int a = Integer.parseInt("10");
            if (a <= 25) {
                vermelho1 = a;
                amamarelo1 = 0;
                azul1 = 0;
                verde1 = 0;
            }
            if (a > 24 && a <= 50) {
                vermelho1 = 0;
                amamarelo1 = a;
                azul1 = 0;
                verde1 = 0;
            }
            if (a > 49 && a <= 75) {
                vermelho1 = 0;
                amamarelo1 = 0;
                azul1 = a;
                verde1 = 0;
            }
            if (a > 74) {
                vermelho1 = 0;
                amamarelo1 = 0;
                azul1 = 0;
                verde1 = a;
            }

            // System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + a);
            // System.out.println("xxxxxxxxxxxxxxxxxx--descritores--xxxxxxxxxxxxxxx " + descritores.get(i).getSiglaDescritor());
            verm.set(i + " - " + avaliacoes.get(i).getNomeAluno(), vermelho1);
            am.set(i + " - " + avaliacoes.get(i).getNomeAluno(), amamarelo1);
            azu.set(i + " - " + avaliacoes.get(i).getNomeAluno(), azul1);
            verd.set(i + " - " + avaliacoes.get(i).getNomeAluno(), verde1);

        }

        //}
        horizontalBarAluno.addSeries(verm);
        horizontalBarAluno.addSeries(am);
        horizontalBarAluno.addSeries(azu);
        horizontalBarAluno.addSeries(verd);

        horizontalBarAluno.setTitle("GRAFICO DE ALUNOS ");
        horizontalBarAluno.setSeriesColors("ff0000,ffff00,0000ff,66ff33");
        horizontalBarAluno.setLegendPosition("e");
        horizontalBarAluno.setStacked(true);
        horizontalBarAluno.setShowPointLabels(true);

        Axis xAAxis = horizontalBarAluno.getAxis(AxisType.X);
        xAAxis.setLabel("");
        xAAxis.setMin(0);
        xAAxis.setMax(150);
        xAAxis.setTickFormat("%1$.0f");
        Axis yAAxis = horizontalBarAluno.getAxis(AxisType.Y);
        yAAxis.setLabel("ALUNOS");
        //------------------------------------\\
        horizontalEvasao = new HorizontalBarChartModel();
        ChartSeries evasao = new ChartSeries();
        ChartSeries presentes = new ChartSeries();

        evasao.setLabel("PRESENTES");
        evasao.set("", resultevasaoTurma);
        horizontalEvasao.addSeries(evasao);

        presentes.setLabel("EVASÃO");
        presentes.set("", resulPreseTurma);
        horizontalEvasao.addSeries(presentes);

        horizontalEvasao.setTitle("GRAFICO DE EVASÃO ");
        horizontalEvasao.setSeriesColors("66ff33,ff0000");
        horizontalEvasao.setLegendPosition("e");
        horizontalEvasao.setStacked(true);
        horizontalEvasao.setShowPointLabels(true);

        Axis xAxi = horizontalEvasao.getAxis(AxisType.X);
        xAxi.setLabel("");
        xAxi.setMin(0);
        xAxi.setMax(150);
        xAxi.setTickFormat("%1$.0f");
        Axis yAxi = horizontalEvasao.getAxis(AxisType.Y);
        yAxi.setLabel("");

        double rendN = quantQuest - quantAcerto;

        horizontalRendimento = new HorizontalBarChartModel();
        ChartSeries rendimentoP = new ChartSeries();
        ChartSeries rendimentoN = new ChartSeries();

        rendimentoP.setLabel("RENDIMENTO POSITIVO");

        double rend = quantAcerto * 100 / quantQuest;

        rendimentoP.set("", rend);

        // alunoDao.insertRendimentoTurma(codTurma, inep, codSerie, codDisciplina, rend);
        horizontalRendimento.addSeries(rendimentoP);

        rendimentoN.setLabel("RENDIMENTO NEGATIVO");
        rendimentoN.set("", rendN * 100 / quantQuest);
        horizontalRendimento.addSeries(rendimentoN);
        horizontalRendimento.setTitle("GRAFICO DE RENDIMENTO DO MUNICIPIO ");
        horizontalRendimento.setSeriesColors("66ff33,ff0000");
        horizontalRendimento.setLegendPosition("e");
        horizontalRendimento.setStacked(true);
        horizontalRendimento.setShowPointLabels(true);

        Axis rAxi = horizontalRendimento.getAxis(AxisType.X);
        rAxi.setLabel("");
        rAxi.setMin(0);
        rAxi.setMax(150);
        rAxi.setTickFormat("%1$.0f");
        Axis yrAxi = horizontalRendimento.getAxis(AxisType.Y);
        yrAxi.setLabel("");
        rend = 0;
        quantAcerto = 0;
        quantQuest = 0;

    }

    public void imprimirAlunos(String serie) throws ErroSistema {

        Map<String, Object> params = new HashMap<String, Object>();

        String a = "";
        if (serie.equals("1") || serie.equals("2")) {
            System.out.println("com.br.seducpaudalho.Bean.AlunoBean.imprimirAlunos()" + serie);
            a = "gaba1";
        }
        if (serie.equals("3") || serie.equals("4") || serie.equals("5")) {
            System.out.println("com.br.seducpaudalho.Bean.AlunoBean.imprimirAlunos()" + serie);
            a = "gaba2";
        }
        if (serie.equals("6") || serie.equals("7") || serie.equals("12")) {
            System.out.println("com.br.seducpaudalho.Bean.AlunoBean.imprimirAlunos()" + serie);
            a = "gaba3";
        }
        if (serie.equals("8")) {
            System.out.println("com.br.seducpaudalho.Bean.AlunoBean.imprimirAlunos()" + serie);
            a = "gaba4";
        }
        if (serie.equals("9")) {
            System.out.println("com.br.seducpaudalho.Bean.AlunoBean.imprimirAlunos()" + serie);
            a = "gaba5";
        }
        if (serie.equals("13")) {
            System.out.println("com.br.seducpaudalho.Bean.AlunoBean.imprimirAlunos()" + serie);
            a = "gaba6";
        }
        if (serie.equals("18")) {
            System.out.println("com.br.seducpaudalho.Bean.AlunoBean.imprimirAlunos()" + serie);
            a = "saepinha";
        }

        try {
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(alunos);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.responseComplete();
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
            String path = scontext.getRealPath("/WEB-INF/relatorios/");
            params.put("SUBREPORT_DIR", path + File.separator);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    scontext.getRealPath("/WEB-INF/relatorios/") + a + ".jasper", params, dataSource);
            HttpServletResponse res = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            res.setContentType("application/pdf");
            int codigo = (int) (Math.random() * 1000);
            res.setHeader("Content-disposition", "inline;filename=relatorio_" + codigo + ".pdf");
            byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
            res.getOutputStream().write(b);
            res.getCharacterEncoding();
            facesContext.responseComplete();
        } catch (Exception e) {
            Logger.getLogger("ERRO").log(Level.SEVERE, null, e);
            //adicionarMensagem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        }

    }

    public void imprimirReservas() throws ErroSistema {

        Map<String, Object> params = new HashMap<String, Object>();
        String a = "gabareserva";

        List<Aluno> alunosReserva = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            Aluno aa = new Aluno();

            aa.setNomeEscola(alunos.get(10).getNomeEscola());
            aa.setNomeSerie(alunos.get(12).getNomeSerie());
            aa.setNomeTurma(alunos.get(14).getNomeTurma());
            aa.setTurno(alunos.get(5).getTurno());

            alunosReserva.add(aa);

        }

        System.out.println("com.br.seducpaudalho.Bean.AlunoBean.imprimirReservas()" + alunosReserva.size());

        try {
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(alunosReserva);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.responseComplete();
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
            String path = scontext.getRealPath("/WEB-INF/relatorios/");
            params.put("SUBREPORT_DIR", path + File.separator);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    scontext.getRealPath("/WEB-INF/relatorios/") + a + ".jasper", params, dataSource);
            HttpServletResponse res = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            res.setContentType("application/pdf");
            int codigo = (int) (Math.random() * 1000);
            res.setHeader("Content-disposition", "inline;filename=relatorio_" + codigo + ".pdf");
            byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
            res.getOutputStream().write(b);
            res.getCharacterEncoding();
            facesContext.responseComplete();
        } catch (Exception e) {
            Logger.getLogger("ERRO").log(Level.SEVERE, null, e);
            //adicionarMensagem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        }

    }

    public void imprimirListaAluno() throws ErroSistema {

        Map<String, Object> params = new HashMap<String, Object>();
        String a = "listaA";

        try {
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(alunos);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.responseComplete();
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
            String path = scontext.getRealPath("/WEB-INF/relatorios/");
            params.put("SUBREPORT_DIR", path + File.separator);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    scontext.getRealPath("/WEB-INF/relatorios/") + a + ".jasper", params, dataSource);
            HttpServletResponse res = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            res.setContentType("application/pdf");
            int codigo = (int) (Math.random() * 1000);
            res.setHeader("Content-disposition", "inline;filename=relatorio_" + codigo + ".pdf");
            byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
            res.getOutputStream().write(b);
            res.getCharacterEncoding();
            facesContext.responseComplete();
        } catch (Exception e) {
            Logger.getLogger("ERRO").log(Level.SEVERE, null, e);
            //adicionarMensagem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        }

    }

    public void concatDescritores() {

        if (!concatDescritor.equals("")) {
            System.out.println("descritor é diferente de nulo------------");
            associacao.setDescritor(concatDescritor + "/" + associacao.getDescritor());
        } else {
            System.out.println("entrou no else descritor não é diferente de nulo------------");
            descritor.setSiglaDescritor(associacao.getDescritor());
        }

        concatDescritor = associacao.getDescritor();
        System.out.println("olha avariavel concat ------------ " + concatDescritor);
    }

    public void apagarSelecao() {

        concatDescritor = "";
        descritor.setSiglaDescritor(concatDescritor);
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

    public List<SelectItem> getSelectDescritor() throws ErroSistema {

        System.out.println("----------------------------------------------");
        if (selectDescritor == null) {
            selectDescritor = new ArrayList<SelectItem>();
            descritor = new Descritor();
            descritores = serieDao.listarDescritores(1, 1);

            if (descritores != null && !descritores.isEmpty()) {

                SelectItem item;
                for (Descritor descritorLista : descritores) {

                    item = new SelectItem(descritorLista, descritorLista.getSiglaDescritor());
                    selectDescritor.add(item);
                }
            }

        }

        return selectDescritor;
    }

    public List<SelectItem> getSelectDisciplina() {

        System.out.println("----------------------------------------------");
        if (selectDisciplina == null) {
            selectDisciplina = new ArrayList<SelectItem>();
            disciplina = new Disciplina();
            //escolas = escolaDao.listarEscolas();

            if (disciplinas != null && !disciplinas.isEmpty()) {

                SelectItem item;
                for (Disciplina disciplinaLista : disciplinas) {

                    item = new SelectItem(disciplinaLista, disciplinaLista.getNomeDisciplina());
                    selectDisciplina.add(item);
                }
            }

        }

        return selectDisciplina;
    }

    public void setSelectDisciplina(List<SelectItem> selectDisciplina) {
        this.selectDisciplina = selectDisciplina;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Disciplina> getDisciplinas() throws ErroSistema {
        // disciplinas = escolaDao.listarDisciplinas();
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
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

    public void onRowEdit(RowEditEvent event) throws ErroSistema {

        Associacao a = (Associacao) event.getObject();
        a.getCodAssociacao();
        a.getDescritor();
        a.getAlternativa();

        alunoDao.atualizarAssociacao(a);

        System.out.println("codigo " + a.getCodAssociacao() + " descritor " + a.getDescritor() + " alternativa" + a.getAlternativa());
        FacesMessage msg = new FacesMessage("EDITE ", ((Associacao) event.getObject()).getCodAssociacao().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void atualizarAssociacao() throws ErroSistema {

        System.out.println("XXXXXXXXXXXXXXXXXXX" + concatDescritor);
        associacao.setDescritor(concatDescritor);
        System.out.println("################## " + associacao.getAlternativa() + " - " + associacao.getQuestao() + " - " + associacao.getDescritor());

        alunoDao.atualizarAssociacao(associacao);

        //   System.out.println("codigo " + a.getCodAssociacao() + " descritor " + a.getDescritor() + " alternativa" + a.getAlternativa());
        //FacesMessage msg = new FacesMessage("EDITE ", ((Associacao) event.getObject()).getCodAssociacao().toString());
        // FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("CANCELAR", ((Associacao) event.getObject()).getCodAssociacao().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        System.out.println("olha o concat descritor------------ " + concatDescritor);

        if (!concatDescritor.equals("")) {
            System.out.println("descritor é diferente de nulo------------");
            associacao.setDescritor(concatDescritor + "/" + newValue);
        } else {
            System.out.println("entrou no else descritor não é diferente de nulo------------");
            associacao.setDescritor((String) oldValue + newValue);
        }

        concatDescritor = (String) oldValue + newValue;
        System.out.println("olha avariavel concat ------XXXXXXXX------ " + concatDescritor);

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void teste(CellEditEvent event) {
        System.out.println("----------------------------------");
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

    public Correcao getCorrecao() {
        return correcao;
    }

    public void setCorrecao(Correcao correcao) {
        this.correcao = correcao;
    }

    public List<Correcao> getCorrecoes() {
        return correcoes;
    }

    public void setCorrecoes(List<Correcao> correcoes) {
        this.correcoes = correcoes;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Avaliacao> getResul() {
        return resul;
    }

    public void setResul(List<Avaliacao> resul) {
        this.resul = resul;
    }

    public List<String> getDescri() {
        return descri;
    }

    public void setDescri(List<String> descri) {
        this.descri = descri;
    }

    public BarChartModel getBarra() {
        return barra;
    }

    public void setBarra(BarChartModel barra) {
        this.barra = barra;
    }

    public HorizontalBarChartModel getBarraHorizontal() {
        return barraHorizontal;
    }

    public void setBarraHorizontal(HorizontalBarChartModel barraHorizontal) {
        this.barraHorizontal = barraHorizontal;
    }

    public LineChartModel getBarraLinha() {
        return barraLinha;
    }

    public void setBarraLinha(LineChartModel barraLinha) {
        this.barraLinha = barraLinha;
    }

    public Descritor getDescritor() {
        return descritor;
    }

    public void setDescritor(Descritor descritor) {
        this.descritor = descritor;
    }

    public Associacao getAssociacao() {
        return associacao;
    }

    public void setAssociacao(Associacao associacao) {
        this.associacao = associacao;
    }

    public String getConcatDescritor() {
        return concatDescritor;
    }

    public void setConcatDescritor(String concatDescritor) {
        this.concatDescritor = concatDescritor;
    }

    public List<Associacao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Associacao> questoes) {
        this.questoes = questoes;
    }

    public List<Descritor> getDescritores() {
        return descritores;
    }

    public void setDescritores(List<Descritor> descritores) {
        this.descritores = descritores;
    }

    public List<String> getColunas() {
        return colunas;
    }

    public void setColunas(List<String> colunas) {
        this.colunas = colunas;
    }

    public String[][] getDados() {
        return dados;
    }

    public void setDados(String[][] dados) {
        this.dados = dados;
    }

    public List<String> getResultdescritores() {
        return resultdescritores;
    }

    public void setResultdescritores(List<String> resultdescritores) {
        this.resultdescritores = resultdescritores;
    }

    public List<String> getResulAlunos() {
        return resulAlunos;
    }

    public void setResulAlunos(List<String> resulAlunos) {
        this.resulAlunos = resulAlunos;
    }

    public Integer getQuantlunos() {
        return quantlunos;
    }

    public void setQuantlunos(Integer quantlunos) {
        this.quantlunos = quantlunos;
    }

    public Integer getQuantPresentes() {
        return quantPresentes;
    }

    public void setQuantPresentes(Integer quantPresentes) {
        this.quantPresentes = quantPresentes;
    }

    public double getResultevasaoTurma() {
        return resultevasaoTurma;
    }

    public void setResultevasaoTurma(double resultevasaoTurma) {
        this.resultevasaoTurma = resultevasaoTurma;
    }

    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    public void setBarChartModel(BarChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }

    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }

    public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
        this.horizontalBarModel = horizontalBarModel;
    }

    public double getQuantFaltosos() {
        return quantFaltosos;
    }

    public void setQuantFaltosos(double quantFaltosos) {
        this.quantFaltosos = quantFaltosos;
    }

    public HorizontalBarChartModel getHorizontalEvasao() {
        return horizontalEvasao;
    }

    public void setHorizontalEvasao(HorizontalBarChartModel horizontalEvasao) {
        this.horizontalEvasao = horizontalEvasao;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public HorizontalBarChartModel getHorizontalRendimento() {
        return horizontalRendimento;
    }

    public void setHorizontalRendimento(HorizontalBarChartModel horizontalRendimento) {
        this.horizontalRendimento = horizontalRendimento;
    }

    public HorizontalBarChartModel getHorizontalBarAluno() {
        return horizontalBarAluno;
    }

    public void setHorizontalBarAluno(HorizontalBarChartModel horizontalBarAluno) {
        this.horizontalBarAluno = horizontalBarAluno;
    }

    public Integer getCa() {
        return ca;
    }

    public void setCa(Integer ca) {
        this.ca = ca;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

}
/*String frase = "00149/007587/10987";
        String array[] = new String[3];
        array = frase.split("/");
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);*/
        //String gabarito = descritores.get(0).getEspeciDescritor();
