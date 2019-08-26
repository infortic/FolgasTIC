package br.com.folgas.factory;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://localhost:3306/FOLGASDB";
        
    public static Connection conectar() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conexao = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;
    }   
    
  //teste de conexão  
    public static void main(String[] args){
        try {
            Connection conexao = ConnectionFactory.conectar();
            System.out.println("Conecitado");
        } catch (Exception erro) {
            System.out.println("Erro: "+erro);
        }
    }  
     
    
}
