/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SEC-EDUC02
 */
public class GabaritoBean {
    
    
    

    public void corrigirGabarito() {

        
        
        
        
        String frase = "00149/007587/10987";
        String array[] = new String[3];
        array = frase.split("/");
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);




        String gabarito = "ABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDE";

        String compara = "";
        Integer resultado = 0;

        List<String> listaDeGabarito = new ArrayList<String>();
        List<String> listaDeResultado = new ArrayList<String>();
        //123456789
        listaDeGabarito.add("BBCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDE");
        listaDeGabarito.add("CBCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDE");
        listaDeGabarito.add("EBCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDE");
        listaDeGabarito.add("ABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDE");





        int[][] data = new int[listaDeGabarito.size()][gabarito.length()];

        List<Integer> meuGabarito = new ArrayList<Integer>();

        for (int b = 0; b < listaDeGabarito.size(); b++) {

            String a = listaDeGabarito.get(b);

            for (int i = 0; i < a.length(); i++) {

                if (a.charAt(i) == gabarito.charAt(i)) {

                    compara = compara + "1";
                    //resultado = resultado + Integer.parseInt(compara);

                } else {
                    compara = compara + "0";
                }
            }

            listaDeResultado.add(compara);
            System.out.println("lista de resultado " + compara);
            compara = "";
            resultado = 0;
        }


        String var = "";

        int s = 0;
        for (int i = 0; i < listaDeResultado.size(); i++) {

            var = listaDeResultado.get(i);

            for (int j = 0; j < var.length(); j++) {

                //  int a =  var.charAt(j
                int v = Character.getNumericValue(var.charAt(j));
                s = s + v;
               // System.out.println("***** - - ****" + s);
                //  System.out.println( "yyyyyy"+v + "uuuuu"+var.charAt(j));
                //data[i][j] = var.charAt(j);
                data[i][j] = v;
               // System.out.println("olha ****" + v++);

            }

            System.out.println("A SOMA DAS LINHAS É "+s);
            s = 0;
        }





        int size = data.length, largestRow = 0, sum = 0, col = 0;

        for (int check = 0; check <= (size - 1); check++) {
            if (largestRow < data[check].length) {
                largestRow = data[check].length;
            }
        }


        do {
            for (int row = 0; row < data.length; row++) {
                //System.out.println("row(long): "+data[row].length+", col: "+col);
                //System.out.println(col>=(data[row].length-1));

                if (col >= (data[row].length)) {
                } else {
                    sum += data[row][col];
                }
            }
            col += 1;

            System.out.println("A SOMA DA COLUNA " + col + " É: " + (sum));//made the row +1, to make it understandable
           // System.out.println(sum + "%");
            sum = 0;
        } while (col != largestRow);

    }
    
    

}



