package br.com.empresa.gerenciador.acao;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.gerenciador.dao.EmpresaDAO;
import br.com.empresa.gerenciador.factory.ConnectionFactory;
import br.com.empresa.gerenciador.modelo.Banco;
import br.com.empresa.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String nome = request.getParameter("nome");		
		String paramDataAbertura = request.getParameter("data");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAbertura = LocalDate.parse(paramDataAbertura, formatter);
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
		
		Connection connection = ConnectionFactory.getConexao();
		EmpresaDAO dao = new EmpresaDAO(connection);
		
		dao.alterar(empresa);
		
		return "redirect:entrada?acao=ListaEmpresas";		
	}
}
