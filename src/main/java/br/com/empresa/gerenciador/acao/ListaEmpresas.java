package br.com.empresa.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.gerenciador.modelo.Banco;
import br.com.empresa.gerenciador.modelo.Empresa;

public class ListaEmpresas {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("acao listando empresas");
		
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		request.setAttribute("empresas", empresas);
		
		return "forward:lista-empresas.jsp";		
	}

}
