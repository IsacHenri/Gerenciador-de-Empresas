package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;

public class RemoveEmpresa implements IAcao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    //metodo do banco de remover esta excluindo por id recebido como string e
	    // tratado pra virar integer
	    banco.remover(id);
	    
	    return "redirect:entrada?acao=ListaEmpresas";

	}

}
