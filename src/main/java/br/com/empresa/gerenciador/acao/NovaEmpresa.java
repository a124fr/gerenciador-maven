package br.com.empresa.gerenciador.acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.gerenciador.modelo.Banco;
import br.com.empresa.gerenciador.modelo.Empresa;

public class NovaEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("acao cadastrando nova empresa");
		
		String nome = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("data");
				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAbertura = LocalDate.parse(paramDataAbertura, formatter);
				
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		return "redirect:entrada?acao=ListaEmpresas";		
	}
}
