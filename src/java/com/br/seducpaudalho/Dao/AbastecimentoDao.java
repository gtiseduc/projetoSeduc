package com.br.seducpaudalho.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.seducpaudalho.Entidade.Abastecimento;
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
public class AbastecimentoDao {

    public List<Abastecimento> listarAbastecimentos() throws ErroSistema {

        System.out.println("entrou no listar abastecimentos");
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from abastecimento";
        List<Abastecimento> abastecimentos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Abastecimento abastecimento = new Abastecimento();

                abastecimento.setIdAbastecimento(rs.getInt("idAbastecimento"));
                abastecimento.setPlaca(rs.getString("placa"));
               

                abastecimentos.add(abastecimento);
                System.out.println("tamanho da lista de abastecimento " + abastecimento.getPlaca());
            }

        } catch (Exception e) {
            System.out.println("erro ao listar abastecimento " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
        System.out.println("tamanho da lista de abastecimento " + abastecimentos.size());
        FabricaConexao.fecharConexao();
        return abastecimentos;

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

    public void salvar(Abastecimento abastecimento) throws ErroSistema {

       try {

            String sql = "";
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

            if (abastecimento.getIdAbastecimento()== null) {
                System.out.println("--------- entrou no if cadastro Abastecimento");
                ps = conexao.prepareStatement("INSERT INTO abastecimento(numeroCartao,placa,combustivel,data,litro,valorAbastecimento,precoLitro,kmLitro,kmInicial,kmFinal,kmRodados,mediaKm,precoKm)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            } else {
                System.out.println("--------- entrou no else cadastro produto" + abastecimento.getIdAbastecimento());
                ps = conexao.prepareStatement("UPDATE abastecimento SET numeroCartao=?,placa=?,combustivel=?,data=?,litro=?,valorAbastecimento=?,precoLitro=?,kmLitro=?,kmInicial=?,kmFinal=?,kmRodados=?,mediaKm=?,precoKm=? where idVeiculo=?");
                ps.setInt(14, abastecimento.getIdAbastecimento());
            }

            ps.setString(1, abastecimento.getNumeroCartao());
            ps.setString(2, abastecimento.getPlaca());
            ps.setString(3, abastecimento.getCombustivel());
            ps.setString(4, abastecimento.getData());
            ps.setDouble(5, abastecimento.getLitro());
            ps.setDouble(6, abastecimento.getValorAbastecido());
            ps.setDouble(7, abastecimento.getPrecoLitro());
            ps.setDouble(8, abastecimento.getKmLitro());
            ps.setDouble(9, abastecimento.getKmInicial());
            ps.setDouble(10, abastecimento.getKmFinal());
            ps.setDouble(11, abastecimento.getKmRodados());
            ps.setDouble(12, abastecimento.getMediaKm());
            ps.setDouble(13, abastecimento.getPrecoKm());
          
           

            ps.execute();
            System.out.println("inserindo Abastecimento---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("erro Abastecimento---------------------------------------" + e);
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
