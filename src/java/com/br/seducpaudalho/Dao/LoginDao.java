package com.br.seducpaudalho.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.br.seducpaudalho.Entidade.Login;
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
public class LoginDao {

    public String buscarLogin(Login login) throws ErroSistema {

       /* System.out.println("entrou no pesquisar login" + login.getCpf() + login.getSenha());
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from login where cpf = ? and senha =?";

        try {
            System.out.println("enontrou no try");
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, login.getCpf());
            ps.setString(2, login.getSenha());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("encontrou um usuario");

                login.setIdLogin(rs.getInt("idLogin"));
                login.setNome(rs.getString("nome"));
                login.setCpf(rs.getString("cpf"));
                login.setSenha(rs.getString("senha"));
              
                login.setNivel(rs.getString("nivelAcesso"));

                retorno = login.getCpf();
                //retorno = "oi";

            } else {
                System.out.println("não encontrou um usuario");
                retorno = null;
            }
        } catch (Exception e) {
            System.out.println("erro ---------------------------------------");
            throw new ErroSistema("erroooooo--------------------", e);
        }

        FabricaConexao.fecharConexao();*/
        //return retorno;
        return null;
    }

    public Login buscarLoginN(Login login) throws ErroSistema {

        System.out.println("entrou no buscarLoginN-----------------------" + login.getCpf() + login.getSenha());

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

        FabricaConexao.fecharConexao();
        return login;
    }

    public void salvar(Login login) throws ErroSistema {

     /*   System.out.println("olha o login" + login.getCpf() + "e a senha" + login.getSenha() + "e o nome" + login.getNome() + "e o nivel" + login.getNivel());

        String sql = "INSERT INTO login(nome,cpf,senha,localidade,nivelAcesso)VALUES (?,?,?,?,?)";

        try {
            System.out.println("1olha o login" + login.getCpf() + "e a senha" + login.getSenha());
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, login.getNome());
            ps.setString(2, login.getCpf());
            ps.setString(3, login.getSenha());
            
            ps.setString(5, login.getNivel());

            ps.execute();
            System.out.println("teste---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);
        }
*/
    }

    public List<Login> buscar() throws ErroSistema {

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

    public List<Login> buscarF(String parametro) throws ErroSistema {

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

    public void deletar(Login login) throws ErroSistema {
       /* String sql = "delete from login where cpf = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, login.getCpf());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (Exception e) {

            throw new ErroSistema("ERRO AO DELETAR USUÁRIO");
        }*/
    }
    
    
    

}
