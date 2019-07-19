package com.br.seducpaudalho.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.seducpaudalho.Entidade.Veiculo;
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
public class VeiculoDao {

    public List<Veiculo> listarVeiculos() throws ErroSistema {

        System.out.println("entrou no listar veiculo");
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from veiculo";
        List<Veiculo> veiculos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();

                veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setDescricao(rs.getString("descricao"));
                veiculo.setResponsavel(rs.getString("responsavel"));
                veiculo.setTelefone1(rs.getString("telefone1"));
                veiculo.setTelefone2(rs.getString("telefone2"));
                veiculo.setSecretaria(rs.getString("secretaria"));

                veiculos.add(veiculo);
                System.out.println("tamanho da lista de veiculo " + veiculo.getResponsavel());
            }

        } catch (Exception e) {
            System.out.println("erro ao listar fornecedor " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
        System.out.println("tamanho da lista de fornecedores " + veiculos.size());
        FabricaConexao.fecharConexao();
        return veiculos;

    }

    public List<Veiculo> lVeiculoCodigo(Integer codigo) throws ErroSistema {

        System.out.println("entrou no lVeiculo veiculo ---------------------");
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from veiculo where idVeiculo = ?";

        List<Veiculo> veiculos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();

                veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setDescricao(rs.getString("descricao"));
                veiculo.setResponsavel(rs.getString("responsavel"));
                veiculo.setTelefone1(rs.getString("telefone1"));
                veiculo.setTelefone2(rs.getString("telefone2"));
                veiculo.setSecretaria(rs.getString("secretaria"));
                veiculos.add(veiculo);
                System.out.println("tamanho da lista de veiculo " + veiculo.getPlaca());
            }

        } catch (Exception e) {
            System.out.println("erro ao listar veiculo " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
        System.out.println("tamanho da lista de veiculo " + veiculos.size());
        FabricaConexao.fecharConexao();
        return veiculos;

    }

    public Veiculo buscarLoginN(Veiculo veiculo) throws ErroSistema {

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
        return veiculo;
    }

    public void salvar(Veiculo veiculo) throws ErroSistema {

       try {

            String sql = "";
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

            if (veiculo.getIdVeiculo()== null) {
                System.out.println("--------- entrou no if cadastro veiculo");
                ps = conexao.prepareStatement("INSERT INTO veiculo(placa,descricao,responsavel,telefone1,telefone2,secretaria)VALUES (?,?,?,?,?,?)");
            } else {
                System.out.println("--------- entrou no else cadastro produto" + veiculo.getIdVeiculo());
                ps = conexao.prepareStatement("UPDATE veiculo SET placa=?,descricao=?,responsavel=?,telefone1=?,telefone2=?,secretaria=? where idVeiculo=?");
                ps.setInt(7, veiculo.getIdVeiculo());
            }

            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getDescricao());
            ps.setString(3, veiculo.getResponsavel());
            ps.setString(4, veiculo.getTelefone1());
            ps.setString(5, veiculo.getTelefone2());
            ps.setString(6, veiculo.getSecretaria());
           

            ps.execute();
            System.out.println("inserindo veiculo---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("erro veiculo---------------------------------------" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }

    }

   

    public List<Veiculo> buscar() throws ErroSistema {

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

    public List<Veiculo> buscarF(String parametro) throws ErroSistema {

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

    public void deletar(Veiculo veiculo) throws ErroSistema {

        System.out.println("com.br.seducpaudalho.Dao.VeiculoDao.deletar()" + veiculo.getPlaca());

        String sql = "delete from veiculo where cnpj = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, veiculo.getPlaca());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (Exception e) {

            throw new ErroSistema("ERRO AO DELETAR VEICULO");
        }
    }

}
