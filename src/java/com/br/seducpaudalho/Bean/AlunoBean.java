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
    List<Descritor> descritores = new ArrayList<>();

    private Associacao associacao = new Associacao();
    List<Associacao> questoes = new ArrayList<>();

    private BarChartModel barra;
    private HorizontalBarChartModel barraHorizontal;
    private LineChartModel barraLinha;
    private String concatDescritor = "";
    private List<String> colunas = new ArrayList<String>();

    String[][] dados;
    private List<String> resultdescritores = new ArrayList<String>();
    private List<String> resulAlunos = new ArrayList<String>();

    private Integer quantlunos = 0;
    private Integer quantPresentes = 0;

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

    public void salvarDescritor() throws ErroSistema {

        alunoDao.salvarDescritor(descritor);
        adicionarMensagem("SALVO COM SUCESSO!", "", FacesMessage.SEVERITY_INFO);

        descritor = new Descritor();
    }

    public void salvarQuestoes() throws ErroSistema {

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
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }

    public void listarSerieParametro(Integer codigo) {

        System.out.println("--------****----***----***------- " + codigo);
        try {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ");
            series = serieDao.listarSerieParametro(codigo);
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

    public void listarTurmasParametro(Integer codigo) {

        System.out.println("olha o codigo da turma--------****----***----***------- " + codigo);
        try {
            turmas = turmaDao.listarTurmaParametro(codigo);
            //adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
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

        barra = new BarChartModel();

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
        yAxis.setMax(10);
    }

    public void graficoHorizontal() {

        barraHorizontal = new HorizontalBarChartModel();

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
        yAxis.setMax(10);
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

            descritores = serieDao.listarDescritores(codSerie, codDisciplina);
            avaliacoes = alunoDao.listarGabaritosAlunos(codTurma, inep, codSerie);
            alunos = alunoDao.imprimirAlunos(codTurma, inep, codSerie);

            quantPresentes = avaliacoes.size();
            quantlunos = alunos.size();

            resultdescritores = new ArrayList<String>();
            resulAlunos = new ArrayList<String>();

            if (descritores.size() == 0) {
                adicionarMensagem("LISTADO!", "NÃO TEM DESCRITOR NEM GABARITO CADASTRADO", FacesMessage.SEVERITY_INFO);
                return;
            }
            adicionarMensagem("LISTADO!", "LISTADO COM SUCESSO", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

        dados = new String[descritores.size() + 2][descritores.size() + 2];
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
            descri.add(Integer.toString(sum));
            resultdescritores.add(Integer.toString(sum));
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

    }

    public void imprimirAlunos() throws ErroSistema {

        Map<String, Object> params = new HashMap<String, Object>();
        String a = "gaba1";

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

}
/*String frase = "00149/007587/10987";
        String array[] = new String[3];
        array = frase.split("/");
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);*/
        //String gabarito = descritores.get(0).getEspeciDescritor();
