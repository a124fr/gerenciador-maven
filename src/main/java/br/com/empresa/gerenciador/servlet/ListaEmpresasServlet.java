package br.com.empresa.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lista-empresas")
public class ListaEmpresasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = Banco.getEmpresas();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		for(Empresa e : empresas) {
			out.println("<ul>");
			out.println("<li>" + e.getNome() + "</li>");
			out.println("</ul>");
		}
		
		out.println("</body>");
		out.println("</html>");	
	}

}
