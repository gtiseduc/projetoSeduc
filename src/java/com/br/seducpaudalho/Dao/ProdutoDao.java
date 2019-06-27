package com.br.seducpaudalho.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.seducpaudalho.Entidade.Fornecedor;
import com.br.seducpaudalho.Entidade.Produto;
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
public class ProdutoDao {

    public List<Produto> listarProdutos() throws ErroSistema {

        System.out.println("entrou no listarProdutos produto");
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from produto";
        List<Produto> produtos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setIdFornecedor(rs.getInt("idFornecedor"));
                produto.setNomeProduto(rs.getString("nProduto"));
                produto.setMarcaProduto(rs.getString("mProduto"));
                produto.setEspecificacaoProduto(rs.getString("eProduto"));
                produto.setUnidadeProduto(rs.getString("uProduto"));
                System.out.println("olha o kilo produtos " + produto.getIdProduto());
                produto.setKiloProduto(rs.getDouble("kProduto"));
                produto.setValorUnitario(rs.getDouble("vUnitario"));
                produto.setValorTotal(rs.getDouble("vTotal"));

                produtos.add(produto);
                System.out.println("tamanho da lista de produtos " + produto.getNomeProduto());
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
        System.out.println("tamanho da lista de produtos " + produtos.size());
        FabricaConexao.fecharConexao();
        return produtos;

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

       
        
        System.out.println("com.br.seducpaudalho.Dao.ProdutoDao.salvar() " + "N "+ produto.getNomeProduto() + "M " +produto.getMarcaProduto()+ "E " + produto.getEspecificacaoProduto()+ "U "+produto.getUnidadeProduto()+"K "+produto.getKiloProduto()+ "V "+produto.getValorUnitario()+"VT "+produto.getValorTotal());

        
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
