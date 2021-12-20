package br.com.empresa.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long ini = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		// executa a ação
		chain.doFilter(request, response);		

		long fim = System.currentTimeMillis();		
		System.out.println("tempo de execução da ação: " + acao + " -> " +(fim-ini));
	}

}
