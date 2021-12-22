package br.com.empresa.gerenciador.acao;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.gerenciador.dao.EmpresaDAO;
import br.com.empresa.gerenciador.factory.ConnectionFactory;
import br.com.empresa.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("acao listando empresas");

		Connection connection = new ConnectionFactory().getConexao();
		EmpresaDAO dao = new EmpresaDAO(connection);				
		List<Empresa> empresas = dao.listar();		
		
		request.setAttribute("empresas", empresas);
		
		return "forward:lista-empresas.jsp";		
	}

}
