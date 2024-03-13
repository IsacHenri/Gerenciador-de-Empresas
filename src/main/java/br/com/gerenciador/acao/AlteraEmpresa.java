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

public class AlteraEmpresa implements IAcao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		return "redirect:entrada?acao=ListaEmpresas";

	}

}
