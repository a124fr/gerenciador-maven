package br.com.empresa.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.gerenciador.acao.AlteraEmpresa;
import br.com.empresa.gerenciador.acao.ListaEmpresas;
import br.com.empresa.gerenciador.acao.MostraEmpresa;
import br.com.empresa.gerenciador.acao.NovaEmpresa;
import br.com.empresa.gerenciador.acao.NovaEmpresaForm;
import br.com.empresa.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		String nome = "";
		
		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);			
		} else if(paramAcao.equals("RemoveEmpresa")) {				
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);			
		} else if(paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(request, response);			
		} else if(paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			nome = acao.executa(request, response);			
		} else if(paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);			
		} else if(paramAcao.equals("NovaEmpresaForm")) {
			NovaEmpresaForm acao = new NovaEmpresaForm();
			nome = acao.executa(request, response);			
		}
		
		String[] tipo = nome.split(":");
		if(tipo[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipo[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipo[1]);
		}
			
	}

}
