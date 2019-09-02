package com.br.seducpaudalho.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.seducpaudalho.Entidade.Aluno;
import com.br.seducpaudalho.Entidade.Avaliacao;
import com.br.seducpaudalho.Entidade.Correcao;
import com.br.seducpaudalho.Entidade.Fornecedor;
import com.br.seducpaudalho.Entidade.Produto;
import com.br.seducpaudalho.Entidade.Serie;
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

        String sql = "select e.inepEscola,e.nomeEscola,codAluno, nome,s.codSerie,s.nomeSerie,t.codTurma,t.nomeTurma,t.turno from aluno as a \n"
                + "join escola e on e.inepEscola = ? \n"
                + "join serie s on s.codSerie = ?\n"
                + "join turma t on t.codTurma = a.codTurma \n"
                + "where a.codTurma = ? order by nome;";

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

                aluno.setNomeEscola(rs.getString("nomeEscola"));
                aluno.setNome(rs.getString("nome"));
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

        String sql = "select * from avaliacao as a \n"
                + "join aluno al on al.codAluno = a.codAluno\n"
                + "where a.inepEscola = ? && a.codSerie = ? && a.codTurma = ? ";

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
                avaliacao.setIdAvaliacao(rs.getInt("idAvaliacao"));
                avaliacao.setCodAluno(rs.getInt("codAluno"));
                avaliacao.setCodTurma(rs.getInt("codTurma"));
                avaliacao.setCodSerie(rs.getInt("codSerie"));

                avaliacao.setRespPortugues(rs.getString("respPortugues"));
                avaliacao.setRespMatematica(rs.getString("respMatematica"));
                avaliacao.setRespCienciasHumanas(rs.getString("respCienciasHumanas"));
                avaliacao.setRespCienciasNatureza(rs.getString("respCienciasNatureza"));
                avaliacao.setNomeAluno(rs.getString("nome"));

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

    public List<Correcao> listarGabaritosDisciplina(Integer codSerie, Integer codDisciplina) throws ErroSistema {

        System.out.println("**************" + codSerie);
        System.out.println("**************" + codDisciplina);
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from correcao where codSerie = ? && codDisciplina = ?";

        List<Correcao> correcoes = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, codSerie);
            ps.setInt(2, codDisciplina);
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

}
