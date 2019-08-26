package br.com.folgas.DAO;

import br.com.folgas.entity.Colaborador;
import br.com.folgas.entity.Evento;
import br.com.folgas.factory.ConnectionFactory;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EventoDAO {


    
    
    
    
    public void salvar(Evento _evento) throws SQLException, ParseException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into agenda(title,start_event,id_colaborador,color)    ");
        sql.append("    values(?,?,1,'#FF00FF')");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());
        
        pst.setString(1, _evento.getTitle());
        pst.setString(2, _evento.getStart_event());
        
                
        pst.executeUpdate();  

    }

    public void deletar(Evento _evento) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from agenda   ");
        sql.append("   where id = ?  ");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());
       
        pst.setString(1, _evento.getId().toString());

        pst.executeUpdate();

    }

   
    public ArrayList<Evento> listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select a.title,a.start_event,a.data_agendamento,a.id_colaborador,f.nome,a.id,f.cod_funcionario  ");
        sql.append("  from agenda a  ");
        sql.append("  inner join Funcionario f on f.cod_funcionario = a.Id_colaborador  ");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());

        ResultSet resultado = pst.executeQuery();

        ArrayList<Evento> listaF = new ArrayList<>();

        while (resultado.next()) {

            Colaborador _colaborador = new Colaborador();
            _colaborador.setCod_funcionario(resultado.getInt("cod_funcionario"));
            _colaborador.setNome(resultado.getString("nome"));           
            
            
            Evento _evento = new Evento();
            _evento.setId(resultado.getInt("id"));
            
            //1991-07-02
            String dia = resultado.getString("start_event").substring(8,10);
            String mes = resultado.getString("start_event").substring(5,7);
            String ano = resultado.getString("start_event").substring(0,4);
            String start_evente = dia+"-"+mes+"-"+ano;
            _evento.setTitle(resultado.getString("title"));
            _evento.setStart_event(start_evente);
            String diaA = resultado.getString("data_agendamento").substring(8,10);
            String mesA = resultado.getString("data_agendamento").substring(5,7);
            String anoA = resultado.getString("data_agendamento").substring(0,4);
            String data_agendamento = diaA+"-"+mesA+"-"+anoA;            
            
            _evento.setData_agendamento(data_agendamento);
            _evento.setColaborador(_colaborador);
            
            
           
            listaF.add(_evento);

        }
        return listaF;
    }

   public String dataUltimaFolga(Evento _evento)throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("select MAX(start_event),start_event,id,title from agenda      ");
        sql.append("    where title = ?   ");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());
        pst.setString(1, _evento.getTitle());

        ResultSet resultado = pst.executeQuery();

       String ultimaFolga = "1";
        
        if (resultado.next()) {
            
            String data = resultado.getString("start_event");
            ultimaFolga = data;
            
            
        }
        
        return ultimaFolga;
        
   }
   
   
   
   
   
   public Integer VerificaData(Evento _evento)throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("select * from agenda");
        sql.append("    where start_event = ?   ");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());
        pst.setString(1, _evento.getStart_event());

        ResultSet resultado = pst.executeQuery();
        Integer gabriela =0;
       while(resultado.next()){
         gabriela =  resultado.getRow();
         
       }
        
        return gabriela;
        
   }
    public Integer folgasPorMes(Evento _evento)throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("select * from agenda  ");
        sql.append("    where month(start_event) = month(curdate()) and title = ?   ");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());
        pst.setString(1, _evento.getTitle());

        ResultSet resultado = pst.executeQuery();
        Integer folgasPorMes =0;
       while(resultado.next()){
         folgasPorMes =  resultado.getRow();
         
       }
        
        
        
        return folgasPorMes;
        
   }
   
   
    
}
