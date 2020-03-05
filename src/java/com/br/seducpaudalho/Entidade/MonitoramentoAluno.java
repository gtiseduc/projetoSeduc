/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Entidade;

/**
 *
 * @author SEC-EDUC02
 */
public class MonitoramentoAluno {
    
    
    private int codAluno;
    private int codSerie;
    private int codTurma;
    private int inepEscola;
    private int codDisciplina;
    private String nomeAluno;
    private String data;
    
    private boolean resp1;
    private boolean resp2;
    private boolean resp3;
    private boolean resp4;
    private boolean resp5;
    private boolean resp6;
    private boolean resp7;
    private boolean resp8;
    private boolean resp9;
    private boolean resp10;
    private boolean resp11;
    private boolean resp12;
    private boolean resp13;
    private boolean resp14;
    private boolean resp15;
    private boolean resp16;
    private boolean resp17;

    public MonitoramentoAluno(int codAluno, int codSerie, int codTurma, int inepEscola, int codDisciplina, String nomeAluno, String data, boolean resp1, boolean resp2, boolean resp3, boolean resp4, boolean resp5, boolean resp6, boolean resp7, boolean resp8, boolean resp9, boolean resp10, boolean resp11, boolean resp12, boolean resp13, boolean resp14, boolean resp15, boolean resp16, boolean resp17) {
        this.codAluno = codAluno;
        this.codSerie = codSerie;
        this.codTurma = codTurma;
        this.inepEscola = inepEscola;
        this.codDisciplina = codDisciplina;
        this.nomeAluno = nomeAluno;
        this.data = data;
        this.resp1 = resp1;
        this.resp2 = resp2;
        this.resp3 = resp3;
        this.resp4 = resp4;
        this.resp5 = resp5;
        this.resp6 = resp6;
        this.resp7 = resp7;
        this.resp8 = resp8;
        this.resp9 = resp9;
        this.resp10 = resp10;
        this.resp11 = resp11;
        this.resp12 = resp12;
        this.resp13 = resp13;
        this.resp14 = resp14;
        this.resp15 = resp15;
        this.resp16 = resp16;
        this.resp17 = resp17;
    }

    public MonitoramentoAluno() {
    }

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }

    public int getCodSerie() {
        return codSerie;
    }

    public void setCodSerie(int codSerie) {
        this.codSerie = codSerie;
    }

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }

    public int getInepEscola() {
        return inepEscola;
    }

    public void setInepEscola(int inepEscola) {
        this.inepEscola = inepEscola;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
    
    public boolean isResp1() {
        return resp1;
    }

    public void setResp1(boolean resp1) {
        this.resp1 = resp1;
    }

    public boolean isResp2() {
        return resp2;
    }

    public void setResp2(boolean resp2) {
        this.resp2 = resp2;
    }

    public boolean isResp3() {
        return resp3;
    }

    public void setResp3(boolean resp3) {
        this.resp3 = resp3;
    }

    public boolean isResp4() {
        return resp4;
    }

    public void setResp4(boolean resp4) {
        this.resp4 = resp4;
    }

    public boolean isResp5() {
        return resp5;
    }

    public void setResp5(boolean resp5) {
        this.resp5 = resp5;
    }

    public boolean isResp6() {
        return resp6;
    }

    public void setResp6(boolean resp6) {
        this.resp6 = resp6;
    }

    public boolean isResp7() {
        return resp7;
    }

    public void setResp7(boolean resp7) {
        this.resp7 = resp7;
    }

    public boolean isResp8() {
        return resp8;
    }

    public void setResp8(boolean resp8) {
        this.resp8 = resp8;
    }

    public boolean isResp9() {
        return resp9;
    }

    public void setResp9(boolean resp9) {
        this.resp9 = resp9;
    }

    public boolean isResp10() {
        return resp10;
    }

    public void setResp10(boolean resp10) {
        this.resp10 = resp10;
    }

    public boolean isResp11() {
        return resp11;
    }

    public void setResp11(boolean resp11) {
        this.resp11 = resp11;
    }

    public boolean isResp12() {
        return resp12;
    }

    public void setResp12(boolean resp12) {
        this.resp12 = resp12;
    }

    public boolean isResp13() {
        return resp13;
    }

    public void setResp13(boolean resp13) {
        this.resp13 = resp13;
    }

    public boolean isResp14() {
        return resp14;
    }

    public void setResp14(boolean resp14) {
        this.resp14 = resp14;
    }

    public boolean isResp15() {
        return resp15;
    }

    public void setResp15(boolean resp15) {
        this.resp15 = resp15;
    }

    public boolean isResp16() {
        return resp16;
    }

    public void setResp16(boolean resp16) {
        this.resp16 = resp16;
    }

    public boolean isResp17() {
        return resp17;
    }

    public void setResp17(boolean resp17) {
        this.resp17 = resp17;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codAluno;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MonitoramentoAluno other = (MonitoramentoAluno) obj;
        if (this.codAluno != other.codAluno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MonitoramentoAluno{" + "codAluno=" + codAluno + ", codSerie=" + codSerie + ", codTurma=" + codTurma + ", inepEscola=" + inepEscola + ", codDisciplina=" + codDisciplina + ", nomeAluno=" + nomeAluno  + ", data=" + data + ", resp1=" + resp1 + ", resp2=" + resp2 + ", resp3=" + resp3 + ", resp4=" + resp4 + ", resp5=" + resp5 + ", resp6=" + resp6 + ", resp7=" + resp7 + ", resp8=" + resp8 + ", resp9=" + resp9 + ", resp10=" + resp10 + ", resp11=" + resp11 + ", resp12=" + resp12 + ", resp13=" + resp13 + ", resp14=" + resp14 + ", resp15=" + resp15 + ", resp16=" + resp16 + ", resp17=" + resp17 + '}';
    }

    
    
   
    
    
}
