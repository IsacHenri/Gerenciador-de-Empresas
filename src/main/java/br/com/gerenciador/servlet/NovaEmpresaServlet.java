package br.com.gerenciador.servlet;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;


//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		String novaEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		Date data = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			// metodos parse modificam o tipo do objeto, passou de string pra data
			// precisou do try cat pra tentar virar data com o formato que informamos
			data = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		
		Empresa empresa = new Empresa();
		empresa.setData(data);
		empresa.setNome(novaEmpresa);
		
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		response.sendRedirect("listarEmpresas");
		
		// chamando JSP
		//RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCadastrada.jsp");
		
		//rd.forward(request, response);
		
	}

}
