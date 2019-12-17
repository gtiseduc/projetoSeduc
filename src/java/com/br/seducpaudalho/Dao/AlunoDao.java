package com.br.seducpaudalho.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.seducpaudalho.Entidade.Aluno;
import com.br.seducpaudalho.Entidade.Associacao;
import com.br.seducpaudalho.Entidade.Avaliacao;
import com.br.seducpaudalho.Entidade.Correcao;
import com.br.seducpaudalho.Entidade.Descritor;
import com.br.seducpaudalho.Entidade.Fornecedor;
import com.br.seducpaudalho.Entidade.FrequenciaTurma;
import com.br.seducpaudalho.Entidade.Produto;
import com.br.seducpaudalho.Entidade.RendimentoTurma;
import com.br.seducpaudalho.Entidade.Serie;
import com.br.seducpaudalho.Entidade.Turma;
import com.br.seducpaudalho.Util.Excepition.ErroSistema;
import com.br.seducpaudalho.Util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VICTOR HUGO
 */
public class AlunoDao {

    public void salvarAluno(Aluno aluno) throws ErroSistema {
        try {
            String sql = "";
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

            if (aluno.getIdAluno() == null) {
                System.out.println("--------- entrou no if cadastro aluno");
                ps = conexao.prepareStatement("INSERT INTO aluno(codSerie,codTurma,inepEscola,nomeAluno,turno)VALUES (?,?,?,?,?)");
            } else {
                System.out.println("--------- entrou no else cadastro aluno" + aluno.getIdAluno());
                ps = conexao.prepareStatement("UPDATE aluno SET codSerie=?,codTurma=?,inepEscola=?,nomeAluno=?,turno=? where codAluno=?");
                ps.setInt(6, aluno.getIdAluno());
            }

            ps.setInt(1, aluno.getIdSerie());
            ps.setInt(2, aluno.getIdTurma());
            ps.setInt(3, aluno.getInepEscola());
            ps.setString(4, aluno.getNome());
            ps.setString(5, aluno.getTurno());

            ps.execute();
            System.out.println("inserindo aluno---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("#########################" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }
        System.out.println("com.br.seducpaudalho.Dao.AlunoDao.salvarAluno()" + aluno.getNome());
    }

    public List<Aluno> listarAlunos() throws ErroSistema {

        System.out.println("entrou no listarProdutos produto");
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from aluno";
        List<Aluno> alunos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();

                /*aluno.setIdProduto(rs.getInt("idProduto"));
                aluno.setIdFornecedor(rs.getInt("idFornecedor"));
                aluno.setNomeProduto(rs.getString("nProduto"));
                aluno.setMarcaProduto(rs.getString("mProduto"));
                aluno.setEspecificacaoProduto(rs.getString("eProduto"));
                aluno.setUnidadeProduto(rs.getString("uProduto"));
                System.out.println("olha o kilo produtos " + aluno.getIdProduto());
                aluno.setKiloProduto(rs.getDouble("kProduto"));
                aluno.setValorUnitario(rs.getDouble("vUnitario"));
                aluno.setValorTotal(rs.getDouble("vTotal"));

                alunos.add(aluno);
                System.out.println("tamanho da lista de produtos " + aluno.getNomeProduto());*/
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
        System.out.println("tamanho da lista de produtos " + alunos.size());
        FabricaConexao.fecharConexao();
        return alunos;

    }

    public List<Serie> listarSerieParametro(Integer codigo) throws ErroSistema {

        System.out.println("entrou no listarProdutos produto");
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from serie where inepEscola = ?";
        List<Serie> series = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Serie serie = new Serie();

                serie.setIdSerie(rs.getInt("idSerie"));
                serie.setInepEscola(rs.getInt("inepEscola"));
                serie.setNome(rs.getString("nome"));

                series.add(serie);

            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return series;

    }

    public List<Aluno> imprimirAlunos(Integer codigoTurma, Integer inepEscola, Integer codSerie) throws ErroSistema {

        System.out.println("**************" + codigoTurma);
        System.out.println("**************" + inepEscola);
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from aluno as a \n"
                + "join escola e on e.inepEscola = a.inepEscola\n"
                + "join serie s on s.codSerie = a.codSerie\n"
                + "join turma t on t.codTurma = a.codTurma\n"
                + "WHERE a.inepEscola = ? && a.codserie = ? && a.codTurma = ? order by nomeAluno";
        //String sql = "select * from aluno where codSerie = ? && inepescola = ? && codTurma = ?  ";

        List<Aluno> alunos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inepEscola);
            ps.setInt(2, codSerie);
            ps.setInt(3, codigoTurma);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ENTROUUUUUUUUUUUUUUUU");
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("codAluno"));
                aluno.setIdSerie(rs.getInt("codSerie"));
                aluno.setIdTurma(rs.getInt("codTurma"));
                aluno.setInepEscola(rs.getInt("inepEscola"));

                aluno.setNomeEscola(rs.getString("nomeEscola"));
                aluno.setNome(rs.getString("nomeAluno"));
                aluno.setNomeSerie(rs.getString("nomeSerie"));
                aluno.setNomeTurma(rs.getString("nomeTurma"));
                aluno.setTurno(rs.getString("turno"));
                aluno.setPortugues((""));
                aluno.setMatematica((""));
                aluno.setCienciasHumanas((""));
                aluno.setCienciasNatureza((""));
                System.out.println("OLHA O NOME DO TURNO :" + aluno.getTurno());

                alunos.add(aluno);
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return alunos;

    }

