package br.com.folgas.bean;

import br.com.folgas.DAO.ColaboradorDAO;
import br.com.folgas.DAO.EventoDAO;
import br.com.folgas.entity.Colaborador;
import br.com.folgas.entity.Evento;
import br.com.folgas.util.JSFUtil;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "MBEvento")
@SessionScoped
public class EventoBEAN {

    String testeX = null;
    public String colabLogado;
    Colaborador funcionario = new Colaborador();

    public String getColabLogado() {
        return colabLogado;
    }

    public void setColabLogado(String colabLogado) {
        this.colabLogado = colabLogado;
    }

    public Colaborador getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Colaborador funcionario) {
        this.funcionario = funcionario;
    }
    private Evento evento;
    private ArrayList<Evento> intes;
    private ArrayList<Evento> intesFiltrados;
    private ArrayList<Colaborador> comboColaborador;

    public ArrayList<Colaborador> getComboColaborador() {
        return comboColaborador;
    }

    public void setComboColaborador(ArrayList<Colaborador> comboColaborador) {
        this.comboColaborador = comboColaborador;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public ArrayList<Evento> getIntes() {
        return intes;
    }

    public void setIntes(ArrayList<Evento> intes) {
        this.intes = intes;
    }

    public ArrayList<Evento> getIntesFiltrados() {
        return intesFiltrados;
    }

    public void setIntesFiltrados(ArrayList<Evento> intesFiltrados) {
        this.intesFiltrados = intesFiltrados;
    }

    @PostConstruct
    public void listarEventos() {
        try {

            EventoDAO _fdao = new EventoDAO();
            intes = _fdao.listar();

        } catch (SQLException e) {
            System.out.println("erro" + e);
            JSFUtil.adicionarMensagemErro("erro:" + e.getMessage());
        }
    }

    public String login() throws SQLException {

        ColaboradorDAO cdao = new ColaboradorDAO();

        String perfil = null;
        String gestor = "GESTOR";
        String padrao = "PADRAO";

        String retorno = cdao.Logar(funcionario);

        if (retorno.equals(gestor)) {
            JSFUtil.adicionarMensagemSucesso("Bem Vindo!");
            return "gestao.xhtml";
        } else {
            if (retorno.equals(padrao)) {
                JSFUtil.adicionarMensagemSucesso("Bem Vindo!");
                return "agenda.xhtml";
            } else {
                JSFUtil.adicionarMensagemErro("Credenciais invalias");
                return "index_1.xhtml";
            }

        }
    }

    public void prepararNovo() {
        evento = new Evento();

    }

    public void novoEventoGestor() {

        EventoDAO edao = new EventoDAO();
        try {
            edao.salvar(evento);
            intes = edao.listar();
            JSFUtil.adicionarMensagemSucesso("**Atenção Gestor!");
            JSFUtil.adicionarMensagemSucesso("Está folga folga não passou por validação!");
        } catch (Exception e) {
            JSFUtil.adicionarMensagemErro("Erro: " +e);
        }

    }

    public void novoEvento() {
        try {
            EventoDAO edao = new EventoDAO();

            //=================================== aprendendo o que é dia escolhido ==========================================
            //Variável dia é o dia escolhido como inteiro 
            String dataEscolhida = evento.getStart_event();
            String diaString = evento.getStart_event().substring(8, 10);
            Integer dia = Integer.parseInt(diaString);
            //==========================================================================================================================================

            //=================================== aprendendo o que é hoje ===================================================
            //Variavel hoje é igual ao dia de hoje como inteiro
            Date dataAtual = new Date();
            SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
            String hojeF = formatar.format(dataAtual);
            String hojeString = hojeF.substring(0, 2);
            Integer hoje = Integer.parseInt(hojeString);

            String ultimaFolga = edao.dataUltimaFolga(evento);
            String diaUltimaFolga = ultimaFolga.substring(8, 10);

            Integer diaUltFolga = Integer.parseInt(diaUltimaFolga);
            Integer folgasPorMes = edao.folgasPorMes(evento);
            if (dia <= hoje) {
                JSFUtil.adicionarMensagemErro("Folga Não Permitida Consulte Manual de Folgasa");
            } else {
                if (diaUltFolga - 7 < dia && diaUltFolga + 7 > dia) {
                    JSFUtil.adicionarMensagemErro("Folga Não Permitida Consulte Manual de Folgasa");
                } else {
                    if (folgasPorMes >= 2) {
                        JSFUtil.adicionarMensagemErro("Folga Não Permitida Consulte Manual de Folgasa");
                    } else {
                        edao.salvar(evento);
                        intes = edao.listar();
                        JSFUtil.adicionarMensagemSucesso("Parabén sua folga foi agendata para do dia: " + dia);
                    }

                }
            }
        } catch (Exception e) {
            JSFUtil.adicionarMensagemErro(e.getMessage());
            try {
                String x = e.toString();
                String u = "java.lang.NullPointerException";
                EventoDAO edao = new EventoDAO();
                Integer folgaRep = edao.VerificaData(evento);
                if (folgaRep >= 2) {
                    JSFUtil.adicionarMensagemErro("Folga Não Permitida Consulte Manual de Folgasa");
                } else {
                    if (x == u) {
                        edao.salvar(evento);
                        intes = edao.listar();
                        JSFUtil.adicionarMensagemSucesso("Sua folga foi agendada!");
                    } else {
                        JSFUtil.adicionarMensagemErro(x);
                    }
                }
            } catch (Exception ex) {
                JSFUtil.adicionarMensagemErro("Aviso:  " + e.getMessage());
            }
        }
    }

    public void exluir() {

        EventoDAO edao = new EventoDAO();
        try {

            edao.deletar(evento);
            intes = edao.listar();
            JSFUtil.adicionarMensagemSucesso("Folga removida!");

        } catch (SQLException e) {
            JSFUtil.adicionarMensagemSucesso("Erro:  " + e);
        }
    }
}
