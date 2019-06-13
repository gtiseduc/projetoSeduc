/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.seducpaudalho.Util;

import com.br.seducpaudalho.Dao.FornecedorDao;
import com.br.seducpaudalho.Entidade.Fornecedor;
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
@FacesConverter(forClass = Fornecedor.class)
public class FornecedorConvert implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        System.out.println("1111111111com.br.seducpaudalho.Util.FornecedorConvert.getAsString()");
        if (value != null && !value.isEmpty()) {
           Integer codigo = Integer.valueOf(value);
            FornecedorDao fornecedor = new FornecedorDao();
            
            try {
                return fornecedor.lFornecedorCodigo(codigo);
            } catch (ErroSistema ex) {
                Logger.getLogger(FornecedorConvert.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        System.out.println("2222222222com.br.seducpaudalho.Util.FornecedorConvert.getAsString()");
        if (value instanceof Fornecedor) {
            Fornecedor entity = (Fornecedor) value;
            if (entity != null && entity instanceof Fornecedor && entity.getIdFornecedor() != null) {
                uiComponent.getAttributes().put( entity.getIdFornecedor().toString(), entity);
                return entity.getIdFornecedor().toString();
            }
        }
        return "";
    }
    
    
    
}
