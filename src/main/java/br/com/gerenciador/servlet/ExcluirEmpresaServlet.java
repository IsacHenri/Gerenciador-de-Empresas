package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;

//@WebServlet("/excluirEmpresa")
public class ExcluirEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    //metodo do banco de remover esta excluindo por id recebido como string e
	    // tratado pra virar integer
	    banco.remover(id);
	    
	    response.sendRedirect("listarEmpresas");
	}


}
