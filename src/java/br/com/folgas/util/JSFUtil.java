package br.com.folgas.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class JSFUtil {
   public static void adicionarMensagemSucesso(String mensagem){
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
       
       FacesContext contesto = FacesContext.getCurrentInstance();
       contesto.addMessage(null, msg);

       
   } 
   
   
   public static void adicionarMensagemErro(String mensagem){
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
       
       FacesContext contesto = FacesContext.getCurrentInstance();
       contesto.addMessage(null, msg);

       
   } 
   
}
