package br.com.alura.javaEJdbcTrabalhandoComBancoDeDados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionPool().getConection();
		Statement stmt = connection.createStatement();
		stmt.execute("delete from produto where id>3");
		
		int count = stmt.getUpdateCount(); // número de linhas atualizadas
		System.out.println(count + " linhas atualizadas");

		stmt.close();
		connection.close();
	}
}
