package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.gerenciador.acao.AlteraEmpresa;
import br.com.gerenciador.acao.CadastrarEmpresa;
import br.com.gerenciador.acao.IAcao;
import br.com.gerenciador.acao.ListaEmpresas;
import br.com.gerenciador.acao.MostraEmpresa;
import br.com.gerenciador.acao.NovaEmpresa;
import br.com.gerenciador.acao.RemoveEmpresa;
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		Map<String, IAcao> actions = new HashMap<>();
    		actions.put("ListaEmpresas", new ListaEmpresas());
    		actions.put("RemoveEmpresa", new RemoveEmpresa());
    		actions.put("MostraEmpresa", new MostraEmpresa());
    		actions.put("Cadastrar", new CadastrarEmpresa());
    		actions.put("NovaEmpresa", new NovaEmpresa());
    		actions.put("AlteraEmpresa", new AlteraEmpresa());
    		
    		
    		
            String paramAcao = request.getParameter("acao");
            IAcao acao = actions.get(paramAcao);
            String nome = null;
            

    		if (acao != null) {
    			nome = acao.executa(request, response);
    		}
//    		
//    		String paramAcao = request.getParameter("acao");
//            IAcao acao = null;
//            String nome = null;
//            // Determinar a ação com base no parâmetro "acao"
//            if ("ListaEmpresas".equals(paramAcao)) {
//                acao = new ListaEmpresas();
//                nome = acao.executa(request, response);
//            } else if ("RemoveEmpresa".equals(paramAcao)) {
//                acao = new RemoveEmpresa();
//                nome = acao.executa(request, response);
//            } else if ("MostraEmpresa".equals(paramAcao)) {
//                acao = new MostraEmpresa();
//                nome = acao.executa(request, response);
//            } else if ("AlteraEmpresa".equals(paramAcao)) {
//                acao = new AlteraEmpresa();
//                nome = acao.executa(request, response);
//            } else if ("Cadastrar".equals(paramAcao)) {
//            	acao = new CadastrarEmpresa();
//            	nome = acao.executa(request, response);
//            } else if ("NovaEmpresa".equals(paramAcao)) {
//                acao = new NovaEmpresa();
//                nome = acao.executa(request, response);
//            }
            System.out.println(nome);
            String[] tipoEndereco = nome.split(":");
            System.out.println(tipoEndereco[0]);
            if(tipoEndereco[0].equals("forward")) {
            	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
            	rd.forward(request, response);
            }else {
            	response.sendRedirect(tipoEndereco[1]);
            }
            
            


    }
}
