package com.br.seducpaudalho.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.br.seducpaudalho.Entidade.Necessidade;
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
public class NecessidadeDao {

    public List<Necessidade> listarNecessidades() throws ErroSistema {

        System.out.println("entrou no listarProdutos produto");
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from produto";
        List<Necessidade> produtos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Necessidade necessidades = new Necessidade();

              /*  produto.setIdProduto(rs.getInt("idProduto"));
                produto.setIdFornecedor(rs.getInt("idFornecedor"));
                produto.setNomeProduto(rs.getString("nProduto"));
                produto.setMarcaProduto(rs.getString("mProduto"));
                produto.setEspecificacaoProduto(rs.getString("eProduto"));
                produto.setUnidadeProduto(rs.getString("uProduto"));
                System.out.println("olha o kilo produtos " + produto.getIdProduto());
                produto.setKiloProduto(rs.getDouble("kProduto"));
                produto.setValorUnitario(rs.getDouble("vUnitario"));
                produto.setValorTotal(rs.getDouble("vTotal"));*/

               // produtos.add(necessidades);
                //System.out.println("tamanho da lista de produtos " + );
            }

        } catch (Exception e) {
            System.out.println("erro ao listar produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
        System.out.println("tamanho da lista de produtos " + produtos.size());
        FabricaConexao.fecharConexao();
        return produtos;

    }

    public List<Necessidade> lFornecedorCodigo(Integer codigo) throws ErroSistema {

        System.out.println("entrou no lFornecedorCodigo fornecedor ---------------------");
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from produto where idFornecedor = ?";

        List<Necessidade> produtos = new ArrayList<>();

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             /*   Necessidade produto = new Necessidade();

                produto.setIdFornecedor(rs.getInt("idProduto"));
                produto.setIdFornecedor(rs.getInt("idFornecedor"));
                produto.setNomeProduto(rs.getString("nProduto"));
                produto.setMarcaProduto(rs.getString("mProduto"));
                produto.setEspecificacaoProduto(rs.getString("eProdutoj"));
                produto.setUnidadeProduto(rs.getString("uProduto"));
                produto.setKiloProduto(rs.getDouble("kProduto"));
                produto.setValorUnitario(rs.getDouble("vProduto"));
                produto.setValorTotal(rs.getDouble("vTotal"));

             
               

                produtos.add(produto);*/
            }

        } catch (Exception e) {
            System.out.println("erro ao listar Produtos " + e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
        System.out.println("tamanho da lista de Produtos " + produtos.size());
        FabricaConexao.fecharConexao();
        return produtos;

    }

    public Necessidade buscarLoginN(Necessidade necessidade) throws ErroSistema {

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
        return necessidade;
    }

    public void salvar(Necessidade necessidade) throws ErroSistema {

       
        
        try {

          String sql = "";
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

             if (necessidade.getIdNecessidade() == null) {
                 System.out.println("--------- entrou no if cadastro produto");
                 ps = conexao.prepareStatement("INSERT INTO necessidades(inepEscola,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20,q21,q22,q23,q24,q25,q26,q27,q28,q29,q30,q31,q32,q33,q34,q35,q36,q37,q38,q39,q40,q41,q42,q43,q44,q45,q46,q47,q48,q49,q50,q51,q52,q53,q54,q55,q56,q57,q58,q59,q60,q61,q62,q63,q64,q65,q66,q67,q68,q69,q70,q71,q72,q73,q74,q75,q76,q77)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
               
             } else {
                System.out.println("--------- entrou no else cadastro produto" + necessidade.getIdNecessidade());
                ps = conexao.prepareStatement("UPDATE necessidades SET inepescola=?,q1=?,q2=?,q3=?,q4=?,q5=?,q6=?,q7=?,q8=?,q9=?,q10=?,q11=?,q12=?,q13=?,q14=?,q15=?,q16=?,q17=?,q18=?,q19=?,q20=?,q21=?,q22=?,q23=?,q24=?,q25=?,q26=?,q27=?,q28=?,q29=?,q30=?,q31=?,q32=? where idNecessidades=?");
                ps.setInt(77, necessidade.getIdNecessidade());
           }

            
            ps.setInt(1, necessidade.getCodInep());
            ps.setString(2, necessidade.getQ1());
            ps.setString(3, necessidade.getQ2());
            ps.setString(4, necessidade.getQ3());
            ps.setString(5, necessidade.getQ4());
            ps.setString(6, necessidade.getQ5());
            ps.setString(7, necessidade.getQ6());
            ps.setString(8, necessidade.getQ7());
            ps.setString(9, necessidade.getQ8());
            ps.setString(10, necessidade.getQ9());
            ps.setString(11, necessidade.getQ10());
            ps.setString(12, necessidade.getQ11());
            ps.setString(13, necessidade.getQ12());
            ps.setString(14, necessidade.getQ13());
            ps.setString(15, necessidade.getQ14());
            ps.setString(16, necessidade.getQ15());
            ps.setString(17, necessidade.getQ16());
            ps.setString(18, necessidade.getQ17());
            ps.setString(19, necessidade.getQ18());
            ps.setString(20, necessidade.getQ19());
            ps.setString(21, necessidade.getQ20());
            ps.setString(22, necessidade.getQ21());
            ps.setString(23, necessidade.getQ22());
            ps.setString(24, necessidade.getQ23());
            ps.setString(25, necessidade.getQ24());
            ps.setString(26, necessidade.getQ25());
            ps.setString(27, necessidade.getQ26());
            ps.setString(28, necessidade.getQ27());
            ps.setString(29, necessidade.getQ28());
            ps.setString(30, necessidade.getQ29());
            ps.setString(31, necessidade.getQ30());
            ps.setString(32, necessidade.getQ31());
            ps.setString(33, necessidade.getQ32());
            ps.setString(34, necessidade.getQ33());
            ps.setString(35, necessidade.getQ34());
            ps.setString(36, necessidade.getQ35());
            ps.setString(37, necessidade.getQ36());
            ps.setString(38, necessidade.getQ37());
            ps.setString(39, necessidade.getQ38());
            ps.setString(40, necessidade.getQ39());
            ps.setString(41, necessidade.getQ40());
            ps.setString(42, necessidade.getQ41());
            ps.setString(43, necessidade.getQ42());
            ps.setString(44, necessidade.getQ43());
            ps.setString(45, necessidade.getQ44());
            ps.setString(46, necessidade.getQ45());
            ps.setString(47, necessidade.getQ46());
            ps.setString(48, necessidade.getQ47());
            ps.setString(49, necessidade.getQ48());
            ps.setString(50, necessidade.getQ49());
            ps.setString(51, necessidade.getQ50());
            ps.setString(52, necessidade.getQ51());
            ps.setString(53, necessidade.getQ52());
            ps.setString(54, necessidade.getQ53());
            ps.setString(55, necessidade.getQ54());
            ps.setString(56, necessidade.getQ55());
            ps.setString(57, necessidade.getQ56());
            ps.setString(58, necessidade.getQ57());
            ps.setString(59, necessidade.getQ58());
            ps.setString(60, necessidade.getQ59());
            ps.setString(61, necessidade.getQ60());
            ps.setString(62, necessidade.getQ61());
            ps.setString(63, necessidade.getQ62());
            ps.setString(64, necessidade.getQ63());
            ps.setString(65, necessidade.getQ64());
            ps.setString(66, necessidade.getQ65());
            ps.setString(67, necessidade.getQ66());
            ps.setString(68, necessidade.getQ67());
            ps.setString(69, necessidade.getQ68());
            ps.setString(70, necessidade.getQ69());
            ps.setString(71, necessidade.getQ70());
            ps.setString(72, necessidade.getQ71());
            ps.setString(73, necessidade.getQ72());
            ps.setString(74, necessidade.getQ73());
            ps.setString(75, necessidade.getQ74());
            ps.setString(76, necessidade.getQ75());
            ps.setString(77, necessidade.getQ76());
            ps.setString(78, necessidade.getQ77());
            
            ps.execute();
            System.out.println("inserindo fornecedor---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("#########################" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }

    }

    public List<Necessidade> buscar(Integer inep) throws ErroSistema {

       
        String sql = "select * from necessidades where inepEscola = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, inep);
            ResultSet rs = ps.executeQuery();
            List<Necessidade> necessidades = new ArrayList<>();

            while (rs.next()) {
                Necessidade necessidade = new Necessidade();
                
                necessidade.setIdNecessidade(rs.getInt("idNecessidades"));
                necessidade.setCodInep(rs.getInt("inepEscola"));
                necessidade.setQ1(rs.getString("q1"));
                necessidade.setQ2(rs.getString("q2"));
                necessidade.setQ3(rs.getString("q3"));
                necessidade.setQ4(rs.getString("q4"));
                necessidade.setQ5(rs.getString("q5"));
                necessidade.setQ6(rs.getString("q6"));
                necessidade.setQ7(rs.getString("q7"));
                necessidade.setQ8(rs.getString("q8"));
                necessidade.setQ9(rs.getString("q9"));
                necessidade.setQ10(rs.getString("q10"));
                necessidade.setQ11(rs.getString("q11"));
                necessidade.setQ12(rs.getString("q12"));
                necessidade.setQ13(rs.getString("q13"));
                necessidade.setQ14(rs.getString("q14"));
                necessidade.setQ15(rs.getString("q15"));
                necessidade.setQ16(rs.getString("q16"));
                necessidade.setQ17(rs.getString("q17"));
                necessidade.setQ18(rs.getString("q18"));
                necessidade.setQ19(rs.getString("q19"));
                necessidade.setQ20(rs.getString("q20"));
                necessidade.setQ21(rs.getString("q21"));
                necessidade.setQ22(rs.getString("q22"));
                necessidade.setQ23(rs.getString("q23"));
                necessidade.setQ24(rs.getString("q24"));
                necessidade.setQ25(rs.getString("q25"));
                necessidade.setQ26(rs.getString("q26"));
                necessidade.setQ27(rs.getString("q27"));
                necessidade.setQ28(rs.getString("q28"));
                necessidade.setQ29(rs.getString("q29"));
                necessidade.setQ30(rs.getString("q30"));
                necessidade.setQ31(rs.getString("q31"));
                necessidade.setQ32(rs.getString("q32"));
                necessidade.setQ33(rs.getString("q33"));
                necessidade.setQ34(rs.getString("q34"));
                necessidade.setQ35(rs.getString("q35"));
                necessidade.setQ36(rs.getString("q36"));
                necessidade.setQ37(rs.getString("q37"));
                necessidade.setQ38(rs.getString("q38"));
                necessidade.setQ39(rs.getString("q39"));
                necessidade.setQ40(rs.getString("q40"));
                necessidade.setQ41(rs.getString("q41"));
                necessidade.setQ42(rs.getString("q42"));
                necessidade.setQ43(rs.getString("q43"));
                necessidade.setQ44(rs.getString("q44"));
                necessidade.setQ45(rs.getString("q45"));
                necessidade.setQ46(rs.getString("q46"));
                necessidade.setQ47(rs.getString("q47"));
                necessidade.setQ48(rs.getString("q48"));
                necessidade.setQ49(rs.getString("q49"));
                necessidade.setQ50(rs.getString("q50"));
                necessidade.setQ51(rs.getString("q51"));
                necessidade.setQ52(rs.getString("q52"));
                necessidade.setQ53(rs.getString("q53"));
                necessidade.setQ54(rs.getString("q54"));
                necessidade.setQ55(rs.getString("q55"));
                necessidade.setQ56(rs.getString("q56"));
                necessidade.setQ57(rs.getString("q57"));
                necessidade.setQ58(rs.getString("q58"));
                necessidade.setQ59(rs.getString("q59"));
                necessidade.setQ60(rs.getString("q60"));
                necessidade.setQ61(rs.getString("q61"));
                necessidade.setQ62(rs.getString("q62"));
                necessidade.setQ63(rs.getString("q63"));
                necessidade.setQ64(rs.getString("q64"));
                necessidade.setQ65(rs.getString("q65"));
                necessidade.setQ66(rs.getString("q66"));
                necessidade.setQ67(rs.getString("q67"));
                necessidade.setQ68(rs.getString("q68"));
                necessidade.setQ69(rs.getString("q69"));
                necessidade.setQ70(rs.getString("q70"));
                necessidade.setQ71(rs.getString("q71"));
                necessidade.setQ72(rs.getString("q72"));
                necessidade.setQ73(rs.getString("q73"));
                necessidade.setQ74(rs.getString("q74"));
                necessidade.setQ75(rs.getString("q75"));
                necessidade.setQ76(rs.getString("q76"));
                necessidade.setQ77(rs.getString("q77"));
                necessidades.add(necessidade);
            }
             System.out.println("----------x-x-x-x-x-x-x-x-x------------ " );  
            return necessidades;
        } catch (Exception e) {
            throw new ErroSistema("erroooooo--------------------", e);

        }
         
       
    }

    public List<Necessidade> buscarF(String parametro) throws ErroSistema {

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

    public void deletar(Necessidade necessidade) throws ErroSistema {

       // System.out.println("com.br.seducpaudalho.Dao.FornecedorDao.deletar()" + necessidade.getIdProduto());

        String sql = "delete from produto where idProduto = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
           // ps.setInt(1, necessidade.getIdProduto());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (Exception e) {

            throw new ErroSistema("ERRO AO DELETAR PRODUTO");
        }
    }

}
