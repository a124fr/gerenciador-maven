package br.com.empresa.gerenciador.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private static DataSource dataSource;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource
					.setJdbcUrl("jdbc:mysql://localhost/gerenciador_usuario?timezone=true&serverTimezone=UTC");
			comboPooledDataSource.setUser("root");
			comboPooledDataSource.setPassword("senac");

			ConnectionFactory.dataSource = comboPooledDataSource;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConexao() {
		try {
			return ConnectionFactory.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
