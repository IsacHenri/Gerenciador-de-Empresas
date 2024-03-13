package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class MostraEmpresa implements IAcao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    //metodo do banco de remover esta excluindo por id recebido como string e
	    // tratado pra virar integerEmpresa empresa = banco.buscaEmpresaPorId(id);

	    Empresa empresa = banco.buscaEmpresaPorId(id);
	    
	    // dispachando para o form a empresa pra fazer a alteração
	    request.setAttribute("empresa", empresa);
	
		return "forward:formAlterarEmpresa.jsp";

	}

}