    public List<Aluno> imprimirAlunosSerie(Integer inepEscola, Integer codSerie) throws ErroSistema {

        System.out.println("**************" + inepEscola);
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from aluno as a \n"
                + "join escola e on e.inepEscola = a.inepEscola\n"
                + "join serie s on s.codSerie = a.codSerie\n"
                + "join turma t on t.codTurma = a.codTurma\n"
                + "WHERE a.inepEscola = ? && a.codserie = ?";
        //String sql = "select * from aluno where codSerie = ? && inepescola = ? && codTurma = ?  ";

        List<Aluno> alunos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inepEscola);
            ps.setInt(2, codSerie);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ENTROUUUUUUUUUUUUUUUU");
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("codAluno"));
                aluno.setIdSerie(rs.getInt("codSerie"));
                aluno.setIdTurma(rs.getInt("codTurma"));
                aluno.setInepEscola(rs.getInt("inepEscola"));

                aluno.setNomeEscola(rs.getString("nomeEscola"));
                aluno.setNome(rs.getString("nomeAluno"));
                aluno.setNomeSerie(rs.getString("nomeSerie"));
                aluno.setNomeTurma(rs.getString("nomeTurma"));
                aluno.setTurno(rs.getString("turno"));
                System.out.println("OLHA O NOME DO TURNO :" + aluno.getTurno());

                alunos.add(aluno);
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return alunos;

    }

    public List<Aluno> listarAlunos(Integer inepEscola, Integer codSerie) throws ErroSistema {

        System.out.println("**************" + inepEscola);
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from aluno as a \n"
                + "join escola e on e.inepEscola = a.inepEscola\n"
                + "join serie s on s.codSerie = a.codSerie\n"
                + "join turma t on t.codTurma = a.codTurma\n"
                + "WHERE a.inepEscola = ? && a.codserie = ? ";
        //String sql = "select * from aluno where codSerie = ? && inepescola = ? && codTurma = ?  ";

        List<Aluno> alunos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inepEscola);
            ps.setInt(2, codSerie);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ENTROUUUUUUUUUUUUUUUU");
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("codAluno"));
                aluno.setIdSerie(rs.getInt("codSerie"));
                aluno.setIdTurma(rs.getInt("codTurma"));
                aluno.setInepEscola(rs.getInt("inepEscola"));

                aluno.setNomeEscola(rs.getString("nomeEscola"));
                aluno.setNome(rs.getString("nomeAluno"));
                aluno.setNomeSerie(rs.getString("nomeSerie"));
                aluno.setNomeTurma(rs.getString("nomeTurma"));
                aluno.setTurno(rs.getString("turno"));
                System.out.println("OLHA O NOME DO TURNO :" + aluno.getTurno());

                alunos.add(aluno);
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return alunos;

    }

    public List<Aluno> listarTodosAlunos(Integer codSerie) throws ErroSistema {

        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from aluno as a \n"
                + "join escola e on e.inepEscola = a.inepEscola\n"
                + "join serie s on s.codSerie = a.codSerie\n"
                + "join turma t on t.codTurma = a.codTurma\n"
                + "WHERE a.codserie = ? ";
        //String sql = "select * from aluno where codSerie = ? && inepescola = ? && codTurma = ?  ";

        List<Aluno> alunos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codSerie);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ENTROUUUUUUUUUUUUUUUU");
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("codAluno"));
                aluno.setIdSerie(rs.getInt("codSerie"));
                aluno.setIdTurma(rs.getInt("codTurma"));
                aluno.setInepEscola(rs.getInt("inepEscola"));

                aluno.setNomeEscola(rs.getString("nomeEscola"));
                aluno.setNome(rs.getString("nomeAluno"));
                aluno.setNomeSerie(rs.getString("nomeSerie"));
                aluno.setNomeTurma(rs.getString("nomeTurma"));
                aluno.setTurno(rs.getString("turno"));
                System.out.println("OLHA O NOME DO TURNO :" + aluno.getTurno());

                alunos.add(aluno);
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return alunos;

    }

    public List<Avaliacao> listarGabaritosAlunos(Integer codigoTurma, Integer inepEscola, Integer codSerie) throws ErroSistema {

        System.out.println("**************" + codigoTurma);
        System.out.println("**************" + inepEscola);
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from testegabarito as a \n"
                + "                join aluno al on al.codAluno = a.codAluno\n"
                + "                where a.inepEscola = ? && a.codSerie = ? && a.codTurma = ?";

        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inepEscola);
            ps.setInt(2, codSerie);
            ps.setInt(3, codigoTurma);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ENTROUUUUUUUUUUUUUUUU");
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setIdAvaliacao(rs.getInt("idTesteGabarito"));
                avaliacao.setCodAluno(rs.getInt("codAluno"));
                avaliacao.setCodTurma(rs.getInt("codTurma"));
                avaliacao.setCodSerie(rs.getInt("codSerie"));

                avaliacao.setRespPortugues(rs.getString("portugues"));
                avaliacao.setRespMatematica(rs.getString("matematica"));
                avaliacao.setRespCienciasHumanas(rs.getString("cienciasHumanas"));
                avaliacao.setRespCienciasNatureza(rs.getString("cienciasNatureza"));
                avaliacao.setNomeAluno(rs.getString("nomeAluno"));

                avaliacoes.add(avaliacao);

                System.out.println("__________________________________________________" + avaliacao.getRespPortugues());
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return avaliacoes;

    }

    public List<Avaliacao> listarGabaritosSerie(Integer inepEscola, Integer codSerie) throws ErroSistema {

        System.out.println("**************" + inepEscola);
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from testegabarito as a \n"
                + "                join aluno al on al.codAluno = a.codAluno\n"
                + "                where a.inepEscola = ? && a.codSerie = ? ";

        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inepEscola);
            ps.setInt(2, codSerie);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ENTROUUUUUUUUUUUUUUUU");
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setIdAvaliacao(rs.getInt("idTesteGabarito"));
                avaliacao.setCodAluno(rs.getInt("codAluno"));
                avaliacao.setCodSerie(rs.getInt("codSerie"));

                avaliacao.setRespPortugues(rs.getString("portugues"));
                avaliacao.setRespMatematica(rs.getString("matematica"));
                avaliacao.setRespCienciasHumanas(rs.getString("cienciasHumanas"));
                avaliacao.setRespCienciasNatureza(rs.getString("cienciasNatureza"));
                avaliacao.setNomeAluno(rs.getString("nomeAluno"));

                avaliacoes.add(avaliacao);

                System.out.println("__________________________________________________" + avaliacao.getRespPortugues());
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return avaliacoes;

    }

    public Integer contarPresentesAvaliacao() throws ErroSistema {
        Integer a = 0;
        String sql = "select count(*) from testegabarito";

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }

            System.out.println("com.br.seducpaudalho.Dao.AlunoDao.contarPresentes()" + a);

        } catch (Exception e) {

            throw new ErroSistema("erroooooo--------------------", e);

        }
        FabricaConexao.fecharConexao();
        return a;
    }

    public Integer contarPresentesEscola(Integer inep) throws ErroSistema {
        Integer a = 0;
        String sql = "select count(*) from testegabarito where inepEscola = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inep);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }

            System.out.println("com.br.seducpaudalho.Dao.AlunoDao.contarPresentes()" + a);

        } catch (Exception e) {

            throw new ErroSistema("erroooooo--------------------", e);

        }
        FabricaConexao.fecharConexao();
        return a;
    }

    public Integer contarAlunosEscola(Integer inep) throws ErroSistema {
        Integer a = 0;
        String sql = "select count(*) from aluno where inepEscola = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inep);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }

            System.out.println("com.br.seducpaudalho.Dao.AlunoDao.contarPresentes()" + a);

        } catch (Exception e) {

            throw new ErroSistema("erroooooo--------------------", e);

        }
        FabricaConexao.fecharConexao();
        return a;
    }

    public Integer contarAlunosMunicipio() throws ErroSistema {
        Integer a = 0;

        String sql = "select count(*) from aluno";

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);

            }

            System.out.println("---####-----****----####----***-----####" + a);

        } catch (Exception e) {

            throw new ErroSistema("erroooooo--------------------", e);

        }
        FabricaConexao.fecharConexao();
        return a;
    }

    public List<Avaliacao> listarGabaritoMediaEscolar(Integer inepEscola, Integer codSerie) throws ErroSistema {

        System.out.println("**************" + inepEscola);
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from testegabarito as a \n"
                + "                join aluno al on al.codAluno = a.codAluno\n"
                + "                where a.inepEscola = ? && a.codSerie = ?";

        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inepEscola);
            ps.setInt(2, codSerie);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ENTROUUUUUUUUUUUUUUUU");
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setIdAvaliacao(rs.getInt("idTesteGabarito"));
                avaliacao.setCodAluno(rs.getInt("codAluno"));
                avaliacao.setCodTurma(rs.getInt("codTurma"));
                avaliacao.setCodSerie(rs.getInt("codSerie"));

                avaliacao.setRespPortugues(rs.getString("portugues"));
                avaliacao.setRespMatematica(rs.getString("matematica"));
                avaliacao.setRespCienciasHumanas(rs.getString("cienciasHumanas"));
                avaliacao.setRespCienciasNatureza(rs.getString("cienciasNatureza"));
                avaliacao.setNomeAluno(rs.getString("nomeAluno"));

                avaliacoes.add(avaliacao);

                System.out.println("__________________________________________________" + avaliacao.getRespPortugues());
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return avaliacoes;

    }

    public List<Turma> listarFrequenciaTurma(Integer inepEscola, Integer codSerie) throws ErroSistema {

        String sql = "select * from frequenciaturma as a \n"
                + "                join escola e on e.inepEscola = a.inepEscola\n"
                + "                join serie s on s.codSerie = a.codSerie\n"
                + "                join turma t on t.codTurma = a.codTurma\n"
                + "                WHERE a.inepEscola = ? && a.codserie = ? ";

        List<Turma> t = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inepEscola);
            ps.setInt(2, codSerie);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Turma tu = new Turma();
                tu.setNome(rs.getString("nomeTurma"));
                tu.setEv(rs.getDouble("resultevasaoTurma"));

                t.add(tu);

            }

        } catch (Exception e) {
            System.out.println("erro ao listar  " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return t;

    }

    public List<Turma> listarRendimentoTurma(Integer inepEscola, Integer codSerie, Integer disciplina) throws ErroSistema {

        String sql = "select * from rendimentoturma as a \n"
                + "                join escola e on e.inepEscola = a.inepEscola\n"
                + "                join serie s on s.codSerie = a.codSerie\n"
                + "                join turma t on t.codTurma = a.codTurma\n"
                + "                WHERE a.inepEscola = ? && a.codserie = ? && a.codDisciplina = ?";

        List<Turma> t = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inepEscola);
            ps.setInt(2, codSerie);
            ps.setInt(3, disciplina);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Turma tu = new Turma();
                tu.setNome(rs.getString("nomeTurma"));
                tu.setEv(rs.getDouble("rendimento"));

                t.add(tu);

            }

        } catch (Exception e) {
            System.out.println("erro ao listar  " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return t;

    }

    public List<Avaliacao> listarGabaritoGeral(Integer codSerie) throws ErroSistema {

        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from testegabarito as a \n"
                + "                join aluno al on al.codAluno = a.codAluno\n"
                + "                where a.codSerie = ?";

        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codSerie);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ENTROUUUUUUUUUUUUUUUU");
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setIdAvaliacao(rs.getInt("idTesteGabarito"));
                avaliacao.setCodAluno(rs.getInt("codAluno"));
                avaliacao.setCodTurma(rs.getInt("codTurma"));
                avaliacao.setCodSerie(rs.getInt("codSerie"));

                avaliacao.setRespPortugues(rs.getString("portugues"));
                avaliacao.setRespMatematica(rs.getString("matematica"));
                avaliacao.setRespCienciasHumanas(rs.getString("cienciasHumanas"));
                avaliacao.setRespCienciasNatureza(rs.getString("cienciasNatureza"));
                avaliacao.setNomeAluno(rs.getString("nomeAluno"));

                avaliacoes.add(avaliacao);

                System.out.println("__________________________________________________" + avaliacao.getRespPortugues());
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return avaliacoes;

    }

    public List<Correcao> listarGabaritosDisciplina(Integer inep, Integer codSerie, Integer codTurma) throws ErroSistema {

        System.out.println("**************" + codSerie);
        System.out.println("**************" + codTurma);
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from testegabarito where codSerie = ? && inepEscola  = ? && codTurma = ?";

        List<Correcao> correcoes = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, codSerie);
            ps.setInt(2, inep);
            ps.setInt(3, codTurma);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ENTROUUUUUUUUUUUUUUUU");
                Correcao correcao = new Correcao();
                correcao.setIdCorrecao(rs.getInt("idCorrecao"));

                correcao.setGabarito(rs.getString("gabarito"));
                correcao.setDescritores(rs.getString("descritores"));

                correcoes.add(correcao);
                System.out.println("GABARITO E DESCRITORES " + correcao.getGabarito() + "  " + correcao.getDescritores());
            }

        } catch (Exception e) {
            System.out.println("erro ao listar descritores " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }

        FabricaConexao.fecharConexao();
        return correcoes;

    }

    public List<Produto> lFornecedorCodigo(Integer codigo) throws ErroSistema {

        System.out.println("entrou no lFornecedorCodigo fornecedor ---------------------");
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from produto where idFornecedor = ?";

        List<Produto> produtos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setIdFornecedor(rs.getInt("idProduto"));
                produto.setIdFornecedor(rs.getInt("idFornecedor"));
                produto.setNomeProduto(rs.getString("nProduto"));
                produto.setMarcaProduto(rs.getString("mProduto"));
                produto.setEspecificacaoProduto(rs.getString("eProdutoj"));
                produto.setUnidadeProduto(rs.getString("uProduto"));
                produto.setKiloProduto(rs.getDouble("kProduto"));
                produto.setValorUnitario(rs.getDouble("vProduto"));
                produto.setValorTotal(rs.getDouble("vTotal"));

                produtos.add(produto);
            }

        } catch (Exception e) {
            System.out.println("erro ao listar Produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
        System.out.println("tamanho da lista de Produtos " + produtos.size());
        FabricaConexao.fecharConexao();
        return produtos;

    }

    public Fornecedor buscarLoginN(Fornecedor fornecedor) throws ErroSistema {

        /* System.out.println("entrou no buscarLoginN-----------------------" + login.getCpf() + login.getSenha());

        // "Select uname, password from Users where uname = ? and password = ?"
        String sql = "select * from login where cpf = ? and senha =?";
        //  Login logado = new Login();
        try {
            System.out.println("enontrou no try");
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, login.getCpf());
            ps.setString(2, login.getSenha());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("encontrou um usuario");
                // retorno = login.getCpf();
                //retorno = "oi";

                System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");

                login.setIdLogin(rs.getInt("idLogin"));
                login.setNome(rs.getString("nome"));
                login.setCpf(rs.getString("cpf"));
                login.setSenha(rs.getString("senha"));
                login.setNivel(rs.getString("nivel"));
                login.setUrl(rs.getString("url"));
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("--------xxxx--------" + login.getNome());
            } else {
                System.out.println("não encontrou um usuario");

                Login logi = new Login();
                return logi;
            }

        } catch (Exception e) {
            System.out.println("erro --------------XXXXXXX-------------------" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }

        FabricaConexao.fecharConexao();*/
        return fornecedor;
    }

    public void salvar(Produto produto) throws ErroSistema {

        System.out.println("com.br.seducpaudalho.Dao.ProdutoDao.salvar() " + "N " + produto.getNomeProduto() + "M " + produto.getMarcaProduto() + "E " + produto.getEspecificacaoProduto() + "U " + produto.getUnidadeProduto() + "K " + produto.getKiloProduto() + "V " + produto.getValorUnitario() + "VT " + produto.getValorTotal());

        try {
            String sql = "";
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

            if (produto.getIdProduto() == null) {
                System.out.println("--------- entrou no if cadastro produto");
                ps = conexao.prepareStatement("INSERT INTO produto(idFornecedor,nProduto,mProduto,eProduto,uProduto,kProduto,vUnitario,vTotal)VALUES (?,?,?,?,?,?,?,?)");
            } else {
                System.out.println("--------- entrou no else cadastro produto" + produto.getIdProduto());
                ps = conexao.prepareStatement("UPDATE produto SET idFornecedor=?,nProduto=?,mProduto=?,eProduto=?,uProduto=?,kProduto=?,vUnitario=?,vTotal=? where idProduto=?");
                ps.setInt(9, produto.getIdProduto());
            }

            ps.setInt(1, produto.getIdFornecedor());
            ps.setString(2, produto.getNomeProduto());
            ps.setString(3, produto.getMarcaProduto());
            ps.setString(4, produto.getEspecificacaoProduto());
            ps.setString(5, produto.getUnidadeProduto());
            ps.setDouble(6, produto.getKiloProduto());
            ps.setDouble(7, produto.getValorUnitario());
            ps.setDouble(8, produto.getValorTotal());

            ps.execute();
            System.out.println("inserindo fornecedor---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("#########################" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }

    }

    public void insertFrequeciaTurma(Integer codTurma, Integer inep, Integer codSerie, double resultevasaoTurma) throws ErroSistema {

        try {

            Integer codFrequencia = pesquisarFrequenciaTurma(codTurma, inep, codSerie);

            String sql = "";
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

            if (codFrequencia == null) {
                System.out.println("--------- entrou no if cadastro produto");
                ps = conexao.prepareStatement("INSERT INTO frequenciaturma(codTurma,inepEscola,codSerie,resultevasaoTurma)VALUES (?,?,?,?)");
            } else {

                ps = conexao.prepareStatement("UPDATE frequenciaturma SET codTurma=?,inepEscola=?,codSerie=?,resultevasaoTurma=? where codFrequencia=?");
                ps.setInt(5, codFrequencia);
            }

            ps.setInt(1, codTurma);
            ps.setInt(2, inep);
            ps.setInt(3, codSerie);
            ps.setDouble(4, resultevasaoTurma);

            ps.execute();
            System.out.println("inserindo ---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("#########################" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }

    }

    private Integer pesquisarFrequenciaTurma(Integer codTurma, Integer inep, Integer codSerie) throws ErroSistema {

        String sql = "select * from frequenciaturma where inepEscola = ? && codTurma = ? && codSerie = ?";
        Integer a = null;
        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, inep);
            ps.setInt(2, codTurma);
            ps.setInt(3, codSerie);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FrequenciaTurma f = new FrequenciaTurma();
                f.setCodFrequencia(rs.getInt("codFrequencia"));

                a = f.getCodFrequencia();
            }

        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);

        }
        return a;
    }

    public void insertRendimentoTurma(Integer codTurma, Integer inep, Integer codSerie, Integer codDisciplina, double rend) throws ErroSistema {

        try {

            Integer codRendimento = pesquisarRendimentoTurma(codTurma, inep, codSerie, codDisciplina);

            String sql = "";
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

            if (codRendimento == null) {
                System.out.println("--------- entrou no if cadastro produto");
                ps = conexao.prepareStatement("INSERT INTO rendimentoturma(codTurma,inepEscola,codSerie,codDisciplina,rendimento)VALUES (?,?,?,?,?)");
            } else {

                ps = conexao.prepareStatement("UPDATE rendimentoturma SET codTurma=?,inepEscola=?,codSerie=?,codDisciplina=?,rendimento=? where codRendimento=?");
                ps.setInt(6, codRendimento);
            }

            ps.setInt(1, codTurma);
            ps.setInt(2, inep);
            ps.setInt(3, codSerie);
            ps.setInt(4, codDisciplina);
            ps.setDouble(5, rend);

            ps.execute();
            System.out.println("inserindo ---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("#########################" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }

    }

    private Integer pesquisarRendimentoTurma(Integer codTurma, Integer inep, Integer codSerie, Integer codDisciplina) throws ErroSistema {

        String sql = "select * from rendimentoturma where inepEscola = ? && codTurma = ? && codSerie = ?  && codDisciplina = ?";
        Integer a = null;
        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, inep);
            ps.setInt(2, codTurma);
            ps.setInt(3, codSerie);
            ps.setInt(4, codDisciplina);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RendimentoTurma r = new RendimentoTurma();
                r.setCodRendimento(rs.getInt("codRendimento"));

                a = r.getCodRendimento();
            }

        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);

        }
        return a;
    }

    public void atualizarAssociacao(Associacao associacao) throws ErroSistema {

        try {

            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

            ps = conexao.prepareStatement("UPDATE associacao SET codSerie=?,codDisciplina=?,descritor=?,questao=?,alternativa=? where codAssociacao=?");
            ps.setInt(6, associacao.getCodAssociacao());

            ps.setInt(1, associacao.getCodSerie());
            ps.setInt(2, associacao.getCodDisciplina());
            ps.setString(3, associacao.getDescritor());
            ps.setString(4, associacao.getQuestao());
            ps.setString(5, associacao.getAlternativa());

            ps.execute();
            System.out.println("inserindo fornecedor---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("#########################" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }

    }

    public List<Fornecedor> buscar() throws ErroSistema {

        /*   String sql = "select * from login";

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Login> logins = new ArrayList<>();

            while (rs.next()) {
                Login login = new Login();
                
                login.setIdLogin(rs.getInt("idLogin"));
                login.setNome(rs.getString("nome"));
                login.setCpf(rs.getString("cpf"));
                login.setSenha(rs.getString("senha"));
              
                login.setNivel(rs.getString("nivelAcesso"));
                logins.add(login);
            }
            return logins;
        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);

        }
         */
        return null;
    }

    public List<Fornecedor> buscarF(String parametro) throws ErroSistema {

        /* System.out.println("entrou no buscarF ----------" + parametro);
        String sql = "select * from login where cpf = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, parametro);
            ResultSet rs = ps.executeQuery();
            List<Login> logins = new ArrayList<>();

            while (rs.next()) {
                Login login = new Login();
                login.setIdLogin(rs.getInt("idLogin"));
                login.setNome(rs.getString("nome"));
                login.setCpf(rs.getString("cpf"));
                login.setSenha(rs.getString("senha"));
               
                login.setNivel(rs.getString("nivelAcesso"));
                logins.add(login);
            }
            return logins;
        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);

        }*/
        return null;

    }

    public List<Descritor> pesquiDescritors(String sigla, Integer disciplina, Integer serie) throws ErroSistema {

        String sql = "select * from descritor where siglaDescritor = ? && codDisciplina = ? && codSerie = ?";
        List<Descritor> a = new ArrayList<>();
        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, sigla);
            ps.setInt(2, disciplina);
            ps.setInt(3, serie);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Descritor d = new Descritor();
                a.add(d);
            }
            return a;

        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);

        }

    }

    /* public List<Auditoria> buscarAuditoria(String parametro) throws ErroSistema {

        System.out.println("entrou no buscarF ----------" + parametro);
        String sql = "select * from auditoria where cpf = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, parametro);
            ResultSet rs = ps.executeQuery();
            List<Auditoria> auditorias = new ArrayList<>();

            while (rs.next()) {
                Auditoria auditoria = new Auditoria();
               // auditoria.setIdLogin(rs.getInt("idLogin"));
                //auditoria.setNome(rs.getString("nome"));
                auditoria.setCpf(rs.getString("cpf"));
                auditoria.setTipo(rs.getString("tipo"));
                auditoria.setData(rs.getString("data"));
               // login.setNivel(rs.getString("nivelAcesso"));
                auditorias.add(auditoria);
            }
            return auditorias;
        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);

        }

    }*/
    public void deletar(Produto produto) throws ErroSistema {

        System.out.println("com.br.seducpaudalho.Dao.FornecedorDao.deletar()" + produto.getIdProduto());

        String sql = "delete from produto where idProduto = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, produto.getIdProduto());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (Exception e) {

            throw new ErroSistema("ERRO AO DELETAR PRODUTO");
        }
    }

    public void salvarDescritor(Descritor descritor) throws ErroSistema {

        System.out.println("--------- olha o  descritor : " + descritor.getCodSerie() + "  - " + descritor.getCodDisciplina() + "  - " + descritor.getSiglaDescritor());
        System.out.println("--------- olha o codigo do descritor" + descritor.getCodDescritor());

        Integer p = pesquisarDescritor(descritor.getSiglaDescritor(), descritor.getCodSerie(), descritor.getCodSerie());

        try {
            String sql = "";
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

            if (p == null) {
                System.out.println("--------- entrou no if cadastro produto");
                System.out.println("--------- olha o  descritor : " + descritor.getSiglaDescritor() + "  - " + descritor.getEspeciDescritor() + "  - " + descritor.getCodDisciplina() + "  - " + descritor.getCodSerie());
                ps = conexao.prepareStatement("INSERT INTO descritor(siglaDescritor,especiDescritor,codDisciplina,codSerie)VALUES (?,?,?,?)");
            } else {
                System.out.println("--------- entrou no else cadastro descritor" + p + " - " + descritor.getSiglaDescritor() + "  - " + descritor.getEspeciDescritor() + "  - " + descritor.getCodDisciplina() + "  - " + descritor.getCodSerie());
                ps = conexao.prepareStatement("UPDATE descritor SET siglaDescritor=?,especiDescritor=?,codDisciplina=?,codSerie=? where codDescritor=?");
                ps.setInt(5, p);
            }

            ps.setString(1, descritor.getSiglaDescritor());
            ps.setString(2, descritor.getEspeciDescritor());
            ps.setInt(3, descritor.getCodDisciplina());
            ps.setInt(4, descritor.getCodSerie());

            ps.execute();
            System.out.println("inserindo fornecedor---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("#########################" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }
    }

    public void salvarGabarito(Aluno aluno) throws ErroSistema {

        System.out.println("--------- olha o  aluno : " + aluno.getIdSerie() + "portugues" + aluno.getPortugues());

        Integer p = pesquisarGabarito(aluno.getIdAluno());

        try {
            String sql = "";
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

            if (p == null) {
                System.out.println("--------- entrou no if cadastro produto");

                ps = conexao.prepareStatement("INSERT INTO testegabarito(codTurma,codSerie,codAluno,inepEscola,portugues,matematica,cienciasHumanas,cienciasNatureza)VALUES (?,?,?,?,?,?,?,?)");
            } else {

                ps = conexao.prepareStatement("UPDATE testegabarito SET codTurma=?,codSerie=?,inepEscola=?,portugues=?,matematica=? ,cienciasHumanas=? ,cienciasNatureza=?  where codAluno=?");
                //ps.setInt(9, p);
            }

            ps.setInt(1, aluno.getIdTurma());
            ps.setInt(2, aluno.getIdSerie());
            ps.setInt(3, aluno.getIdAluno());
            ps.setInt(4, aluno.getInepEscola());
            ps.setString(5, aluno.getPortugues());
            ps.setString(6, aluno.getMatematica());
            ps.setString(7, aluno.getCienciasHumanas());
            ps.setString(8, aluno.getCienciasNatureza());

            ps.execute();
            System.out.println("inserindo fornecedor---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("#########################" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }
    }

    public void salvarQuestao(Associacao associacao) throws ErroSistema {

        System.out.println("--------- olha questao : " + associacao.getCodSerie() + "  - " + associacao.getCodDisciplina() + "  - " + associacao.getNumeroQuestoes());
        // System.out.println("--------- olha questao" + associacao.getCodDescritor());
        //Integer p = pesquisarDescritor(associacao.getSiglaDescritor(),associacao.getCodSerie(),associacao.getCodSerie());

        List<Associacao> pesquisa = new ArrayList<>();

        pesquisa = pesquiQuestoes(associacao);
        int cont = pesquisa.size();
        cont++;
        for (int i = 0; i < associacao.getNumeroQuestoes(); i++) {

            System.out.println("olha o tamahno da lista " + pesquisa.size());
            try {
                //String sql = "";
                Connection conexao = FabricaConexao.getConnection();
                PreparedStatement ps;

                //  if (p == null) {
                // System.out.println("--------- entrou no if cadastro produto");
                System.out.println("--------- olha a associacao : " + associacao.getCodSerie() + "  - " + associacao.getCodDisciplina());
                ps = conexao.prepareStatement("INSERT INTO associacao(codSerie,codDisciplina,descritor,questao,alternativa)VALUES (?,?,?,?,?)");
                /*} else {
                System.out.println("--------- entrou no else cadastro descritor" + p + " - "+ associacao.getSiglaDescritor() + "  - "+ associacao.getEspeciDescritor()+ "  - "+ associacao.getCodDisciplina()+ "  - "+associacao.getCodSerie());
                ps = conexao.prepareStatement("UPDATE descritor SET siglaDescritor=?,especiDescritor=?,codDisciplina=?,codSerie=? where codDescritor=?");
                ps.setInt(5, p);
            }*/
                ps.setInt(1, associacao.getCodSerie());
                ps.setInt(2, associacao.getCodDisciplina());
                ps.setString(3, "");
                ps.setString(4, "Q" + Integer.toString(cont++));
                ps.setString(5, "");

                ps.execute();
                //System.out.println("inserindo fornecedor---------------------------------------");
                FabricaConexao.fecharConexao();
            } catch (Exception e) {
                System.out.println("#########################" + e);
                throw new ErroSistema("erroooooo--------------------", e);
            }
        }

    }

    public List<Associacao> pesquiQuestoes(Associacao as) throws ErroSistema {

        String sql = "select * from associacao where codSerie = ? && codDisciplina = ?";
        List<Associacao> a = new ArrayList<>();
        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, as.getCodSerie());
            ps.setInt(2, as.getCodDisciplina());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Associacao associacao = new Associacao();
                associacao.setCodAssociacao(rs.getInt("codAssociacao"));
                a.add(associacao);
            }
            return a;

        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);

        }

    }

    private Integer pesquisarDescritor(String siglaDescritor, Integer codSerie, Integer codSerie0) throws ErroSistema {

        String sql = "select * from descritor where siglaDescritor = ? && codDisciplina = ? && codSerie = ?";
        Integer a = null;
        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, siglaDescritor);
            ps.setInt(2, codSerie);
            ps.setInt(3, codSerie0);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Descritor d = new Descritor();
                d.setCodDescritor(rs.getInt("codDescritor"));

                a = d.getCodDescritor();
            }

        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);

        }
        return a;
    }

    private Integer pesquisarGabarito(Integer codigo) throws ErroSistema {

        String sql = "select * from testegabarito where codAluno = ?";
        Integer a = null;
        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Aluno d = new Aluno();
                d.setIdAluno(rs.getInt("codAluno"));

                a = d.getIdAluno();
            }

        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);

        }
        return a;
    }

    public void deletar(Aluno p) throws ErroSistema {
        
        System.out.println("com.br.seducpaudalho.Dao.FornecedorDao.deletar()" + p.getIdAluno());

        String sql = "delete from aluno where codAluno = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, p.getIdAluno());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (Exception e) {

            throw new ErroSistema("ERRO AO DELETAR PRODUTO");
        }
        
    }

}
