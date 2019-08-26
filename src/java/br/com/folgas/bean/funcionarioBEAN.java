package br.com.folgas.bean;

import br.com.folgas.DAO.ColaboradorDAO;
import br.com.folgas.entity.Colaborador;
import br.com.folgas.entity.Evento;
import br.com.folgas.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "MBFuncionario")
@ViewScoped

public class funcionarioBEAN {
    
    public Evento getAgenda() {
        return agenda;
    }

    public void setAgenda(Evento agenda) {
        this.agenda = agenda;
    }

    private Evento agenda;

    
    private Colaborador funcionario;
    private ArrayList<Colaborador> intes;
    private ArrayList<Colaborador> intesFiltrados;

    public Colaborador getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Colaborador funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Colaborador> getIntes() {
        return intes;
    }

    public void setIntes(ArrayList<Colaborador> intes) {
        this.intes = intes;
    }

    public ArrayList<Colaborador> getIntesFiltrados() {
        return intesFiltrados;
    }

    public void setIntesFiltrados(ArrayList<Colaborador> intesFiltrados) {
        this.intesFiltrados = intesFiltrados;
    }

    @PostConstruct
    public void prepararPesquisa() {
        try {
            
            ColaboradorDAO _fdao = new ColaboradorDAO();
            intes = _fdao.listar();

        } catch (SQLException e) {
            System.out.println("erro" + e);
            JSFUtil.adicionarMensagemErro("erro:" + e.getMessage());
        }
    }

    public void prepararNovo() {
        funcionario = new Colaborador();
    }

    public void novoFuncionario() {
        try {
            ColaboradorDAO _fdao = new ColaboradorDAO();
            _fdao.salvar(funcionario);

            intes = _fdao.listar();

            JSFUtil.adicionarMensagemSucesso("O Colaborador foi Adicionado");
        } catch (SQLException ex) {
            JSFUtil.adicionarMensagemErro("Erro:" + ex.getMessage());
            
        }
    }

    public void exluir() {
        ColaboradorDAO fdao = new ColaboradorDAO();
        
        try {
            fdao.deletar(funcionario);
            intes = fdao.listar();
            JSFUtil.adicionarMensagemSucesso("O Colaborador foi Removido!");
        } catch (SQLException e) {
            JSFUtil.adicionarMensagemSucesso("Erro:  " + e);
        }
    }

 
    
    public void editarFuncionario() {
       
        
        
            try {
                 ColaboradorDAO cdao = new ColaboradorDAO();
                  cdao.alterar(funcionario);
                  intes = cdao.listar();
                  JSFUtil.adicionarMensagemSucesso("Alteração Realizada!");
            } catch (Exception e) {
                 JSFUtil.adicionarMensagemErro("Erro: "+e.getMessage());
            }
          
            
  
        }
        
        
        
        
    

    
   
    
    
}
