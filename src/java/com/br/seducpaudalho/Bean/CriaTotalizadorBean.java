/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Bean;

import com.br.seducpaudalho.Entidade.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author SEC-EDUC02
 */
@ManagedBean
@SessionScoped
public class CriaTotalizadorBean {

    private List<String> colunas = new ArrayList<String>();
    private List<String> operacoes = new ArrayList<String>();
    private List<Aluno> alunos = new ArrayList<>();
    // the rows and cells of the database table
    List<List<String>> content = new ArrayList<>();
    String[][] array = {{"D1", "D2", "D3", "D4", "D5"}, {" ", "D7", "D8", " ", "D10"}, {"D6", "D7"},};

    String[][] dados = new String[6][6];

    String myTwoDimensionalStringArray[][] = new String[2][2];

    public CriaTotalizadorBean() {

        myTwoDimensionalStringArray[0][0] = "Apple";
        myTwoDimensionalStringArray[0][1] = "Banana";
        myTwoDimensionalStringArray[1][0] = "Pork";
        myTwoDimensionalStringArray[1][1] = "Beef";

        /* for (int x = 0; x < myTwoDimensionalStringArray.length; x ++) {
    String subArray[] = myTwoDimensionalStringArray[x]; 
    System.out.println( "Length of array " + x + " is " + subArray.length );
    for (int y = 0; y < subArray.length; y ++) {
        String item = subArray[y];
        System.out.println( "  Item " +yx + " is " + item );
    }*/
        Aluno a = new Aluno();
        a.setIdAluno(1);
        a.setNome("ABCDEF");
        a.setNomeSerie("1º ANO");
        a.setIdSerie(20);
        alunos.add(a);
        Aluno aa = new Aluno();
        aa.setIdAluno(2);
        aa.setNome("FEDCBA");
        aa.setNomeSerie("1º ANO");
        aa.setIdSerie(30);
        alunos.add(aa);
        Aluno aaa = new Aluno();
        aaa.setIdAluno(3);
        aaa.setNome("ABBDDA");
        aaa.setNomeSerie("1º ANO");
        aaa.setIdSerie(29);
        alunos.add(aaa);
        Aluno aaaa = new Aluno();
        aaaa.setIdAluno(4);
        aaaa.setNome("BBBDDA");
        aaaa.setNomeSerie("1º ANO");
        aaaa.setIdSerie(45);
        alunos.add(aaaa);

         for (int i = 0; i < alunos.size(); i++) {

            for (int j = 0; j <= 5; j++) {

                System.out.println("_____________***********_________ " + alunos.get(i).getNome().length());
                char tes = alunos.get(i).getNome().charAt(j);
                String b = String.valueOf(tes);
                System.out.println("############ " + b);
                dados[i][j] = b;
              
                
               
                //   System.out.println("_____________XXXXXXXXXXXXX_________ " + i + "xxxxxxxxxxxxx " + j);
               // System.out.println("_____________XXXXXXXXXXXXX_________ " + tes.toString());
            }
        }

       /*dados[0][0] = "A";
        dados[0][1] = "B";
        dados[0][2] = "C";
        dados[0][3] = "D";
        dados[0][4] = "E";
        dados[0][5] = "F";*/
       

        /*dados[1][0] = "F";
        dados[1][1] = "G";
        dados[1][2] = " ";
        dados[1][3] = "I";
        dados[1][4] = "J";*/
        colunas.add("coluna1");
        colunas.add("coluna2");
        colunas.add("coluna3");
        colunas.add("coluna4");

        operacoes.add("D1");
        operacoes.add("D2");
        operacoes.add("D3");
        operacoes.add("D4");
        operacoes.add("D5");
        content.add(operacoes);
    }

    public List<String> getColunas() {
        return colunas;
    }

    public void setColunas(List<String> colunas) {
        this.colunas = colunas;
    }

    public List<String> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<String> operacoes) {
        this.operacoes = operacoes;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String[][] getArray() {
        return array;
    }

    public void setArray(String[][] array) {
        this.array = array;
    }

    public String[][] getDados() {
        return dados;
    }

    public void setDados(String[][] dados) {
        this.dados = dados;
    }

    public String getRowsOfTable() {
        StringBuilder sb = new StringBuilder();
        for (List<String> row : content) {
            sb.append("\t<tr>\n");
            for (String cell : row) {
                sb.append("\t\t<td>" + cell + "</td>\n");
            }
            sb.append("\t</tr>\n");
        }
        return sb.toString();
    }
    /*
    Teste[][] testes = new Teste[10][10];
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				Teste t = new Teste();
				t.setNome("N " + i + " " + j);
				t.setVal(i+j);
				testes[i][j] = t;
			}
		}
		System.out.println("Agora escrevendo os valores: ");

		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				Teste t = testes[i][j];
				System.out.println("Teste posição: " + i + " " + j);
				System.out.println("Teste nome: " + t.getNome());
				System.out.println("Valor: " + t.getVal());
			}
		}
	}*/
 /*  Object [] [] t = new Object [1][12];*/
}
