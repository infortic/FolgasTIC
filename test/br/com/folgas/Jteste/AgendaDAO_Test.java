package br.com.folgas.Jteste;

import br.com.folgas.DAO.EventoDAO;
import br.com.folgas.entity.Colaborador;
import br.com.folgas.entity.Evento;
import br.com.folgas.factory.ConnectionFactory;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.JOptionPane;
import org.junit.Ignore;
import org.junit.Test;

public class AgendaDAO_Test {

    @Test
    @Ignore
    public void hojeInteiro() throws SQLException {

        Date dataAtual = new Date();
        SimpleDateFormat dataAtualF = new SimpleDateFormat("dd/MM/yyyy");
        String hojeF = dataAtualF.format(dataAtual);
        String hojeString = hojeF.substring(0, 2);
        Integer hoje = Integer.parseInt(hojeString);

        System.out.println(hoje);

    }

    @Test
    @Ignore
    public void retornoDataAtual() throws SQLException {
        Evento evento = new Evento();
        evento.setTitle("Gabriela");

        EventoDAO edao = new EventoDAO();

        String ultimaFolgaColaborador = edao.dataUltimaFolga(evento);

        System.out.println(ultimaFolgaColaborador);

        //  }
        // Integer hoje = Integer.parseInt(ultimaFolgaColaborador);
        System.out.println(ultimaFolgaColaborador);

    }

    @Test
    @Ignore
    public void deletarTest() throws SQLException {
        Evento _evento = new Evento();
        _evento.setId(5);

        EventoDAO edao = new EventoDAO();
        edao.deletar(_evento);

    }

    @Test
    @Ignore
    public void verificarData() throws SQLException {
        Evento _evento = new Evento();

        _evento.setStart_event("2019-08-12");

        EventoDAO edao = new EventoDAO();
        Integer diasRep = edao.VerificaData(_evento);

        System.out.println(diasRep);

    }

    @Test
    @Ignore
    public void folgasPorMes() throws SQLException {
        Evento _evento = new Evento();

        _evento.setTitle("cleiton");

        EventoDAO edao = new EventoDAO();
        Integer folgasPorMes = edao.folgasPorMes(_evento);

        System.out.println(folgasPorMes);

    }

}
