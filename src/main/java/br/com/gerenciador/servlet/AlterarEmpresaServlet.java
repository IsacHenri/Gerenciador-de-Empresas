package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

//@WebServlet("/alterarEmpresa")
public class AlterarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
	    // faz o parse pra string recebida da request virar integer
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    
	    // fzd a empresa receber a empresa obtida pelo metodo de banco buscarPorId
	    Empresa empresa = banco.buscaEmpresaPorId(id);
	    
	    // dispachando para o form a empresa pra fazer a alteração
	    request.setAttribute("empresa", empresa);
	    RequestDispatcher rd = request.getRequestDispatcher("/formAlterarEmpresa.jsp");
		rd.forward(request, response);
		
		
	}

}
