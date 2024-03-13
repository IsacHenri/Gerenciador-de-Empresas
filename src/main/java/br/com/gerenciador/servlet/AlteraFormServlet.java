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

//@WebServlet("/alteraForm")
public class AlteraFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		String novaEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		Date data = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

	    Integer id = Integer.valueOf(request.getParameter("id"));

	    Empresa empresa = banco.buscaEmpresaPorId(id);
	    empresa.setNome(novaEmpresa);
	    empresa.setData(data);
		response.sendRedirect("listarEmpresas");
		
	}
	

}
