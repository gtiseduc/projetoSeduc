package com.br.seducpaudalho.Dao;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import com.br.seducpaudalho.Entidade.Disciplina;
import com.br.seducpaudalho.Entidade.Escola;
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
public class EscolaDao {

    public List<Escola> listarEscolas() throws ErroSistema {

       System.out.println("entrou no listarEscola Escola" );
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from escola";
        List<Escola> escolas = new ArrayList<>();
        
        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
          
            ResultSet rs = ps.executeQuery();

           

            while (rs.next()) {
                Escola escola = new Escola();
                
                escola.setInepEscola(rs.getInt("inepEscola"));
                escola.setNome(rs.getString("nomeEscola"));
              
               
                escolas.add(escola);
                System.out.println("tamanho da lista de escola " + escola.getNome()); 
            }
          
        } catch (Exception e) {
            System.out.println("erro ao listar fornecedor " +e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
 //System.out.println("tamanho da lista de fornecedores " + escolas.size() );
        FabricaConexao.fecharConexao();
        return escolas;
    
    }
    public List<Disciplina> listarDisciplinas() throws ErroSistema {

       System.out.println("entrou no listar Disciplina" );
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from disciplina";
        List<Disciplina> disciplinas = new ArrayList<>();
        
        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
          
            ResultSet rs = ps.executeQuery();

           

            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                
                disciplina.setCodDisciplina(rs.getInt("codDisciplina"));
                disciplina.setNomeDisciplina(rs.getString("nomeDisciplina"));
              
               
                disciplinas.add(disciplina);
                System.out.println("nome da disciplina " + disciplina.getNomeDisciplina()); 
                System.out.println("codigo da disciplina " + disciplina.getCodDisciplina()); 
            }
          
        } catch (Exception e) {
            System.out.println("erro ao listar disciplina " +e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
 //System.out.println("tamanho da lista de fornecedores " + escolas.size() );
        FabricaConexao.fecharConexao();
        return disciplinas;
    
    }
  
    public List<Escola> lFornecedorCodigo(Integer codigo) throws ErroSistema {

       System.out.println("entrou no lFornecedorCodigo fornecedor ---------------------" );
        String retorno = "";
        // "Select uname, password from Users where uname = ? and password = ?"

        String sql = "select * from escola where inepEscola = ?";
       
        List<Escola> fornecedores = new ArrayList<>();
        
        try {
            Connection conexao = FabricaConexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();

           

            while (rs.next()) {
               /* Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                fornecedor.setPessoa(rs.getString("tPessoa"));
                fornecedor.setRzSocial(rs.getString("rzSocial"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setFantasia(rs.getString("nFantasia"));
                fornecedor.setMunicipal(rs.getString("iMunicipal"));
                fornecedor.setEstadual(rs.getString("iEstadual"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setNumero(rs.getString("numero"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setEstado(rs.getString("estado"));
                fornecedor.setEstado(rs.getString("pais"));
                fornecedor.setTelefone1(rs.getString("telefone1"));
                fornecedor.setTelefone2(rs.getString("telefone2"));
                fornecedor.setEmail(rs.getString("email"));
                escolas.add(fornecedor);
                System.out.println("tamanho da lista de fornecedor " + fornecedor.getPessoa()); */
            }
          
        } catch (Exception e) {
            System.out.println("erro ao listar fornecedor " +e);
            throw new ErroSistema("erroooooo--------------------", e);

        }
 System.out.println("tamanho da lista de fornecedores " + fornecedores.size() );
        FabricaConexao.fecharConexao();
        return fornecedores;
    
    }

   

    public void salvar(Escola fornecedor) throws ErroSistema {

        /*
        try {
            
             String sql = "";
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps;

             if (fornecedor.getIdFornecedor() == null) {
                 System.out.println("--------- entrou no if cadastro produto");
               ps = conexao.prepareStatement("INSERT INTO fornecedor(tPessoa,rzSocial,cnpj,nFantasia,iMunicipal,iEstadual,cep,endereco,complemento,numero,bairro,cidade,estado,pais,telefone1,telefone2,email)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           } else {
                 System.out.println("--------- entrou no else cadastro produto" + fornecedor.getIdFornecedor());
                 ps = conexao.prepareStatement("UPDATE fornecedor SET tPessoa=?,rzSocial=?,cnpj=?,nFantasia=?,iMunicipal=?,iEstadual=?,cep=?,endereco=?,complemento=?,numero=?,bairro=?,cidade=?,estado=?,pais=?,telefone1=?,telefone2=?,email=? where idFornecedor=?");
                ps.setInt(18, fornecedor.getIdFornecedor());
           }
            
            
            
            
            ps.setString(1, fornecedor.getPessoa());
            ps.setString(2, fornecedor.getRzSocial());
            ps.setString(3, fornecedor.getCnpj());
            ps.setString(4, fornecedor.getFantasia());
            ps.setString(5, fornecedor.getMunicipal());
            ps.setString(6, fornecedor.getEstadual());
            ps.setString(7, fornecedor.getCep());
            ps.setString(8, fornecedor.getEndereco());
            ps.setString(9, fornecedor.getComplemento());
            ps.setString(10, fornecedor.getNumero());
            ps.setString(11, fornecedor.getBairro());
            ps.setString(12, fornecedor.getCidade());
            ps.setString(13, fornecedor.getEstado());
            ps.setString(14, fornecedor.getPais());
            ps.setString(15, fornecedor.getTelefone1());
            ps.setString(16, fornecedor.getTelefone2());
            ps.setString(17, fornecedor.getEmail());
           
           

            ps.execute();
            System.out.println("inserindo fornecedor---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("erro fornecedor---------------------------------------" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }
*/
    }
    public void salvarProduto(Escola p) throws ErroSistema {

      /*  System.out.println("com.br.seducpaudalho.Dao.FornecedorDao.salvar() "+ p.getEspecificacaoProduto());

        String sql = "INSERT INTO produto(idFornecedor,nProduto,mProduto,eProduto,uProduto,kProduto,vUnitario,vTotal)VALUES (?,?,?,?,?,?,?,?)";

        try {
            
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, p.getIdFornecedor());
            ps.setString(2, p.getNomeProduto());
            ps.setString(3, p.getMarcaProduto());
            ps.setString(4, p.getUnidadeProduto());
            ps.setString(5, "asd");
            ps.setString(6, "asd");
            ps.setString(7, "asd");
            ps.setString(8, "asd");
            
           
           

            ps.execute();
            System.out.println("inserindo fornecedor---------------------------------------");
            FabricaConexao.fecharConexao();

        } catch (Exception e) {
            System.out.println("erro fornecedor---------------------------------------" + e);
            throw new ErroSistema("erroooooo--------------------", e);
        }
*/
    }

    public List<Escola> buscar() throws ErroSistema {

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

    public List<Escola> buscarF(String parametro) throws ErroSistema {

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

    public void deletar(Escola fornecedor) throws ErroSistema {
        
       // System.out.println("com.br.seducpaudalho.Dao.FornecedorDao.deletar()"+fornecedor.getCnpj());
       
        String sql = "delete from fornecedor where cnpj = ?";

        try {
            Connection conexao = FabricaConexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
           // ps.setString(1, fornecedor.getCnpj());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (Exception e) {

            throw new ErroSistema("ERRO AO DELETAR FORNECEDOR");
        }
    }
    
    
    

}
