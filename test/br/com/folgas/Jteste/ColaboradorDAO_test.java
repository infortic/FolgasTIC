package br.com.folgas.Jteste;

import br.com.folgas.DAO.ColaboradorDAO;
import br.com.folgas.entity.Colaborador;
import br.com.folgas.util.JSFUtil;
import java.sql.SQLException;
import org.junit.Ignore;
import org.junit.Test;


public class ColaboradorDAO_test {
    
    
    @Test
   @Ignore
    public void login() throws SQLException{
        ColaboradorDAO cdao = new  ColaboradorDAO();
         String perfil = null;
         String gestor = "GESTOR";
         String padrao = "PADRAO";
        Colaborador funcionario = new Colaborador();
        funcionario.setLogin("cleiton");
        funcionario.setSenha("1234");
        String retorno = cdao.Logar(funcionario);
           
           if(retorno.equals(gestor)){
               System.out.println("Gestor = "+retorno);
           }else{
               if(retorno.equals(padrao)){
                 System.out.println("padrao = "+retorno);  
               }else{
                   System.out.println("credenciais invalidas ");
               }
               
           }

    }
    @Test
    public  void alterar()throws SQLException{
        Colaborador _colab= new Colaborador();
        ColaboradorDAO edao = new ColaboradorDAO();
        _colab.setCod_funcionario(4);
        _colab.setSenha("CU");
        _colab.setPerfil("PADRAO");
        
        edao.alterar(_colab);
        
    }
         
         
}
