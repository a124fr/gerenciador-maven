package br.com.empresa.gerenciador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.empresa.gerenciador.modelo.Empresa;

public class EmpresaDAO {
	
	private Connection connection;
	private DateTimeFormatter formatterDB = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
	public EmpresaDAO(Connection connection) {
		this.connection = connection; 
	}
	
	public List<Empresa> listar() {
		List<Empresa> empresas = new ArrayList<>();
		
		try {
			try (PreparedStatement pstm = this.connection.prepareStatement("SELECT id, nome, data_abertura FROM empresa")) {
				pstm.execute();
				
				try (ResultSet rst = pstm.getResultSet()) {
					while(rst.next()) {
						Empresa empresa = new Empresa();
						empresa.setId(rst.getInt(1));
						empresa.setNome(rst.getString(2));
						empresa.setDataAbertura(LocalDate.parse(rst.getString(3), this.formatterDB));
						
						empresas.add(empresa);
					}
				}
			}
			
			return empresas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
