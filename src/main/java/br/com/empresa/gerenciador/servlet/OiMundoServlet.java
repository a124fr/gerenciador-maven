package br.com.empresa.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oi")
public class OiMundoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"pt-br\">");
		out.println("<head>");		
		out.println("<title>Oi</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Oi Mundo! Parabêns você escreveu o primeiro servlet</p>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("Servlet \"OiMundoServlet\" foi chamando!");
	}
}
