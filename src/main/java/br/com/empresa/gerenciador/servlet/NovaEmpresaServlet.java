package br.com.empresa.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nova-empresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		// adiciona o nome da empresa na requisição
		request.setAttribute("nomeEmpresa", empresa.getNome());
		
		//chamar o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/nova-empresa-criada.jsp");
		rd.forward(request, response);		
	}
}
