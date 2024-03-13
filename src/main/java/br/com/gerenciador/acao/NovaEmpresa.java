package br.com.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class NovaEmpresa implements IAcao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
