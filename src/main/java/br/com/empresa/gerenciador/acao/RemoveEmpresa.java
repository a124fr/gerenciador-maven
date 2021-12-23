package br.com.empresa.gerenciador.acao;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.gerenciador.dao.EmpresaDAO;
import br.com.empresa.gerenciador.factory.ConnectionFactory;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
				
		Connection connection = ConnectionFactory.getConexao();
		EmpresaDAO dao = new EmpresaDAO(connection);
		
		dao.remover(id);
		
		return "redirect:entrada?acao=ListaEmpresas";		
	}

}
