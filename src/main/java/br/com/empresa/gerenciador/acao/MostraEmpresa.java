package br.com.empresa.gerenciador.acao;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.gerenciador.dao.EmpresaDAO;
import br.com.empresa.gerenciador.factory.ConnectionFactory;
import br.com.empresa.gerenciador.modelo.Banco;
import br.com.empresa.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Connection connection = ConnectionFactory.getConexao();
		EmpresaDAO dao = new EmpresaDAO(connection);
		
		Empresa empresa = dao.buscarPorId(id);
		
		request.setAttribute("empresa", empresa);
		
		return "forward:form-altera-empresa.jsp";
	}
}
