package br.com.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection(){
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String senha = "postgres";
		String url = "jdbc:postgresql://127.0.0.1:5432/EscolaAlunoFeliz";
		Connection con = null;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, senha);
		}catch (ClassNotFoundException e){
			System.err.println(e.getMessage());
		}catch (SQLException e){
			System.err.println(e.getMessage());
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		
		return con;
	}
	
	public static void close (Connection con){
		try{
			con.close();
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}