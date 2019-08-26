package br.com.folgas.DAO;

import br.com.folgas.entity.Colaborador;
import br.com.folgas.factory.ConnectionFactory;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ColaboradorDAO {

    public void salvar(Colaborador _funcionario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into Funcionario(nome,login,senha,perfil)    ");
        sql.append("    values(?,?,?,?)");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());
        pst.setString(1, _funcionario.getNome());
        pst.setString(2, _funcionario.getLogin());
        pst.setString(3, _funcionario.getSenha());
        pst.setString(4, _funcionario.getPerfil());

        pst.executeUpdate();

    }

    public void deletar(Colaborador _funcionario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from funcionario   ");
        sql.append("   where cod_funcionario = ? ");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());
       
        pst.setString(1, _funcionario.getCod_funcionario().toString());

        pst.executeUpdate();

    }

    public void alterar(Colaborador _funcionario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("  update Funcionario    ");
        sql.append("   set  senha = ?, perfil = ?   ");    
        sql.append("    where cod_funcionario = ?    ");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());

        pst.setString(1, _funcionario.getSenha());
        pst.setString(2, _funcionario.getPerfil());
        pst.setString(3, _funcionario.getCod_funcionario().toString());

        pst.executeUpdate();

    }

    public Colaborador buscaPorCodigo(Colaborador _funcionario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from Funcionario     ");
        sql.append("    where cod_funcionario = ?    ");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());
        pst.setInt(1, _funcionario.getCod_funcionario());

        ResultSet resultado = pst.executeQuery();

        Colaborador retorno = null;

        if (resultado.next()) {
            retorno = new Colaborador();
            retorno.setCod_funcionario(resultado.getInt("cod_funcionario"));
            retorno.setLogin(resultado.getString("login"));
            retorno.setNome(resultado.getString("nome"));
            retorno.setNome(resultado.getString("senha"));

        }
        return retorno;
    }

    public ArrayList<Colaborador> listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from Funcionario  ");
        sql.append("  ORDER BY nome ASC  ");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());

        ResultSet resultado = pst.executeQuery();

        ArrayList<Colaborador> listaF = new ArrayList<>();

        while (resultado.next()) {
            Colaborador _funcionario = new Colaborador();

            _funcionario.setCod_funcionario(resultado.getInt("cod_funcionario"));
            _funcionario.setLogin(resultado.getString("login"));
            _funcionario.setNome(resultado.getString("nome"));
            _funcionario.setSenha(resultado.getString("senha"));

            listaF.add(_funcionario);

        }
        return listaF;
    }

    public ArrayList<Colaborador> buscarPorNome() throws SQLException {
        Colaborador f = new Colaborador();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from Funcionario  ");
        sql.append("  where nome like  ?  ");
        sql.append("  ORDER BY nome ASC  ");

        Connection conexao = ConnectionFactory.conectar();

        PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());

        pst.setString(1, f.getNome());

        ResultSet resultado = pst.executeQuery();

        ArrayList<Colaborador> listaF = new ArrayList<>();

        while (resultado.next()) {
            Colaborador _funcionario = new Colaborador();

            _funcionario.setCod_funcionario(resultado.getInt("cod_funcionario"));
            _funcionario.setLogin(resultado.getString("login"));
            _funcionario.setNome(resultado.getString("nome"));
            _funcionario.setNome(resultado.getString("senha"));

            listaF.add(_funcionario);
        }
        return listaF;
    }
    
     public String Logar(Colaborador _colab)throws SQLException{

         
         StringBuilder sql = new StringBuilder();
            sql.append("select login, senha, nome, perfil from funcionario    ");
            sql.append("   where login=? and senha=?  ");
            
             Connection conexao = ConnectionFactory.conectar();
            
            PreparedStatement pst = (PreparedStatement) conexao.prepareStatement(sql.toString());
            pst.setString(1, _colab.getLogin());
            pst.setString(2, _colab.getSenha());
            ResultSet resultado = pst.executeQuery();
            
            String perfil = null;
            
            if(resultado.next()){
                 perfil = resultado.getString("perfil");
            }
            

            return perfil;
            
           
            }   
            
        }

