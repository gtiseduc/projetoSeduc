/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Util;

import com.br.seducpaudalho.Util.Excepition.ErroSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VICTOR HUGO
 */
public class FabricaConexao {

   public static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:mysql://localhost:3306/db_seduc";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
   
   // private static final String USUARIO = "root";
   // private static final String SENHA = "saepa2020seducvic";

    public static Connection getConnection() throws ErroSistema {

        if (conexao == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);

            } catch (ClassNotFoundException ex) {

                throw new ErroSistema("NÃO FOI POSSIVEL CONECTAR AO BANCO DE DADOS", ex);

            } catch (SQLException ex) {

                throw new ErroSistema("NÃO FOI POSSIVEL CONECTAR AO DRIVE DO BANCO", ex);

            }

        }
        return conexao;

    }

    public static void fecharConexao() throws ErroSistema {

        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
               throw new ErroSistema("NÃO FOI POSSIVEL FECHAR A CONEXAO COM O BANCO", ex); 
            }

        }
    }
}
