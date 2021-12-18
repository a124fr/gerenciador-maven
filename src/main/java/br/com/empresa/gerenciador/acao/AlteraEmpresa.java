package br.com.empresa.gerenciador.acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.gerenciador.modelo.Banco;
import br.com.empresa.gerenciador.modelo.Empresa;

public class AlteraEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String nome = request.getParameter("nome");		
		String paramDataAbertura = request.getParameter("data");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAbertura = LocalDate.parse(paramDataAbertura, formatter);
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
				
		System.out.println("acao alterando empresa - id: " + id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPorId(id);
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
		
	}
}
