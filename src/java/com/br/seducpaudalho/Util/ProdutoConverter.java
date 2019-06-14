/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Util;

import com.br.seducpaudalho.Dao.FornecedorDao;
import com.br.seducpaudalho.Dao.ProdutoDao;
import com.br.seducpaudalho.Entidade.Fornecedor;
import com.br.seducpaudalho.Entidade.Produto;
import com.br.seducpaudalho.Util.Excepition.ErroSistema;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author VICTOR HUGO
 */
//@FacesConverter(value = "classeConverter")    
//@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        System.out.println("1111111111com.br.seducpaudalho.Util.FornecedorConvert.getAsString()");
        if (value != null && !value.isEmpty()) {
           Integer codigo = Integer.valueOf(value);
            ProdutoDao produto = new ProdutoDao();
            
            try {
                return produto.lFornecedorCodigo(codigo);
            } catch (ErroSistema ex) {
                Logger.getLogger(ProdutoConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        System.out.println("2222222222com.br.seducpaudalho.Util.FornecedorConvert.getAsString()");
        if (value instanceof Fornecedor) {
            Produto entity = (Produto) value;
            if (entity != null && entity instanceof Produto && entity.getIdProduto() != null) {
                uiComponent.getAttributes().put( entity.getIdProduto().toString(), entity);
                System.out.println("------------ "+entity.getIdProduto().toString());
                return entity.getIdProduto().toString();
            }
        }
        return "";
    }
    
    
    
}
