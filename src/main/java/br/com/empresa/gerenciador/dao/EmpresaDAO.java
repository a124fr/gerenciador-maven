package br.com.empresa.gerenciador.dao;

import java.sql.Connection;
import java.sql.Date;
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
			throw new RuntimeException("Erro ao listar empresas!", e);
		}
	}

	public void cadastrar(Empresa empresa) {
		try (PreparedStatement pstm = this.connection.prepareStatement("INSERT INTO empresa (nome, data_abertura) VALUES(?,?)")){
			pstm.setString(1, empresa.getNome());
			pstm.setDate(2, Date.valueOf(empresa.getDataAbertura()));
			pstm.execute();
			
		} catch(SQLException e) {
			throw new RuntimeException("Erro ao cadastrar empresa!", e);
		}
	}

	public void remover(Integer id) {
		try (PreparedStatement pstm = this.connection.prepareStatement("DELETE FROM empresa WHERE id = ?")){
			pstm.setInt(1, id);
			pstm.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao excluir a empresa", e);
		}
	}

	public Empresa buscarPorId(Integer id) {
		Empresa empresa = new Empresa();
		
		try (PreparedStatement pstm = this.connection.prepareStatement("SELECT id, nome, data_abertura FROM empresa WHERE id = ?")) {
			pstm.setInt(1, id);
			pstm.execute();
			
			ResultSet  rst = pstm.getResultSet();
			if (rst.next()) {
				empresa.setId(rst.getInt(1));
				empresa.setNome(rst.getString(2));
				empresa.setDataAbertura(LocalDate.parse(rst.getString(3), this.formatterDB));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao consultar a empresa", e);
		}
		
		return empresa;
	}

	public void alterar(Empresa empresa) {
		try (PreparedStatement pstm = this.connection.prepareStatement("UPDATE empresa SET nome  = ?, data_abertura = ? WHERE id = ?")) {
			pstm.setString(1, empresa.getNome());
			pstm.setDate(2, Date.valueOf(empresa.getDataAbertura()));
			pstm.setInt(3, empresa.getId());
			pstm.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar a empresa", e);
		}
	}
	
	
}
