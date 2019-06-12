package com.br.seducpaudalho.phaselistener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.br.seducpaudalho.Entidade.Login;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VICTOR HUGO
 */
public class LoginPhaseListener implements PhaseListener {
    
     private FacesContext facesContext;
  
    @Override
    public void afterPhase(PhaseEvent event) {
       System.out.println("encontrou no metodo afterPhase");
         facesContext = event.getFacesContext();
        String viewId = facesContext.getViewRoot().getViewId();
      
       
      
        NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
        boolean paginaLogin = viewId.lastIndexOf("login") > -1;

       if (existeUsuarioLogado() && paginaLogin) {
             System.out.println("encontrou na pagina index");
            nh.handleNavigation(facesContext, null, "/index?faces-redirect=true");
        } else if (!existeUsuarioLogado() && !paginaLogin) {
            System.out.println("encontrou na pagina login");
            nh.handleNavigation(facesContext, null, "/login?faces-redirect=true");
        }
    }

    public boolean existeUsuarioLogado() {
        return (((Login) getAtributoSessao("login")) != null);
        //return (( getAtributoSessao("cpf")) != null);
        
    }

    public Object getAtributoSessao(String attributeName) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       
        if (session != null) {
            System.out.println("retornando atributo na sessão"+session.getAttribute(attributeName));
            return session.getAttribute(attributeName);
        }
        return null;
    }

    @Override
    public void beforePhase(PhaseEvent event) {
       System.out.println("encontrou no metodo beforePhase");  
    }

    @Override
    public PhaseId getPhaseId() {
        System.out.println("encontrou no metodo getPhaseId");  
        return PhaseId.RESTORE_VIEW;
    }

    
}
